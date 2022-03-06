
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
import org.silverolympics.dao.Questionselector;

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
                
                int nbr_quest = (Integer)session.getAttribute("question_number");
                nbr_quest = nbr_quest-nbr_quest;
                request.setAttribute("question_nbr", nbr_quest);
                //Assign the first question and its corresponding answers 
                //QuestionGeneratorDao chosen_question = new Question(chosen_themes);
                
                int current_score = 0;
                //Retrieving the chosen theme
                String chosen_themes = (String) session.getAttribute("chosenthemes");
                List<Integer> used_questions = new ArrayList<>();
                used_questions = (List<Integer>)session.getAttribute("used_questions");
                
                request.setAttribute("score", current_score);
                //Selects a new question 
                Questionselector selector = new Questionselector();
                
                Question chosen_question =selector.selectquestion(chosen_themes, used_questions);
        
                Integer id_chosen = chosen_question.getIdQuestion();
        
                assert !(used_questions.contains(id_chosen)):"Question Already Chosen in GameOptionsPanelControllerServleet";
        
        
                //update the already selected question list
                used_questions.add(id_chosen);
                session.setAttribute("used_questions", used_questions);
                
                //Retrieves the chosen question/its answers
                String question_chosen =chosen_question.getQuestion();
                String answera_chosen = chosen_question.getAnswerA();
                String answerb_chosen = chosen_question.getAnswerB();
                String answerc_chosen = chosen_question.getAnswerC();
                String answerd_chosen = chosen_question.getAnswerD();
                String correct_answer_chosen= chosen_question.getCorrectAnswer();
        
                //assignation of and filling of  the next game screen 
        
                request.setAttribute("question", question_chosen);
                request.setAttribute("answerA", answera_chosen);
                request.setAttribute("answerB", answerb_chosen);
                request.setAttribute("answerC", answerc_chosen);
                request.setAttribute("answerD", answerd_chosen);
                request.setAttribute("correctAnswer", correct_answer_chosen);
        
                
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
   

