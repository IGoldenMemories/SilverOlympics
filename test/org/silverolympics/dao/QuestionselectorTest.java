
package org.silverolympics.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        //randomly choose themes (random or within the list of possible ones)
        List<String> potentialthemes = new ArrayList<>(Arrays.asList("history","sport","sciences","geo","language"));
        List<String> randomchoice = new ArrayList<>(Arrays.asList("random"));
        
        int choice = (int)Math.floor(Math.random()*(2)+1);
        if(choice ==1){
            List<String> chosenthemes = randomchoice;
        }
        else{
            List<String> chosenthemes = potentialthemes;
            Random rand = new Random();
        
            int nbrelementinlist = (int)(Math.random() * ((chosenthemes.size())));
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
        }
        
        //Randomly populates the used questions list
        List<Integer> usedquestions = new ArrayList<>();
        int choicefill = (int)Math.floor(Math.random()*(2)+1);
        //Fill the usedquestions list with a random ammount of andwer id in chosen theme(s)
        if(choicefill == 1){
            
        }
        //otherwise leaves it empty (null) to test whether the class reacts properly
        
    }
    
    @AfterEach
    public void tearDown() {
       
    }

    /**
     * Test of selectquestion method, of class Questionselector.
     */
    @Test
    public void testSelectquestion() {
        int nbrtest = 1;
        System.out.println("Select question test"+nbrtest);
        List<String> chosenthemes = null;
        List<Integer> usedquestions = null;
        Questionselector instance = new Questionselector();
        
        // Test Loop 
        while(nbrtest<5){
            Question expResult = null;
            Question result = instance.selectquestion(chosenthemes, usedquestions);
            assertEquals(expResult, result);
        
            fail("The test case is a prototype.");
            nbrtest++;
        }
    }
    
}
