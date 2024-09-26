<%-- 
    Document   : formulario2
    Created on : 19 sept 2024, 12:01:13
    Author     : ciclom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="alumno" class="entities.Alumno" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario 2</h1>
        <%
            out.println("El nombre es: " +alumno.getNombre() + "<br>");
            out.println("Los apellidos son: " +alumno.getApellidos() + "<br>");
            out.println("El email es: " +alumno.getEmail() + "<br>");
            %>
    </body>
</html>
