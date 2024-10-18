'use strict'

let xmlfinal = document.createElement('div')
let xmlcont = "<table><tr><th>Id</th><th>Familia</th><th>Nombre</th><th>Proveedor</th><th>Precio</th></tr>"
var selectcont = document.getElementById('selectcont')
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
    p.open('GET', "./consultarArticulos.php?"+parameters)
    p.addEventListener('load', function(){
        if (p.status == 200){
            console.log(parameters)
            console.log(p.responseURL)
            console.log(p.responseText)
            mostrarArticulos(p.responseText)
        }
    })
    p.send(parameters)
}
function loadFamilias() {
    let p = new XMLHttpRequest()
    let parameters = "opcion=TF"
    p.open('GET', "./consultarArticulos.php?"+parameters)
    p.addEventListener('load', function(){
        if (p.status == 200){
            familias = JSON.parse(p.responseText)
        }
    })
    p.send(parameters)
}
function loadProv() {
    let p = new XMLHttpRequest()
    let parameters = "opcion=TP"
    p.open('GET', "./consultarArticulos.php?"+parameters)
    p.addEventListener('load', function(){
        if (p.status == 200){
            proveedores = JSON.parse(p.responseText)
        }
    })
    p.send(parameters)
}
function mostrarArticulos(resp) {
    var data = JSON.parse(resp)
    data.forEach(element => {
        xmlcont += "<tr>"
        xmlcont += "<td>" + element.idarticulo + "</td>"
        xmlcont += "<td>" + element.familia + "</td>"
        xmlcont += "<td>" + element.descripcion + "</td>"
        xmlcont += "<td>" + element.proveedor + "</td>"
        xmlcont += "<td>" + element.precioventa + "</td>"
        xmlcont += "</tr>"
    });
    xmlcont += "</table>"
    xmlfinal.innerHTML = xmlcont
    document.body.appendChild(xmlfinal)
}
function doaction(){
    
    switch (document.getElementById("opc1").value) {
        case "TA":
            
            procesarArticulos("TA",null,null)
            
            break;
        case "TF":
            selectFamilia()
            break;
    
        default:
            break;
    }
}
function selectFamilia(){
    if (document.getElementById('opc2') != null){
        document.removeChild('opc2')
    }
    let s = document.createElement('select')
    s.id = "opc2"
    s.innerHTML = "<option value='Selecciona una familia' selected hidden>Selecciona una familia</option>"
    Array.from(familias).forEach(e => {
        s.innerHTML += "<option value='"+e.nombre+"'>"+e.nombre+"</option>"
    });
    
    selectcont.appendChild(s)
    s.addEventListener('change', function(){
        if (s.value != 'Selecciona una familia'){
            console.log(s.value)
            procesarArticulos("AF", s.value, null)
        }
    })
}
loadFamilias()