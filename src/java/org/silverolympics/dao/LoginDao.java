/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.silverolympics.dao;
import org.silverolympics.bean.LoginBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Takes care of all the logic surrounding databases' accesses to validate the user's inputed credentials
 * 
 * @author Manon Michaux
 * @see org.silverolympics.LoginController
 */
public class LoginDao {
    
    public static String authorizeLogin(LoginBean loginBean){
        
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        //Creates two variables to compare:
        //whether the entered username belongs to a created account
        //if so, whether the entered password matches that username
        String dbusername="";
        String dbpassword="";
        
        String url="jdbc:derby://localhost:1527/SilverOlympicsDB";
        String uname="anuser";
        String pass="SilverOlympics2021";
        
        try{
           Connection con=DriverManager.getConnection(url, uname, pass);
           
           //create a statement to check the existence/validity of the inputs
           PreparedStatement checkstatement=null;
           checkstatement= con.prepareStatement("select * from LOGIN where USERNAME=? and PASSWORD=?");
           checkstatement.setString(1,username);
           checkstatement.setString(2,password);
           ResultSet rs=checkstatement.executeQuery();
           
           while(rs.next()){
               dbusername=rs.getString("USERNAME");
               dbpassword=rs.getString("PASSWORD");
               
               
               if(username.equals(dbusername)&& password.equals(dbpassword)){
                   
                   return "SUCCESSFUL LOGIN";
               }
           }
           //closing the statement
           checkstatement.close();
           //closing the connection
           con.close();
           
           
        }
        
        catch(SQLException e){
            e.printStackTrace();
        }
        return "Wrong Username AND/OR PASSWORD";
    }
    
}
