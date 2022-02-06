
package org.silverolympics.controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.silverolympics.bean.UserAccount;
import org.silverolympics.dao.DataBaseDao;

/**
 * 
 * @author Manon
 */
@WebServlet("/")
public class HomeControllerServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * constructor/initializator of the servlet
     */
    public HomeControllerServlet() {
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
        int value = 0;
        try {
            value = DataBaseDao.number_users();
        } catch (SQLException ex) {
            Logger.getLogger(HomeControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("resultdb",value);
        request.getRequestDispatcher("index.jsp").forward(request, response);

       
    }
    
    /**
     * takes care of post request
     * @param request the incoming request (from the user's web agent)
     * @param response the outgoing answer (from the server side)
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
