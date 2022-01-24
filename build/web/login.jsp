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
        <div class="formwrapper">
            
            <form class="login-form" action="LoginController" accept-charset="ISO-8859-1" method="post" name ="LoginForm" onsubmit="return validate()">        
                <!-- form header -->
                <div class="form-header">
                    <h1> Veuillez vous connecter </h1>
                </div>
                
                <!-- form body -->
                <div class =" form-body">
                    <!-- Username of the institution's account -->
                    <label for="username" class="label-title"> Nom d'utilisateur: </label>
                    {{ form.username(placeholder="entrez le nom d'utilisateur du compte de votre établissement", class="form-input") }}
                    <!-- Password of the institution's account -->
                    <label for="password" class="label-title"> Mot de passe:</label>
                    {{ form.password(placeholder="entrez le mot de passe du compte de votre établissement", class="form-input")
                </div>
                <!-- form footer with redirection link to register page if no account has been created for the institution -->
                <div class="form-footer">
                <!-- Redirects to the register page  -->
                <button type="submit" class="btn">Se connecter</button>
      <div class="noconnected"> Pas encore de compte? <a href="{{url_for('register')}}" > Créez en un ! </a> </div>
                <h3> Pas encore de compte? <a href="register.jsp"> Créer un compte </a> </h3>
            </form>
        </div>
    </body>
</html>
