<%-- 
    Document   : carrito.jsp
    Created on : 25 sept 2024, 13:14:21
    Author     : ciclom
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<%@page import="pojos.*" %>
<jsp:useBean id="carrito" class="pojos.Carrito" scope="session"/>
<!DOCTYPE html>
<html>

    <head>
        <title>Carrito Javier</title>
        <style>
            body {
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                margin: 0;
                padding: 0;
                background-color: #fae9f1;

            }

            .cont {
                gap: 10px;
                margin-top: 20px;
                width: 86vw;
                display: flex;
                flex-wrap: wrap;
                margin-left: auto;
                margin-right: auto;
            }

            .obj {
                border-style: groove;
                border-width: 2px;
                border-color: #4e091e;
                width: 97%;
                height: 100px;
                background: #EECDA3;
                background: -webkit-linear-gradient(to right, #EF629F, #EECDA3);
                background: linear-gradient(to right, #EF629F, #EECDA3);
                align-content: center;
                border-radius: 8px;
            }

            form {
                color: #4e091e;
                text-align: center;
                align-content: center;
                display: flex;
                flex-direction: row;
                gap: 30px;
                align-items: center;
                font-weight: bold;
                justify-content: center;
                font-size: 20px;
            }
            form *{
                margin-left: auto;
                margin-right: auto;
            }

            .subm {
                background-color: #fad0e4;
                border-radius: 12px;
                color: #4e091e;
                margin-left: 30px;
                margin-right: 30px;
                height: 40px;
            }

            .subm:hover {
                color: #fad0e4;
                background-color: #4e091e;
                cursor: pointer;
            }

            label {
                margin-bottom: -10px;
            }

            .menu {
                width: 100%;
                display: flex;
                align-items: center;
                justify-content: center;
                height: 100px;
                background: #C33764;
                background: -webkit-linear-gradient(to right, #1D2671, #C33764);
                background: linear-gradient(to right, #1D2671, #C33764);
                color: white;
                margin-bottom: 50px;
                text-align: center;
                align-content: center;
                font-size: 30px;
                font-weight: bold;
                font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
            }
            a{
                text-decoration: none;
                text-overflow: none;
                color: #fad0e4;
                border-color: #fad0e4;
                background-color: #C33764;
                padding: 10px;
                border-radius: 15px;
                border-style: solid;
                margin-left: 50px;
            }
            a:hover{
                background-color: #fad0e4;
                color: #C33764;
                border-color: #C33764;
                cursor: pointer;
            }
            .footer{
                position: absolute;
                bottom: 0;
                width: 100%;
                height: 100px;
                background: #C33764;
                background: -webkit-linear-gradient(to right, #1D2671, #C33764);
                background: linear-gradient(to right, #1D2671, #C33764);
                color: white;
                text-align: center;
                align-content: center;
                font-size: 30px;
                font-weight: bold;
                font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
            }
            .notif{
                position: relative;
                background-color: black;
                width: 30px;
                height: 30px;
                margin-top: 52px;
                margin-left: -20px;
                border-radius: 30px;
                color: #fad0e4;
                border-color: #fad0e4;
                background-color: #C33764;
                border-radius: 15px;
                border-style: solid;
                text-align: center;
                align-content: center;
                font-size: 20px;
            }
        </style>
    </head>

    <body>
        <div class="menu">
            El epiquisimo carrito del epiquisimo javi
            <a href="./productos.jsp">Tienda</a>
            <%
                if (!carrito.getData().isEmpty()) {
                    Enumeration e = carrito.getData().keys();
                    int total = 0;
                    while (e.hasMoreElements()) {
                        total += (int) carrito.getData().get(e.nextElement());
                    }
            %>
            <div class="notif"><%=total%></div>
            <%
                }
            %>
        </div>
        <%
            double preciototal = 0;
            DecimalFormat df = new DecimalFormat("#.##");
            request.setAttribute("cart", true);
            Enumeration a = carrito.getData().keys();
            while (a.hasMoreElements()) {
                String clave = (String) a.nextElement();
                double precio = 0.0;
                String precioformat = "";
                for (Producto p : ProductData.getData()) {
                    if (p.getNombre().equals(clave)) {
                        precio = p.getPrecio();
                        precioformat = df.format(precio);
                    }
                }
                
                int cant = (int) carrito.getData().get(clave);
                preciototal += (precio * cant);
        %>
        <div class="cont">
            <div class="obj">
                <form action="CarritoServlet" method="post">
                    <p><%=clave%></p>
                    <p><%= carrito.getData().get(clave)%> uds</p>
                    <p><%=df.format(precio * cant)%>€ (<%=precioformat%>€/ud)</p>
                    <input type="submit" name="rem" id="rem" class="subm" value="Quitar <%=clave%> del carrito">
                </form>
            </div>
        </div>
        <%}%>
        <div class="footer">
            Total: <%=df.format(preciototal)%>€
        </div>

    </body>

</html>
