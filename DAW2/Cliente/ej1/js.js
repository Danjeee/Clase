var cont = 0;
var cont2 = 0;
var cont3 = 0;
var cont4 = 0;
function showmsg() {
    alert("hola desde el boton 1")
}

function boton4(){
    let main = document.getElementById("main")
    cont3++
    if (cont3 == 1){
        let form = document.createElement("form")
        form.id = "form"
        let txtimp = document.createElement("input")
        txtimp.id = "txtimp"
        txtimp.setAttribute("type", "text")
        let sub = document.createElement("env")
        sub.innerHTML = "Enviar"
        sub.id = "enviar"
        sub.addEventListener('click', botonenviar)
        form.appendChild(txtimp)
        form.appendChild(sub)
        main.appendChild(form)
    }
    
}
function botonenviar(){
    cont4++;
    let txt = document.getElementById("txtimp")
    let main = document.getElementById("main")
    if (cont4 != 1) {
        let saludo = document.getElementById("saludo4")
        saludo.innerHTML = "Hola " + txt.value + " desde el boton 4"
    } else {
        let saludo = document.createElement('p')
        saludo.innerHTML = "Hola " + txt.value + " desde el boton 4"
        saludo.id = "saludo4"
        main.appendChild(saludo)
    }
}
function confirmm() {
    let resp = confirm("¿Te gusta javascript?")
    cont2++;
    var a = false;
    if (resp == true) {
        a = true
    } else {
        a = false
    }
   
    let main = document.getElementById("main")
    if (cont2 != 1) {
        let conf = document.getElementById("conf")
        if (a == true){
            conf.innerHTML = "El boton 3 quiere ser tu amigo"
        } else {
            conf.innerHTML = "El boton 3 va a quemar tu casa"
        }
    } else {
        let conf = document.createElement("p")
        conf.id = "conf"
        main.appendChild(conf)
        if (a == true){
            conf.innerHTML = "El boton 3 quiere ser tu amigo"
        } else {
            conf.innerHTML = "El boton 3 va a quemar tu casa"
        }
    }
    
   
}
function showprompt() {
    cont++;
    let main = document.getElementById("main")
    if (cont != 1) {
        let saludo = document.getElementById("saludo")
        saludo.innerHTML = "Hola " + prompt("Introduce tu nombre") + " desde el boton 2"
    } else {
        let saludo = document.createElement('p')
        saludo.innerHTML = "Hola " + prompt("Introduce tu nombre") + " desde el boton 2"
        saludo.id = "saludo"
        main.appendChild(saludo)
    }

}
let a = document.getElementById("button1")
a.addEventListener('click', showmsg);
let b = document.getElementById("button2")
b.addEventListener('click', showprompt);
let c = document.getElementById("button3")
c.addEventListener('click', confirmm)
let d = document.getElementById("button4")
d.addEventListener('click', boton4)
