<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SilverOlympics-Acceuil</title>
        <link rel="stylesheet" href="ressources/css/Homepage.css" >



    </head>
    <body>
        <!-- Display of the header/navigation tab -->
        
        <div class = "header">
            
            <a href="/Acceuil">Acceuil</a>
            <a href="${pageContext.request.contextPath}/logout.jsp">Déconnection</a>
            <a href="${pageContext.request.contextPath}/classement">Classement</a>
            <a href="${pageContext.request.contextPath}/aide">Aide</a>
     
        </div>

        <div class="title">
            <%
            if(session.getAttribute("login")==null || session.getAttribute("login")==""){
                response.sendRedirect("index.jsp");
                
            }
            %>
            <br>
            <h1>Bienvenue sur Silver Olympics,</br> <%=session.getAttribute("login")%></h1>
        </div>
        <div class=" bodyhomepage">       
               
            <button class= "button buttonsolo" onclick="document.location = 'login.jsp'">Partie Solo</button> 
            
            <button class = "button buttonmulti" onclick="document.location = 'login.jsp'">Partie Multi</button>
            <div class="imagebackground">
               <img src="ressources/img/bugsbodovsstock.png" alt="imageback" width="800" height="600">
            </div>

        </div>

    </body>
</html>
