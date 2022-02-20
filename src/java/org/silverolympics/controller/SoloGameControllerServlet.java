
package org.silverolympics.controller;

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
import org.silverolympics.dao.QuestionGeneratorDao;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/sologame.jsp");
        
        List<String> chosen_themes = (List<String>) request.getAttribute("themeschoice");
        HttpSession session = request.getSession();
        int game_score = (Integer)session.getAttribute("score");
        int nbr_quest = (Integer)session.getAttribute("question_number");
        
        nbr_quest++;
        session.setAttribute("question_number", nbr_quest);
        //number_question +=1;
        //session.setAttribute("question_nbr", number_question);
        String result_prev_quest = (String) request.getParameter("result");
        
        //Display the end screen 
        //if(number_question == 10){
            //score final added to current user score in database!
            //Assert score user bfr game (stored bfr update) <= score user +scoregame
        
            //Screen fin
        
        //}
        //Displays the next question / posssible answers
        //else{
            //If the previous question was correctly answered 
        if ("success".equals(result_prev_quest)){
            //update score
            game_score++;
            
            
            //Select a new question 
            QuestionGeneratorDao chosen_question = new QuestionGeneratorDao(chosen_themes);
            String question_chosen ="À qui doit-on la chanson « I Shot the Sheriff » ?";
            String answera_chosen = "Bob Marley";
            String answerb_chosen = "Eric Clapton";
            String answerc_chosen = "UB40";
            String answerd_chosen = "Jim Morrison";
            String correct_answer_chosen= "A";
            chosen_question .setAnswerA(answera_chosen);
            chosen_question .setQuestion(question_chosen);
            chosen_question .setAnswerB(answerb_chosen);
            chosen_question .setAnswerC(answerc_chosen);
            chosen_question .setAnswerD(answerd_chosen);
            chosen_question .setCorrectAnswer(correct_answer_chosen);
        
            request.setAttribute("question", chosen_question.getQuestion());
            request.setAttribute("answerA", chosen_question.getAnswerA());
            request.setAttribute("answerB", chosen_question.getAnswerB());
            request.setAttribute("answerC", chosen_question.getAnswerC());
            request.setAttribute("answerD", chosen_question.getAnswerD());
            request.setAttribute("correctAnswer",chosen_question.getCorrectAnswer());
            
            session.setAttribute("score", game_score);
            RequestDispatcher rd = request.getRequestDispatcher("/sologame.jsp");
            //RequestDispatcher rd=request.getRequestDispatcher("/endscreen.jsp");  
            rd.forward(request, response);  
            }
  
                
                //assignation of parameters
        //}   
   
       
        
        
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/sologame.jsp");
        
        dispatcher.forward(request, response);
    }
   
}
