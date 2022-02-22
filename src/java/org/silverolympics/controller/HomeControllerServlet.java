
package org.silverolympics.controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
     * takes care of get request
     * @param request the incoming request (from the user's web agent)
     * @param response the outgoing answer (from the server side)
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Integer> used_questions = new ArrayList<>();
        HttpSession session = request.getSession();
        session.setAttribute("used_questions", used_questions);
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

        RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/sologame.jsp");
        
        
        
        String result_prev_quest = (String) request.getParameter("result");
        
       //If new game is requested, redirects to the game options panel
        if ("Newgame".equals(result_prev_quest)){
            
            
            RequestDispatcher rd=request.getRequestDispatcher("/sologameoptions.jsp");  
            rd.forward(request, response);  
        }
        //If help page was requested
        else{
            assert ("Help".equals(result_prev_quest)):"Result value issue for post form in index.jsp";

            //Displays Help document
            RequestDispatcher rd=request.getRequestDispatcher("/help.jsp");  
            rd.forward(request, response);  

            }
            
        
    }
}
