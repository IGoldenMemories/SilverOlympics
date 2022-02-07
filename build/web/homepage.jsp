<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Acceuil</title>
        <link rel="stylesheet" href="ressources/css/homepagestyle.css" >



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
        <div class="imagebackground">
            <img src="ressources/img/bugsbodovsstock.png" alt="imageback" width="800" height="600">
        </div>

        

    </body>
</html>
