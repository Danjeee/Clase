let but1 = document.getElementById("button1")
let but2 = document.getElementById("button2")
let but3 = document.getElementById("button3")
let but4 = document.getElementById("button4")

let act1p = 0
let act2p = 0
let tablamult = 1
let bonolotoselected = 0
var bononums = []
var win = []
var num1 = 0
var num2 = 0
var num3 = 0

let ej1 = document.getElementById("1")
let ej2 = document.getElementById("2")
let ej3 = document.getElementById("3")
let ej4 = document.getElementById("4")
let alt4 = document.getElementById("alt4")

function selected(a) {
    let selected = document.getElementById("selected")
    selected.innerHTML = "Selected: Ej." + a
    if (a == 0) {
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
    if (a == 4) {
        bonolotoselected = 0
        bononums = []
        win = []
        alt4.style.opacity = 1
        alt4.innerHTML = ""
    } else {
        alt4.style.opacity = 0
    }
}
function act1() {
    act1p = 1
    resetEL()
    selected(1)
    num1 = prompt("Elije el numero 1")
    while (Number.isNaN(num1 - 1)) {
        num1 = prompt("Elije el numero 1")
    }
    num2 = prompt("Elije el numero 2")
    while (Number.isNaN(num2 - 1)) {
        num2 = prompt("Elije el numero 2")
    }
    num3 = prompt("Elije el numero 3")
    while (Number.isNaN(num3 - 1)) {
        num3 = prompt("Elije el numero 3")
    }
    let op = document.getElementById("o")
    let sum = document.getElementById("s")
    let res = document.getElementById("r")
    let mult = document.getElementById("m")
    let divi = document.getElementById("d")
    let mod = document.getElementById("mod")
    let inc = document.getElementById("inc")
    let dec = document.getElementById("dec")
    let inc1 = num1 - (-1)
    let inc2 = num2 - (-1)
    let suma = num1 - (-num2);
    let dec1 = num1 - 1
    let dec2 = num2 - 1
    let rest = num1 - num2
    let multt = num1 * num2
    let divvi = num1 / num2
    let mood = num1 % num2
    op.innerHTML = "Los numeros introducidos son " + num1 + " y " + num2
    sum.innerHTML = "La suma de " + num1 + " y " + num2 + " es: " + suma
    res.innerHTML = "La resta de " + num1 + " y " + num2 + " es: " + rest
    inc.innerHTML = "El incremento de " + num1 + " y " + num2 + " es: " + inc1 + " y " + inc2 + " respectivamente"
    mult.innerHTML = "La multiplicacion de " + num1 + " y " + num2 + " es: " + multt
    if (num2 == 0) {
        divi.innerHTML = "La division de " + num1 + " y " + num2 + " no se puede ejecutar porque el segundo numero es 0"
    } else {
        divi.innerHTML = "La division de " + num1 + " y " + num2 + " es: " + divvi
    }
    mod.innerHTML = "El modulo de " + num1 + " y " + num2 + " es: " + mood
    dec.innerHTML = "El decremento de " + num1 + " y " + num2 + " es: " + dec1 + " y " + dec2 + " respectivamente"
    but1.innerHTML = "Ej1: Mayor"
    but1.removeEventListener('click', act1)
    but1.addEventListener('click', a1p2)
}
function a1p2() {
    clear(document.getElementById("1"))
    act1p = 2
    document.getElementById("r").innerHTML = "Los numeros introducidos son " + num1 + ", " + num2 + " y " + num3
    document.getElementById("m").innerHTML = "El numero mayor es " + Math.max(num1, num2, num3)
    but1.innerHTML = "Ej1: Tabla de multiplicar (" + num2 + ")"
    but1.removeEventListener('click', a1p2)
    but1.addEventListener('click', a1p3)
    tablamult = num2
}
function a1p3() {
    act1p = 0
    clear(document.getElementById("1"))
    for (let i = 0; i < 10; i++) {
        document.getElementById("r").innerHTML = document.getElementById("r").innerHTML + tablamult + " x " + (i - (-1)) + " = " + (tablamult * (i - (-1))) + "<br><br>"
    }
    but1.removeEventListener('click', a1p3)
    but1.addEventListener('click', act1)
    but1.innerHTML = "Ej1: Operadores"
}
function clear(cont) {
    cont.childNodes.forEach(element => {
        element.innerHTML = ""
    });
}
function act2() {
    act2p = 1
    resetEL()
    selected(2)
    clear(document.getElementById("2"))
    for (let i = 9; i >= 0; i--) {
        for (let j = i; j >= 0; j--) {
            document.getElementById("pir").innerHTML = document.getElementById("pir").innerHTML + j

        }
        document.getElementById("pir").innerHTML = document.getElementById("pir").innerHTML + "<br><br>"
    }
    but2.innerHTML = "Ej2: Piramide"
    but2.removeEventListener('click', act2)
    but2.addEventListener('click', a2p2)
}
function a2p2() {
    act2p = 2
    clear(document.getElementById("2"))
    for (let i = 0; i <= 9; i++) {
        for (let j = 0; j <= i; j++) {
            document.getElementById("pir").innerHTML = document.getElementById("pir").innerHTML + j

        }
        document.getElementById("pir").innerHTML = document.getElementById("pir").innerHTML + "<br><br>"
    }
    but2.innerHTML = "Ej2: 1 al 100"
    but2.removeEventListener('click', a2p2)
    but2.addEventListener('click', a2p3)
}
function a2p3() {
    act2p = 0
    clear(document.getElementById("2"))
    let fila = 0;
    for (let j = 0; j <= 100; j++) {
        if (j % 2 == 0) {
            fila++
            document.getElementById("pir").innerHTML = document.getElementById("pir").innerHTML + j
            if (j != 100) {
                document.getElementById("pir").innerHTML = document.getElementById("pir").innerHTML + ", "
            }
            if (fila == 10) {
                fila = 0
                document.getElementById("pir").innerHTML = document.getElementById("pir").innerHTML + "<br><br>"
            }
        }
    }

    but2.innerHTML = "Ej2: Operadores"
    but2.removeEventListener('click', a2p3)
    but2.addEventListener('click', act2)
}
function act3() {
    resetEL()
    selected(3)
    clear(document.getElementById("3"))
    let rand = Math.floor(Math.random() * 50)
    let cont = document.getElementById("rand")
    let intentos = 0
    console.log(rand)
    let res = prompt("Escribe un numero")
    while (res != rand) {
        intentos++
        if (res == null) {
            cont.innerHTML = "Te has rendido a los " + (intentos - 1) + " intentos"
            break
        }
        if (res > rand) {
            res = prompt(res + " es mayor al numero aleatorio, intentalo de nuevo")
        } else {
            res = prompt(res + " es menor al numero aleatorio, intentalo de nuevo")
        }

    }
    if (res == rand) {
        cont.innerHTML = "ENHORABUENA, HAS CONSEGUIDO ACERTAR EL NUMERO A LOS " + (intentos - (-1)) + " INTENTOS"
    }
}
function act4() {
    resetEL()
    selected(4)
    generatebono()
    let cont = document.getElementById("4")
    cont.innerHTML = ""
    let contt = 1
    for (let i = 0; i < 7; i++) {
        let newrow = document.createElement("div")
        newrow.style.display = "flex"
        newrow.style.flexDirection = "row"
        newrow.style.height = "50px"
        for (let j = 0; j < 7; j++) {
            let newbut = document.createElement("div")
            newbut.id = "b" + contt
            newbut.style.height = "50px"
            newbut.style.width = "50px"
            newbut.innerHTML = contt
            newbut.className = "selectable"
            newbut.addEventListener('click', function () {
                if (bonolotoselected < 6) {
                    console.log(bononums)
                    let num = newbut.id.substring(1)
                    let isnotin = false
                    for (let i = 0; i < bononums.length; i++) {
                        if (bononums[i] == num) {
                            isnotin = true
                        }
                    }
                    if (!isnotin) {
                        newbut.style.backgroundColor = "#000"
                        newbut.className = ""
                        bonolotoselected++
                        bononums.push(num)
                        writebono()
                    }
                }
            })
            newrow.appendChild(newbut)
            contt++
        }
        cont.appendChild(newrow)
    }
}

function generatebono() {
    var i = 0
    while (i < 7) {
        let num = Math.random() * 48 + 1
        num = Math.floor(num)
        console.log(num)
        console.log(win)
        let bool = false
        for (let j = 0; j < win.length; j++) {
            if (!win[j] == num) {
                bool = true
            }
        }
        if (!bool) {
            win.push(num)
            i++
        }
    }
}
function writebono() {
    alt4.innerHTML = "Numeros seleccionados: "
    for (let i = 0; i < bononums.length; i++) {
        alt4.innerHTML = alt4.innerHTML + " " + bononums[i]

    }
    if (bonolotoselected == 6) {
        alt4.innerHTML = alt4.innerHTML + "<br>Numeros ganadores:"
        for (let i = 0; i < win.length; i++) {
            alt4.innerHTML = alt4.innerHTML + " " + win[i]

        }
        var comp = Math.floor(Math.random() * 48 + 1)
        alt4.innerHTML = alt4.innerHTML + "<br>Numero complementario: " + comp
        var rein = Math.floor(Math.random() * 8 + 1)
        alt4.innerHTML = alt4.innerHTML + "<br>Reintegro: " + rein
        var contador = 0
        for (let i = 0; i < win.length; i++) {
            let windiv = document.getElementById("b"+win[i])
                windiv.style.borderColor = "#ffffff"
            for (let j = 0; j < bononums.length; j++) {
                if (bononums[j] == win[i]){
                    contador++
                }
                
            }
        }
        alt4.innerHTML = alt4.innerHTML + "<br>Has acertado "+contador+" numeros"
        for (let i = 0; i < bononums.length; i++) {
            if (comp == bononums[i]){
                
                alt4.innerHTML = alt4.innerHTML + " y el complementario"
            }
        }
        if (bononums[bononums.length] == rein) {
            alt4.innerHTML = alt4.innerHTML + " y tambien el reintegro"
        }
        if (win == bononums) {
            alert("¡Has ganado el bonoloto!")
        } else {
            alert("No has ganado el bonoloto :c")
        }
        let compdiv = document.getElementById("b"+comp)
                compdiv.style.borderColor = "#ffa500"
    }
}

selected(0)
function resetEL() {
    if (act1p = 1) {
        but1.removeEventListener('click', a1p2)
    }
    if (act1p = 2) {
        but1.removeEventListener('click', a1p3)
    }
    if (act2p = 1) {
        but1.removeEventListener('click', a2p2)
    }
    if (act2p = 2) {
        but1.removeEventListener('click', a2p3)
    }
    but1.innerHTML = "Ej1: Operadores"
    but2.innerHTML = "Ej2: Invertido"
    but3.innerHTML = "Ej3: Adivina "
    but4.innerHTML = "Ej4: Bonoloto"
    but1.addEventListener('click', act1)
    but2.addEventListener('click', act2)
    but3.addEventListener('click', act3)
    but4.addEventListener('click', act4)
}
resetEL()

