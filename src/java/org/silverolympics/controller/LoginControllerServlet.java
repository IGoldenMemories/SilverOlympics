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


@WebServlet("/login")
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
				= this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserAccount userAccount = DataBaseMock.findUser(userName, password);
                
                //TO RAFFINE (see decision tree)
		if (userAccount == null) {
			String errorMessage = "Invalid userName or Password";

			request.setAttribute("errorMessage", errorMessage);

			RequestDispatcher dispatcher //
					= this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");

			dispatcher.forward(request, response);
			return;
		}

		AppUtils.storeLoggedinUser(request.getSession(), userAccount);

		// 
		int redirectId = -1;
		try {
			redirectId = Integer.parseInt(request.getParameter("redirectId"));
		} catch (Exception e) {
		}
		String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
		if (requestUri != null) {
			response.sendRedirect(requestUri);
		} else {
			// Default after successful login
			// redirect to /acceuil page
			response.sendRedirect(request.getContextPath() + "/acceuil");
		}

	}
    
    
    
}