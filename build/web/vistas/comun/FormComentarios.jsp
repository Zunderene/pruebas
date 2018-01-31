<%-- 
    Document   : ArtUser
    Created on : 05-ene-2018, 13:13:13
    Author     : Hector Gonzalez Guerreiro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<div id ="comentarios" >
    
    <div id="listaComentarios">
        <h1> Lista de comentarios </h1>
        <ul>
        <c:forEach items="${requestScope.comentarios}" var="C">
            <li>${C.texto}</li>
        </c:forEach>
        </ul>
    </div>
    <c:if test="${sessionScope.user ne null}">
        <h1>Comentarios</h1>
        <form method="POST">
            <textarea id="Comentario" rows="10" cols="100" name="C" placeholder="Comentario"></textarea>
            <input type="radio" id="privado" name="privaciad" value="privado">
            <label for="privado"><b>privado</b></label>
            <input type="radio" id="publico" name="privaciad" value="publico">
            <label for="publico"><b>publico</b></label>
            <input type="radio" id="personal" name="privacidad" calue="personal">
            <label for="personal"><b>personal</b></label>
            <input type="button" id="boton"  onclick="Comentarios();" value="Subir comentario">
        </form>
    </c:if>
</div>