
package org.silverolympics.controller;


import java.io.IOException;
import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.silverolympics.dao.Question;

/**
 *
 * @author informatique
 */
public class EndScreenControllerServlet extends HttpServlet {
    
    public EndScreenControllerServlet(){
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
				= this.getServletContext().getRequestDispatcher("/endscreen.jsp");
        
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
        RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/endscreen.jsp");
        String choice = (String)request.getParameter("result");
        
        if(choice != null){
         
            //If a new game with same options is chosen
            if("A".equals(choice)){
                HttpSession session = request.getSession();
                int nbr_questions = 1;
                session.setAttribute("question_nbr", nbr_questions);
                //Assign the first question and its corresponding answers 
                //QuestionGeneratorDao chosen_question = new Question(chosen_themes);
            
                int current_score = 0;
            
                request.setAttribute("score", current_score);
                RequestDispatcher rd=request.getRequestDispatcher("/sologame.jsp");  
                rd.forward(request, response);      
            }
        
            // If a new game with different options is chosen
            else{
                // If a new game with different options is chosen
                if("B".equals(choice)){
                    RequestDispatcher rd=request.getRequestDispatcher("/sologameoptions.jsp");  
                    rd.forward(request, response); 
                }
                else{
                    //If the user wants to go back to the homepage
                    assert choice.equals("C");
                    RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
                    rd.forward(request, response); 
                    }
                 
                }
            
            }
        }
 }
   

