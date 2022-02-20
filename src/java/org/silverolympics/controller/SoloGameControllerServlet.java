
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
        int number_question = Integer.parseInt(request.getParameter("current_nbr_question"));
        number_question +=1;
        request.setAttribute("question_nbr", number_question);
        String result_prev_quest = (String) request.getParameter("result");
        
        //Display the end screen 
        if(number_question == 10){
            
        }
        //Displays the next question / posssible answers
        else{
            //If the previous question was correctly answered 
            if(result_prev_quest.equals("success")){
                //update score
                int current_score = (int) request.getAttribute("score");
                current_score+=1;
                request.setAttribute("score", current_score);
            }
            //Select a new question 
            QuestionGeneratorDao chosen_question = new QuestionGeneratorDao(chosen_themes);
            String question_chosen ="Qui a dit : « Le sort en est jeté » (Alea jacta est) ?";
            String answera_chosen = "Vercingétorix";
            String answerb_chosen = "Attila";
            String answerc_chosen = "Auguste";
            String answerd_chosen = "César";
            String correct_answer_chosen= "D";
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
        
            
        
                
                //assignation of parameters
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/sologame.jsp");
        
        dispatcher.forward(request, response);
    }
   
}
