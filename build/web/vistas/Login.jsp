<%-- 
    Document   : Login
    Created on : 26-dic-2017, 14:32:17
    Author     : Hector Gonzalez Guerreiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="CSS/Login.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        
        <div id="cabecera">
            <h1>Mi Cuenta</h1>
        </div>

        <form action="login" method="POST">

            <div class="container">
                <label><b>Username</b></label>
                <input type="email" placeholder="Enter Username" name="nick" id="nick" required>

                <label><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="pass" id="pass" required>

                <button type="submit">Conectarse</button>
                <input type="checkbox" checked="checked"> Recordarme
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" class="cancelbtn" onclick='location="Home"'>Cancel</button>
                <span class="psw">Olvidaste <a href="#">Contraseña?</a></span>
            </div>
            
            <c:choose>
                <c:when test='${requestScope.msg == "NO"}'>
                    <div id="Error" role="alert">
                        <strong>Error!</strong> Usuario o Contraseña erroneas.
                    </div>
                </c:when>
            </c:choose>
            
        </form>
    </body>
    <script src="JS/Almacenamiento.js" type="text/javascript"> </script>
</html>