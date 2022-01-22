<%-- 
    Document   : logout
    Created on : 23-nov.-2021, 16:31:36
    Author     : Manon Michaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Déconnection</title>
    </head>
    <body>
        <h1>
            <%
                session.invalidate();
                response.sendRedirect("index.jsp"); //once the session destroyed the user is redirected to the base homepage
                %>
            
            
        </h1>
    </body>
</html>
