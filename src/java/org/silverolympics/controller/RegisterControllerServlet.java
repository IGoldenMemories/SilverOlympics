package org.silverolympics.controller;

import org.silverolympics.bean.RegisterBean;
import org.silverolympics.dao.RegisterDao;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.http.HttpSession;
import org.silverolympics.bean.UserAccount;
import org.silverolympics.dao.DataBaseDao;
/**
 *
 * @author Manon Michaux
 * @see org.silverolympics.bean.ConnectionDB
 * @see org.silverolympics.dao.DataBaseDao
 */

public class RegisterControllerServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    /**
     * Constructor/initializator of the servlet
     */
    public RegisterControllerServlet() {
		super();
	}
    
    
    /**
     * takes care of get request
     * @param request the incoming request (from the user's web agent)
     * @param response the outgoing answer (from the server side)
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/register.jsp");

		dispatcher.forward(request, response);
	}
    
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
        
        //con = DriverManager.getConnection(url, uname, pass);
        String input_userName = request.getParameter("username");
        //String input_password = request.getParameter("password");
        DataBaseDao databaseconnector = new DataBaseDao();
        Connection con = databaseconnector.getCon();
        //int nbr_user = DataBaseDao.number_users();
        //create a registerbean 
        //call authorizeRegister(registerbean)
        //Following result(msg) --> redirect (login if successful, register if chosen username already used)
        
        try {
            Statement stmt =  con.createStatement();
            stmt.executeUpdate("insert into user (username) values('"+input_userName+"'");
            
            RequestDispatcher rd = request.getRequestDispatcher("/sologame.jsp");
            rd.forward(request, response); 
        } 
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}