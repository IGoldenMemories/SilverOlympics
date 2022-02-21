/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.silverolympics.dao;
import jakarta.servlet.http.HttpSession;
import org.silverolympics.bean.LoginBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.silverolympics.bean.UserAccount;
import org.silverolympics.utils.AppUtils;
/**
 * Takes care of all the logic surrounding databases' accesses to validate the user's inputed credentials
 * 
 * @author Manon Michaux
 * @see org.silverolympics.LoginController
 */
public class LoginDao {
    
    public static String authorizeLogin(LoginBean loginBean, HttpSession session){
        
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        //Creates two variables to compare:
        //whether the entered username belongs to a created account
        //if so, whether the entered password matches that username
        
        
        String url="jdbc:mysql://localhost:3306/silver_schema?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]";
        String uname="root";
        String pass="Silv3rQuestions42";
        
        try{
           Connection con=DriverManager.getConnection(url, uname, pass);
           
           //creates a statement to, first, check the existence of an account with the input username
           PreparedStatement checkstatement=null;
           
           checkstatement= con.prepareStatement("select * from user where username=?");
           checkstatement.setString(1,username);
           boolean user_exist=checkstatement.execute();
           
           
           if(user_exist){
               //closing the statement
               checkstatement.close();
               PreparedStatement checkstatement_pswrd=null;
               //Checks whether the input password corresponds to the saved one of the account in the database
               checkstatement_pswrd= con.prepareStatement("select * from user where username=? and password=?");
               //https://wisdomoverflow.com/2021/02/20/login-web-application-using-java-mysql-servlet-part-2/
               checkstatement_pswrd.setString(1,username);
               checkstatement_pswrd.setString(2,password);
               boolean correct_passwrd = checkstatement_pswrd.execute();
               
               if(correct_passwrd){
                   //Then the login is successful
                   //closes the connection and statements
                   con.close();
                   checkstatement_pswrd.close();
                   PreparedStatement add_logged_user=null;
                   //And stores the logged in user in a list for multi player game/ accessing the user's info
                   add_logged_user= con.prepareStatement("select id, score from user where username=? and password=?");
                   checkstatement_pswrd.setString(1,username);
                   checkstatement_pswrd.setString(2,password);
                   ResultSet logged_user_id = add_logged_user.executeQuery();
                   int user_id;
                   int user_score;
                  
                   user_score = logged_user_id.getInt("score");
                   UserAccount current_user = new UserAccount();
                   
                   current_user.setUserName(username);
                   AppUtils.storeLoggedinUser(session, current_user);
                   session.setAttribute("user_name", current_user.getUserName());
                   return "SUCCESSFUL LOGIN";
               }
               
               else{
                   //The password was invalid
                   //closing the connection
                   con.close();
                   checkstatement_pswrd.close();
                   return "Mot de passe ne correspondant pas au nom d'utilisateur";
               }
               
           }
           
           else{
               //user does not exist( input username doesn't correspond to any existing account in database)
               //closing the connection
               con.close();
               return "Nom d'utilisateur n'appartient à aucun compte existant";
               
           }
  
        }
        
        
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
        
    }
    
}
