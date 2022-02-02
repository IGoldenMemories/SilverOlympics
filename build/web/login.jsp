<%-- 
    Document   : login
    Created on : 16-nov.-2021, 12:08:32
    Author     : Manon Michaux
--%>

<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;" charset="utf-8">
        <title>Connection</title>
        <link href=" ressources/css/Login_Register.css" rel="stylesheet" type="text/css">

    </head>
    <body>
        <div class="formwrapper">
            
            <form class="login-form" accept-charset="ISO-8859-1" method="post" name ="LoginForm" ">        
                <!-- form header -->
                <div class="form-header">
                    <h2> Bienvenue sur Silver Olympics, veuillez vous connecter </h2>
                </div>
                
                <!-- form body -->
                <div class =" form-body">
                    <!-- Username of the institution's account -->
                    <label for="username" class="label-title"> Nom d'utilisateur: </label>
                    <input class="form-input" name ="username" size="40"/>
                    <!-- Password of the institution's account -->
                    <label for="password" class="label-title"> Mot de passe:</label>
                    <input class="form-input" name ="password" size="40"/>
                </div>
                <!-- form footer with redirection link to register page if no account has been created for the institution -->
                <div class="form-footer">
                    <button type="submit" class="btn">Se connecter</button>
                    <br> 
                    <div class="noaccount"> Pas encore de compte? <a href="${pageContext.request.contextPath}/creercompte" > Créez en un ! </a> </div>
                </div>
            </form>
        </div>
    </body>
</html>
