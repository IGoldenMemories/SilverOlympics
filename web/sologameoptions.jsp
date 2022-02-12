<%-- 
    Document   : sologameoptions
    Description: Display the pop-up that allows user to choose a solo game's  options  
    Created on : 28-nov.-2021, 16:01:51
    Author     : Manon Michaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Partie Solo</title>
        <link rel="stylesheet" href="ressources/css/popupsolo.css" >
    </head>
    <body>
        <div class="options">
            <h1>Options de la partie:</h1>
            <br>
            <!-- <form action="optionspanelsolocontroller" method="post">
                Limite de temps? 
                <input type="checkbox"
                   id="countdownbool"
                   name="timer"
                   onClick={this.handleClick;}
                   checked={this.state.active} 
                    />  -->
               
                <h2> Sélectionnez les thèmes des questions de la partie: </h2> <br/>
                
                <input type="button" class="history" type=”submit” name="history_button"  value ="Histoire">
                <input type="button" class="sport" type=”submit” name="sport_button" value="Sport"> 
                <input type="button" class="sciences" type=”submit” name="sciences_button" value ="Nature">  
                <input type="button" class="geo" type=”submit” name="geo_button" value="Géographie"> 
                <input type="button" class="langue" type=”submit” name="langue_button" value="Langue Française">  
                </br>
                Ou
                <br>
                <h2> Choisissez d'avoir des questions de thèmes aléatoires: </h2>
                <input type="button" class="random" type=”submit” name="random_button" value="Aléatoire"> 
                <div id="explanationrandom"  style="display:none;"  >
                    <p>En cliquant sur Aléatoire vous recevrez des questions de n'importe quel thème </p>
                </div>
                </br>
                <input id="okoption" class="gamelaunchbutton" type="submit" value="Lancer la partie"  />
            
            
            </form>
            <a href="sologame.jsp"> Cliquer ici (pour le moment )pour tester partie solo </a>
        </div>
        
            
        
    </body>
</html>
