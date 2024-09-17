function showmsg(){
    alert("hola")
}
function showprompt(){
    
    let saludo = document.getElementById("saludo")
    saludo.innerHTML = "Hola " +prompt("Introduce tu nombre");
}
let a = document.getElementById("button1")
a.addEventListener('click', showmsg);
let b = document.getElementById("button2")
b.addEventListener('click', showprompt);

