'use strict';
function peticionGet(){
    let url="../php/procesarGetPost.php"
    let peticion = new XMLHttpRequest()
    peticion.open('POST', url)
    peticion.addEventListener('load', function(){
        if (peticion.status == 200){
            document.querySelector('body').innerHTML = peticion.responseText
        }
    })
    peticion.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
    let parametros = "nombre=Ada&apellidos=Lovelace"
    peticion.send(parametros)
}
window.addEventListener('load', peticionGet)