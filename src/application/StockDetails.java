package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class StockDetails implements Initializable{
	   @FXML
	    private TableView<Stock> tvstock;

	    @FXML
	    private TableColumn<Stock, String> colproduct_id;

	    @FXML
	    private TableColumn<Stock, String> colproduct_name;

	    @FXML
	    private TableColumn<Stock, String> colcomp_name;

	    @FXML
	    private TableColumn<Stock, String> colcategory_name;

	    @FXML
	    private TableColumn<Stock, String> colexp_date;

	    @FXML
	    private TableColumn<Stock, Integer> colquantity;

	    @FXML
	    private TableColumn<Stock, Integer> colquantity_add;

	    @FXML
	    private TableColumn<Stock, Integer> colmrp;

	    @FXML
	    private TableColumn<Stock, Integer> coldiscount;
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
	
	
	 public void showStock(){
	        ObservableList<Stock> list = getStockList();
	        
	        colproduct_id.setCellValueFactory(new PropertyValueFactory<Stock, String>("product_id"));
	        colproduct_name.setCellValueFactory(new PropertyValueFactory<Stock, String>("product_name"));
	        colcomp_name.setCellValueFactory(new PropertyValueFactory<Stock, String>("comp_name"));
	        colcategory_name.setCellValueFactory(new PropertyValueFactory<Stock, String>("category_name"));
	        colexp_date.setCellValueFactory(new PropertyValueFactory<Stock, String>("exp_date"));
	        colquantity.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("quantity"));
	        colquantity_add.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("quantity_add"));
	        colmrp.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("mrp"));
	        coldiscount.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("discount"));
	        
	        tvstock.setItems(list);
	    }
	 public ObservableList<Stock> getStockList(){
	        ObservableList<Stock> stockList = FXCollections.observableArrayList();
	        Connection conn = getConnection();
	        String query = "SELECT * FROM stock";
	        Statement pst;
	        ResultSet rs;
	        
	        try{
	            pst = conn.createStatement();
	            rs = pst.executeQuery(query);
	            Stock stock;
	            while(rs.next()){
	                stock = new Stock(rs.getString("product_id"), rs.getString("product_name"), rs.getString("comp_name"), rs.getString("category_name"),rs.getString("exp_date"),rs.getInt("quantity"),rs.getInt("quantity_add"),rs.getInt("mrp"),rs.getInt("discount"));
	               stockList.add(stock);
	            }
	                
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	        return stockList;
	    }
	
@Override
public void initialize(URL url, ResourceBundle rb) {
	// TODO Auto-generated method stub
	showStock();
}


}
