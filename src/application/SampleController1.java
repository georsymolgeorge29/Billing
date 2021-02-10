package application;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SampleController1 implements Initializable{
	 @FXML
	    private Tab tstaff;

	    @FXML
	    private Tab tstock;

	    @FXML
	    private Tab tsales;

	  
	    @FXML
	    private TextField tfstaff_id;

	    @FXML
	    private TextField tfstaff_name;

	    @FXML
	    private TextField tfmobile_no;

	    @FXML
	    private TextField tfstaffaddress;

	    @FXML
	    private TextField tfemail_d;

	    @FXML
	    private TextField tfpassword;

	    @FXML
	    private TextField tfstaffcomp_name;

	    @FXML
	    private Button btnstaffadd;

	    @FXML
	    private Button btnstaffupdate;

	    @FXML
	    private Button btnstaffdelete;

	  //Staff details

	    @FXML
	    private TableView<Staff> tvstaff;

	    @FXML
	    private TableColumn<Staff, Integer> colstaff_id;

	    @FXML
	    private TableColumn<Staff, String> colstaff_name;

	    @FXML
	    private TableColumn<Staff, Integer> colmobile_no;

	    @FXML
	    private TableColumn<Staff, String> coladdress;

	    @FXML
	    private TableColumn<Staff, String> colemail_d;

	    @FXML
	    private TableColumn<Staff, String> colpassword;

	    @FXML
	    private TableColumn<Staff, String> colcomp_name;
	    
	    
	    //Stock details
	    
	    @FXML
	    private TextField tfproduct_id;

	    @FXML
	    private TextField tfproduct_name;

	    @FXML
	    private TextField tfcomp_name;

	    @FXML
	    private TextField tfcategory_name;

	    @FXML
	    private TextField tfexp_date;

	    @FXML
	    private TextField tfquantity;

	    @FXML
	    private TextField tfquantity_add;

	    @FXML
	    private TextField tfmrp;

	    @FXML
	    private TextField tfdiscount;

	    @FXML
	    private Button btnstockadd;

	    @FXML
	    private Button btnstockupdate;

	    @FXML
	    private Button btnstockdelete;

	   
	    
	    
	    Stage dialogStage = new Stage();
	    Scene scene;
	    Connection conn =null;
	    ResultSet rs = null;
	    PreparedStatement pst = null;
	    
	    public Connection getConnection(){
	        Connection conn;
	        try{
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root","");
	            return conn;
	        }catch(Exception ex){
	            System.out.println("Error: " + ex.getMessage());
	            return null;
	        }
	    }
		
  		@FXML
		private void handleButtonStaffAction(ActionEvent event) {        
	        
	        if(event.getSource() == btnstaffadd){
	            insertRecord();
	        }else if(event.getSource() == btnstaffupdate){
	            updateRecord();
	        }
	        else if (event.getSource() == btnstaffdelete){
	            deleteRecord();
	        }
	            
	    }
  		private void deleteRecord() {
			// TODO Auto-generated method stub
  			 String query = "DELETE FROM staff WHERE staff_id =" + tfstaff_id.getText() + "";
 	        executeQuery(query);
 	        showStaff();
		}

		private void updateRecord() {
			// TODO Auto-generated method stub
			 String query = "UPDATE  staff SET staff_id  = " + tfstaff_id.getText() + ",staff_name = '" + tfstaff_name.getText() + "',mobile_no = " + tfmobile_no.getText() + ",address = '" + tfstaffaddress.getText() + "', email_d = '" + tfemail_d.getText() + "', password = '" +
		                tfpassword.getText() + "', comp_name = '" + tfstaffcomp_name.getText() + "' WHERE staff_id = " + tfstaff_id.getText() + "";
		        executeQuery(query);
		        showStaff();
		}

		private void insertRecord(){
	        String query = "INSERT INTO staff VALUES (" + tfstaff_id.getText() + ",'" + tfstaff_name.getText() + "'," + tfmobile_no.getText() + ",'"+ tfstaffaddress.getText() + "','" + tfemail_d.getText() + "','" + tfpassword.getText() + "','" + tfstaffcomp_name.getText() + "')";
	        executeQuery(query);
	        
	        showStaff();
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
			 Staff staff=tvstaff.getSelectionModel().getSelectedItem();
			tfstaff_id.setText("" + staff.getStaff_id());
			tfstaff_name.setText("" +staff.getStaff_name());
			tfmobile_no.setText("" +staff.getMobile_no());
			tfstaffaddress.setText("" + staff.getAddress());
			tfemail_d.setText("" + staff.getEmail_d());
			tfpassword.setText("" + staff.getPassword());
			tfstaffcomp_name.setText("" + staff.getComp_name());
		 }
		 public void showStaff(){
		        ObservableList<Staff> list = getStaffList();
		        
		        colstaff_id.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("staff_id"));
		        colstaff_name.setCellValueFactory(new PropertyValueFactory<Staff, String>("staff_name"));
		        colmobile_no.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("mobile_no"));
		        coladdress.setCellValueFactory(new PropertyValueFactory<Staff, String>("address"));
		        colemail_d.setCellValueFactory(new PropertyValueFactory<Staff, String>("email_d"));
		        colpassword.setCellValueFactory(new PropertyValueFactory<Staff, String>("password"));
		        colcomp_name.setCellValueFactory(new PropertyValueFactory<Staff, String>("comp_name"));
		        tvstaff.setItems(list);
		    }
		 public ObservableList<Staff> getStaffList(){
		        ObservableList<Staff> staffList = FXCollections.observableArrayList();
		        Connection conn = getConnection();
		        String query = "SELECT * FROM staff";
		        Statement pst;
		        ResultSet rs;
		        
		        try{
		            pst = conn.createStatement();
		            rs = pst.executeQuery(query);
		            Staff staff;
		            while(rs.next()){
		                staff = new Staff(rs.getInt("staff_id"), rs.getString("staff_name"), rs.getInt("mobile_no"), rs.getString("address"),rs.getString("email_d"),rs.getString("password"),rs.getString("comp_name"));
		               staffList.add(staff);
		            }
		                
		        }catch(Exception ex){
		            ex.printStackTrace();
		        }
		        return staffList;
		    }
		    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		showStaff();
	}

	
	
	
	//STock
	
	
	
	@FXML
	private void handleButtonStockAction(ActionEvent event) {        
        
        if(event.getSource() == btnstockadd){
            insertRecordstock();
        }else if(event.getSource() == btnstockupdate){
            updateRecordstock();
        }
        else if (event.getSource() == btnstockdelete){
            deleteRecordstock();
        }
            
    }
	

	private void insertRecordstock(){
        String query = "INSERT INTO stock VALUES ('" + tfproduct_id.getText() + "','" + tfproduct_name.getText() + "','" + tfcomp_name.getText() + "','"+ tfcategory_name.getText() + "','" + tfexp_date.getText() + "'," + tfquantity.getText() + "," + tfquantity_add.getText() + "," + tfmrp.getText() + "," + tfdiscount.getText() + ")";
        executeQuery(query);
        
        //showStaff();
    }
	private void deleteRecordstock() {
		// TODO Auto-generated method stub
			 String query = "DELETE FROM staff WHERE staff_id =" + tfstaff_id.getText() + "";
	        executeQuery(query);
	        //showStaff();
	}

	private void updateRecordstock() {
		// TODO Auto-generated method stub
		 String query = "UPDATE  staff SET staff_id  = " + tfstaff_id.getText() + ",staff_name = '" + tfstaff_name.getText() + "',mobile_no = " + tfmobile_no.getText() + ",address = '" + tfstaffaddress.getText() + "', email_d = '" + tfemail_d.getText() + "', password = '" +
	                tfpassword.getText() + "', comp_name = '" + tfstaffcomp_name.getText() + "' WHERE staff_id = " + tfstaff_id.getText() + "";
	        executeQuery(query);
	        //showStaff();
	}
	
	 @FXML
	 private void handleMouseActionstock(MouseEvent event) {
		 try {
		    	FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("Stockdetails.fxml"));
		    	Parent root1=(Parent) fxmlLoader.load();
		    	Stage stage=new Stage();
		    	stage.setTitle("ViewStock");
		    	stage.setScene(new Scene(root1));
		    	stage.show();
		    }
		    catch (Exception ex) {
		    	System.out.println("Cant load window");
		    	 
			            ex.printStackTrace();
			           // System.out.println("error");
			        }
		    }
	 }
	
	






