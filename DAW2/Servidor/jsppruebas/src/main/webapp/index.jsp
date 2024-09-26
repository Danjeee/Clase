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
        Aqui producimos un error: <%= 10/0%>
        <br>
        Fecha actual: <%= new Date() %>
        <br>
        <%
            double a = Math.random();
            out.println("El valor del numero generado es: "+a);
        %>
    </body>
</html>
