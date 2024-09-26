<%-- 
    Document   : productos.jsp
    Created on : 25 sept 2024, 12:19:59
    Author     : ciclom
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                justify-items: center;
                margin: 0;
                padding: 0;
                background-color: #fae9f1;

            }

            .cont {
                gap: 100px;
                margin-top: 20px;
                width: 86vw;
                display: flex;
                flex-wrap: wrap;
                margin-left: auto;
                margin-right: auto;
                justify-content: center;
            }

            .obj {
                border-style: groove;
                border-width: 2px;
                border-color: #4e091e;
                width: 200px;
                height: 300px;
                background: #EECDA3;
                background: -webkit-linear-gradient(to right, #EF629F, #EECDA3);
                background: linear-gradient(to right, #EF629F, #EECDA3);
                align-content: center;
                border-radius: 8px;
            }

            form {
                color: #4e091e;
                text-align: center;
                display: flex;
                flex-direction: column;
                gap: 10px;
            }

            .subm {
                background-color: #fad0e4;
                border-radius: 12px;
                color: #4e091e;
                margin-left: 30px;
                margin-right: 30px;
                height: 40px;
                margin-top: 20px;
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
            La epiquisima tienda del epiquisimo javi
            <a href="./carrito.jsp">Carrito</a>
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
        <div class="cont">
            <%
                request.setAttribute("cart", false);
                DecimalFormat df = new DecimalFormat("#.##");
                for (Producto p : ProductData.getData()) {
            %>
            <div class="obj">
                <form action="CarritoServlet" method="post">
                    <label for="<%=p.getId()%>"><%=p.getNombre()%></label>
                    <br>
                    <%out.println(df.format(p.getPrecio()) + "€");%>
                    <br>
                    <input type="submit" name="add" id="add" class="subm" value="Añadir <%=p.getNombre()%>">
                </form>
            </div>
            <%
                }
            %>
        </div>

    </body>

</html>
