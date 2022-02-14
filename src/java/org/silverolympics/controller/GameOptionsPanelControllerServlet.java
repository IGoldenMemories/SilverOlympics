
package org.silverolympics.controller;

import static com.google.gwt.user.client.Window.alert;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author informatique
 */
public class GameOptionsPanelControllerServlet extends HttpServlet {
    
    public GameOptionsPanelControllerServlet(){
        super();
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/sologameoptions.jsp");
        
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext sc = this.getServletContext();
        
        //Handling whether the timer checkbox has been checked or not
        String timerchoice =request.getParameter("timer");
        
        request.setAttribute("timer",timerchoice); 

        //Handling which themes have been chosen 
          
        if(null != request.getParameter("button_b_clicked")){
            
        }
  // do 'B' stuff
        if(null != request.getParameter("button_c_clicked")){
            
        }
  // do 'C' stuff

        RequestDispatcher rd = sc.getRequestDispatcher("/sologameoptions.jsp");
        rd.forward(request, response);
    }
   
}
