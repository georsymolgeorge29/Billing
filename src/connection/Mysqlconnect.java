package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import application.Admin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Mysqlconnect {
	Connection conn = null;
    public static Connection ConnectDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/billing","root","");
           // JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
    }
    public static ObservableList<Admin> getAdminsList(){
        Connection conn = ConnectDb();
        ObservableList<Admin> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from admin_reg");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Admin(Integer.parseInt(null, rs.getInt("account_id")), rs.getString("username"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("password"), rs.getString("address"),rs.getInt("contact_no"), rs.getString("comp_name")));               
            }
        } catch (Exception e) {
        }
        return list;
    }
}
