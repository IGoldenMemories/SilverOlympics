<%-- 
    Document   : register
    Created on : 23-nov.-2021, 15:18:31
    Author     : Manon Michaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nouveaucompte</title>
        <link rel="stylesheet" href="ressources/css/Login_Register.css" >
    </head>
    <body>
        <h2>Créer un compte:</h2>
        
        <form method="post" accept-charset="ISO-8859-1" action="controller/RegisterController" onsubmit="return validate()" >
            Nom d'utilisateur: <input type="text" name="username" ></br></br>
            Mot de passe: <input type="text" name="password" > </br></br>
            
            <input type="submit" name="button_register" value="Créer le compte">
            
            <h3> Existe-t-il déjà un compte pour votre établissement? </br> Si oui, <a href="login.jsp"> connectez vous</a> </h3>
        
        </form>
    </body>
</html>
