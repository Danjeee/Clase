<%-- 
    Document   : formulario
    Created on : 18 sept 2024, 10:44:55
    Author     : ciclom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.*"%>
<jsp:useBean id="alumno" class="entities.Alumno"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prueba formulario</title>
    </head>
    <body>
        <h1>Prueba formulario</h1>
        <br>  
        <% Alumno alumno = new Alumno(); %>
        <%
            if ((request.getParameter("nombre") == null||
            request.getParameter("apellidos") == null||
            request.getParameter("email") == null) 
            || 
            (request.getParameter("nombre").equals("")||
            request.getParameter("apellidos").equals("")||
            request.getParameter("email").equals(""))){
                out.println("<form method='POST' action='formulario.jsp'>");
        %>

        Su nombre: <input type="text" name="nombre" size="50">
        <br>
        Sus apellidos: <input type="text" name="apellidos" size="50">
        <br>
        Su email: <input type="text" name="email" size="50">
        <br>
        <input type="submit" value="Enviar">
        <% } else {
            alumno.setApellidos(request.getParameter("apellidos"));
            alumno.setNombre(request.getParameter("nombre"));
            alumno.setEmail(request.getParameter("email"));
            out.println("El nombre es: " +alumno.getNombre() + "<br>");
            out.println("Los apellidos son: " +alumno.getApellidos() + "<br>");
            out.println("El email es: " +alumno.getEmail() + "<br>");
            }
        %>
    </form>
</body>
</html>
