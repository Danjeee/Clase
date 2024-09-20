let but1 = document.getElementById("button1")
let but2 = document.getElementById("button2")
let but3 = document.getElementById("button3")
let but4 = document.getElementById("button4")

let ej1 = document.getElementById("1")
let ej2 = document.getElementById("2")
let ej3 = document.getElementById("3")
let ej4 = document.getElementById("4")

function selected(a) {
    let selected = document.getElementById("selected")
    selected.innerHTML = "Selected: Ej." + a
    if (a == 0){
        selected.innerHTML = ""
    }
    var childDivs = document.getElementById('cont').getElementsByTagName('div');
    for (i = 0; i < childDivs.length; i++) {
        if (childDivs[i].id == a) {
            childDivs[i].style.opacity = 1;
        } else {
            childDivs[i].style.opacity = 0;
        }
    }
}
function act1() {
    let var1 = prompt("Elije un numero")
    let var2 = prompt("Elije otro numero")
    let op = document.getElementById("o")
    let sum = document.getElementById("s")
    let res = document.getElementById("r")
    let mult = document.getElementById("m")
    let divi = document.getElementById("d")
    let mod = document.getElementById("mod")
    let inc = document.getElementById("inc")
    let dec = document.getElementById("dec")
    let inc1 = var1-(-1)
    let inc2 = var2-(-1)
    let suma = var1 -(-var2);
    let dec1 = var1-1
    let dec2 = var2-1
    let rest = var1-var2
    let multt = var1*var2
    let divvi = var1/var2
    let mood = var1%var2
    op.innerHTML = "Los numeros introducidos son "+var1 +" y "+var2
    sum.innerHTML = "La suma de "+var1 +" y "+var2 +" es: "+suma
    res.innerHTML = "La resta de "+var1 +" y "+var2 +" es: " +rest
    inc.innerHTML = "El incremento de "+var1 +" y "+var2 +" es: "+inc1 +" y "+inc2 +" respectivamente"
    mult.innerHTML = "La multiplicacion de "+var1 +" y "+var2 +" es: "+multt
    if (var2 == 0){
        divi.innerHTML = "La division de "+var1 +" y "+var2 +" no se puede ejecutar porque el segundo numero es 0"
    } else {
        divi.innerHTML = "La division de "+var1 +" y "+var2 +" es: "+divvi
    }
    mod.innerHTML = "El modulo de "+var1 +" y "+var2 +" es: "+mood
    dec.innerHTML = "El decremento de "+var1 +" y "+var2 +" es: "+dec1 +" y " +dec2 +" respectivamente"
    selected(1)
}
function act2() {
    selected(2)
}
function act3() {
    selected(3)
}
function act4() {

}

selected(0)
but1.addEventListener('click', act1)
but2.addEventListener('click', act2)
but3.addEventListener('click', act3)
but4.addEventListener('click', act4)

