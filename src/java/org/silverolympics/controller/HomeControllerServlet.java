
package org.silverolympics.controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;



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
        
        HttpSession session = request.getSession();
        
        //Creates a new list to store which questions have been asked
        // if it's the first time the homepage is accessed during this session
        // on web app launch
        if(null == session.getAttribute("used_questions")){
            List<Integer> used_questions = new ArrayList<>();
            session.setAttribute("used_questions",used_questions);
        }
        //Retrieves the chosen themes
        String atheme = getServletContext().getInitParameter("Atheme");
        String btheme = getServletContext().getInitParameter("Btheme");
        String ctheme = getServletContext().getInitParameter("Ctheme");
        String dtheme = getServletContext().getInitParameter("Dtheme");
        String etheme = getServletContext().getInitParameter("Etheme");
        String ftheme = getServletContext().getInitParameter("Ftheme");
        
        //Setting up the different possible themes (defined in the deployement descriptor (web.xml))
        if(atheme != null){
            session.setAttribute("AthemeMapping", atheme);
        }
        if(btheme != null){
            session.setAttribute("BthemeMapping", btheme);
        }
        if(ctheme != null){
            session.setAttribute("CthemeMapping", ctheme);
        }
        if(dtheme != null){
            session.setAttribute("DthemeMapping", dtheme);
        }
        if(etheme != null){
            session.setAttribute("EthemeMapping", etheme);
        }
        if(ftheme != null){
            session.setAttribute("FthemeMapping", ftheme);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

       
    }
    
    /**
     * redirects to:
     * either the solo game panel (if the A qr code is shown)
     * or the help page that contains the user guide pdf (if the B qr code is shown)
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
            if ("end".equals(result_prev_quest)){
            
            RequestDispatcher rd=request.getRequestDispatcher("/endscreen.jsp");  
            rd.forward(request, response);  
        }
            assert ("Help".equals(result_prev_quest)):"Result value issue for post form in index.jsp";

            //Displays Help page/document
            RequestDispatcher rd=request.getRequestDispatcher("/help.jsp");  
            rd.forward(request, response);  

            }
            
        
    }
}
