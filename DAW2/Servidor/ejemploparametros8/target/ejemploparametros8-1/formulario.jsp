<%-- 
    Document   : formulario
    Created on : 18 sept 2024, 10:44:55
    Author     : ciclom
--%>

<%@page import="com.sun.org.apache.bcel.internal.generic.GOTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="alumno" class="entities.Alumno" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prueba formulario</title>
    </head>
    <body>
        <h1>Prueba formulario</h1>
        <br>
        <%
            if ((request.getParameter("nombre") == null
                    || request.getParameter("apellidos") == null
                    || request.getParameter("email") == null)
                    || (request.getParameter("nombre").equals("")
                    || request.getParameter("apellidos").equals("")
                    || request.getParameter("email").equals(""))) {
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
        %>
        <jsp:forward page="formulario2.jsp" />
        <%
            }
        %>
    </form>
</body>
</html>
