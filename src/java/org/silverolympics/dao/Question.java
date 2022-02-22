
package org.silverolympics.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a question to be displayed on a game screen 
 * @author Manon
 * @see org.silverolympics.dao.Questionselector.selectquestion()
 * @see org.silverolympics.controller.GameOptionsPanelControllerServlet
 * @see org.silverolympics.controller.SoloGameControllerServlet
 */
public final class Question {

    private Integer id_quest;
    private String question;
    private String answera;
    private String answerb;
    private String answerc;
    private String answerd;
    private String correct_answer;
    private String theme;
    
    
    
    public Question(){
        
        super();
        
        }
    
    public Integer getIdQuestion() {
      return this.id_quest;
   }

    public void setIdQuestion(Integer id_quest) {
      this.id_quest = id_quest;
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
    
    public String gettheme() {
      return this.theme;
   }

    public void setTheme(String theme) {
      this.theme = theme;
   }
   
}
