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
    selected(1)
}
function act2() {
    selected(2)
}
function act3() {

}
function act4() {

}


but1.addEventListener('click', act1)
but2.addEventListener('click', act2)
but3.addEventListener('click', act3)
but4.addEventListener('click', act4)

