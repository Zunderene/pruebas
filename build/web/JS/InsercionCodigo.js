var xhr;


function init_ajax() {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }

}

function correoValido(){
    if(xhr.readyState === 4 && xhr.status === 200){
        document.getElementById("CorreoValido").innerHTML = xhr.responseText;
    }
}

function comprobarCorreo(){
    init_ajax();
    
    var url = "comprobarCorreo";
    xhr.open("POST",url,true);
    xhr.onreadystatechange = correoValido;
    
    var id = document.getElementById("IDcorreo");
    var datos = "id=" + encodeURIComponent(id.value);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(datos);
}

function comprobarFormulario(){
    var ok = true;
    var msg = "ERROR ";
    var pass1 = document.getElementById("contraseña");
    var pass2 = document.getElementById("Rcontraseña");
    
    
    if(pass1.value !== pass2.value){
        msg = msg + "Contraseñas no coinciden";
        ok = false;
    }
    
    if(!ok) alert(msg);
    return ok;
    
}

function contraseñaCoinciden(){
    var pass1 = document.getElementById("contraseña");
    var pass2 = document.getElementById("Rcontraseña");
    if(pass1.value !== pass2.value){
        document.getElementById("estatusContraseña").innerHTML = '<link rel="stylesheet" href="CSS/AltaUsuario.css" type="text/css"> <div id="Error"><strong>Error!</strong> La contraseña no coinciden.</div>';
    }
    else{
        document.getElementById("estatusContraseña").innerHTML = '<link rel="stylesheet" href="CSS/AltaUsusario.css" type="text/css"> <div id="sucesful"> <strong>Aceptada!</strong> La contraseña coinciden.</div>';
    }
}



function cargarComentario(){
    if(xhr.readyState === 4 && xhr.status === 200){
        document.getElementById("listaComentarios").innerHTML = xhr.responseText;
    }
}

function Comentarios(){
    init_ajax();
    var url = "subirComentario";
    xhr.open("POST",url,true);
    xhr.onreadystatechange = cargarComentario;
    
    var comentario = document.getElementById("Comentario");
    var privado = document.getElementById("privado");
    var publico = document.getElementById("publico");
    var personal = document.getElementById("personal");
    
    var datos = "comentario=" + encodeURIComponent(comentario.value)
                + "&privado=" + encodeURIComponent(privado.checked)
                + "&publico=" + encodeURIComponent(publico.checked)
                + "&personal=" + encodeURIComponent(personal.checked)
                + "&id_articulo=" + localStorage.getItem("ArticuloEnVision");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(datos);
    
}

function cargarFavoritos(){
    if(xhr.readyState === 4 && xhr.status === 200){
        document.getElementById("contenido").innerHTML = xhr.responseText;
    }
}
function enviarSession(){
    init_ajax();
    var url = "FavoritosPagina";
    xhr.open("POST",url,true);
    xhr.onreadystatechange = cargarFavoritos;
    var datos = 'datos=' + sessionStorage.getItem('listaFavoritos');
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(datos);
}

function GuardarSesionArticulo(id){
    localStorage.setItem("ArticuloEnVision", id);
}





