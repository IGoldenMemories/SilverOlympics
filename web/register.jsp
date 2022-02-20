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
        <title>Nouveau compte</title>
        <link rel="stylesheet" href="ressources/css/register_look.css" >
    </head>
    <body>
        <div class="formwrapper">
            <form class="registerform" method="post" accept-charset="ISO-8859-1" action="creercompte"  >
                
                <!-- form header -->
                <div class="form-header">
                    <h2>Créer un compte:</h2>
                </div>
        
                <!-- form body -->
                <div class =" form-body">
                    <!-- Username of the institution's account -->
                    <label for="username" class="label-title"> Nom d'utilisateur: </label>
                    <input class="form-input" name ="username" size="40" required/>
                    <!-- Password of the institution's account -->
                    <!-- <label for="password" class="label-title"> Mot de passe:</label>
                    <input class="form-input" name ="password" size="40" required/> -->
                    
                </div>
                
                <!-- form footer with redirection link to register page if no account has been created for the institution -->
                <div class="form-footer">
                    <input type="submit" class="btn" name="button_register" value="Créer le compte">
                    <br>
                    <h3> Existe-t-il déjà un compte pour votre établissement? </br> Si oui, <a href="${pageContext.request.contextPath}/connection"> connectez vous</a> </h3>
                </div>
            </form>
        </div>
    </body>
</html>
