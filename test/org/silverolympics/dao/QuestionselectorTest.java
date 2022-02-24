
package org.silverolympics.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Before;	;
import java.util.Random;

/**
 * Test class for the question selector
 * @author Manon
 * @see org.silverolympics.dao.Questionselector
 * 
 */
public class QuestionselectorTest {
    
    public QuestionselectorTest() {
        super();
    }
    
    
    
    @Before
    public void setUp() {
        
        
    }
    
    
    /**
     * Test of selectquestion method, of class Questionselector.
     */
    @Test
    public void testSelectquestion() {
        int nbrtest = 1;
        //randomly choose themes (random or within the list of possible ones)
        List<String> potentialthemes = new ArrayList<>(Arrays.asList("history","sport","sciences","geo","language"));
        String chosentheme;
        
        int choice = (int)Math.floor(Math.random()*(2)+1);
        //Chooses random as the "theme"
        if(choice ==1){
            chosentheme = "random";
            System.out.println("Random option chosen and Chosen theme(s) "+ chosentheme);
        }
        else{
            //chooses from one of the possible themes (in potentialthemes)
            
            
            Random rand = new Random();
            
            String randomElement = potentialthemes.get(rand.nextInt(potentialthemes.size()));
            
            chosentheme = randomElement;
            System.out.println("Chosen theme "+ chosentheme);
        }
        
        
        //Randomly populates the used questions list
        List<Integer> usedquestions = new ArrayList<>();
        int choicefill = (int)Math.floor(Math.random()*(2)+1);
        //Fill the usedquestions list with a random ammount of andwer id in chosen theme(s)
        if(choicefill == 1){
            int nbrquesttoadd = 1 + (int)(Math.random() * 50);
            int i =0;
            while(i<nbrquesttoadd){
                int nbrquest = 1 + (int)(Math.random() * 50);
                usedquestions.add(nbrquest);
            }
            
        }
        //otherwise leaves it empty (null) to test whether the class reacts properly
        
        Questionselector instance = new Questionselector();
        
        // Test Loop 
        //while(nbrtest<5){
            System.out.println("Select question test"+nbrtest);
            Question result = instance.selectquestion(chosentheme, usedquestions);
            String chosenquestiontheme = result.gettheme();
            int chosenquestionid = result.getIdQuestion();
            
            boolean themeok = chosentheme.equals(chosenquestiontheme);
            assert themeok:"Issue with the themes of chosen question";
            
            if(usedquestions != null){
                boolean notyetinused = (usedquestions.contains(chosenquestionid));
                assert notyetinused:"Issue with the themes of chosen question";
            }
       
            nbrtest++;
       // }
    }
    
}
