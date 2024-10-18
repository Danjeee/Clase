'use strict';
function peticionGet(){
    let url="../php/procesarGetPost.php?nombre=Ada&apellidos=Lovelace"
    let peticion = new XMLHttpRequest()
    peticion.open('GET', url)
    peticion.addEventListener('load', function(){
        if (peticion.status == 200){
            document.querySelector('body').innerHTML = peticion.responseText
        }
    })
    peticion.send()
}
window.addEventListener('load', peticionGet)