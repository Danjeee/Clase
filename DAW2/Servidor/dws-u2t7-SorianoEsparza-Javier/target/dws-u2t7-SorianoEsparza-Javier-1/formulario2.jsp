<%-- 
    Document   : formulario2
    Created on : 24 sept 2024, 13:11:04
    Author     : ciclom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="alquiler" class="pojos.Alquiler" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            *{
                font-size: 30px;
            }
        </style>
    </head>
    <body>
        <strong>Usted indicó la siguiente información:</strong>
        <br>
        <strong>Pelicula: </strong>
        <%
            out.println(alquiler.getPelicula());
        %>
        <br>
        <strong>Dias de alquiler: </strong>
        <%
            out.println(alquiler.getDias());
        %>
        <br>
        <strong>Edad Cliente: </strong>
        <%
            out.println(alquiler.getEdad());
        %>
        <br>
        <strong>Forma de pago: </strong>
        <%
            out.println(alquiler.getPago());
        %>
        <%
            if (alquiler.getExtra() != null) {
                if (!alquiler.getExtra().equals("")) {
        %>
        <br>
        <strong>Extra: </strong>
        <%
                    out.println(alquiler.getExtra());
                }
            }
        %>
        <br>
        <strong>¡Disfrute de la pelicula!</strong>
    </body>
</html>
