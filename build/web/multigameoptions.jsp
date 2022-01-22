<%-- 
    Document   : multigameoptions
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
        <link rel="stylesheet" href="ressources/css/popupmulti.css" >
        <script type="text/javascript">
            function randombuttonaction() {
                 document.getElementById('explanationrandom').style.display = "block";
            }
            
            
            
        </script>
    </head>
    <body>
        <h2>Choisissez les thèmes que vous préférez:</h2>
        
                    </br>
     
         <div class="options">
             <div id="explanationrandom"  style="display:none;"  > 
                 <p>En cliquant sur Aléatoire vous recevrez des questions de n'importe quel thème </p>
            </div>
            <button id = "random" class="button random" onClick="randombuttonaction()"> Aléatoire </button>
            <button class="button history" id="hist" > Histoire </button>
            <button class="button sport"> Sport </button>
            <button class="button sciences"> Nature </button>
            <button class="button geo"> Géographie </button>
            <button class="button langue"> Langue Française </button>
            
              
            </br>
            </br>
            </br>    
            <input id="okoption" type="button" value="Cliquer pour confirmer les options choisies"  />
        </div>
        
                    
        
    </body>
</html>
