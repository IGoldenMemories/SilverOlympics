
package org.silverolympics.bean;
import java.sql.*;


/**
 *
 * @author Manon
 */
public class ConnectionDB {
    private static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/silver_schema","root","Silv3rQuestions42");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}

