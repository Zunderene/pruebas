<%-- 
    Document   : Alta Articulo
    Created on : 29-dic-2017, 18:12:06
    Author     : Hector Gonzalez Guerreiro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/FormulariosAltas.css" type="text/css" rel="stylesheet">
        <link href="CSS/Index.css" type="text/css" rel="stylesheet">
        <title> Alta Articulo </title>
    </head>
    <body>
        <%@include file="comun/Cabecera.jsp" %>
        <%@include file="comun/Menu.jsp" %>
        <div id="cabecera">
            <h1> Nuevo Articulo </h1>
        </div>

        <form action="GuardarArticulo" method="POST" id="formulario" enctype="multipart/form-data">
            <div class="container">
                <label><b>Categoria</b></label>*
                <select name="parent_category" id="parent_category">
                    <option value="NA">Seleccionar</option>
                    <option  value="Vehiculos">VEHÍCULOS</option>							
                    <option  value="Inmobiliaria">INMOBILIARIA</option>
                    <option  value="Hogar">HOGAR</option>
                    <option  value="Moda y Belleza">MODA Y BELLEZA</option>
                    <option  value="Para Niños y Bebes">PARA NIÑOS Y BEBÉS</option>
                    <option  value="Electronica" selected="">ELECTRÓNICA</option>						
                    <option  value="Ocio y Deportes">OCIO Y DEPORTES</option>
                    <option  value="Mascotas y Animales">MASCOTAS Y ANIMALES</option>
                    <option  value="Trabajo y Formacion">TRABAJO Y FORMACIÓN</option>
                    <option  value="Negocios y Servicios">NEGOCIOS Y SERVICIOS</option>
                    <option  value="otros">OTROS</option>
                </select>

                <label><b>Nombre</b></label>*
                <input type="text" id="name" name="nombre" required placeholder="Nombre">

                <label><b>Estado</b></label>
                <select name="parent_estade" id="parent_category">
                    <option value="0">Seleccionar</option>
                    <option  value="Nuevo">Nuevo</option>							
                    <option  value="Seminuevo">Seminuevo</option>
                    <option  value="Deteriorado">Deteriorado</option>
                </select>

                <label><b>Año de adquisicion</b> </label>
                <input type="text" id="year" name="y" placeholder=2017>

                <label><b>Precio $</b></label>*
                <input  type="number" step="0.01" id="precio" name="p" min="0" placeholder="0.0">

                <label for="File"><b>Foto</b></label>*
                <input type="file" class="form-control-file" required value="" name="f" id="f">


                <label><b>Descripcion</b></label>
                <textarea id="Descripcion" rows="10" cols="300" name="Des" placeholder="Descripcion"></textarea>

                <div class="container" style="background-color:#f1f1f1">
                    <button type="submit" class="btn btn-primary" >Enviar</button>
                </div>
            </div>
        </form>

        <footer><h6>© Copyright 2018, Hector Gonzalez Guerreiro</h6></footer>
    </body>
    <script src="JS/Almacenamiento.js" type="text/javascript"> </script>
</html>
