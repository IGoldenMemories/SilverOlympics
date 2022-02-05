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
        
        
        DataBaseDao regUser = new DataBaseDao(ConnectionDB.getConnection());
        String newusername="",newpassword="";
        newusername= request.getParameter("username");
        newpassword= request.getParameter("password");
        //How to get number of entries in database
        UserAccount user = new UserAccount(0,newusername, newpassword,0);
        
        
        if (regUser.saveUser(user)) {
            response.sendRedirect("/connection");
}       else {
            String errorMessage = "User Available";
            HttpSession regSession = request.getSession();
            regSession.setAttribute("RegError", errorMessage);
            response.sendRedirect("/creercompte");
            }
    }
}