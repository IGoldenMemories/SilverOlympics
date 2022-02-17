
package org.silverolympics.dao;

import java.util.List;

/**
 * Select "randomly" a question from the database following the themes that were chosen in the option panel
 * @author Manon
 * @see org.silverolympics.controller.GameOptionsPanelControllerServlet
 * @see org.silverolympics.controller.SoloGameControllerServlet
 */
public final class QuestionGeneratorDao {

    
    private String question;
    private String answera;
    private String answerb;
    private String answerc;
    private String answerd;
    private String correct_answer;
    
    
    /**
     * Constructor for the QuestionGeneratorDao class
     * @param chosenthemes list regrouping all of the chosen themes for this game
     */
    public QuestionGeneratorDao(List<String> chosenthemes){
        //String question_chosen;
        //String answera_chosen;
        //String answerb_chosen;
        //String answerc_chosen;
        //String answerd_chosen;
        //String correct_answer_chosen;
        //Connection to BDD
        super();
        //Selection of random row where theme in chosenthemes
        
        
        
        
    }
    public String getQuestion() {
      return this.question;
   }

    public void setQuestion(String question) {
      this.question = question;
   }
    
    
    public String getAnswerA() {
      return this.answera;
   }

    public void setAnswerA(String answera) {
      this.answera = answera;
   }
    
    
    public String getAnswerB() {
      return this.answerb;
   }

    public void setAnswerB(String answerb) {
      this.answerb = answerb;
   }
    
    
    public String getAnswerC() {
      return this.answerc;
   }

    public void setAnswerC(String answerc) {
      this.answerc = answerc;
   }
    
    
   public String getAnswerD() {
      return this.answerd;
   }

    public void setAnswerD(String answerd) {
      this.answerd = answerd;
   }
    
    
   public String getCorrectAnswer() {
      return this.correct_answer;
   }

    public void setCorrectAnswer(String correct_answer) {
      this.correct_answer = correct_answer;
   }
   
}
