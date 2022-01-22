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
            function randombuttonaction() {
                 document.getElementById('explanationrandom').style.display = "block";
            }
            
            
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
            <div class="options">
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
                <div id="explanationrandom"  style="display:none;"  > 
                    <p>En cliquant sur Aléatoire vous recevrez des questions de n'importe quel thème </p>
                </div>
                </br>
                <button class="button random" onClick="randombuttonaction()"> Aléatoire </button>
                <button class="button history" id="hist" onClick="setcolor('hist')"> Histoire </button>
                <button class="button sport"> Sport </button>
                <button class="button sciences"> Nature </button>
                <button class="button geo"> Géographie </button>
                <button class="button langue"> Langue Française </button>
            
            
            
                </br>
                </br>
                <input id="okoption" type="submit" value="Cliquer pour confirmer les options choisies"  />
            </div>
            
        </form>
        <a href="sologame.jsp"> Cliquer ici (pour le moment )pour tester partie solo </a>
            
        
    </body>
</html>
