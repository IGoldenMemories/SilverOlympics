
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
import java.util.Arrays;
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
        List<String> chosen_themes = new ArrayList<>();
        //If the random button has been selected then other selected themes aren't taken into account 
        if(request.getParameter("random_button") != null){
            chosen_themes.add("random");
            request.setAttribute("themeschoice", chosen_themes);
        }
        
        //Otherwise the selected (clicked on) themes (in the select )are gathered 
        // and sent to the SoloGameControllerServlet to select this game's questions in the database
  
        else{
            String[] selectedthemes = request.getParameterValues("themes");
            //If history has been selected
            if(Arrays.stream(selectedthemes).anyMatch("Histoire"::equals)){
                chosen_themes.add("history");
            }
            //If sport has been selected
            if(Arrays.stream(selectedthemes).anyMatch("Sport"::equals)){
                chosen_themes.add("sport");
            }
            //If sciences(nature) has been selected
            if(Arrays.stream(selectedthemes).anyMatch("Nature"::equals)){
                chosen_themes.add("sciences");
            }
            //If geo(geography) has been selected
            if(Arrays.stream(selectedthemes).anyMatch("Geographie"::equals)){
                chosen_themes.add("geo");
            }
            //If language(litterature) has been selected
            if(Arrays.stream(selectedthemes).anyMatch("Litterature"::equals)){
                chosen_themes.add("language");
            }
            
            request.setAttribute("themeschoice", chosen_themes);
        }
        
        //At least one theme should be chosen 
        assert !chosen_themes.isEmpty(): "Issue with chosen_themes size";
        
        
        RequestDispatcher rd=request.getRequestDispatcher("/sologame.jsp");  
        rd.forward(request, response);  
    }
   
}
