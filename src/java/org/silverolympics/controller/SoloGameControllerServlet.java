
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nbr_questions = 1;
        RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/sologame.jsp");
        
        List<String> chosen_themes = (List<String>) request.getAttribute("themeschoice");
        
        //Timer checkbox was selected/checked in options panel
        //while(nbr_questions<10){
            
        //Select a question in BDD (random row with theme in chosen themes)
        QuestionGeneratorDao chosen_question = new QuestionGeneratorDao(chosen_themes);
        //assignation of parameters
        
        //Put question in question div
        //Put answers in respective div
        //Get answer
        String given_answer = request.getParameter("given_answer");
        
        //Compare with one in BD
        
        //Scenario win
        //Scenario loose 
            
        //}//while(nbr_questions<10){
            
            //Select a question in BDD (random row with theme in chosen themes)
        //    QuestionGeneratorDao chosen_question = new QuestionGeneratorDao(chosen_themes);
            //assignation of parameters
         //   String question_chosen ="Qui a dit : « Le sort en est jeté » (Alea jacta est) ?";
           // String answera_chosen = "Vercingétorix";
            //String answerb_chosen = "Attila";
           // String answerc_chosen = "Auguste";
           // String answerd_chosen = "César";
           // String correct_answer_chosen= "D";
            //chosen_question .setAnswerA(answera_chosen);
            //chosen_question .setQuestion(question_chosen);
            //chosen_question .setAnswerB(answerb_chosen);
            //chosen_question .setAnswerC(answerc_chosen);
           // chosen_question .setAnswerD(answerd_chosen);
            //chosen_question .setCorrectAnswer(correct_answer_chosen);
            //Pass the different chosen values (qeustion and possible answers to the jsp)
            //request.setAttribute("question", chosen_question.getQuestion());
            //dispatcher.forward(request, response);
            //Put question in question div
            //Put answers in respective div
            //Get answer
            //Compare with one in BD
            //Scenario win
            //Scenario loose 
            
            //}
        //}
        //Timer not selected in solo game panel
        //else{
            //ALLOW TIMER IN JSP/JAVASCRIPT
            
            //while(nbr_questions<10){
            //Select a question in BDD (random row with theme in chosen themes)
           // QuestionGeneratorDao chosen_question = new QuestionGeneratorDao(chosen_themes);
            //update the question number (for display)
           // request.setAttribute("question_nbr",nbr_questions);
            //Pass the different chosen values (qeustion and possible answers to the jsp)
            //request.setAttribute("question", chosen_question.getQuestion());
            //dispatcher.forward(request, response);
            //Get answer
            //Compare with one in BD
            //Scenario win
            //Scenario loose 
            
            //}
        //}
        
        //score final added to current user score in database!
        //Assert score user bfr game (stored bfr update) <= score user +scoregame
        
        //Screen fin
        dispatcher =request.getRequestDispatcher("/sologame.jsp");  
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
