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
        <script type="text/javascript">
            
            
            
            var count = 1;
            function setColor(btn) {
                var property = document.getElementById(btn);
                if (count === 0) {
                    property.style.backgroundColor = "#FFFFFF";
                    count = 1;        
                }
                else {
                    property.style.backgroundColor = "#7FFF00";
                    count = 0;
                }
            }
        </script>

    </head>
    <body>
        <h1>Options de la partie:</h1>
        <form action="optionspanelsolocontroller" method="post">
            Limite de temps? 
            <input type="checkbox"
                   id="countdownbool"
                   name="timer"
                   onClick={this.handleClick;}
                   checked={this.state.active} 
                    /> 
            </br>
     
            </br>
            Sélection des thèmes des questions de la partie: </br>
            </br>
            <input type="button" class="random" type=”submit” name="random_button" onClick="randombuttonaction()"> Aléatoire </input>
            <input type="button" class="history" type=”submit” name="history_button" onClick="setcolor('hist')"> Histoire </input>
            <input type="button" class="sport" type=”submit” name="sport_button"> Sport </input>
            <input type="button" class="sciences" type=”submit” name="sciences_button"> Nature </input>
            <input type="button" class="geo" type=”submit” name="geo_button"> Géographie </input>
            <input type="button" class="langue" type=”submit” name="langue_button"> Langue Française </input>
            
            <div id="explanationrandom"  style="display:none;"  >
                <p>En cliquant sur Aléatoire vous recevrez des questions de n'importe quel thème </p>
            </div>
            </br>
            <input id="okoption" type="submit" value="Cliquer pour confirmer les options choisies"  />
            
            
        </form>
        <a href="sologame.jsp"> Cliquer ici (pour le moment )pour tester partie solo </a>
            
        
    </body>
</html>
