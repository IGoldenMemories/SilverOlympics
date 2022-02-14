
package org.silverolympics.controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author informatique
 */
public class SoloGameControllerServlet extends HttpServlet {
    
    public SoloGameControllerServlet(){
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
        int nbr_questions = 0;
        RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/sologame.jsp");
        //Timer checkbox was selected/checed in options panel
        if(request.getAttribute("timer")!=null){
            //ALLOW TIMER IN JSP/JAVASCRIPT
            while(nbr_questions<10){
            
            //Select a question in BDD (random row with theme in chosen themes)
            
            //Put question in question div
            //Put answers in respective div 
            //Get answer
            //Compare with one in BD 
            //Scenario win 
            //Scenario loose 
            
            }
        }
        //Timer not selected in solo game panel
        else{
            while(nbr_questions<10){
            
                //Select a question in BDD (random row with theme in chosen themes)
            
                //Put question in question div
                //Put answers in respective div 
                //Get answer
                //Compare with one in BD 
                //Scenario win 
                //Scenario loose 
            
            }
        }
        
        //score final added to current user score in database!
        //Assert score user bfr game (stored bfr update) <= score user +scoregame
        
        //Screen fin
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
        doGet(request,response);
    }
   
}
