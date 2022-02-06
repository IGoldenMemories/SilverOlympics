package org.silverolympics.controller;

import org.silverolympics.bean.LoginBean;
import org.silverolympics.dao.LoginDao;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;

import org.silverolympics.bean.UserAccount;
import org.silverolympics.dao.DataBaseMock;
import org.silverolympics.utils.AppUtils;
/**
 *
 * @author informatique
 * @see org.silverolympics.bean.UserAccount
 * @see org.silverolympics.dao.DataBaseMock
 * @see org.silverolympics.utils.AppUtils
 */


public class LoginControllerServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    /**
     * Constructor/initializator of the servlet
     */
    public LoginControllerServlet() {
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
				= this.getServletContext().getRequestDispatcher("/login.jsp");

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String input_userName = request.getParameter("userName");
		String input_password = request.getParameter("password");
                LoginBean testlogin = new LoginBean(input_userName,input_password);
                
                //Replace with database check in logindao
		String resulttest = LoginDao.authorizeLogin(testlogin);
                
                //TO RAFFINE (see decision tree --> HANDLED BY LOGINDAO SEE SUCCESS )
		if (resulttest.equals("SUCCESSFUL LOGIN")) {
                    
                    
                    
                    RequestDispatcher dispatcher= this.getServletContext().getRequestDispatcher("/homepage.jsp");
                    
                    dispatcher.forward(request, response);
	
		}
                else{
                    if(resulttest.equals("NoAccountWithUsername")){
                        String errorMessage = "Nom d'utilisateur n'appartient à aucun compte existant";
                        //DISPLAY ERROR MESSAGE IN HTML VIA ATTRIBUTE
			request.setAttribute("errorMessage", errorMessage);
                        RequestDispatcher dispatcher //
					= this.getServletContext().getRequestDispatcher("/login.jsp");

			dispatcher.forward(request, response);
                       
                    }
                    else{
                        
                        String errorMessage = "Mot de passe ne correspondant pas au nom d'utilisateur";
                        //DISPLAY ERROR MESSAGE IN HTML VIA ATTRIBUTE
			request.setAttribute("errorMessage", errorMessage);
                        RequestDispatcher dispatcher //
					= this.getServletContext().getRequestDispatcher("/login.jsp");

			dispatcher.forward(request, response);
                        
                    }
                        
                }
                    
                           
		

	}
    
    
    
}