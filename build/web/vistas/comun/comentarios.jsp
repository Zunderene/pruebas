<%-- 
    Document   : Comentarios
    Created on : 05-ene-2018, 1:41:10
    Author     : Alistair
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

   <ul>
        <c:forEach items="${requestScope.comentarios}" var="C">
            <li>${C.texto}</li>
        </c:forEach>
    </ul>

