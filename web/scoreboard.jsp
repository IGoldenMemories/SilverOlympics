<%-- 
    Document   : scoreboard
    Created on : 6 févr. 2022, 15:41:04
    Author     : Manon
--%>

<%@page import="org.silverolympics.bean.UserAccount"%>
<%@page import="org.silverolympics.controller.ServletUtility"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Classement </title>
    </head>
    <body>
        <h1>Tableau de score</h1>
        
        <table class="scoretable" border="1">
            <thead>
                <tr>
                    <!-- Table headers -->
                    <td></td>
                    <td>Nom</td>
                    <td>Total de points</td>
                </tr>
            </thead>
            <tbody>
                <%
                    int index=1;
                    List list= request.getAttribute("listuser");
                    Iterator it=list.iterator();
                    while(it.hasNext()){
                        UserAccount user= (UserAccount)it.next();
                %>
                <tr>
                    <th scope="row"><%=index++%></th>
                    <td><%=user.getUserName()%></td>
                    <td><%=user.getUserScore()%></td>
                </tr>
                <%} %>
                
            </tbody>
            </table>
            
    </body>
</html>
