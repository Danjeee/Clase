'use strict'

let xmlfinal = document.getElementById('final')
let xmlcont = "<table><tr><th>Id</th><th>Familia</th><th>Nombre</th><th>Proveedor</th><th>Precio</th></tr>"
var selectcont = document.getElementById('selectcont')
var tit = document.getElementById("tit")
let selectcontbase = selectcont.innerHTML
var familias
var proveedores

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
        var data = JSON.parse(resp)
        data.forEach(element => {
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
    } catch (error) {
        xmlfinal.innerHTML = "<h1>Lo sentimos, no hay articulos en esta categoria</h1>"

    }

}
function doaction() {

    switch (document.getElementById("opc1").value) {
        case "TA":
            tit.innerHTML = ""
            xmlfinal.innerHTML = ""
            selectcont.innerHTML = selectcontbase
            procesarArticulos("TA", null, null)

            break;
        case "TF":
            selectFamilia()
            break;

        case "TP":
            selectProveedor()
            break;
        case "TT":
            selectFamAndProveedor()
            break;
    }
}
function selectFamilia() {
    xmlfinal.innerHTML = ""
    selectcont.innerHTML = selectcontbase
    let s = document.createElement('select')
    s.innerHTML = "<option value='Selecciona una familia' selected hidden>Selecciona una familia</option>"
    Array.from(familias).forEach(e => {
        s.innerHTML += "<option value='" + e.nombre + "'>" + e.nombre + "</option>"
    });

    selectcont.appendChild(s)
    s.addEventListener('change', function () {
        if (s.value != 'Selecciona una familia') {
            procesarArticulos("AF", s.value, null)
            tit.innerHTML = "<h1>Familia: "+s.value+"</h1><img src='img/"+s.value+".png'>"
        }
    })
}
function selectProveedor() {
    xmlfinal.innerHTML = ""
    selectcont.innerHTML = selectcontbase
    let s = document.createElement('select')
    s.innerHTML = "<option value='Selecciona un proveedor' selected hidden>Selecciona un proveedor</option>"
    Array.from(proveedores).forEach(e => {
        s.innerHTML += "<option value='" + e.nombre + "'>" + e.nombre + "</option>"
    });

    selectcont.appendChild(s)
    s.addEventListener('change', function () {
        if (s.value != 'Selecciona un proveedor') {
            procesarArticulos("AP", null, s.value)
            tit.innerHTML = "<h1>Proveedor: "+s.value+"</h1>"
        }
    })
}
function selectFamAndProveedor() {
    xmlfinal.innerHTML = ""
    selectcont.innerHTML = selectcontbase
    let s = document.createElement('select')
    s.innerHTML = "<option value='Selecciona una familia' selected hidden>Selecciona una familia</option>"
    Array.from(familias).forEach(e => {
        s.innerHTML += "<option value='" + e.nombre + "'>" + e.nombre + "</option>"
    });
    let s2 = document.createElement('select')
    s2.innerHTML = "<option value='Selecciona un proveedor' selected hidden>Selecciona un proveedor</option>"
    Array.from(proveedores).forEach(e => {
        s2.innerHTML += "<option value='" + e.nombre + "'>" + e.nombre + "</option>"
    });
    s.addEventListener('change', function () {
        if (s.value != 'Selecciona una familia' && s2.value != 'Selecciona un proveedor') {
            procesarArticulos("TT", s.value, s2.value)
            tit.innerHTML = "<h1>Familia: "+s.value+", Proveedor: "+s2.value+"</h1><img src='img/"+s.value+".png'>"
        }
    })
    s2.addEventListener('change', function () {
        if (s.value != 'Selecciona una familia' && s2.value != 'Selecciona un proveedor') {
            procesarArticulos("TT", s.value, s2.value)
            tit.innerHTML = "<h1>Familia: "+s.value+", Proveedor: "+s2.value+"</h1><img src='img/"+s.value+".png'>"
        }
    })
    selectcont.appendChild(s)
    selectcont.appendChild(s2)
}
function name(params) {
    
}
loadProv()
loadFamilias()