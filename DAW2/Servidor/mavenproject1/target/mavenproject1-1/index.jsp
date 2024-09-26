<%-- 
    Document   : index.jsp
    Created on : 16 sept 2024, 11:35:14
    Author     : ciclom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        La edad actual mia es: <%= 10 + 9%>
        <br>
        Aqui producimos un error (Ya no): <%= 10/1%>
        <br>
        Fecha actual: <%= new Date() %>
        <br>
        <%
            double a = Math.random();
            if (a < 0.5){
            out.println("El valor del numero generado es menor a 0.5 ("+a+")");
            } else {
            out.println("El valor del numero generado es mayor a 0.5 ("+a+")");
            }
        %>
        <br>
        La ip del cliente es <%= request.getRemoteHost() %>
    </body>
</html>
