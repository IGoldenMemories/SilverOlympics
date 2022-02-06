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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import org.silverolympics.bean.ConnectionDB;
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
        String url="jdbc:mysql://localhost:3306/silver_schema?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]";
        String uname="root";
        String pass="Silv3rQuestions42";
        
        Connection con;
        try {
            con = DriverManager.getConnection(url, uname, pass);
            String input_userName = request.getParameter("username");
            String input_password = request.getParameter("password");
            DataBaseDao reguser = new DataBaseDao(con);
            int nbr_user = DataBaseDao.number_users();
            //create a registerbean 
            //call authorizeRegister(registerbean)
            //Following result(msg) --> redirect (login if successful, register if chosen username already used)
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}