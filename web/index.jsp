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
        <link rel="stylesheet" href="../css/Homepage.css" >


    </head>
    <body>
        <!-- Display of the header/navigation tab -->
        <div class = "header">
            <!-- Redirects to the "same" homepage  -->
            <a href="homepage.jsp">Acceuil</a>
            <!-- Opens a pop-up to   allow the user to connect themselves to their establishment's account -->
            <a href='#' onclick= 'javascript:window.open("login.jsp", "_blank", "scrollbars=1,resizable=1,height=300,width=450")'>Connection</a>
            <a href="${pageContext.request.contextPath}/classement">Classement</a>
            <a href="${pageContext.request.contextPath}/aide">Aide</a>
     
        </div>

        <div class="title">
            <br>
            <h1>Bienvenue sur Silver Olympics </h1>
            
        </div>   
          
        <div class="gamebuttons">
            <div class="center">
                <button class= "button buttonsolo" onclick="popupsolo()"> Entraînement</button> 
                
                <button class = "button buttonmulti" onclick="popupmulti()">Partie Multi</button>
                
                <script>
                    function popupsolo() {
                        window.open("sologameoptions.jsp", "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,top=200,left=500,width=650,height=850");
                    }
                    
                    function popupmulti() {
                        window.open("multigameoptions.jsp", "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,top=200,left=500,width=650,height=400");
                    }
                    
                </script>
                
            </div>
        </div>
            </br>
        <div class="imagebackground">
            <img src="ressources/img/bugsbodovsstock.png" alt="imageback" width="800" height="600">
        </div>

        

    </body>
</html>
