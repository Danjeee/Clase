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

    if (page!=1 && document.getElementById("prev") == null){
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
    if (document.getElementById("next") != null){
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
            tit.innerHTML = "<h1>Familia: " + s.value + "</h1><img src='img/" + s.value + ".png'>"
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
            tit.innerHTML = "<h1>Proveedor: " + s.value + "</h1>"
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
    s2.disabled = true
    s.addEventListener('change', function () {
        s2.disabled = true
        if (s.value != 'Selecciona una familia') {
            encontrarProveedores(s.value)
            if (mixf) {
                console.log(mix)
                s2.disabled = false
                s2.innerHTML = "<option value='Selecciona un proveedor' selected hidden>Selecciona un proveedor</option>"
                mix.forEach(e => {
                    s2.innerHTML += "<option value='" + e.nombre + "'>" + e.nombre + "</option>"
                });
                s2.addEventListener('change', function () {
                    if (s.value != 'Selecciona una familia' && s2.value != 'Selecciona un proveedor') {
                        procesarArticulos("TT", s.value, s2.value)
                        tit.innerHTML = "<h1>Familia: " + s.value + ", Proveedor: " + s2.value + "</h1><img src='img/" + s.value + ".png'>"
                    }
                })
            } else {
                s2.disabled = true
                s2.innerHTML = "<option value='Selecciona un proveedor' selected hidden>Selecciona un proveedor</option>"
            }
        } else {
            s2.disabled = true
        }
    })

    selectcont.appendChild(s)
    selectcont.appendChild(s2)
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