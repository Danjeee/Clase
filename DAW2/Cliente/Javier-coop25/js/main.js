let user = JSON.parse(sessionStorage.getItem("user"))
function load(){
    let params = new FormData()
    params.append("opcion", "AV")
    const data = new URLSearchParams(params);
    fetch("../php/coop25.php", {
        method: "POST",
        body: data,
    })
    .then(response => response.json())
    .then(data => {
        data.forEach(e => {
            if (e.vendedor != user.id) {
                createitem(e)
            }
        });
    })
}
function createitem(e){
    let cont = document.createElement('div')
    cont.className = "art"
    let nom = document.createElement("h3")
    nom.innerHTML = e.nombre
    let prec = document.createElement("p")
    prec.innerHTML = e.precio
    prec.className = "precio"
    let desc = document.createElement("p")
    desc.className = "desc"
    desc.innerHTML = e.descripcion
    let buy = document.createElement("button")
    buy.innerHTML = "Comprar"
    cont.appendChild(nom)
    cont.appendChild(prec)
    cont.appendChild(desc)
    cont.appendChild(buy)
    document.getElementById("main").appendChild(cont)
}
load()
document.getElementById("user").addEventListener("click", showuser)
document.getElementById("userdata").innerHTML = "<str>"+user.nombre+"</str><p2>"+user.email+"</p2><button id='closeuser'>X</button>"
document.getElementById("closeuser").addEventListener("click", function(){
    document.getElementById("userdata").style.zIndex = 0
    document.getElementById("userdata").style.opacity = 0
})
function showuser(){
    document.getElementById("userdata").style.zIndex = 2
    document.getElementById("userdata").style.opacity = 1
}
document.getElementById("cs").addEventListener("click", function(){
    if (confirm("¿Quieres cerrar sesión?").valueOf(true)) {
        sessionStorage.setItem("user", null)
        window.location.href="./login.html"
    }
})