<%-- 
    Document   : ArticuloInfo
    Created on : 04-ene-2018, 14:21:23
    Author     : Hector Gonzalez Guerreiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/Index.css" type="text/css" rel="stylesheet">
        <link href="CSS/DetallesArticulo.css" type="text/css" rel="stylesheet">
        <title>${requestScope.Articulo.nombreArticulo} </title>
    </head>

    <body data-spy="scroll" data-target=".navbar" data-offset="50">
        <script>
            var a = ${requestScope.Articulo.id};
            localStorage.setItem("ArticuloEnVision", a);
        </script>
        <div>
            <%@include file="comun/Cabecera.jsp" %>
            <%@include file="comun/Menu.jsp" %>

           
            <jsp:useBean id="Articulo" scope="request" class="SegundaMano.Articulos" />
            <div id="infoArticulo">
                <h1>ARTICULO</h1>
                <c:if test="${Articulo.imagen ne null}">
                    <img id = "Imagen" src="http://localhost:8080/Segunda_Mano_WEB/Foto?id=${Articulo.id}"/></li>
                </c:if>
                <p> Categoria  <jsp:getProperty name="Articulo" property="categoria" /> </p>
                <p> Nombre <jsp:getProperty name="Articulo" property="nombreArticulo" /></p>
                <p> Año <jsp:getProperty name="Articulo" property="año" /> </p>
                <p> Estado <jsp:getProperty name="Articulo" property="estado" /></p>
                <p> Precio <jsp:getProperty name="Articulo" property="precio" /> €</p>
                <p class="ajustado"> <jsp:getProperty name="Articulo" property="descripcion" /></p>
                <c:if test="${sessionScope.user ne null}">
                    <input id="fav" type="button" value="Añadir a favoritos" onclick="añadirFavoritos('${Articulo.id}');">
                </c:if>

            </div>

            <div id="user">
                <h1>Usuario</h1>
                <jsp:useBean id="Usuario" scope="request" class="SegundaMano.Usuario" />
                <p> Nombre <jsp:getProperty name="Usuario" property="name" /> </p>
                <p> Codigo postal <jsp:getProperty name="Usuario" property="CP" /> </p>
                <p> Direccion <jsp:getProperty name="Usuario" property="direccion" /> </p>
                <p> Faceboock <jsp:getProperty name="Usuario" property="faceboock" /> </p>
                <p> Twiter <jsp:getProperty name="Usuario" property="twiter" /> </p>
                <p> Telefono <jsp:getProperty name="Usuario" property="telefono" /> </p>
            </div>
            <div>

            <%@include file="comun/FormComentarios.jsp" %>

            </div>
    <footer><h6>© Copyright 2018, Hector Gonzalez Guerreiro</h6></footer>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="JS/InsercionCodigo.js" type="text/javascript"></script>
    <script src="JS/Almacenamiento.js" type="text/javascript"></script>
</html>
