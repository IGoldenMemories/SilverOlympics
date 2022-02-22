
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
import org.silverolympics.dao.Question;
import org.silverolympics.dao.Questionselector;

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
        
        
        HttpSession session = request.getSession();
        List<String> chosen_themes = (List<String>) session.getAttribute("chosenthemes");
        
        int game_score = (Integer)session.getAttribute("score");
        int nbr_quest = (Integer)session.getAttribute("question_number");
        
        nbr_quest++;
        session.setAttribute("question_number", nbr_quest);
        
        String result_prev_quest = (String) request.getParameter("result");
        List<Integer> used_questions = new ArrayList<>();
        
       //If the previous question was correctly answered 
        if ("success".equals(result_prev_quest)){
            //update score
            game_score++;
            
            //Displays the end screen 
            if(nbr_quest == 5){
                //score final passed to end screen
                //Assert score not null
                assert game_score >=0:"Game score value issue";
                session.setAttribute("score", game_score);
                RequestDispatcher rd=request.getRequestDispatcher("/endscreen.jsp");  
                rd.forward(request, response);  
                
        
            }
            else{
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
        
                //updates score for next screen 
                session.setAttribute("score", game_score);
                
                RequestDispatcher rd = request.getRequestDispatcher("/sologame.jsp");
                
                rd.forward(request, response);  
            }
        }
      
                
        //If the previous question was incorrectly answered 
        else{
            assert ("fail".equals(result_prev_quest)):"Result value issue";

            //Displays the end screen 
            if(nbr_quest == 5){
                //score final passed to end screen
                //Assert score not null
                assert game_score >=0:"Game score value issue";
                session.setAttribute("score", game_score);
                RequestDispatcher rd=request.getRequestDispatcher("/endscreen.jsp");  
                rd.forward(request, response);  

            }
            
            else{
  
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
        
                
                RequestDispatcher rd = request.getRequestDispatcher("/sologame.jsp");
                rd.forward(request, response);  
            }
        }
           
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
