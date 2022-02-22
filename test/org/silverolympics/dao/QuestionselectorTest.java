
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
        //randomly choose themes (random or within the list of possible ones)
        List<String> potentialthemes = new ArrayList<>(Arrays.asList("history","sport","sciences","geo","language"));
        List<String> randomchoice = new ArrayList<>(Arrays.asList("random"));
        
        int choice = (int)Math.floor(Math.random()*(2)+1);
        if(choice ==1){
            List<String> chosenthemes = randomchoice;
            System.out.println("Random option chosen and Chosen theme(s) "+ chosenthemes);
        }
        else{
            List<String> chosenthemes = potentialthemes;
            Random rand = new Random();
        
            int nbrelementinlist = (int)(Math.random() * ((chosenthemes.size())-1));
            // create a temporary list for storing
            // selected element
            List<String> newList = new ArrayList<>();
        
            for (int i = 0; i < nbrelementinlist; i++) {
 
                // take a random index between 0 to size
                // of given List
                int randomIndex = rand.nextInt(chosenthemes.size());
 
                // add element in temporary list
                newList.add(chosenthemes.get(randomIndex));
 
                // Remove selected element from original list
                chosenthemes.remove(randomIndex);
                
            }
            chosenthemes = newList;
            System.out.println("Chosen theme(s) "+ chosenthemes);
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
        
    }
    
    
    /**
     * Test of selectquestion method, of class Questionselector.
     */
    @Test
    public void testSelectquestion() {
        int nbrtest = 1;
        
        List<String> chosenthemes = null;
        List<Integer> usedquestions = null;
        Questionselector instance = new Questionselector();
        
        // Test Loop 
        //while(nbrtest<5){
            System.out.println("Select question test"+nbrtest);
            Question result = instance.selectquestion(chosenthemes, usedquestions);
            String chosenquestiontheme = result.gettheme();
            int chosenquestionid = result.getIdQuestion();
            
            boolean themeok = chosenthemes.contains(chosenquestiontheme);
            assert themeok:"Issue with the themes of chosen question";
            
            if(usedquestions != null){
                boolean notyetinused = (usedquestions.contains(chosenquestionid));
                assert notyetinused:"Issue with the themes of chosen question";
            }
       
            nbrtest++;
       // }
    }
    
}
