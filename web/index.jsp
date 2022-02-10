<%-- 
    Document   : index
    Created on : 12-oct.-2021, 18:34:02
    Author     : Manon Michaux 
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="org.silverolympics.bean.UserAccount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SilverOlympics-Acceuil</title>
        <link rel="stylesheet" href="ressources/css/homepagestyle.css" >
        


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
           
            <h1>Bienvenue sur Silver Olympics </h1>
            
        </div>   
        
        <div class="solobutton"><button> 
                <a href="${pageContext.request.contextPath}/jeusolooptions"> Entraînement </a></button> 
        </div>
        <br>
        <div class="center imagebackground" id="backimage">
           
        </div>
        <script type="text/javascript" src="ressources/js/homepagehandler.js"></script>  
        

        

    </body>
</html>
