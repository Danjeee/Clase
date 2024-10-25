'use strict'

let xmlfinal = document.getElementById('final')
let xmlcont = "<table><tr><th>Id</th><th>Familia</th><th>Nombre</th><th>Proveedor</th><th>Precio</th></tr>"
var selectcont = document.getElementById('selectcont')
var tit = document.getElementById("tit")
let selectcontbase = selectcont.innerHTML
var familias
var proveedores
var mix
var mixf = false;
var data;
var page = 0;
let pagetxt = document.getElementById("pagetxt")

function procesarArticulos(opc, fam, prov) {
    let p = new XMLHttpRequest()
    let parameters = "opcion=" + opc
    if (fam != null) {
        parameters += "&familia=" + fam
    }
    if (prov != null) {
        parameters += "&proveedor=" + prov
    }
    p.open('GET', "./consultarArticulos.php?" + parameters)
    p.addEventListener('load', function () {
        if (p.status == 200) {
            mostrarArticulos(p.responseText)
        }
    })
    p.send()
}
function loadFamilias() {
    let p = new XMLHttpRequest()
    let parameters = "opcion=TF"
    p.open('GET', "./consultarArticulos.php?" + parameters)
    p.addEventListener('load', function () {
        if (p.status == 200) {
            familias = JSON.parse(p.responseText)
        }
    })
    p.send()
}
function loadProv() {
    let p = new XMLHttpRequest()
    let parameters = "opcion=TP"
    p.open('GET', "./consultarArticulos.php?" + parameters)
    p.addEventListener('load', function () {
        if (p.status == 200) {
            proveedores = JSON.parse(p.responseText)
        }
    })
    p.send()
}
function mostrarArticulos(resp) {
    try {
        xmlcont = "<table><tr><th>Id</th><th>Familia</th><th>Nombre</th><th>Proveedor</th><th>Precio</th></tr>"
        data = JSON.parse(resp)
        if (data.length > 25) {
            var dataaux = [];
            for (let i = 0; i < 25; i++) {
                dataaux.push(Array.from(data)[i])
                

            }
            var nextbut = document.createElement('button')
            nextbut.innerHTML = "->"
            nextbut.id = "next"
            nextbut.addEventListener('click', function(){
            next()
        })
        document.body.appendChild(nextbut)
        } else {
            var dataaux = data;
        }
        dataaux.forEach(element => {
            xmlcont += "<tr>"
            xmlcont += "<td class='n'>" + element.idarticulo + "</td>"
            xmlcont += "<td class='n'>" + element.familia + "</td>"
            xmlcont += "<td class='s'>" + element.descripcion + "</td>"
            xmlcont += "<td class='n'>" + element.proveedor + "</td>"
            xmlcont += "<td class='n'>" + element.precioventa + "</td>"
            xmlcont += "</tr>"
        });
        xmlcont += "</table>"
        xmlfinal.innerHTML = xmlcont
        pagetxt.innerHTML = dataaux.length+"/"+data.length
    } catch (error) {
        xmlfinal.innerHTML = "<h1>Lo sentimos, no hay articulos en esta categoria</h1>"

    }

}
function next() {
    page++
    var erro = false;
    var total = 0
    var dataaux = [];
    if ((page+1)*25>data.length) {
        for (let i = 25 * page; i < data.length; i++) {
            try {
                dataaux.push(Array.from(data)[i])
                total++
            } catch (error) {
                erro = true
                break;
            }
        }
        console.log("a")
        if (document.getElementById("next") != null){
            document.body.removeChild(document.getElementById("next"))
        }
    } else {
        for (let i = 25 * page; i < 25 * (page + 1); i++) {
            try {
                dataaux.push(Array.from(data)[i])
                total++
            } catch (error) {
                erro = true
                break;
            }
        }
    }
    pagetxt.innerHTML = total+(page*25)+"/"+data.length

    if (page!=0 && document.getElementById("prev") == null){
        var prevbut = document.createElement('button')
        prevbut.innerHTML = "<-"
        prevbut.id = "prev"
        prevbut.addEventListener('click', function(){
            prev()
        })
        document.body.appendChild(prevbut)
    }
    xmlcont = "<table><tr><th>Id</th><th>Familia</th><th>Nombre</th><th>Proveedor</th><th>Precio</th></tr>"
    dataaux.forEach(element => {
        xmlcont += "<tr>"
        xmlcont += "<td class='n'>" + element.idarticulo + "</td>"
        xmlcont += "<td class='n'>" + element.familia + "</td>"
        xmlcont += "<td class='s'>" + element.descripcion + "</td>"
        xmlcont += "<td class='n'>" + element.proveedor + "</td>"
        xmlcont += "<td class='n'>" + element.precioventa + "</td>"
        xmlcont += "</tr>"
    });
    xmlcont += "</table>"
    xmlfinal.innerHTML = xmlcont
}
function prev() {
    page-=2
    if (document.getElementById("next") == null){
        var nextbut = document.createElement('button')
        nextbut.innerHTML = "->"
        nextbut.id = "next"
        nextbut.addEventListener('click', function(){
            next()
        })
        document.body.appendChild(nextbut)
    }
    if((page+1) == 0){
        if (document.getElementById("prev") != null){
            document.body.removeChild(document.getElementById("prev"))
        }
    }
    next()
}
function doaction() {
    
    if (document.getElementById("next") != null){
        document.body.removeChild(document.getElementById("next"))
    }
    if (document.getElementById("prev") != null){
        document.body.removeChild(document.getElementById("prev"))
    }
    for (let i = 0; i < document.getElementById("opc1").childNodes.length; i++) {
        if (document.getElementById("opc1").childNodes[i].value == document.getElementById("opc1").value) {
            document.getElementById("opc1").childNodes[i].className = "selected"
        } else {
            document.getElementById("opc1").childNodes[i].className = "notselected"
        }
        
    }
    switch (document.getElementById("opc1").value) {
        case "TA":
            tit.innerHTML = ""
            xmlfinal.innerHTML = ""
            if (document.getElementById("famselect") != null) {
                selectcont.removeChild(document.getElementById("famselect"))
            }
            if (document.getElementById("provselect") != null) {
                selectcont.removeChild(document.getElementById("provselect"))
            }
            document.getElementById("opc1").className = ""
            
            procesarArticulos("TA", null, null)

            break;
        case "TF":
            pagetxt.innerHTML = ""
            document.getElementById("opc1").className = "selected"
            selectFamilia()
            break;

        case "TP":
            pagetxt.innerHTML = ""
            document.getElementById("opc1").className = "selected"
            selectProveedor()
            break;
    }
}
function selectFamilia() {
    xmlfinal.innerHTML = ""
    if (document.getElementById("famselect") != null) {
        selectcont.removeChild(document.getElementById("famselect"))
    }
    if (document.getElementById("provselect") != null) {
        selectcont.removeChild(document.getElementById("provselect"))
    }
    let s = document.createElement('select')
    s.id = "famselect"
    s.innerHTML = "<option value='Selecciona una familia' selected hidden>Selecciona una familia</option>"
    Array.from(familias).forEach(e => {
        s.innerHTML += "<option value='" + e.imagen + "'>" + e.nombre + "</option>"
    });

    selectcont.appendChild(s)
    s.addEventListener('change', function () {
        if (s.value != 'Selecciona una familia') {
            procesarArticulos("AF", s.value, null)
            tit.innerHTML = "<h1>Familia: " + s.childNodes[s.selectedIndex].innerHTML + "</h1><img src='img/" + s.value + "'>"
        }
        for (let i = 0; i < document.getElementById("famselect").childNodes.length; i++) {
            if (document.getElementById("famselect").childNodes[i].value == document.getElementById("famselect").value) {
                document.getElementById("famselect").childNodes[i].className = "selected"
            } else {
                document.getElementById("famselect").childNodes[i].className = "notselected"
            }
            
        }
    })
}
function selectProveedor() {
    xmlfinal.innerHTML = ""
    if (document.getElementById("famselect") != null) {
        selectcont.removeChild(document.getElementById("famselect"))
    }
    if (document.getElementById("provselect") != null) {
        selectcont.removeChild(document.getElementById("provselect"))
    }
    let s = document.createElement('select')
    s.id = "provselect"
    s.innerHTML = "<option value='Selecciona un proveedor' selected hidden>Selecciona un proveedor</option>"
    Array.from(proveedores).forEach(e => {
        s.innerHTML += "<option value='" + e.nombre + "'>" + e.nombre + "</option>"
    });

    selectcont.appendChild(s)
    s.addEventListener('change', function () {
        if (s.value != 'Selecciona un proveedor') {
            procesarArticulos("AP", null, s.value)
            tit.innerHTML = "<h1>Proveedor: " + s.value + "</h1>"
        }
        for (let i = 0; i < document.getElementById("provselect").childNodes.length; i++) {
            if (document.getElementById("provselect").childNodes[i].value == document.getElementById("provselect").value) {
                document.getElementById("provselect").childNodes[i].className = "selected"
            } else {
                document.getElementById("provselect").childNodes[i].className = "notselected"
            }
            
        }
    })
}
function encontrarProveedores(a) {

    let p = new XMLHttpRequest()
    let parameters = "opcion=PF&familia=" + a
    p.open('GET', "./consultarArticulos.php?" + parameters)
    p.addEventListener('load', function () {
        if (p.status == 200) {
            mix = JSON.parse(p.responseText)
            try {
                mix.forEach(i => console.log("a"))
                mixf = true
            } catch (error) {
                mixf = false
            }
        }
    })
    p.send()
}
loadProv()
loadFamilias()