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
        <link rel="stylesheet" href="ressources/css/sologame_panel.css" >
        <script type='text/javascript' src='http://code.jquery.com/jquery-1.9.1.js'></script>
    </head>
    <body>
        <div class="options">
            <div class="titreoption" >Options de la partie: </div>
            <br>
            <form method="post">
                <div class="titrechoix"> Limite de temps?  </div>
                <input type="checkbox"
                   id="countdownbool"
                   name="timer"
                   onClick={this.handleClick;}
                   checked={this.state.active} 
                    />  
                <hr>
               
                <div class="titrechoix"> Sélectionnez les thèmes des questions de la partie: </div> 
                <br>
                <input type="button" class="history" type=”submit” name="history_button"  value ="Histoire">
                <input type="button" class="sport" type=”submit” name="sport_button" value="Sport"> 
                <input type="button" class="sciences" type=”submit” name="sciences_button" value ="Nature">  
                <input type="button" class="geo" type=”submit” name="geo_button" value="Géographie"> 
                <input type="button" class="language" type=”submit” name="language_button" value="Littérature">  
                <br>
                <br>
                <hr>
                <div class="titrechoix">Ou</div> 
                <hr>
                <div class="titrechoix">  Choisissez d'avoir des questions de thèmes aléatoires: </div>
                <br>
                <input type="button" class="random" type=”submit” name="random_button" onclick="button_pressed(this)" value="Aléatoire"> 
                <br>
                <br>
                <br>
                <input id="okoption" class="gamelaunchbutton" type="submit" value="Lancer la partie"  />
            
            </form>
            <a href="sologame.jsp"> Cliquer ici (pour le moment )pour tester partie solo </a>
        </div>
        
    
    <script type="text/javascript" src="ressources/js/solooptions.js"></script>  
        
        
    </body>
</html>
