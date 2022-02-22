
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
        
        
        
        //Handling which themes have been chosen 
        List<String> chosen_themes = new ArrayList<>();
        
        //If the random button has been selected then other selected themes aren't taken into account 
        if(request.getParameter("random_button") != null){
            chosen_themes.add("random");
            request.setAttribute("themeschoice", chosen_themes);
        }
        
        //Otherwise the selected (clicked on) themes (in the select )are gathered 
        // and sent to the SoloGameControllerServlet to select this game's questions
  
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
        
        
        HttpSession session = request.getSession();
        
        
        int nbr_questions = 1;
        session.setAttribute("question_number", nbr_questions);
        int game_score  = 0;
        session.setAttribute("score",game_score);
        session.setAttribute("chosenthemes", chosen_themes);
        //Assign the first question and its corresponding answers
        //By selecting a random in the chosen themes (or any one if random was chosen instead)
        Questionselector selector = new Questionselector();
        List<Integer> used_questions = (List<Integer>) session.getAttribute("used_questions");
        Question chosen_question =selector.selectquestion(chosen_themes, used_questions);
        
        Integer id_chosen = chosen_question.getIdQuestion();
        
        assert !(used_questions.contains(id_chosen)):"Question Already Chosen in GameOptionsPanelControllerServleet";
        if(used_questions == null){
            List<Integer> first_used_questions = new ArrayList<Integer> (); 
            first_used_questions.add(id_chosen);
            
        }
        else{
            //update the already selected question list
            used_questions.add(id_chosen);
            session.setAttribute("used_questions", used_questions);
        }
        
        
        String question_chosen =chosen_question.getQuestion();
        String answera_chosen = chosen_question.getAnswerA();
        String answerb_chosen = chosen_question.getAnswerB();
        String answerc_chosen = chosen_question.getAnswerC();
        String answerd_chosen = chosen_question.getAnswerD();
        String correct_answer_chosen= chosen_question.getCorrectAnswer();
        
        //assignation of parameters
        
        request.setAttribute("question", question_chosen);
        request.setAttribute("answerA", answera_chosen);
        request.setAttribute("answerB", answerb_chosen);
        request.setAttribute("answerC", answerc_chosen);
        request.setAttribute("answerD", answerd_chosen);
        request.setAttribute("correctAnswer", correct_answer_chosen);
        
        
        // Attention divide score in:
        //-currentscore attribute (before the game)
        //-score attribute(which will be updated and asserted in SoloGameController >= currentscore)
        
        
        RequestDispatcher rd=request.getRequestDispatcher("/sologame.jsp");  
        rd.forward(request, response);  
    }
   
}
