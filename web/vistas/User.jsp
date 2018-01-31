<%-- 
    Document   : Home
    Created on : 23-dic-2017, 12:22:06
    Author     : Hector Gonzalez Guerreiro
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/Index.css" type="text/css">
        <link rel="stylesheet" href="CSS/AltaUsuario.css" type="text/css">
        <title>SSR</title>
    </head>

    <body>
       
        <%@include file="comun/Cabecera.jsp" %>
        <%@include file="comun/Menu.jsp" %>

        <div id="cabecera">
            <h1> Usuario </h1>
        </div>
        
        <jsp:useBean id="Usuario" scope="request" class="SegundaMano.Usuario" />
        
        <form action="EditarUser" method="POST" id="formulario" onsubmit="return comprobarFormulario();">
            <div class="container">
                <label><b>Correo</b></label>
                <input type="email" id="IDcorreo" disabled name="IDcorreo" placeholder='<jsp:getProperty name="Usuario" property="nick" />' >
                 
                <label><b>Antigua Contraseña</b></label>
                <input  type="password" id="OldContraseña" name="Oldpass"  required pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" placeholder="Antigua Contraseña ">
                
                <label><b>Nueva Contraseña</b></label>
                <input  type="password" id="contraseña" name="pass"  required pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" placeholder="Contraseña ">
                <small>  Debe tener caracteres mayusculas y minusculas y al menos un numero </small> </br></br>

                <label><b>Repetir Contraseña</b></label>
                <input type="password" id="Rcontraseña"  name="Rpass" required pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" placeholder="Repetir Contraseña" onchange="contraseñaCoinciden();">
                <div id = "estatusContraseña"></div>

                <label><b>Direccion</b></label>
                <input type="text" id="Direccion" name="Direccion" placeholder='<jsp:getProperty name="Usuario" property="direccion" />'>

                <label><b>Codigo Postal</b></label>*
                <input type="text" id="CP" name="CP" required placeholder='<jsp:getProperty name="Usuario" property="CP" />' pattern="[0-9]{5}">

                <label><b>Facebook</b> </label>
                <input type="text" id="FA"  name="FA" placeholder='<jsp:getProperty name="Usuario" property="faceboock" />'>

                <label><b>Twiter</b></label>
                <input  type="text" id="TW" name="TW" placeholder='<jsp:getProperty name="Usuario" property="twiter" />'>

                <label><b>Telefono</b></label>
                <input  type="text" id="Telefono" name="Telefono" pattern="[0-9]{9}" placeholder='<jsp:getProperty name="Usuario" property="telefono" />'>

                <!--<label for="File">Avatar</label>
                <input type="file" class="form-control-file" id="exampleFormControlFile1" value="" name="file">
                -->

                <!--Insertar un catchap para el alta.-->

                <div class="container" style="background-color:#f1f1f1">
                    <button type="submit" class="btn btn-primary">Editar</button>
                </div>
            </div>
        </form>

        <footer><h6>© Copyright 2018, Hector Gonzalez Guerreiro</h6></footer>
    </body>
    <script src="JS/Almacenamiento.js" type="text/javascript"> </script>
</html>
