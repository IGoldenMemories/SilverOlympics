package org.silverolympics.controller;

import org.silverolympics.bean.RegisterBean;
import org.silverolympics.dao.RegisterDao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Manon Michaux
 */

public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        Connection con = null;
        PreparedStatement stmt = null;
        String newusername="",newpassword="";
        newusername= request.getParameter("username");
        newpassword= request.getParameter("password");
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/SilverDB", "root", "SilverOlympics2021");
            stmt= con.prepareStatement("insert into loginuser values(?,?,?,?)");  
            stmt.setString(1,newusername);  
            stmt.setString(2,newpassword);  
            
            stmt.executeUpdate();
            out.print("You are successfully registered...");  
            
        } catch (SQLException ex) {
            out.println("Sorry didn't work");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}