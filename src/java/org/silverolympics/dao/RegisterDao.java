package org.silverolympics.dao;
import org.silverolympics.bean.RegisterBean;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Manon Michaux 
 */
public class RegisterDao {
    
    public String authorizeRegister(RegisterBean registerBean) throws SQLException{
        
        String username= registerBean.getUsername();
        String password= registerBean.getPassword();
        
        String url="jdbc:derby://localhost:1527/SilverOlympicsDB";
        String uname="root";
        String pass="";
        
        try{
           Connection con=DriverManager.getConnection(url, uname, pass);
           
           PreparedStatement checkstatement= null;
           //create the insert query that will "add" the informations of the new account into the LOGIN database
           checkstatement=con.prepareStatement("insert into LOGIN(USERNAME, PASSWORD, SCORE) values(?,?,?)");
           checkstatement.setString(1, username);
           checkstatement.setString(2, password);
           checkstatement.setInt(3, 0);
           checkstatement.executeUpdate();
           
           checkstatement.close();
           con.close();
           
           return "SUCCESS REGISTER";
           
        }
        
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return "Fail REGISTER";
    }
    
}
