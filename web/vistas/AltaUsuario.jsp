<%-- 
    Document   : Alta 
    Created on : 24-dic-2017, 18:50:03
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
        <title>SSR ALTA</title>
    </head>
    <body>

        <%@include file="comun/Cabecera.jsp" %>
        <%@include file="comun/Menu.jsp" %>

        <div id="TextCabecera">
            <h1> Alta de Usuario </h1>
        </div>

        <form action="darAlta" method="POST" id="Formulario" onsubmit="return comprobarFormulario();">
            <div class="container">
                <label><b>Correo</b></label>*
                <input type="email" id="IDcorreo" name="IDcorreo" placeholder="Correo" required onchange="comprobarCorreo();">
                <div id ="CorreoValido"></div>

                <label><b>Contraseña</b></label>*
                <input  type="password" id="contraseña" name="pass"  required pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" placeholder="Contraseña ">
                <small>  Debe tener caracteres mayusculas y minusculas y al menos un numero </small> </br></br>

                <label><b>Repetir Contraseña</b></label>*
                <input type="password" id="Rcontraseña"  name="Rpass" required pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" placeholder="Repetir Contraseña" onchange="contraseñaCoinciden();">
                <div id = "estatusContraseña"></div>

                <label><b>Nombre</b></label>*
                <input type="text" id="name" name="name" required placeholder="Nombre">

                <label><b>Direccion</b></label>
                <input type="text" id="Direccion" name="Direccion" placeholder="Direccion">

                <label><b>Codigo Postal</b></label>*
                <input type="text" id="CP" name="CP" placeholder="21450" required pattern="[0-9]{5}">

                <label><b>Facebook</b> </label>
                <input type="text" id="FA"  name="FA" placeholder="">

                <label><b>Twiter</b></label>
                <input  type="text" id="TW" name="TW" placeholder="">

                <label><b>Telefono</b></label>*
                <input  type="text" id="Telefono" name="Telefono" required pattern="[0-9]{9}" placeholder="959390850">

                <!--<label for="File">Avatar</label>
                <input type="file" class="form-control-file" id="exampleFormControlFile1" value="" name="file">
                -->

                <!--Insertar un catchap para el alta.-->

                <div class="container" style="background-color:#f1f1f1">
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </div>
            </div>
        </form>
        <footer><h6>© Copyright 2018, Hector Gonzalez Guerreiro</h6></footer>

    </body>
    <script src="../JS/Almacenamiento.js" type="text/javascript"> </script>
    <script src="../JS/InsercionCodigo.js" type="text/javascript"> </script>
</html>
