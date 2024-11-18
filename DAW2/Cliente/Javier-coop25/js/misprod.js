let user = JSON.parse(sessionStorage.getItem("user"))
function load(){
    let params = new FormData()
    params.append("opcion", "AS")
    params.append("idsocio", user.id)
    const data = new URLSearchParams(params);
    fetch("../php/coop25.php", {
        method: "POST",
        body: data,
    })
    .then(response => response.json())
    .then(data => {
        if (data.length == 0) {
            document.getElementById("errmsg").innerHTML = "No hay articulos"
        }
        data.forEach(e => {
                if (e.estado != "V") {
                    createitem(e)
                } else {
                    createsolditem(e)
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
    let n = Number.parseFloat(e.precio)
    prec.innerHTML = n.toFixed(2) + "€"
    prec.className = "precio"
    let desc = document.createElement("p")
    desc.className = "desc"
    desc.innerHTML = e.descripcion
    let buy = document.createElement("button")
    buy.innerHTML = "Eliminar"
    let edit = document.createElement("button")
    edit.innerHTML = "Editar"
    let img = document.createElement("img")
    img.src = "../imgs/articulos/"+e.imagen
    let buttons = document.createElement("div")
    buttons.style.display = "flex"
    buttons.style.gap = "5px"
    cont.appendChild(nom)
    cont.appendChild(img)
    cont.appendChild(prec)
    edit.addEventListener("click", function(){
        sessionStorage.setItem("art", e.id)
        window.location.href = "editprod.html"
    })
    buy.addEventListener("click", function(){
        Swal.fire({
            icon: "warning",
            title: "Eliminar artículo",
            text: "¿Seguro que quiere eliminar el articulo?",
            showDenyButton: true,
            showCancelButton: false,
            confirmButtonText: 'Eliminar',
            denyButtonText: `Cancelar`,
          }).then(result => {
            if (result.isConfirmed) {
                datos = new FormData()
                datos.append("opcion", "BA")
                datos.append("idarticulo", e.id)
                fetch("../php/coop25.php", {
                    method: "POST",
                    body: datos
                })
                .then(response => response.text())
                .then(data => {
                    if (data==="error") {
                        Swal.fire({
                            icon: "error",
                            title: "Error",
                            text: "Ha habido un error al eliminar el articulo",
                          })
                    } else {
                        Swal.fire({
                            icon: "success",
                            title: "Articulo retirado",
                            text: "Articulo eliminado exitosamente",
                          })
                            .then(function(){
                                window.location.href = "./misproductos.html"
                            })
                          
                    }
                })
            }
          })
    })
    buttons.appendChild(edit)
    buttons.appendChild(buy)
    cont.appendChild(buttons)
    cont.appendChild(desc)
    document.getElementById("main").appendChild(cont)
    
}
function createsolditem(e){
    let cont = document.createElement('div')
    cont.className = "art"
    let nom = document.createElement("h3")
    nom.innerHTML = e.nombre
    let prec = document.createElement("p")
    let n = Number.parseFloat(e.precio)
    prec.innerHTML = n.toFixed(2) + "€"
    prec.className = "precio"
    let desc = document.createElement("p")
    desc.className = "desc"
    desc.innerHTML = e.descripcion
    let buy = document.createElement("button")
    buy.innerHTML = "Vendido"
    buy.className = "vendido"
    let img = document.createElement("img")
    img.src = "../imgs/articulos/"+e.imagen
    
    cont.appendChild(nom)
    cont.appendChild(img)
    cont.appendChild(prec)
    cont.appendChild(buy)
    cont.appendChild(desc)
    document.getElementById("main").appendChild(cont)
}
document.getElementById("newprod").addEventListener("click", function(){
    window.location.href = "./newprod.html"
})
load()