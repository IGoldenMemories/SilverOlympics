
package org.silverolympics.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Selects "randomly" a question from the map following the theme(s) that was/were chosen in the option panel
 * This is the class where you can add new questions by respecting the pattern of the previously added one 
 * By first adding each one of them to a new ArrayList<String> 
 * And adding the mapping with the next unused number of question to the filled map HashMap
 * @author Manon
 * @see org.silverolympics.controller.GameOptionsPanelControllerServlet
 * @see org.silverolympics.controller.SoloGameControllerServlet
 */
public class Questionselector {
    
    public Questionselector(){
        super();
    }
    public Question selectquestion(List<String> chosenthemes,List<Integer> usedquestions){
        
        
        Question chosen_question = new Question();
        
        ArrayList<String> q1 = new ArrayList<>(Arrays.asList("Qui a dit : « Le sort en est jeté » (Alea jacta est) ?","Vercingétorix","Attila","Auguste","César","D","history"));
        ArrayList<String> q2 = new ArrayList<>(Arrays.asList("À qui doit-on la chanson « I Shot the Sheriff » ?","Bob Marley","Eric Clapton","UB40","Jim Morrison","A","aleatoire"));
        ArrayList<String> q3 = new ArrayList<>(Arrays.asList("Dans quelle ville italienne l’action de la pièce de Shakespeare « Roméo et Juliette » se situe-t-elle ?","Vérone","Venise","Rome","Milan","A","language"));
        ArrayList<String> q4 = new ArrayList<>(Arrays.asList("Par quel mot désigne-t-on une belle-mère cruelle ?","Une jocrisse","Une chenapan","Une marâtre","Une godiche","C","language"));
        ArrayList<String> q5 = new ArrayList<>(Arrays.asList("Qui était le dieu de la guerre dans la mythologie grecque ?","Hadès","Arès","Hermès","Apollon","B","history"));
        ArrayList<String> q6 = new ArrayList<>(Arrays.asList("Quel est l’impératif du verbe feindre à la première personne du pluriel ?","Feignons!","Feins!","Feignez!","Feindez!","A","language"));
        ArrayList<String> q7 = new ArrayList<>(Arrays.asList("Quel roi de France proclama l’Édit de Nantes ?","Louis XVI","François Ier","Henri IV","Louis XIII","C","history"));
        ArrayList<String> q8 = new ArrayList<>(Arrays.asList("À quel écrivain attribue-t-on la rédaction de l’Illiade et l’Odyssée ?","Virgile","Homère","Euripide","Sophocle","B","language"));
        ArrayList<String> q9 = new ArrayList<>(Arrays.asList("Le drapeau russe est blanc, bleu et…?","Rouge","Jaune","Vert","Noir","A","geo"));
        ArrayList<String> q10 = new ArrayList<>(Arrays.asList("Quel animal andin de la famille des camélidés est élevé pour sa laine ?","Le lama","Le yak","Le chameau","Le buffle","A","sciences"));
        ArrayList<String> q11 = new ArrayList<>(Arrays.asList("Quel célèbre égyptologue fut le premier à déchiffrer les hiéroglyphes ?","Christian Jacq","Jean-François Champollion","Jean-Philippe Lauer","Gaston Maspéro","B","history"));
        ArrayList<String> q12 = new ArrayList<>(Arrays.asList("Dans quel pays peut-on trouver le mont Elbrouz ?","La Russie","L'Azerbaïdjan","La Géorgie","L'Iran","A","geo"));
        ArrayList<String> q13 = new ArrayList<>(Arrays.asList("On écrit des…","choux-fleur","choux-fleurs","chou-fleur","chou-fleurs","B","language"));
        ArrayList<String> q14 = new ArrayList<>(Arrays.asList("Quel animal peut être marteau, tigre ou pèlerin ?","La baleine","L'orque","Le moustique","Le requin","D"	,"sciences"));
        ArrayList<String> q15 = new ArrayList<>(Arrays.asList("Parmi les marques de voiture suivantes, laquelle n’est pas allemande ?	Ford	Audi	Volkswagen	Mercedes	A	aleatoire"));
        ArrayList<String> q16 = new ArrayList<>(Arrays.asList("Parmi les animaux suivants, lequel est le plus rapide ?","Le faucon pélerin","Le canard colvert","Le moineau","Le pigeon","A","sciences"));
        ArrayList<String> q17 = new ArrayList<>(Arrays.asList("Parmi les termes suivants, lequel est féminin ?","Entête","Equivoque","Entracte","Emblème","B","language"));
        ArrayList<String> q18 = new ArrayList<>(Arrays.asList("De quel pays Recep Tayyip Erdogan est le dirigeant (depuis 2003)…","de la Turquie","de l'Iran","du Pakistan","de l'Egypte","A","geo"));
        ArrayList<String> q19 = new ArrayList<>(Arrays.asList("De ces villes, laquelle est la plus peuplée (en comptant les banlieues) ?","Madrid","Rome","Berlin","Paris","D","geo"));
        ArrayList<String> q20 = new ArrayList<>(Arrays.asList("En combien de temps la Terre tourne-t-elle autour du Soleil ?","456 jours et demi","24h","365 jours et un quart","364 jours","C","sciences"));
        ArrayList<String> q21 = new ArrayList<>(Arrays.asList("Qui est Zlatan Ibrahimovic ?","Un joueur de football suédois","Un joueur de football serbe","Un joueur de football croate","Un joueur de football turque","A","sport"));
        ArrayList<String> q22 = new ArrayList<>(Arrays.asList("Quelle est la périodicité des jeux Olympiques d’été ?","Tous les ans","Tous les deux ans","Tous les trois ans","Tous les quatre ans","D","sport"));
        ArrayList<String> q23 = new ArrayList<>(Arrays.asList("Lors du Tour de France cycliste, qui est récompensé d’un maillot blanc à pois rouges ?","Le meilleur jeune coureur","Le meilleur sprinteur","Le meilleur grimpeur","Le meilleur pédaleur","C","sport"));
        ArrayList<String> q24 = new ArrayList<>(Arrays.asList("Quel nom porte un terrain de tennis ?","La surface","La terre battue", "Le Field","Le court","D","sport"));
        ArrayList<String> q25 = new ArrayList<>(Arrays.asList("Au judo, quel est le grade le plus élevé parmi ces ceintures ?","Orange","Verte","Bleue","Jaune","C","sport"));
        ArrayList<String> q26 = new ArrayList<>(Arrays.asList("Aux Etats-Unis, qu’est-ce que la NBA ?","La National Basketball Association","La National Boxe Association","La National Base-Ball Association","La National Billiard Association","A","sport"));
        ArrayList<String> q27 = new ArrayList<>(Arrays.asList("Quel est le revêtement d’un terrain de curling ?","De l'herbe", "De la glace", "De l'eau", "Du sable","B","sport"));
        ArrayList<String> q28 = new ArrayList<>(Arrays.asList("On dit qu'un cheval...","rugit","hurle","blatère","hennit","D","sciences"));
        ArrayList<String> q29 = new ArrayList<>(Arrays.asList("Où se situe l'Oural?","En Ukraine","Au Kazakhstan","En Turquie","En Russie","D","geo"));
        ArrayList<String> q30 = new ArrayList<>(Arrays.asList("Que collectionne un philatéliste?","Des badges", "Des timbres", "Des papillons","Des pièces de monnaie","B","aleatoire"));
        
        ArrayList<String> q31 = new ArrayList<>(Arrays.asList("Quel est le plus petit état du monde?","Monaco","Saint-Martin","Le Vatican","Andorre","C","geo"));
        ArrayList<String> q32 = new ArrayList<>(Arrays.asList("Quelle est la femelle du cochon ?","La gorette","La trouille","La cochonne","La truie","D","sciences"));
        ArrayList<String> q33 = new ArrayList<>(Arrays.asList("Quel est l'organe respiratoire des poissons ?","Le tuba","Les poumons","Les branchies","L'estomac","C","sciences"));
        ArrayList<String> q34 = new ArrayList<>(Arrays.asList("En quelle année Adolf Hitler accède-t-il au pouvoir en Allemagne ?","1931","1929", "1937","1933","D","history"));
        ArrayList<String> q35 = new ArrayList<>(Arrays.asList("Quelle est la spécificité du portrait de Dorian Gray ?","Il veillit","C'est un monochrome","Il parle","Il change chaque jour","A","language"));
        ArrayList<String> q36 = new ArrayList<>(Arrays.asList("Quel est le plus grand État du monde ?","La Chine","Les Etats-Unis","La Russie","Le Canada","C","geo"));
        ArrayList<String> q37 = new ArrayList<>(Arrays.asList("Quel animal appelle-t-on aussi le « hérisson des mers » ?","L'étoile de mer", "Le crabe", "L'oursin", "L'huître","C","sciences"));
        ArrayList<String> q38 = new ArrayList<>(Arrays.asList("On dit qu'un cheval...","rugit","hurle","blatère","hennit","D","sciences"));
        ArrayList<String> q39 = new ArrayList<>(Arrays.asList("Qui a déclare en 1944 : « Paris outragé, Paris brisé, Paris martyrisé, mais Paris libéré ! » ?","François Mitterrand","Charles de Gaulle","Philippe Leclerc","Winston Churchill","B","history"));
        ArrayList<String> q40 = new ArrayList<>(Arrays.asList("Quelle est la capitale du Maroc ?","Rabat", "Marrakech", "Casablanca","Tanger","A","geo"));
        
        ArrayList<String> q41 = new ArrayList<>(Arrays.asList("Que fait la mante après l’accouplement avec le mâle ?","Elle migre","Elle le dévore","Elle forme un nid","Elle mange un de ses petits","B","sciences"));
        ArrayList<String> q42 = new ArrayList<>(Arrays.asList("Quel pays surnomme-t-on « Le pays du Soleil levant » ?","La Thaïlande","La Chine","Le Japon","La Corée","c","geo"));
        ArrayList<String> q43 = new ArrayList<>(Arrays.asList("Quel est l'organe respiratoire des poissons ?","Le tuba","Les poumons","Les branchies","L'estomac","C","sciences"));
        ArrayList<String> q44 = new ArrayList<>(Arrays.asList("En quelle année Adolf Hitler accède-t-il au pouvoir en Allemagne ?","1931","1929", "1937","1933","D","history"));
        ArrayList<String> q45 = new ArrayList<>(Arrays.asList("Quelle est la spécificité du portrait de Dorian Gray ?","Il veillit","C'est un monochrome","Il parle","Il change chaque jour","A","language"));
        ArrayList<String> q46 = new ArrayList<>(Arrays.asList("Quel est le plus grand État du monde ?","La Chine","Les Etats-Unis","La Russie","Le Canada","C","geo"));
        ArrayList<String> q47 = new ArrayList<>(Arrays.asList("Quel animal appelle-t-on aussi le « hérisson des mers » ?","L'étoile de mer", "Le crabe", "L'oursin", "L'huître","C","sciences"));
        ArrayList<String> q48 = new ArrayList<>(Arrays.asList("On dit qu'un cheval...","rugit","hurle","blatère","hennit","D","sciences"));
        ArrayList<String> q49 = new ArrayList<>(Arrays.asList("Qui a déclare en 1944 : « Paris outragé, Paris brisé, Paris martyrisé, mais Paris libéré ! » ?","François Mitterrand","Charles de Gaulle","Philippe Leclerc","Winston Churchill","B","history"));
        ArrayList<String> q50 = new ArrayList<>(Arrays.asList("Quelle est la capitale du Maroc ?","Rabat", "Marrakech", "Casablanca","Tanger","A","geo"));
        
        
        Map<Integer,ArrayList<String>> filledmap = new HashMap<>();
        
        filledmap.put(1,q1);
        filledmap.put(2,q2);
        filledmap.put(3,q3);
        filledmap.put(4,q4);
        filledmap.put(5,q5);
        filledmap.put(6,q6);
        filledmap.put(7,q7);
        filledmap.put(8,q8);
        filledmap.put(9,q9);
        filledmap.put(10,q10);
        filledmap.put(11,q11);
        filledmap.put(12,q12);
        filledmap.put(13,q13);
        filledmap.put(14,q14);
        filledmap.put(15,q15);
        filledmap.put(16,q16);
        filledmap.put(17,q17);
        filledmap.put(18,q18);
        filledmap.put(19,q19);
        filledmap.put(20,q20);
        filledmap.put(21,q21);
        filledmap.put(22,q22);
        filledmap.put(23,q23);
        filledmap.put(24,q24);
        filledmap.put(25,q25);
        filledmap.put(26,q26);
        filledmap.put(27,q27);
        filledmap.put(28,q28);
        filledmap.put(29,q29);
        filledmap.put(30,q30);
        filledmap.put(31,q31);
        filledmap.put(32,q32);
        filledmap.put(33,q33);
        filledmap.put(34,q34);
        filledmap.put(35,q35);
        filledmap.put(36,q36);
        filledmap.put(37,q37);
        filledmap.put(38,q38);
        filledmap.put(39,q39);
        filledmap.put(40,q40);
        filledmap.put(41,q41);
        filledmap.put(42,q42);
        filledmap.put(43,q43);
        filledmap.put(44,q44);
        filledmap.put(45,q45);
        filledmap.put(46,q46);
        filledmap.put(47,q47);
        filledmap.put(48,q48);
        filledmap.put(49,q49);
        filledmap.put(50,q50);
        
        
        //If no particular theme was chosen (if aleatoire was chosen)
        boolean random = chosenthemes.contains("random");
        boolean noquestfound = true;
        if(random){
            while(noquestfound){
                //Selects a question "randomly"
                int nbrquest = 1 + (int)(Math.random() * 50);
                
                if (! (usedquestions==null)){
                    //If it hasn't be asked in the current user's session
                    if(!usedquestions.contains(nbrquest)){
                        List<String> questioncomponent = new ArrayList<>();
                        questioncomponent = filledmap.get(nbrquest);
                        
                        chosen_question.setIdQuestion(nbrquest);
                        String question = questioncomponent.get(0);
                        chosen_question.setQuestion(question);
                        String answera = questioncomponent.get(1);
                        chosen_question.setAnswerA(answera);
                        String answerb = questioncomponent.get(2);
                        chosen_question.setAnswerB(answerb);
                        String answerc = questioncomponent.get(3);
                        chosen_question.setAnswerC(answerc);
                        String answerd = questioncomponent.get(4);
                        chosen_question.setAnswerD(answerd);
                        String right_answer = questioncomponent.get(5);
                        chosen_question.setCorrectAnswer(right_answer);
                        String theme = questioncomponent.get(6);
                        chosen_question.setTheme(theme);
                        noquestfound = false;
                    } 
                }
                else{
                    List<String> questioncomponent = new ArrayList<>();
                        questioncomponent = filledmap.get(nbrquest);
                    
                        chosen_question.setIdQuestion(nbrquest);
                        String question = questioncomponent.get(0);
                        chosen_question.setQuestion(question);
                        String answera = questioncomponent.get(1);
                        chosen_question.setAnswerA(answera);
                        String answerb = questioncomponent.get(2);
                        chosen_question.setAnswerB(answerb);
                        String answerc = questioncomponent.get(3);
                        chosen_question.setAnswerC(answerc);
                        String answerd = questioncomponent.get(4);
                        chosen_question.setAnswerD(answerd);
                        String right_answer = questioncomponent.get(5);
                        chosen_question.setCorrectAnswer(right_answer);
                        String theme = questioncomponent.get(6);
                        chosen_question.setTheme(theme);
                        noquestfound = false;
                    
                }
            
            }
        } 
        else{
            
            //Finds a question which theme is in the chosen one
            while(noquestfound){
                //Selects a question "randomly"
                int nbrquest = 1 + (int)(Math.random() * 50);
                
                //verifies that last element in list value in chosenthemes
                List<String> questioncomponent = new ArrayList<>();
                questioncomponent = filledmap.get(nbrquest);
                String theme_quest = questioncomponent.get(6);
                
                //If the randomly chosen question is of one of the chosen themes
                if(chosenthemes.contains(theme_quest)){
                    if(!(usedquestions==null)){
                        //If it hasn't be asked in the current user's session
                        if(!usedquestions.contains(nbrquest)){
                            chosen_question.setIdQuestion(nbrquest);
                            String question = questioncomponent.get(0);
                            chosen_question.setQuestion(question);
                            String answera = questioncomponent.get(1);
                            chosen_question.setAnswerA(answera);
                            String answerb = questioncomponent.get(2);
                            chosen_question.setAnswerB(answerb);
                            String answerc = questioncomponent.get(3);
                            chosen_question.setAnswerC(answerc);
                            String answerd = questioncomponent.get(4);
                            chosen_question.setAnswerD(answerd);
                            String right_answer = questioncomponent.get(5);
                            chosen_question.setCorrectAnswer(right_answer);
                            String theme = questioncomponent.get(6);
                            chosen_question.setTheme(theme);
                            noquestfound = false;
                        }
                    }
                    else{
                        chosen_question.setIdQuestion(nbrquest);
                        String question = questioncomponent.get(0);
                        chosen_question.setQuestion(question);
                        String answera = questioncomponent.get(1);
                        chosen_question.setAnswerA(answera);
                        String answerb = questioncomponent.get(2);
                        chosen_question.setAnswerB(answerb);
                        String answerc = questioncomponent.get(3);
                        chosen_question.setAnswerC(answerc);
                        String answerd = questioncomponent.get(4);
                        chosen_question.setAnswerD(answerd);
                        String right_answer = questioncomponent.get(5);
                        chosen_question.setCorrectAnswer(right_answer);
                        String theme = questioncomponent.get(6);
                        chosen_question.setTheme(theme);
                        noquestfound = false;
                    }
                    
                    
                }
                 
            }
        
        }
        
        return chosen_question;
    }
}
