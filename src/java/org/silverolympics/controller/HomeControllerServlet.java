
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
public class HomeControllerServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * constructor/initializator of the servlet
     */
    public HomeControllerServlet() {
        super();
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //https://codedec.com/tutorials/how-to-retrieve-data-and-display-in-table-format-in-jsp-and-servlet-using-mysql/
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
        //RESEARCH DISPLAY FIRST DB ENTRY (ATTEMPT BFR --> SCOREBOARD)
        request.setAttribute("noconnection",true);
        
        dispatcher.forward(request, response);
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
