<%-- 
    Document   : Favoritos
    Created on : 30-dic-2017, 19:11:44
    Author     : hecto
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/Index.css" type="text/css" rel="stylesheet">
        <title> Articulos </title>
    </head>

    <body data-spy="scroll" data-target=".navbar" data-offset="50">
        <%@include file="comun/Cabecera.jsp" %>
        <%@include file="comun/Menu.jsp" %>
        
        <div id="cabecera">
            <h1> Articulos </h1>
        </div>
        <div>
            <form id="formFiltro" action="filtro">
                <ul id="cont">
                    <li><label><b>Categoria</b></label>
                    <select name="parent_category" id="categoria">
                            <option value="NA"selected="">Seleccionar</option>
                            <option  value="Vehiculos">VEHÍCULOS</option>							
                            <option  value="Inmobiliaria">INMOBILIARIA</option>
                            <option  value="Hogar">HOGAR</option>
                            <option  value="Moda y Belleza">MODA Y BELLEZA</option>
                            <option  value="Para Niños y Bebes">PARA NIÑOS Y BEBÉS</option>
                            <option  value="Electronica">ELECTRÓNICA</option>						
                            <option  value="Ocio y Deportes">OCIO Y DEPORTES</option>
                            <option  value="Mascotas y Animales">MASCOTAS Y ANIMALES</option>
                            <option  value="Trabajo y Formacion">TRABAJO Y FORMACIÓN</option>
                            <option  value="Negocios y Servicios">NEGOCIOS Y SERVICIOS</option>
                            <option  value="otros">OTROS</option>
                    </select>
                    </li>
                    <li> <label><b>Precio Minimo $</b></label>
                         <input  type="number" step="0.01" id="pmm" name="p" min="0" placeholder="0.0">
                    </li>
                    <li> <label><b>Precio Maximo $</b></label>
                         <input  type="number" step="0.01" id="pme" name="pm" min="0" placeholder="0.0">
                    </li>
                    <li> <label><b>Codigo Postal</b></label>
                         <input type="text" id="CodigoPostal" name="CP" >
                    </li>
                    <li> <input type="submit" title="Filtrar"></li>
                    <li> <input type="reset" title="Borrar"></li>
                </ul>
            </form>
        </div>
    
    <div id="contenido">
        <%@include file="comun/ManejaArticulos.jsp" %>
    </div>

</body>
<script src="JS/InsercionCodigo.js" type="text/javascript"></script>
<script src="JS/Almacenamiento.js" type="text/javascript"> </script>
</html>
