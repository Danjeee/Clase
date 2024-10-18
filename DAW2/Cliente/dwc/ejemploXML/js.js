'use strict';
let xmlfinal = document.createElement('div')
let xmlcont = "<table><tr><th>Titulo</th><th>Autor</th><th>Editorial</th><th>ISBN</th></tr>"
function peticionXML() {
    let p = new XMLHttpRequest()
    p.open('GET', "./procesarXML.php")
    p.addEventListener('load', function () {
        if (p.status == 200) {
            mostrarXML(p.responseXML)
        }
    })
    p.send()
}

function mostrarXML(a) {
    
    Array.from(a.getElementsByTagName('LIBRO')).forEach(element => {
        xmlcont += "<tr>"
        xmlcont += "<td>"+element.querySelector('TITULO').innerHTML +"</td>"
        xmlcont += "<td>" +element.querySelector('AUTOR').innerHTML +"</td>"
        xmlcont += "<td>"+element.querySelector('EDITORIAL').innerHTML +"</td>"
        xmlcont += "<td>" +element.querySelector('ISBN').innerHTML +"</td>"
        xmlcont += "</tr>"
    });
    xmlcont +="</table>"
    xmlfinal.innerHTML = xmlcont
    document.body.appendChild(xmlfinal)
}
window.addEventListener('load', peticionXML)