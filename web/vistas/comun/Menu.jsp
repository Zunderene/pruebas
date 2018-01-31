<%-- 
    Document   : noLogin
    Created on : 23-dic-2017, 12:34:45
    Author     : Hector Gonzalez Guerreiro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div> 
    <ul id = "Menu">
        <li><a  href="Home">Home</a></li>
        <li><a  href="VerArticulos">Articulos</a></li>

        <c:choose>
            <c:when test='${sessionScope.user != null}'>
                <li><a  href="FArticulo?np=${i}">Alta Articulos</a></li>
                <li><a  href ="Favoritos">Favoritos</a></li>
            </c:when>
        </c:choose>

        <li id="search">
            <form id="formularioSearch">
                <input  type="text" placeholder="Busqueda Articulos">
                <button  type="submit">Buscar</button>
            </form>
        </li>
    </ul>
</div>


