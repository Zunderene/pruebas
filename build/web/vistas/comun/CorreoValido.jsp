<%-- 
    Document   : CorreoValido
    Created on : 24-dic-2017, 20:17:10
    Author     : Hector Gonzalez Guerreiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="CSS/AltaUsuario.css" type="text/css">
<% 
    if ("NO".equals(request.getAttribute("correoValido"))){ 
%> 
<div id="Error" role="alert">
    <strong>Error!</strong> Este correo esta en uso.
</div> 
<% } 
    else 
    {
%>
<div id="sucesful" role="alert">
    <strong>Felicidades!</strong> Tu id esta disponible.
</div>
<%
    }
%>