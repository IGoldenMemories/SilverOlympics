<%-- 
    Document   : scoreboard
    Created on : 6 févr. 2022, 15:41:04
    Author     : Manon
--%>

<%@page import="java.util.ArrayList"%>
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
        
        <table>
            <tr bgcolor="00FF7F">
                
                <th><b>Nom d'utilisateur</b></th>
                <th><b>Score</b></th>
                
            </tr>
           
            <tr>
                <c:forEach var="entry" items="${authors}">
                    <c:forEach var="value" items="${entry.key}">
                        <c:forEach var="hvalue" items="${value}">
                            <TR>
                                <TD>${entry.value}</TD>
                                <c:if test="${!empty value}">
                                    <TD>${hvalue}<br></TD>
                                </c:if>
                            </TR> 
                        </c:forEach>
                    </c:forEach> 
                                       
                </c:forEach>  
            </tr>
           
        </table>
               
            
    </body>
</html>
