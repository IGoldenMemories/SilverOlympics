<%-- 
    Document   : login
    Created on : 16-nov.-2021, 12:08:32
    Author     : Manon Michaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;" charset="ISO-8859-1">
        <title>Login</title>
        <link rel="stylesheet" href="ressources/css/Login_Register.css" >

    </head>
    <body>
        <form action="LoginController" accept-charset="ISO-8859-1" method="post" name ="LoginForm" onsubmit="return validate()">        
            Nom d'utilisateur: <input type="text" name="username" /><br/><br/>
            Mot de passe:<input type="password" name="password" /><br/><br/>
            
            <input type="submit" name="button_login" value="Se connecter"  />
            <!-- Redirects to the register page  -->
            <h3> Pas encore de compte? <a href="register.jsp"> Créer un compte </a> </h3>
        </form>
    </body>
</html>
