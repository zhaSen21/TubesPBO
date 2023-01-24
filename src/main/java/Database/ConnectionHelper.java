package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConnectionHelper {
    public static Connection connect;
    public static Statement st;
    public static ResultSet rs;
    
    public static Connection getConnection(){
        if(connect==null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connect=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bayarspp",
                        "root","");
                st = (Statement) connect.createStatement();
                JOptionPane.showMessageDialog(null,"Terkoneksi");
                
            }catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, "Tidak Terkoneksi");
            }
        }
        return connect;
    }
    public static void main(String[] args) {
        ConnectionHelper.getConnection();
    }
}