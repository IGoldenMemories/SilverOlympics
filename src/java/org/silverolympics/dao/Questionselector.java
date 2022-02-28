
package org.silverolympics.dao;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Selects "randomly" a question from the map following the theme(s) that was/were chosen in the option panel
 * This is the class where you can add new questions by respecting the pattern of the previously added one 
 * By first adding each one of them to a new List<String> 
 * And adding the mapping with the next unused number of question to the filled map HashMap
 * @author Manon
 * @see org.silverolympics.controller.GameOptionsPanelControllerServlet
 * @see org.silverolympics.controller.SoloGameControllerServlet
 */
public class Questionselector {
    
    public Questionselector(){
        super();
    }
    public Question selectquestion(String chosenthemes,List<Integer> usedquestions){
        
        
        Question chosen_question = new Question();
        
        List<String> q1 = asList("Qui a dit : « Le sort en est jeté » (Alea jacta est) ?","Vercingétorix","Attila","Auguste","César","D","Histoire");
        List<String> q2 = asList("À qui doit-on la chanson « I Shot the Sheriff » ?","Bob Marley","Eric Clapton","UB40","Jim Morrison","A","Aleatoire");
        List<String> q3 = asList("Dans quelle ville italienne l’action de la pièce de Shakespeare « Roméo et Juliette » se situe-t-elle ?","Vérone","Venise","Rome","Milan","A","Litterature");
        List<String> q4 = asList("Par quel mot désigne-t-on une belle-mère cruelle ?","Une jocrisse","Une chenapan","Une marâtre","Une godiche","C","Litterature");
        List<String> q5 = asList("Qui était le dieu de la guerre dans la mythologie grecque ?","Hadès","Arès","Hermès","Apollon","B","Histoire");
        List<String> q6 = asList("Quel est l’impératif du verbe feindre à la première personne du pluriel ?","Feignons!","Feins!","Feignez!","Feindez!","A","Litterature");
        List<String> q7 = asList("Quel roi de France proclama l’Édit de Nantes ?","Louis XVI","François Ier","Henri IV","Louis XIII","C","Histoire");
        List<String> q8 = asList("À quel écrivain attribue-t-on la rédaction de l’Illiade et l’Odyssée ?","Virgile","Homère","Euripide","Sophocle","B","Litterature");
        List<String> q9 = asList("Le drapeau russe est blanc, bleu et…?","Rouge","Jaune","Vert","Noir","A","Geo");
        List<String> q10 = asList("Quel animal andin de la famille des camélidés est élevé pour sa laine ?","Le lama","Le yak","Le chameau","Le buffle","A","Sciences");
        List<String> q11 = asList("Quel célèbre égyptologue fut le premier à déchiffrer les hiéroglyphes ?","Christian Jacq","Jean-François Champollion","Jean-Philippe Lauer","Gaston Maspéro","B","Histoire");
        List<String> q12 = asList("Dans quel pays peut-on trouver le mont Elbrouz ?","La Russie","L'Azerbaïdjan","La Géorgie","L'Iran","A","Geo");
        List<String> q13 = asList("On écrit des…","choux-fleur","choux-fleurs","chou-fleur","chou-fleurs","B","Litterature");
        List<String> q14 = asList("Quel animal peut être marteau, tigre ou pèlerin ?","La baleine","L'orque","Le moustique","Le requin","D","Sciences");
        List<String> q15 = asList("Parmi les marques de voiture suivantes, laquelle n’est pas allemande ?","Ford","Audi","Volkswagen","Mercedes","A","Aleatoire");
        List<String> q16 = asList("Parmi les animaux suivants, lequel est le plus rapide ?","Le faucon pélerin","Le canard colvert","Le moineau","Le piGeon","A","Sciences");
        List<String> q17 = asList("Parmi les termes suivants, lequel est féminin ?","Entête","Equivoque","Entracte","Emblème","B","Litterature");
        List<String> q18 = asList("De quel pays Recep Tayyip Erdogan est le dirigeant (depuis 2003)…","de la Turquie","de l'Iran","du Pakistan","de l'Egypte","A","Geo");
        List<String> q19 = asList("De ces villes, laquelle est la plus peuplée (en comptant les banlieues) ?","Madrid","Rome","Berlin","Paris","D","Geo");
        List<String> q20 = asList("En combien de temps la Terre tourne-t-elle autour du Soleil ?","456 jours et demi","24h","365 jours et un quart","364 jours","C","Sciences");
        List<String> q21 = asList("Qui est Zlatan Ibrahimovic ?","Un joueur de football suédois","Un joueur de football serbe","Un joueur de football croate","Un joueur de football turque","A","Sport");
        List<String> q22 = asList("Quelle est la périodicité des jeux Olympiques d’été ?","Tous les ans","Tous les deux ans","Tous les trois ans","Tous les quatre ans","D","Sport");
        List<String> q23 = asList("Lors du Tour de France cycliste, qui est récompensé d’un maillot blanc à pois rouges ?","Le meilleur jeune coureur","Le meilleur sprinteur","Le meilleur grimpeur","Le meilleur pédaleur","C","Sport");
        List<String> q24 = asList("Quel nom porte un terrain de tennis ?","La surface","La terre battue", "Le Field","Le court","D","Sport");
        List<String> q25 = asList("Au judo, quel est le grade le plus élevé parmi ces ceintures ?","Orange","Verte","Bleue","Jaune","C","Sport");
        List<String> q26 = asList("Aux Etats-Unis, qu’est-ce que la NBA ?","La National Basketball Association","La National Boxe Association","La National Base-Ball Association","La National Billiard Association","A","Sport");
        List<String> q27 = asList("Quel est le revêtement d’un terrain de curling ?","De l'herbe", "De la glace", "De l'eau", "Du sable","B","Sport");
        List<String> q28 = asList("On dit qu'un cheval...","rugit","hurle","blatère","hennit","D","Sciences");
        List<String> q29 = asList("Où se situe l'Oural?","En Ukraine","Au Kazakhstan","En Turquie","En Russie","D","Geo");
        List<String> q30 = asList("Que collectionne un philatéliste?","Des badges", "Des timbres", "Des papillons","Des pièces de monnaie","B","Aleatoire");
        
        List<String> q31 = asList("Quel est le plus petit état du monde?","Monaco","Saint-Martin","Le Vatican","Andorre","C","Geo");
        List<String> q32 = asList("Quelle est la femelle du cochon ?","La gorette","La trouille","La cochonne","La truie","D","Sciences");
        List<String> q33 = asList("Quel est l'organe respiratoire des poissons ?","Le tuba","Les poumons","Les branchies","L'estomac","C","Sciences");
        List<String> q34 = asList("En quelle année Adolf Hitler accède-t-il au pouvoir en Allemagne ?","1931","1929", "1937","1933","D","Histoire");
        List<String> q35 = asList("Quelle est la spécificité du portrait de Dorian Gray ?","Il veillit","C'est un monochrome","Il parle","Il change chaque jour","A","Litterature");
        List<String> q36 = asList("Quel est le plus grand État du monde ?","La Chine","Les Etats-Unis","La Russie","Le Canada","C","Geo");
        List<String> q37 = asList("Quel animal appelle-t-on aussi le « hérisson des mers » ?","L'étoile de mer", "Le crabe", "L'oursin", "L'huître","C","Sciences");
        List<String> q38 = asList("On dit qu'un cheval...","rugit","hurle","blatère","hennit","D","Sciences");
        List<String> q39 = asList("Qui a déclare en 1944 : « Paris outragé, Paris brisé, Paris martyrisé, mais Paris libéré ! » ?","François Mitterrand","Charles de Gaulle","Philippe Leclerc","Winston Churchill","B","Histoire");
        List<String> q40 = asList("Quelle est la capitale du Maroc ?","Rabat", "Marrakech", "Casablanca","Tanger","A","Geo");
        
        List<String> q41 = asList("Que fait la mante après l’accouplement avec le mâle ?","Elle migre","Elle le dévore","Elle forme un nid","Elle mange un de ses petits","B","Sciences");
        List<String> q42 = asList("Quel pays surnomme-t-on « Le pays du Soleil levant » ?","La Thaïlande","La Chine","Le Japon","La Corée","C","Geo");
        List<String> q43 = asList("Quel est l'organe respiratoire des poissons ?","Le tuba","Les poumons","Les branchies","L'estomac","C","Sciences");
        List<String> q44 = asList("En quelle année Adolf Hitler accède-t-il au pouvoir en Allemagne ?","1931","1929", "1937","1933","D","Histoire");
        List<String> q45 = asList("Quelle est la spécificité du portrait de Dorian Gray ?","Il veillit","C'est un monochrome","Il parle","Il change chaque jour","A","Litterature");
        List<String> q46 = asList("Quel est le plus grand État du monde ?","La Chine","Les Etats-Unis","La Russie","Le Canada","C","Geo");
        List<String> q47 = asList("Quel animal appelle-t-on aussi le « hérisson des mers » ?","L'étoile de mer", "Le crabe", "L'oursin", "L'huître","C","Sciences");
        List<String> q48 = asList("On dit qu'un cheval...","rugit","hurle","blatère","hennit","D","Sciences");
        List<String> q49 = asList("Qui a déclare en 1944 : « Paris outragé, Paris brisé, Paris martyrisé, mais Paris libéré ! » ?","François Mitterrand","Charles de Gaulle","Philippe Leclerc","Winston Churchill","B","Histoire");
        List<String> q50 = asList("Quelle est la capitale du Maroc ?","Rabat", "Marrakech", "Casablanca","Tanger","A","Geo");
        List<String> q51 = asList("À quelle hauteur se situe les paniers de basket ?","2m95", "3m05", "3m15","3m25","B","Sport");
        List<String> q52 = asList("Contre qui a combattu Mohamed Ali lors du « combat du siècle » à Kinshasa ?","Michael Moorer", "Henry Cooper", "Joe Frazier","George Foreman","D","Sport");
        List<String> q53 = asList("Quelle est la différence entre un canoë et un kayak ?","La position du rameur", "La forme de la jupe", "La taille de la pagaie","Le nombre de rameurs","A","Sport");
        List<String> q54 = asList("À l’origine, en quelle matière étaient faites les balles de golf ?","En bois", "En cuir", "En plâtre","En terre ","B","Sport");
        List<String> q55 = asList("À quel pays actuel correspond l’Empire ottoman ?","À la Turquie", "À l'Ukraine", "À l'Inde","À l'iran","A","Histoire");
        List<String> q56 = asList("À quel écrivain doit-on la « Divine Comédie » ?","Petrarque", "Dante", "Umberto eco","Boccace","B","Litterature");
        List<String> q57 = asList("Quel écrivain britannique a inventé le personnage d’Hercule Poirot ?","Enid Blyton", "Charles Dickens", "Arthur Conan Doyle","Agatha Christie","D","Litterature");
        List<String> q58 = asList("Que signifie charivari ?","Discours insensé", "Histoire drôle/plaisanterie", "Grand bruit/tumulte","Grand buffet","C","Litterature");
        List<String> q59 = asList("Quel roi était surnommé le « Roi-Soleil » ?","Louis XIII", "Louis XIV", "Louis XV","Philippe le Bel","B","Histoire");
        List<String> q60 = asList("Quelle théorie doit-on à Isaac Newton ?","La théorie de la gravitation universelle", "La théorie de l'évolution des espèces", "La théorie atomique","La théorie des cordes","A","Sciences");
        List<String> q61 = asList("Parmi les villes suivantes, laquelle est à la fois en Asie et en Europe ?","Alexandrie", "Rhodes", "Moscou","Istanbul","D","Geo");
        List<String> q62 = asList("Avec la laine de quel animal fait-on du cachemire ?","Du mouton", "Du vison", "Du lapin","De la chèvre","D","Sciences");
        List<String> q63 = asList("Où se situe La Valette ?","À Malte", "En Espagne", "En France","En Toscane","A","Geo");
        List<String> q64 = asList("Quel a été le premier mammifère cloné ?","Un singe", "Un chat", "Une brebis","Un rat","C","Sciences");
        List<String> q65 = asList("Quel est le nom usuel des chiroptères ?","Les chauve-souris", "Les araignées", "Les limaces","Les hippopotames","A","Sciences");
        List<String> q66 = asList("Quel port du sud de la France a été fondé par les Grecs ?","Bordeaux", "Marseille", "Toulon","Sète","B","Histoire");
        List<String> q67 = asList("Quel animal est issu du croisement d’un tigre et d’une lionne ?","Un lionceau", "Un tigre", "Un liard","Un tigron","D","Sciences");
        List<String> q68 = asList("Où se trouve l’Etna ?","Au Péloponnèse", "Dans le latium", "En sicile","En calabre","C","Geo");
        List<String> q69 = asList("En solfège, comment appelle-t-on le silence qui dure un temps ?","Une pause", "Un silence", "Un soupir","Un souffle","C","Aleatoire");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Map<Integer,List<String>> filledmap = new HashMap<>();
        
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
        filledmap.put(51,q51);
        filledmap.put(52,q52);
        filledmap.put(53,q53);
        filledmap.put(54,q54);
        filledmap.put(55,q55);
        filledmap.put(56,q56);
        filledmap.put(57,q57);
        filledmap.put(58,q58);
        filledmap.put(59,q59);
        filledmap.put(60,q60);
        filledmap.put(61,q61);
        filledmap.put(62,q62);
        filledmap.put(63,q63);
        filledmap.put(64,q64);
        filledmap.put(65,q65);
        filledmap.put(66,q66);
        filledmap.put(67,q67);
        filledmap.put(68,q68);
        filledmap.put(69,q69);
        
        
        
        boolean random = chosenthemes.equals("Aleatoire");
        boolean noquestfound = true;
        //If no particular theme was chosen (if Aleatoire was chosen)
        if(random){
            //Carries on searching while no unasked question has been found
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
            
            //Finds a question which theme is the chosen one
            while(noquestfound){
                //Selects a question "randomly"
                int nbrquest = 1 + (int)(Math.random() * 50);
                
                //verifies that last element in list value in chosenthemes
                List<String> questioncomponent = new ArrayList<>();
                questioncomponent = filledmap.get(nbrquest);
                String theme_quest = questioncomponent.get(6);
                
                //If the randomly chosen question is of one of the chosen themes
                if(chosenthemes.equals(theme_quest)){
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
