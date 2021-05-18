/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management;
import java.sql.*;

/**
 *
 * @author ANSHUMAN
 */
public class DBConnect {
    static Connection con;
    public static Connection getConnection(){
       
            try{
                //loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //creating the connection
            con=DriverManager.getConnection("jdbc:mysql:///store_management_system","root","password");
            }
            catch(ClassNotFoundException |SQLException e){
                e.printStackTrace();
            }
     
        return con;
    }
}
