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
    let n = Number.parseFloat(e.precio)
    prec.innerHTML = n.toFixed(2) + "€"
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
    buy.addEventListener("click", function(){
        Swal.fire({
            icon: "warning",
            title: "Comprar artículo",
            text: "¿Seguro que quiere comprar el articulo?",
            showDenyButton: true,
            showCancelButton: false,
            confirmButtonText: 'Comprar',
            denyButtonText: `Cancelar`,
          }).then(result => {
            if (result.isConfirmed) {
                datos = new FormData()
                datos.append("opcion", "CA")
                datos.append("idarticulo", e.id)
                fetch("../php/coop25.php", {
                    method: "POST",
                    body: datos
                })
                var datos2 = new FormData()
                datos2.append("fecha", new Date(Date.now()).toISOString())
                datos2.append("opcion", "RV")
                datos2.append("vendedor", e.vendedor)
                datos2.append("idarticulo", e.id)
                datos2.append("precio", e.precio)
                datos2.append("idsocio", user.id)
                fetch("../php/coop25.php", {
                    method: "POST",
                    body: datos2,
                })
                .then(response => response.text())
                .then(data => {
                    if (data==="error") {
                        Swal.fire({
                            icon: "error",
                            title: "Error",
                            text: "Ha habido un error al comprar el articulo",
                          })
                    } else {
                        Swal.fire({
                            icon: "success",
                            title: "Articulo comprado",
                            text: "Esperamos que disfrute de su nuevo articulo",
                          })
                            .then(function(){
                                window.location.href = "./inicio.html"
                            })
                          
                    }
                })
            }
          })
    })
    cont.appendChild(buy)
    cont.appendChild(desc)
    document.getElementById("main").appendChild(cont)
}
load()