package application;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SampleController implements Initializable{
	
	    
	  @FXML
	    private Button btnadmin;

	   
	    @FXML
	    private TableView<Admin> tvadmin;

	    @FXML
	    private TableColumn<Admin, Integer> colaccount_id;

	    @FXML
	    private TableColumn<Admin, String> colusername;

	    @FXML
	    private TableColumn<Admin, String> colfirstname;
	    
	    @FXML
	    private TableColumn<Admin, String> collastname;
	    
	    @FXML
	    private TableColumn<Admin, String> colemail;

	   
	    @FXML
	    private TableColumn<Admin, String> colpassword;

	    @FXML
	    private TableColumn<Admin, String> coladdress;

	    @FXML
	    private TableColumn<Admin, Integer> colcontact_no;

	    @FXML
	    private TableColumn<Admin, String> colcomp_name;

	   
	    @FXML
	    private TextField tfaccount_id;

	    @FXML
	    private TextField tfusername;

	    @FXML
	    private TextField tffirstname;

	    @FXML
	    private TextField tflastname;

	    @FXML
	    private TextField tfemail;

	    @FXML
	    private TextField tfpassword;

	    @FXML
	    private TextField tfaddress;

	    @FXML
	    private TextField tfcontact_no;

	    @FXML
	    private TextField tfcomp_name;

	    @FXML
	    private Button btnadd;

	    @FXML
	    private Button btnupdate;

	    @FXML
	    private Button btndelete;
	    
	    @FXML
	    private TextField tfusernamelogin;

	    @FXML
	    private TextField tfpasswordlogin;
	    
	    @FXML
	    private Button btnadminlogin;
	    
	

	   
	    
	    
	    
	    Stage dialogStage = new Stage();
	    Scene scene;
	    Connection conn =null;
	    ResultSet rs = null;
	    PreparedStatement pst = null;

	   // public SampleController() {
	    //    conn = Mysqlconnect.ConnectDb();
	    //}
	  
	    
	    @FXML
	    public void handlebuttonadmin(ActionEvent event) throws IOException {
	    	try {
		    	FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("Admin.fxml"));
		    	Parent root1=(Parent) fxmlLoader.load();
		    	Stage stage=new Stage();
		    	stage.setTitle("Admin");
		    	stage.setScene(new Scene(root1));
		    	stage.show();
		    }
		    catch (Exception ex) {
		    	System.out.println("Cant load window");
		    	 
			            ex.printStackTrace();
			           // System.out.println("error");
			        }
		    }
	   
		public void handlebuttonloginAction(ActionEvent event) throws IOException{
	    	//conn = Mysqlconnect.ConnectDb();
			Connection conn = getConnection();
	        String username = tfusernamelogin.getText().toString();
	        String password = tfpasswordlogin.getText().toString();
	    
	        String sql = "SELECT * FROM admin_reg WHERE username = ? and password = ?";
	        
	        try{
	            pst = conn.prepareStatement(sql);
	            pst.setString(1, username);
	            pst.setString(2, password);
	            rs = pst.executeQuery();
	            if(!rs.next()){
	                infoBox("Please enter correct username and Password", null, "Failed");
	            }else{
	                infoBox("Login Successfull",null,"Success" );
	                //Node node = (Node)event.getSource();
	                //dialogStage = (Stage) node.getScene().getWindow();
	                //dialogStage.close();
	                //scene = new Scene(FXMLLoader.load(getClass().getResource("Welcomecashier.fxml")));
	                //dialogStage.setScene(scene);
	                //dialogStage.show();
	                FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("Staff.fxml"));
	    	    	Parent root1=(Parent) fxmlLoader.load();
	    	    	Stage stage=new Stage();
	    	    	stage.setTitle("AdminSignPage");
	    	    	stage.setScene(new Scene(root1));
	    	    	stage.show();
	            }
	        }
	        catch(Exception e){
	            e.printStackTrace();
	           // System.out.println("error");
	        }
	        
	    }
	    
	    
	    public static void infoBox(String infoMessage, String headerText, String title){
	        Alert alert = new Alert(AlertType.CONFIRMATION);
	        alert.setContentText(infoMessage);
	        alert.setTitle(title);
	        alert.setHeaderText(headerText);
	        alert.showAndWait();
	    }
	
	 @FXML
		private void handleButtonupdateAction(ActionEvent event) {        
	        
	        if(event.getSource() == btnadd){
	            insertRecord();
	        }else if(event.getSource() == btnupdate){
	            updateRecord();
	        }
	        else if (event.getSource() == btndelete){
	            deleteRecord();
	        }
	            
	    }
	    
	    @Override
		public void initialize(URL url, ResourceBundle rb) {
			// TODO 
	    	//showAdmin();
			
		}  
	    public Connection getConnection(){
	        Connection conn;
	        try{
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing1", "root","");
	            return conn;
	        }catch(Exception ex){
	            System.out.println("Error: " + ex.getMessage());
	            return null;
	        }
	    }
	    
	    
	    public ObservableList<Admin> getAdminList(){
			 //conn = Mysqlconnect.ConnectDb();
			
		        ObservableList<Admin> adminList = FXCollections.observableArrayList();
		        Connection conn = getConnection();
		        String query = "SELECT * FROM admin_reg";
		        Statement pst;
		        ResultSet rs;
		        
		        try{
		            pst = conn.createStatement();
		            rs = pst.executeQuery(query);
		            Admin admin;
		            while(rs.next()){
		                admin = new Admin(rs.getInt("account_id"),rs.getString("username"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("password"),rs.getString("address"), rs.getInt("contact_no"), rs.getString("comp_name"));
		                adminList.add(admin);
		            }
		                
		        }catch(Exception ex){
		            ex.printStackTrace();
		        }
		        return adminList;
		    }
	    
  public void showAdmin(){
	        ObservableList<Admin> list = getAdminList();
	    	
	    	
	        colaccount_id.setCellValueFactory(new PropertyValueFactory<Admin, Integer>("account_id"));
	        colusername.setCellValueFactory(new PropertyValueFactory<Admin, String>("username"));
	        colfirstname.setCellValueFactory(new PropertyValueFactory<Admin, String>("firstname"));
	        collastname.setCellValueFactory(new PropertyValueFactory<Admin, String>("lastname"));
	        colemail.setCellValueFactory(new PropertyValueFactory<Admin, String>("email"));
	        colpassword.setCellValueFactory(new PropertyValueFactory<Admin, String>("password"));
	        coladdress.setCellValueFactory(new PropertyValueFactory<Admin, String>("address"));
	        colcontact_no.setCellValueFactory(new PropertyValueFactory<Admin, Integer>("contact_no"));
	        colcomp_name.setCellValueFactory(new PropertyValueFactory<Admin, String>("comp_name"));
	       
	        
	        tvadmin.setItems(list);
	    }
	  
	    private void insertRecord(){
	        String query = "INSERT INTO admin_reg VALUES (" + tfaccount_id.getText() + ",'" + tfusername.getText() + "','" + tffirstname.getText() + "','"
	                + tflastname.getText() + "','" + tfemail.getText() + "','" + tfpassword.getText() + "','" + tfaddress.getText() + "'," + tfcontact_no.getText() + ",'" + tfcomp_name.getText() + "')";
	        executeQuery(query);
	        
	        showAdmin();
	    }

	    private void updateRecord(){
	        String query = "UPDATE  admin_reg SET account_id  = " + tfaccount_id.getText() + ",username = '" + tfusername.getText() + "',firstname = '" + tffirstname.getText() + "',lastname = '" + tflastname.getText() + "', email = '" + tfemail.getText() + "', password = " +
	                tfpassword.getText() + ", address = '" + tfaddress.getText() + "',contact_no = " + tfcontact_no.getText() + ",comp_name = '" + tfcomp_name.getText() + "' WHERE account_id = " + tfaccount_id.getText() + "";
	        executeQuery(query);
	        showAdmin();
	        
	    }
	    private void deleteRecord(){
	        String query = "DELETE FROM admin_reg WHERE account_id =" + tfaccount_id.getText() + "";
	        executeQuery(query);
	        showAdmin();
	    }
	    private void executeQuery(String query) {
	        Connection conn = getConnection();
	        Statement pst;
	        try{
	            pst = conn.createStatement();
	            pst.executeUpdate(query);
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	    }
	    
	  		 @FXML
	    		 private void handleMouseAction(MouseEvent event) {
	    			 Admin admin=tvadmin.getSelectionModel().getSelectedItem();
	    			tfaccount_id.setText("" + admin.getAccount_id());
	    			tfusername.setText("" +admin.getUsername());
	    			tffirstname.setText("" + admin.getFirstname());
	    			tflastname.setText("" +admin.getLastname());
	    			tfemail.setText("" +admin.getEmail());
	    			tfpassword.setText("" + admin.getPassword());
	    			tfaddress.setText("" + admin.getAddress());
	    			tfcontact_no.setText("" + admin.getContact_no());
	    			tfcomp_name.setText("" +admin.getComp_name());
	    		 }   
	    		
	  		
}

