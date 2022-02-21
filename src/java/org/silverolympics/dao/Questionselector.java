
package org.silverolympics.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Manon
 */
public class Questionselector {
    
    public Questionselector(){
        super();
    }
    public Question selectquestion(List<String> chosenthemes,List<String> usedquestions){
        
        
        Question chosen_question = new Question();
        ArrayList<String> q1 = new ArrayList<String>(Arrays.asList("Qui a dit : « Le sort en est jeté » (Alea jacta est) ?","Vercingétorix","Attila","Auguste","César","D","histoire"));
        ArrayList<String> q2 = new ArrayList<String>(Arrays.asList("À qui doit-on la chanson « I Shot the Sheriff » ?","Bob Marley","Eric Clapton","UB40","Jim Morrison","A","aleatoire"));
        ArrayList<String> q3 = new ArrayList<String>(Arrays.asList("Dans quelle ville italienne l’action de la pièce de Shakespeare « Roméo et Juliette » se situe-t-elle ?","Vérone","Venise","Rome","Milan","A","litterature"));
        ArrayList<String> q4 = new ArrayList<String>(Arrays.asList("Par quel mot désigne-t-on une belle-mère cruelle ?","Une jocrisse","Une chenapan","Une marâtre","Une godiche","C","litterature"));
        ArrayList<String> q5 = new ArrayList<String>(Arrays.asList("Qui était le dieu de la guerre dans la mythologie grecque ?","Hadès","Arès","Hermès","Apollon","B","histoire"));
        ArrayList<String> q6 = new ArrayList<String>(Arrays.asList("Quel est l’impératif du verbe feindre à la première personne du pluriel ?	Feignons!	Feins!	Feignez!	Feindez!	A	litterature"));
        ArrayList<String> q7 = new ArrayList<String>(Arrays.asList("Quel roi de France proclama l’Édit de Nantes ?	Louis XVI	François Ier	Henri IV	Louis XIII	C	histoire"));
        ArrayList<String> q8 = new ArrayList<String>(Arrays.asList("À quel écrivain attribue-t-on la rédaction de l’Illiade et l’Odyssée ?	Virgile	Homère	Euripide	Sophocle	B	litterature"));
        ArrayList<String> q9 = new ArrayList<String>(Arrays.asList("Le drapeau russe est blanc, bleu et…?	Rouge	Jaune	Vert	Noir	A	geo"));
        ArrayList<String> q10 = new ArrayList<String>(Arrays.asList("Quel animal andin de la famille des camélidés est élevé pour sa laine ?	Le lama	Le yak	Le chameau	Le buffle	A	nature"));
        ArrayList<String> q11 = new ArrayList<String>(Arrays.asList("Quel célèbre égyptologue fut le premier à déchiffrer les hiéroglyphes ?	Christian Jacq	Jean-François Champollion	Jean-Philippe Lauer	Gaston Maspéro	B	histoire"));
        ArrayList<String> q12 = new ArrayList<String>(Arrays.asList("Dans quel pays peut-on trouver le mont Elbrouz ?	La Russie	L'Azerbaïdjan	La Géorgie	L'Iran	A	geo"));
        ArrayList<String> q13 = new ArrayList<String>(Arrays.asList("On écrit des…	choux-fleur	choux-fleurs	chou-fleur	chou-fleurs	B	litterature"));
        ArrayList<String> q14 = new ArrayList<String>(Arrays.asList("Quel animal peut être marteau, tigre ou pèlerin ?	La baleine	L'orque	Le moustique	Le requin	D	nature"));
        ArrayList<String> q15 = new ArrayList<String>(Arrays.asList("Parmi les marques de voiture suivantes, laquelle n’est pas allemande ?	Ford	Audi	Volkswagen	Mercedes	A	aleatoire"));
        ArrayList<String> q16 = new ArrayList<String>(Arrays.asList("Parmi les animaux suivants, lequel est le plus rapide ?	Le faucon pélerin	Le canard colvert	Le moineau	Le pigeon	A	nature"));
        ArrayList<String> q17 = new ArrayList<String>(Arrays.asList("Parmi les termes suivants, lequel est féminin ?	Entête	Equivoque	Entracte	Emblème	B	litterature"));
        ArrayList<String> q18 = new ArrayList<String>(Arrays.asList("De quel pays Recep Tayyip Erdogan est le dirigeant (depuis 2003)…	de la Turquie	de l'Iran	du Paistan	de l'Egypte	A	geo"));
        ArrayList<String> q19 = new ArrayList<String>(Arrays.asList("De ces villes, laquelle est la plus peuplée (en comptant les banlieues) ?	Madrid	Rome	Berlin	Paris	D	geo"));
        ArrayList<String> q20 = new ArrayList<String>(Arrays.asList("En combien de temps la Terre tourne-t-elle autour du Soleil ?	456 jours et demi	24h	365 jours et un quart	364 jours	C	nature"));
        ArrayList<String> q21 = new ArrayList<String>(Arrays.asList("Qui est Zlatan Ibrahimovic ?","Un joueur de football suédois","Un joueur de football serbe","Un joueur de football croate","Un joueur de football turque","A","sport"));
        ArrayList<String> q22 = new ArrayList<String>(Arrays.asList("Quelle est la périodicité des jeux Olympiques d’été ?","Tous les ans","Tous les deux ans","Tous les trois ans","Tous les quatre ans","D","sport"));
        ArrayList<String> q23 = new ArrayList<String>(Arrays.asList("Lors du Tour de France cycliste, qui est récompensé d’un maillot blanc à pois rouges ?","Le meilleur jeune coureur","Le meilleur sprinteur","Le meilleur grimpeur","Le meilleur pédaleur","C","sport"));
        ArrayList<String> q24 = new ArrayList<String>(Arrays.asList("Quel nom porte un terrain de tennis ?","La surface","La terre battue", "Le Field","Le court","D","sport"));
        ArrayList<String> q25 = new ArrayList<String>(Arrays.asList("Au judo, quel est le grade le plus élevé parmi ces ceintures ?","Orange","Verte","Bleue","Jaune","C","sport"));
        ArrayList<String> q26 = new ArrayList<String>(Arrays.asList("Aux Etats-Unis, qu’est-ce que la NBA ?","La National Basketball Association","La National Boxe Association","La National Base-Ball Association","La National Billiard Association","A","sport"));
        ArrayList<String> q27 = new ArrayList<String>(Arrays.asList("Quel est le revêtement d’un terrain de curling ?","De l'herbe", "De la glace", "De l'eau", "Du sable","B","sport"));
        ArrayList<String> q28 = new ArrayList<String>(Arrays.asList("On dit qu'un cheval...","rugit","hurle","blatère","hennit","D","nature"));
        ArrayList<String> q29 = new ArrayList<String>(Arrays.asList("Où se situe l'Oural?","En Ukraine","Au Kazakhstan","En Turquie","En Russie","D","geo"));
        ArrayList<String> q30 = new ArrayList<String>(Arrays.asList("Que collectionne un philatéliste?","Des badges", "Des timbres", "Des papillons","Des pièces de monnaie","B","aleatoire"));
        
        ArrayList<String> q31 = new ArrayList<String>(Arrays.asList("Quel est le plus petit état du monde?","Monaco","Saint-Martin","Le Vatican","Andorre","C","geo"));
        ArrayList<String> q32 = new ArrayList<String>(Arrays.asList("Quelle est la femelle du cochon ?","La gorette","La trouille","La cochonne","La truie","D","nature"));
        ArrayList<String> q33 = new ArrayList<String>(Arrays.asList("Quel est l'organe respiratoire des poissons ?","Le tuba","Les poumons","Les branchies","L'estomac","C","nature"));
        ArrayList<String> q34 = new ArrayList<String>(Arrays.asList("En quelle année Adolf Hitler accède-t-il au pouvoir en Allemagne ?","1931","1929", "1937","1933","D","histoire"));
        ArrayList<String> q35 = new ArrayList<String>(Arrays.asList("Quelle est la spécificité du portrait de Dorian Gray ?","Il veillit","C'est un monochrome","Il parle","Il change chaque jour","A","litterature"));
        ArrayList<String> q36 = new ArrayList<String>(Arrays.asList("Quel est le plus grand État du monde ?","La Chine","Les Etats-Unis","La Russie","Le Canada","C","geo"));
        ArrayList<String> q37 = new ArrayList<String>(Arrays.asList("Quel animal appelle-t-on aussi le « hérisson des mers » ?","L'étoile de mer", "Le crabe", "L'oursin", "L'huître","C","nature"));
        ArrayList<String> q38 = new ArrayList<String>(Arrays.asList("On dit qu'un cheval...","rugit","hurle","blatère","hennit","D","nature"));
        ArrayList<String> q39 = new ArrayList<String>(Arrays.asList("Qui a déclare en 1944 : « Paris outragé, Paris brisé, Paris martyrisé, mais Paris libéré ! » ?","François Mitterrand","Charles de Gaulle","Philippe Leclerc","Winston Churchill","B","histoire"));
        ArrayList<String> q40 = new ArrayList<String>(Arrays.asList("Quelle est la capitale du Maroc ?","Rabat", "Marrakech", "Casablanca","Tanger","A","geo"));
        
        ArrayList<String> q41 = new ArrayList<String>(Arrays.asList("Que fait la mante après l’accouplement avec le mâle ?","Elle migre","Elle le dévore","Elle forme un nid","Elle mange un de ses petits","B","nature"));
        ArrayList<String> q42 = new ArrayList<String>(Arrays.asList("Quel pays surnomme-t-on « Le pays du Soleil levant » ?","La Thaïlande","La Chine","Le Japon","La Corée","c","geo"));
        ArrayList<String> q43 = new ArrayList<String>(Arrays.asList("Quel est l'organe respiratoire des poissons ?","Le tuba","Les poumons","Les branchies","L'estomac","C","nature"));
        ArrayList<String> q44 = new ArrayList<String>(Arrays.asList("En quelle année Adolf Hitler accède-t-il au pouvoir en Allemagne ?","1931","1929", "1937","1933","D","histoire"));
        ArrayList<String> q45 = new ArrayList<String>(Arrays.asList("Quelle est la spécificité du portrait de Dorian Gray ?","Il veillit","C'est un monochrome","Il parle","Il change chaque jour","A","litterature"));
        ArrayList<String> q46 = new ArrayList<String>(Arrays.asList("Quel est le plus grand État du monde ?","La Chine","Les Etats-Unis","La Russie","Le Canada","C","geo"));
        ArrayList<String> q47 = new ArrayList<String>(Arrays.asList("Quel animal appelle-t-on aussi le « hérisson des mers » ?","L'étoile de mer", "Le crabe", "L'oursin", "L'huître","C","nature"));
        ArrayList<String> q48 = new ArrayList<String>(Arrays.asList("On dit qu'un cheval...","rugit","hurle","blatère","hennit","D","nature"));
        ArrayList<String> q49 = new ArrayList<String>(Arrays.asList("Qui a déclare en 1944 : « Paris outragé, Paris brisé, Paris martyrisé, mais Paris libéré ! » ?","François Mitterrand","Charles de Gaulle","Philippe Leclerc","Winston Churchill","B","histoire"));
        ArrayList<String> q50 = new ArrayList<String>(Arrays.asList("Quelle est la capitale du Maroc ?","Rabat", "Marrakech", "Casablanca","Tanger","A","geo"));
        
        
        Map<Integer,ArrayList<String>> filledmap = new HashMap<Integer,ArrayList<String>>();
        
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
        
        boolean noquestfound = true;
        //If no particular theme was chosen (if aleatoire was chosen)
        
        //Finds a question which theme is in the chosen one
        while(noquestfound){
            //Select a random entry
        //verifies that last element in list value in chosenthemes
        //If so then noquestfound = false
        //Return a Question and set all other attributes of that class 
        }
        
        return chosen_question;
    }
}
