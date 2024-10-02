let but1 = document.getElementById("button1")
let but2 = document.getElementById("button2")
let but3 = document.getElementById("button3")
let but4 = document.getElementById("button4")
let but5 = document.getElementById("button5")
let troll = document.getElementById("button6")

var a1p = 1;
var a2p = 1;

let ej1 = document.getElementById("1")
let ej2 = document.getElementById("2")
let ej3 = document.getElementById("3")
let ej4 = document.getElementById("4")
let ej5 = document.getElementById("5")

function selected(a) {
    let selected = document.getElementById("selected")
    if (a != 0) {
        selected.innerHTML = "Seleccionado: Ej." + a
    }
    var childDivs = document.getElementById('cont').getElementsByTagName('div');
    for (i = 0; i < childDivs.length; i++) {

        childDivs[i].innerHTML = "";
        if (childDivs[i].id == a) {
            childDivs[i].style.opacity = 1;
        } else {
            childDivs[i].style.opacity = 0;
        }
    }
}
function act1() {
    selected(1)
    reset()
    let cont = document.getElementById("1")
    var frase = document.createElement("p")
    var inner = "SHIFT TO THE LEFT! SHIFT TO THE RIGHT! POP UP, PUSH DOWN, BYTE, BYTE, BYTE!"
    var subcadena = document.createElement("p")
    subcadena.innerHTML = "Subcadena 'TO' en: " + inner.indexOf("TO")
    var usertxt = prompt("Introduce una palabra/frase")
    var userin = document.createElement("p")
    if (inner.includes(usertxt) != 0) {

        userin.innerHTML = "La cadena existe"
    } else {
        userin.innerHTML = "La cadena no existe"
    }
    var subcadena2 = document.createElement("p")
    subcadena2.innerHTML = "Subcadena 'POP' en: " + inner.indexOf("POP")
    var orepet = document.createElement("p")
    orepet.innerHTML = "Subcadena 'O' se ha repetido " + inner.search("O") + " veces"
    do {
        var pos = parseInt(prompt("Inserta un numero entre 0 y " + Number.parseInt(inner.length + (-1))));
    } while (isNaN(pos) || pos > inner.length - 1 || pos < 0);
    var postxt = document.createElement("p")
    postxt.innerHTML = "El caracter en la posicion " + pos + " es " + inner.charAt(pos) + " (" + inner.charCodeAt(pos) + ")"
    frase.innerHTML = inner
    cont.appendChild(frase);
    cont.appendChild(subcadena);
    cont.appendChild(subcadena2);
    cont.appendChild(userin);
    cont.appendChild(orepet);
    cont.appendChild(postxt);
    nextAct1()

}
function act1p2() {
    let cont = document.getElementById("1")
    cont.innerHTML = ""
    var frase = "User,error:,Replace,user,and,press,any,key,to,continue"
    var txt1 = document.createElement("p")
    txt1.innerHTML = frase
    var txt2 = document.createElement("p")
    txt2.innerHTML = frase.replaceAll(',', " ")
    cont.appendChild(txt1)
    cont.appendChild(txt2)
    nextAct1()
}
function act1p3() {
    let cont = document.getElementById("1")
    cont.innerHTML = ""
    var userwrd = prompt("Introduce una palabra")
    var txt = document.createElement("p")
    txt.innerHTML = "Palabra introducida: " + userwrd
    var txtrev = document.createElement("p")
    txtrev.innerHTML = "Palabra al reves: " + reverse(userwrd)
    var txtcount = document.createElement("p")
    txtcount.innerHTML = "Número de caracteres: " + Number.parseInt(userwrd.length)
    cont.appendChild(txt)
    cont.appendChild(txtcount)
    cont.appendChild(txtrev)
    nextAct1()
}
function act1p4() {
    var text = 'La criptografía (griego “oculto” y “escribir”, literalmente “escritura oculta”): ciencia de cifrar <br> y descifrar información. Se emplea permitir un intercambio de mensajes que solo puedan <br> ser leídos por personas a las que van dirigidos y que poseen los medios para descifrarlos. <br> Una técnica sencilla de cifrado, criptografía clásica, es la sustitución: cambio de significado <br> de los elementos básicos del mensaje, las letras, los dígitos o los símbolos.'
    let cont = document.getElementById("1")
    cont.innerHTML = ""
    var txtcont = document.createElement("p")
    var txtcont2 = document.createElement("p")
    txtcont.innerHTML = text
    var replacedtxt = text.replaceAll("a", "1")
    var replacedtxt = replacedtxt.replaceAll("e", "2")
    var replacedtxt = replacedtxt.replaceAll("i", "3")
    var replacedtxt = replacedtxt.replaceAll("o", "4")
    var replacedtxt = replacedtxt.replaceAll("u", "5")
    txtcont2.innerHTML = replacedtxt;
    cont.appendChild(txtcont)
    cont.appendChild(txtcont2)
    nextAct1()

}
function reverse(a) {
    var rev = ""
    for (i = a.length; i >= 0; i--) {
        rev = rev + a.charAt(i)
    }
    return rev;
}

