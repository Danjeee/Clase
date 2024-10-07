let but1 = document.getElementById("button1")
let but2 = document.getElementById("button2")
let but3 = document.getElementById("button3")
let but4 = document.getElementById("button4")
let but5 = document.getElementById("button5")
let troll = document.getElementById("button6")


var extrabutts = [document.getElementById("esquina"), document.getElementById("centro"), document.getElementById("cerrar")]
var a1p = 1;
var a2p = 1;
var userwr = ""
var longitud = 0

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
    var final = document.createElement("p")
    final.innerHTML = frase.innerHTML + "<br>"
    final.innerHTML += subcadena.innerHTML + "<br>";
    final.innerHTML += subcadena2.innerHTML + "<br>";
    final.innerHTML += userin.innerHTML + "<br>";
    final.innerHTML += orepet.innerHTML + "<br>";
    final.innerHTML += postxt.innerHTML + "<br>";
    cont.appendChild(final)
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
    var final = document.createElement("p")
    final.innerHTML = txt1.innerHTML + "<br>" + txt2.innerHTML
    cont.appendChild(final)
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
    var final = document.createElement("p")
    final.innerHTML = txt.innerHTML + "<br>" + txtrev.innerHTML + "<br>" + txtcount.innerHTML
    cont.appendChild(final)
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
    var final = document.createElement("p")
    final.innerHTML = txtcont.innerHTML + "<br>" + txtcont2.innerHTML
    cont.appendChild(final)
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
    var entero1 = 'Parseint ("14", "6.65", "7asd", 12.78, true, Null): ' + Number.parseInt("14") + ", " + Number.parseInt("6.65") + ", " + Number.parseInt("7asd") + ", " + Number.parseInt(12.78) + ", " + Number.parseInt(true) + ", " + Number.parseInt(null)
    var dec1 = 'Decimal ("14", "6.65", "7.13asd12"): ' + Number.parseFloat("14") + ", " + Number.parseFloat("6.65") + ", " + Number.parseFloat("7.13asd12")
    var ej1cont = document.createElement("p")
    ej1cont.innerHTML = entero1 + "<br>" + dec1
    cont.appendChild(ej1cont)
    nextAct2()
}
function act2p2() {
    var siniva = prompt("Escribe un precio sin iva")
    var test = document.createElement("p")
    test.innerHTML = siniva - 1
    while (test.innerHTML == "NaN") {
        siniva = parseInt(prompt("Entre un precio sin iva valido "));
        test.innerHTML = siniva - 1
    };
    var coniva = prompt("Escribe un precio con iva")
    var test2 = document.createElement("p")
    test2.innerHTML = coniva - 1
    while (test2.innerHTML == "NaN") {
        coniva = parseInt(prompt("Entre un precio con iva valido "));
        test2.innerHTML = coniva - 1
    };
    let cont = document.getElementById("2")
    cont.innerHTML = ""
    test.innerHTML = "Precio " + siniva + " (21%) = " + (parseFloat(siniva) * 0.21) + ", Precio con IVA = " + (parseFloat(siniva) + (parseFloat(siniva) * 0.21))
    test.innerHTML += "<br>Precio " + coniva + " (21%)" + ", Precio sin IVA = " + parseFloat(coniva) * (1 / 1.21)
    cont.appendChild(test)
    nextAct2()
}
function act3() {
    selected(3)
    reset()
    let cont = document.getElementById("3")
    let txt = document.createElement("p")
    txt.innerHTML = "Numeros mas cercanos a 5.67 y 5.37 respectivamente: " + Math.round(5.67) + " y " + Math.round(5.37) + "<br>"
    txt.innerHTML += "Numeros maximo entero menor o igual a 5.87: " + Math.ceil(5.87) + "<br>"
    txt.innerHTML += "Numeros entero mas pequeño menor o igual a 6.17: " + Math.floor(6.17) + "<br>"
    txt.innerHTML += "Numero menor y el mayor de los números: 12, 43, 56, 7, 12: Menor = " + Math.min(12, 43, 56, 7, 12) + ", Mayor = " + Math.max(12, 43, 56, 7, 12)
    cont.appendChild(txt)


}
function act4() {
    selected(4)
    reset()
    let d = new Date(Date.now())
    var resp = confirm("Rapido responde");

    let cont = document.getElementById("4")
    let dtxt = document.createElement("p")
    var week = ["", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"]
    dtxt.innerHTML = week[d.getDay()] + " " + (parseInt(d.getDate())) + " de " + d.toLocaleString('default', { month: 'long' }) + " de " + d.getFullYear()

    if (resp == true || resp == false) {
        var resptxt = document.createElement("p")
        let d2 = new Date(Date.now())
        var diff = new Date(d2 - d)

        resptxt.innerHTML = "Has tardado " + diff.getMinutes() + "min y " + (diff.getSeconds() + 1) + "s en responder"
        dtxt.innerHTML += "<br>" + resptxt.innerHTML + "<br>"
    }
    var tiempotrans = new Date(d - new Date(1970, 1, 1))
    var segs = 1000;
    var mins = segs * 60;
    var hrs = mins * 60;
    var dias = hrs * 24;
    var meses = dias * 30.416666666666668;
    var anos = meses * 12;
    dtxt.innerHTML += "<br>" + "Fecha actual: " + d + "<br> Han pasado " + Math.floor(tiempotrans / anos) + " años desde 1970"
    dtxt.innerHTML += "<br>Han pasado " + Math.floor(tiempotrans / meses) + " meses desde 1970"
    dtxt.innerHTML += "<br>Han pasado " + Math.floor(tiempotrans / dias) + " dias desde 1970"
    dtxt.innerHTML += "<br>Han pasado " + Math.floor(tiempotrans / hrs) + " horas desde 1970"
    dtxt.innerHTML += "<br>Han pasado " + Math.floor(tiempotrans / mins) + " mins desde 1970"
    dtxt.innerHTML += "<br>Han pasado " + Math.floor(tiempotrans / segs) + " segundos desde 1970"
    dtxt.innerHTML += "<br>Han pasado " + Math.floor(tiempotrans) + " milisegundos desde 1970"
    let diacum = ""
    let comprovacion = document.createElement("p")
    do {
        diacum = prompt("Escribe el dia de tu cumpleaños");
        comprovacion.innerHTML = parseInt(diacum)
    } while (comprovacion.innerHTML == "NaN" || parseInt(diacum) > 31 || parseInt(diacum) < 0);
    let mescum = ""
    do {
        mescum = prompt("Escribe el mes de tu cumpleaños");
        comprovacion.innerHTML = parseInt(mescum)
    } while (comprovacion.innerHTML == "NaN" || parseInt(mescum) > 12 || parseInt(mescum) < 0);
    mescum = parseInt(mescum) - 1
    let anocum = ""
    console.log(comprovacion.innerHTML)
    do {
        anocum = prompt("Escribe el año de tu cumpleaños");
        comprovacion.innerHTML = parseInt(anocum)
    } while (comprovacion.innerHTML == "NaN" == NaN);
    let falta = new Date(new Date(anocum, mescum, diacum) - d)
    var anostuyos = quitarsigno(Math.floor(falta / anos))
    var diasfaltantes = new Date(d - new Date(d.getFullYear(), mescum, diacum))
    var otro = "";
    var diasrest = ""
    console.log(diacum + " "+d.getDate())
    if (mescum < d.getMonth()){
        diasrest = quitarsigno(Math.floor(diasfaltantes / dias)-365)
        otro = " (Este año has cumplido "+quitarsigno((parseInt(Math.floor(falta / anos))+1))+" años)";
    } else {
        if (d.getDate()>diacum && mescum==d.getMonth()){
            diasrest = quitarsigno(Math.floor(diasfaltantes / dias)-365)
            otro = " (Este año has cumplido "+quitarsigno((parseInt(Math.floor(falta / anos))+1))+" años)";
        } else {
            diasrest = quitarsigno(Math.floor(diasfaltantes / dias))
        }
        
    }
    if (quitarsigno(Math.floor(diasfaltantes / dias)) == 0){
        dtxt.innerHTML += "<br>¡Feliz " +anostuyos+" cumpleaños!"
    } else {
        dtxt.innerHTML += "<br>Faltan " + falta.getMonth() + " meses para tu cumpleaños, faltan " +diasrest  + " dias para tu cumpleaños y vas a cumplir " + anostuyos + " años" +otro
    }

    cont.appendChild(dtxt)

}

let myWindow;
let myWindow2;
function esqopen() {
    writei = 0;
    myWindow = window.open("", "myWindow", "width=200, height=100")
    myWindow.resizeTo(200, 100)
    resizeesquina()

}
function centopen() {
    writei = 0;
    myWindow2 = window.open("", "myWindow2", "width=200, height=100")
    myWindow2.resizeTo(200, 100)
    myWindow2.screenLeft = 2000
    resizecenter()

}
function dosDecimales(n) {
    let t = n.toString();
    let regex = /(\d*.\d{0,2})/;
    return t.match(regex)[0];
}
function act5() {
    selected(5)
    reset()
    showButts()
    writei = 0
    let cont = document.getElementById("5")
    let txt = document.createElement("p")
    txt.id = "write"


    txt.innerHTML = navigator.userAgent + "<br>" + navigator.language + "<br>"
    txt.innerHTML += location.href + "<br>" + location.pathname + "<br>"
    var diag = Math.sqrt(Math.pow(screen.availWidth, 2) + Math.pow(screen.availHeight, 2))
    txt.innerHTML += "Width: " + screen.availWidth + "<br>Heigth: " + screen.availHeight + "<br> Diag: " + dosDecimales(diag) + "<br>"

    var esquina = document.getElementById("esquina")
    esquina.addEventListener('click', esqopen)
    var centro = document.getElementById("centro")
    centro.addEventListener('click', centopen)
    var cerrar = document.getElementById("cerrar")
    cerrar.addEventListener('click', function(){
        if (myWindow != null) {
            myWindow.close();
        }
        if (myWindow2 != null) {
            myWindow2.close();
        }
    })
    cont.appendChild(txt)
    user = prompt("Escribe una frase")
    longitud = user.length
    write()

}
var writei = 0
function resizecenter() {
    myWindow2.moveTo(1920/2-myWindow2.outerWidth/2,1080/2-myWindow2.outerHeight/2)
    if (writei <= window.innerWidth) {
        myWindow2.resizeTo(myWindow2.outerWidth + 10, myWindow2.outerHeight + 5)
        writei += 10;
        setTimeout(resizecenter, 10);
    }
}
function resizeesquina() {
    if (writei <= window.innerWidth) {
        myWindow.resizeTo(myWindow.outerWidth + 10, myWindow.outerHeight + 5)
        writei += 10;
        setTimeout(resizeesquina, 10);
    }
};
function write() {
    var txt = document.getElementById("write")
    if (writei <= longitud) {
        txt.innerHTML += user.charAt(writei);
        writei++;
        setTimeout(write, 300);
    }
};
function quitarsigno(a) {
    if (0 > a) {
        return -a;
    } else {
        return a;
    }
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
    hideButts()
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
    but3.innerHTML = "3: Math"
    but4.innerHTML = "4: Date"
    but5.innerHTML = "5: Screen y Window"
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

function hideButts() {
    extrabutts.forEach(e => {
        e.style.opacity = 0
    });
}
function showButts() {
    extrabutts.forEach(e => {
        e.style.opacity = 1
    });
}


selected(0)
reset()

troll.addEventListener('mouseenter', move)
but1.addEventListener('click', act1)
but2.addEventListener('click', act2)
but3.addEventListener('click', act3)
but4.addEventListener('click', act4)
but5.addEventListener('click', act5)
