<%-- 
    Document   : formulario1
    Created on : 24 sept 2024, 12:54:34
    Author     : ciclom
--%>

<%@page import="pojos.Alquiler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="pojos.Alquiler" id="alquiler" scope="request"/>
<!DOCTYPE html>
<html>

    <head>
        <title>Formulario 1</title>
        <style>
            body {
                padding: 0;
                margin: 0;
                margin-top: -21px;
                background-color: #FFFFCE;
            }

            h1 {
                background-color: #FED031;
                width: 100%;
                font-weight: bold;
            }

            form {
                display: flexbox;
            }

            .esp {
                margin-left: 160px;
            }

            textarea {
                width: 400px;
                height: 200px;
            }

            label {
                background-color: #9D9A02;
                padding: 3px;
                font-weight: bold;

            }

            input {
                margin-bottom: 6px;
            }
        </style>
    </head>

    <body>
        <h1>VIDEOCLUB ON-LINE</h1>
        <%
            if ((request.getParameter("nombre") == null
                    || request.getParameter("dias") == null
                    || request.getParameter("edad") == null)
                    || (request.getParameter("nombre").equals("")
                    || request.getParameter("dias").equals("")
                    || request.getParameter("edad").equals(""))){
        %>
        <form action="formulario1.jsp">
            <label for="nombre">Nombre Película</label>
            <input type="text" name="nombre" id="nombre" style="margin-left: 36px;">
            <br>
            <label for="dias">Número Días Alquiler</label>
            <input type="number" id="dias" name="dias">
            <br>
            <label for="" class="esp">Edad Cliente</label>
            <label for="pago" class="esp">Forma de Pago</label>
            <br>
            <div class="esp">
                <div style="display: flex; flex-direction: row;">
                    <div>
                        <input type="radio" name="edad" value='<7'>
                        Menor de 7 años
                        <br>
                        <input type="radio" name="edad" value='<14'>
                        Menor de 14 años
                        <br>
                        <input type="radio" name="edad" value='<18'>
                        Menor de 18 años
                        <br>
                        <input type="radio" name="edad" value='+18'>
                        Mayor de 18 años
                    </div>
                    <div>
                        <select name="pago" id="edad" style="margin-top: 32px; margin-left: 117px;">
                            <option value="VISA">VISA</option>
                            <option value="Cheque">Cheque</option>
                            <option value="Contado">Contado</option>
                            <option value="Metalico">Metalico</option>
                        </select>
                    </div>

                </div>
                <br>
                <label for="extra" id="extra">Especificaciones extras</label>
                <br>
                <textarea name="extra"></textarea>
                <br>
                <input type="submit" name="env" value="Enviar Pedido">
                <input type="reset" name="borr" value="Borrar Formulario">
            </div>


        </form>
        <%
            } else {
                    String nombre = request.getParameter("nombre");
                int dias = Integer.parseInt(request.getParameter("dias"));
                String edad = request.getParameter("edad");
                String pago = request.getParameter("pago");
                String extra = request.getParameter("extra");
                
                alquiler.setAlquiler(nombre, dias, edad, pago, extra);
        %>
        <jsp:forward page="formulario2.jsp" />
        <%}%>
    </body>

</html>