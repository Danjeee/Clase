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
    let img = document.createElement("img")
    img.src = "../imgs/articulos/"+e.imagen
    cont.appendChild(nom)
    cont.appendChild(img)
    cont.appendChild(prec)
   
    cont.appendChild(buy)
    cont.appendChild(desc)
    document.getElementById("main").appendChild(cont)
}
load()
document.getElementById("cs").addEventListener("click", function(){
    Swal.fire({
        icon: "warning",
        title: "Cerrar sesión",
        text: "¿Seguro que quiere cerrar la sesión?",
        showDenyButton: true,
        showCancelButton: false,
        confirmButtonText: 'Cerrar sesión',
        denyButtonText: `Cancelar`,
      }).then(result => {
        if (result.isConfirmed) {
            sessionStorage.setItem("user", null)
            window.location.href = "./login.html"
        }
      })
})
document.getElementById("user").addEventListener("click", function(){
    Swal.fire({
        icon: "info",
        title: user.nombre,
        text: user.email
      })
      
})