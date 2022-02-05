<%-- 
    Document   : index
    Created on : 12-oct.-2021, 18:34:02
    Author     : Manon Michaux 
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SilverOlympics-Acceuil</title>
        <link rel="stylesheet" href="/ressources/css/homepagestyle.css" >


    </head>
    <body>
        <!-- Display of the header/navigation tab -->
        <div class = "header">
            <a href="${pageContext.request.contextPath}/creercompte" >Créer un compte </a>  
            <a href="${pageContext.request.contextPath}/connection" >Se connecter</a>
            <a href="${pageContext.request.contextPath}/classement">Classement</a>
            <a href="${pageContext.request.contextPath}/aide">Aide</a>
           
        </div>

        <div class="title">
            <br>
            <h1>Bienvenue sur Silver Olympics </h1>
            
        </div>   
          
        
            </br>
        <div class="imagebackground">
            <img src="ressources/img/bugsbodovsstock.png" alt="imageback" width="800" height="600">
        </div>

        

    </body>
</html>
