
/*Funcion que añade en una sesion una lista de favoritos*/

function añadirFavoritos(id){
    
    if(sessionStorage.getItem('listaFavoritos') === null){
        var  lista = [];
        lista.push(id);
        sessionStorage.setItem('listaFavoritos',lista);
    }
    else{
        var lista = sessionStorage.getItem('listaFavoritos');
        lista = lista + "," + id;
        var listaEle = lista.split(',');
        var existe = false;
        var num = 0;
        while(listaEle.length > num && !existe){
            if(listaEle[num] ===id)
                existe = true;
            else
                num++;
        }
        
        if(!existe)
            sessionStorage.setItem('listaFavoritos',lista);
    }
    
    var boton = document.getElementById('fav');
    boton.setAttribute('disabled',false);
    
}



