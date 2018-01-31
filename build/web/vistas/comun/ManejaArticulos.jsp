<%-- 
    Document   : ManejaArticulos
    Created on : 30-dic-2017, 21:51:30
    Author     : Hector Gonzalalez Guerreiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/Articulos.css" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Fjalla+One" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Quattrocento" rel="stylesheet">
    </head>
    <body>
        <c:forEach items="${requestScope.articulos}" var="Articulos">
            <div class="floatin-box">
                <c:if test="${Articulos.imagen ne null}">
                    <img src="http://localhost:8080/SegundaMano/Foto?id=${Articulos.id}"/></li>
                </c:if>

                <p>${Articulos.categoria}</p>
                <p>${Articulos.nombreArticulo}</p>
                <p>CP ${Articulos.art.CP}</p>
                <p>${Articulos.precio} €</p>

                <a id="button" href="ArticulosInfo?IdenArticulo=${Articulos.id}">Detalle</a>

            </div>

    </c:forEach>
    <c:choose >
        <c:when test="${requestScope.sice > 0}">
            <div  id="page">
                <c:forEach begin="0" end="${requestScope.cont}" var="i">
                    <c:choose>
                        <c:when test="${requestScope.p == i}">
                            <li><a href="ArticulosPagina?np=${i}">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                            <li><a href="ArticulosPagina?np=${i}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
            </div>
        </c:when>

        <c:when test="${requestScope.sice == 0}">
            <h2 style="opacity: 0.5 ; text-align: center;">
                NO HAY ELEMENTOS
            </h2>
        </c:when>

    </c:choose>
</body>
 <script src="JS/InsercionCodigo.js" type="text/javascript"></script>
</html>
