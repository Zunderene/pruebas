<%-- 
    Document   : session
    Created on : 30-ene-2018, 16:44:49
    Author     : Hector Gonzalez Guerreiro
--%>
<!DOCTYPE html>

<nav>
    <c:choose>
        <c:when test='${sessionScope.user !=null}'>
            <p>${sessionScope.user} | <a href="VerUser">Mi perfil</a> | <a href="deslog"> Desconexion</a> </p>
        </c:when>
        <c:otherwise>
            <a href="FAltaUser">Registro</a> |
            <a href="FLogin">Inicio Sesion</a>
        </c:otherwise>
    </c:choose>
</nav>