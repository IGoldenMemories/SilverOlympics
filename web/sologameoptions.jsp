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
                <select name="themes" size=5 multiple>
                    <option class="history" name="history_button" value ="Histoire">Histoire</option>
                    <option class="sport" name="sport_button" value="Sport">Sport</option>
                    <option class="sciences" name="sciences_button" value ="Nature">Nature</option>  
                    <option class="geo" name="geo_button" value="Geographie">Géographie</option> 
                    <option class="language" name="language_button" value="Litterature">Littérature</option>  
                </select>
                <br>
                <input id="okoption" class="gamelaunchbutton" type="submit" value="Lancer la partie"  />
                <br>
                <br>
                <hr>
                <div class="titrechoix">Ou</div> 
                <hr>
                <div class="titrechoix">  Choisissez d'avoir des questions de thèmes aléatoires: </div>
                <br>
                <input type="submit" class="random"  name="random_button" onclick="button_pressed(this)" value="Aléatoire"> 

            </form>
           
        </div>
        
    
    <script type="text/javascript" src="ressources/js/solooptions.js"></script>  
        
        
    </body>
</html>
