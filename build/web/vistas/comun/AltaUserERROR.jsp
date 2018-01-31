<%-- 
    Document   : MensageUsuario
    Created on : 25-dic-2017, 14:16:37
    Author     : Hector Gonzalez Guerreiro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MSG</title>
    </head>
    <body>
        <fieldset>
            <c:choose>
                <c:when test='${requestScope.msg} == "NO"'>
                    <h2> A sido imposible insertar el nuevo usuario en nuestra base de datos. Desea intentarlo de nuevo </h2>
                    <nav> <a href="Home.jsp"> HOME </a> | <a href="vistas/FAltaUser.jsp"> Intentarlo de nuevo </a> </nav>
                </c:when>
            </c:choose>
            
        </fieldset>
    </body>
</html>
