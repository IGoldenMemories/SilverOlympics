<%-- 
    Document   : endscrren
    Created on : 20 févr. 2022, 14:36:15
    Author     : Manon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ecran de fin de partie</title>
    </head>
    <body>
        <h1>Félicitation vôtre score est de :</h1>
        <div class="scoredisplay"> ${score} </div>
        <form action="ecranfinpartie" method="post">
            Voulez-vous recommencer une partie ?
            <hr>
            Avec les mêmes options? 
            <input type="submit" class="newgame"  name="newgamebutton" value="A"> 
            <hr>
            Ou 
            Avec des options différentes ?
            <input type="submit" class="other_options"  name="other_options"  value="B"> 
            <hr>
            Souhaitez vous plutôt revenir au menu principal
            <input type="submit" class="other_options"  name="homepagebutton"  value="C"> 
        </form>
    </body>
</html>
