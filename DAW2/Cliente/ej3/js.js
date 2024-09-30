let but1 = document.getElementById("button1")
let but2 = document.getElementById("button2")
let but3 = document.getElementById("button3")
let but4 = document.getElementById("button4")

var a1p = 1;

let ej1 = document.getElementById("1")
let ej2 = document.getElementById("2")
let ej3 = document.getElementById("3")
let ej4 = document.getElementById("4")

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
        var pos = parseInt(prompt("Inserta un numero entre 0 y " +  Number.parseInt(inner.length+(-1))));
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
function act1p2(){
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
function act1p3(){
    let cont = document.getElementById("1")
    cont.innerHTML = ""
    var userwrd = prompt("Introduce una palabra")
    var txt = document.createElement("p")
    txt.innerHTML = "Palabra introducida: "+userwrd
    var txtrev = document.createElement("p")
    txtrev.innerHTML = "Palabra al reves: "+userwrd.substring() 
    var txtcount = document.createElement("p")
    txtcount.innerHTML = "Número de caracteres: "+Number.parseInt(userwrd.length)
    cont.appendChild(txt)
    cont.appendChild(txtcount)
    cont.appendChild(txtrev)
}

function act2() {
    selected(2)
    reset()
}
function act3() {
    selected(3)
}
function act4() {
    selected(4)
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
    }
    
    a1p++;
}

function reset() {
    switch (a1p) {
        case 2:
            but1.removeEventListener('click', act1p2)
            but1.addEventListener('click', act1)
            but1.innerHTML = "1: String"
            a1p = 1;
            break;

        default:
            break;
    }
}

selected(0)


but1.addEventListener('click', act1)
but2.addEventListener('click', act2)
but3.addEventListener('click', act3)
but4.addEventListener('click', act4)

