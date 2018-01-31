<%-- 
    Document   : Articulos
    Created on : 30-dic-2017, 19:11:44
    Author     : Hector Gonzalez Guerreiro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="SegundaMano.Articulos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/Articulos.css" type="text/css" rel="stylesheet">
        <link href="CSS/Index.css" type="text/css" rel="stylesheet">
        <script src="JS/InsercionCodigo.js" type="text/javascript"></script>
        <title> Articulos </title>
    </head>

    <body data-spy="scroll" data-target=".navbar" data-offset="50">
        <%@include file="comun/Cabecera.jsp" %>
        <%@include file="comun/Menu.jsp" %>
        
        <div id="cabecera">
            <h1> Favoritos </h1>
        </div>
       
        <script> enviarSession(); </script>
    <div id="contenido">
       
    </div>

</body>

<script src="JS/Almacenamiento.js" type="text/javascript"> </script>
</html>
