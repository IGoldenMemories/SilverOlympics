
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
        
        HttpSession session = request.getSession();
        
        //Theme choice handling
        String chosen_themes;
        String result_prev_quest = (String) request.getParameter("result");
        
        
        //Checks which theme has been selected (which theme's qr code was shown)
        //the result of the read qr code should be of the following:
        assert "history".equals(result_prev_quest) ^ "sport".equals(result_prev_quest) ^ "sciences".equals(result_prev_quest) 
                ^ "geo".equals(result_prev_quest) ^ "language".equals(result_prev_quest) ^ "random".equals(result_prev_quest):"Issue with value of result in sologameoptions.jsp";
        
        chosen_themes = result_prev_quest;
        
        session.setAttribute("chosenthemes", chosen_themes);
        
        
        //At least one theme should be chosen 
        assert !(chosen_themes == null): "No chosen theme in GameOptionsPanelControllerServlet";
        
        
        //Setting the score and question number (for each game(first of the session and next ones)
        int nbr_questions = 1;
        session.setAttribute("question_number", nbr_questions);
        int game_score  = 0;
        session.setAttribute("score",game_score);
        
        
        //Assign the first question and its corresponding answers
        //By selecting a random in the chosen themes (or any one if random was chosen instead)
        Questionselector selector = new Questionselector();
        List<Integer> used_questions = (List<Integer>) session.getAttribute("used_questions");
        Question chosen_question =selector.selectquestion(chosen_themes, used_questions);
        
        Integer id_chosen = chosen_question.getIdQuestion();
        
        assert !(used_questions.contains(id_chosen)):"Question already selected was chosen in GameOptionsPanelControllerServleet";
        
        //If it's the first game of the session (used_question is null)
        if(used_questions == null){
            List<Integer> first_used_questions = new ArrayList<Integer> (); 
            first_used_questions.add(id_chosen);
            
        }
        else{
            //update the already selected question list
            used_questions.add(id_chosen);
            session.setAttribute("used_questions", used_questions);
        }
        
        //Retrieves the infos of the first question that'll be asked in the next screen
        String question_chosen =chosen_question.getQuestion();
        String answera_chosen = chosen_question.getAnswerA();
        String answerb_chosen = chosen_question.getAnswerB();
        String answerc_chosen = chosen_question.getAnswerC();
        String answerd_chosen = chosen_question.getAnswerD();
        String correct_answer_chosen= chosen_question.getCorrectAnswer();
        
        //Passing the first selected question/its possible and correct answers to the next screen (sologame.jsp)
        
        request.setAttribute("question", question_chosen);
        request.setAttribute("answerA", answera_chosen);
        request.setAttribute("answerB", answerb_chosen);
        request.setAttribute("answerC", answerc_chosen);
        request.setAttribute("answerD", answerd_chosen);
        request.setAttribute("correctAnswer", correct_answer_chosen);
        
        
        
        RequestDispatcher rd=request.getRequestDispatcher("/sologame.jsp");  
        rd.forward(request, response);  
    }
   
}