function act2() {
    selected(2)
    reset()
    let cont = document.getElementById("2")
    cont.innerHTML = ""
    var entero1 = 'Parseint ("14", "6.65", "7asd", 12.78, true, Null): '+Number.parseInt("14") + ", " +Number.parseInt("6.65") + ", " +Number.parseInt("7asd") +", "+ Number.parseInt(12.78) + ", " +Number.parseInt(true) +", " +Number.parseInt(null)
    var dec1 = 'Decimal ("14", "6.65", "7.13asd12"): ' +Number.parseFloat("14") +", " +Number.parseFloat("6.65") + ", " +Number.parseFloat("7.13asd12")
    var ej1cont = document.createElement("p")
    ej1cont.innerHTML = entero1 + "<br>" +dec1
    cont.appendChild(ej1cont)
    nextAct2()
}
function act2p2(){
    var siniva = prompt("Escribe un precio sin iva")
    var test = document.createElement("p")
    test.innerHTML = siniva-1
    while (test.innerHTML == "NaN") {
        console.log(test.innerHTML)
        siniva = parseInt(prompt("Entre un precio sin iva valido "));
        test.innerHTML = siniva-1
    };
    console.log(test.innerHTML)
}
function act3() {
    selected(3)
}2
function act4() {
    selected(4)
}
function act5() {
    selected(5)
}

function nextAct1() {
    switch (a1p) {
        case 1:
            but1.removeEventListener('click', act1)
            but1.addEventListener('click', act1p2)
            but1.innerHTML = "1: Strings (Parte 2)"
            break;

        case 2:
            but1.removeEventListener('click', act1p2)
            but1.addEventListener('click', act1p3)
            but1.innerHTML = "1: Strings (Parte 3)"
            break;
        case 3:
            but1.removeEventListener('click', act1p3)
            but1.addEventListener('click', act1p4)
            but1.innerHTML = "1: Strings (Parte 4)"
            break;
        case 4:
            but1.removeEventListener('click', act1p4)
            but1.addEventListener('click', act1)
            but1.innerHTML = "1: Strings"
            a1p = 0
            break;
    }

    a1p++;
}
function nextAct2() {
    switch (a2p) {
        case 1:
            but2.removeEventListener('click', act2)
            but2.addEventListener('click', act2p2)
            but2.innerHTML = "2: Numbers (Parte 2)"
            break;

        case 2:
            but2.removeEventListener('click', act2p2)
            but2.addEventListener('click', act2)
            but2.innerHTML = "2: Numbers"
            a2p = 0
            break;
    }
    a2p++;
}

function reset() {
    switch (a1p) {
        case 2:
            but1.removeEventListener('click', act1p2)
            but1.addEventListener('click', act1)
            but1.innerHTML = "1: String"
            a1p = 1;
            break;
        case 3:
            but1.removeEventListener('click', act1p3)
            but1.addEventListener('click', act1)
            but1.innerHTML = "1: String"
            a1p = 1;
            break;
        case 4:
            but1.removeEventListener('click', act1p4)
            but1.addEventListener('click', act1)
            but1.innerHTML = "1: String"
            a1p = 1;
            break;

        default:
            break;
    }
    switch (a2p) {
        case 2:
            but2.removeEventListener('click', act2p2)
            but2.addEventListener('click', act2)
            but2.innerHTML = "2: Numbers"
            a2p = 1;
            break;
}
}
function resettroll() {
    troll.style.position = "relative"
    troll.style.top = 0
    troll.style.left = 0
    document.getElementById("selected").removeEventListener('click', resettroll)
}

function move() {
    reset()
    selected(0)
    troll.style.zIndex = 9
    troll.style.position = "absolute"
    troll.style.left = Math.floor(Math.random() * window.innerWidth) + "px"
    troll.style.top = Math.floor(Math.random() * window.innerHeight - 7) + "px"
    let s = document.getElementById("selected")
    s.addEventListener('click', resettroll)
    s.innerHTML = "Poner la sorpresa en su sitio"
}

selected(0)

troll.addEventListener('mouseenter', move)
but1.addEventListener('click', act1)
but2.addEventListener('click', act2)
but3.addEventListener('click', act3)
but4.addEventListener('click', act4)
but5.addEventListener('click', act5)
