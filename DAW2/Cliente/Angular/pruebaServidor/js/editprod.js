let user = JSON.parse(sessionStorage.getItem("user"))
let art = sessionStorage.getItem("art")
let f = document.getElementById("f")
let nombre = document.getElementById("nombre")
let desc = document.getElementById("desc")
let foto = document.getElementById("imagen")
let cat = document.getElementById("cat")
let precio = document.getElementById("precio")
let img = document.getElementById("imgfile")
var corr = false;
function load2(){
    let params = new FormData()
    params.append("opcion", "AC")
    params.append("idarticulo", art)
    fetch("../php/coop25.php", {
        body: params,
        method: "POST",
        
    })
    .then(response => response.json())
    .then(data => {
        let artic = data[0]
        nombre.value = artic.nombre
        desc.value = artic.descripcion
        img.src = "../imgs/articulos/"+artic.imagen
        cat.value = artic.categoria
        precio.value = artic.precio
    })
}
function register() {
    document.getElementById("errorlist").innerHTML = ""
    let params = new FormData()
    params.append("opcion", "MA")
    params.append("idarticulo", art)
    params.append("nombre", nombre.value)
    params.append("descripcion", desc.value)
    params.append("precio", precio.value)
    params.append("categoria", cat.value)
    params.append("vendedor", user.id)
    if (foto.files[0] != null || foto.files[0] != undefined) {
        params.append("imagen", foto.files[0])
        console.log(foto.files[0].src)
    } else {
        params.append("camb", "nocamb")
        params.append("imagen", img.src.substring(img.src.lastIndexOf("/")+1))
    }
    var corr = true;
    if (nombre.value=="") {
        corr=false
        errormsg("errnom", "El nombre no puede estar vacio")
    } else {
        removeerror("errnom")
    }
    if (precio.value<=0) {
        corr=false
        errormsg("errorprec", "El precio no puede ser 0 o menor a 0")
    } else {
        removeerror("errorprec")
    }
    if (desc.value=="") {
        corr=false
        errormsg("erraps", "La descripcion no puede estar vacia")
    } else {
        removeerror("erraps")
    }
    if (corr) {
        sendRegister(params)
    }
 

}
function errormsg(id, text){
    var has = false
    Array.from(document.getElementById("errorlist").childNodes).forEach(child => {
        if (child.id == id) {
            has = true
        }
    });
    if (!has) {
        let error = document.createElement("div")
        error.id = id
        error.innerHTML = text
        error.className = "error"
        document.getElementById("errorlist").appendChild(error)
    }
}
function removeerror(id){
    Array.from(document.body.childNodes).forEach(child => {
        if (child.id == id) {
            document.getElementById("errorlist").remove(child)
        }
    });
}
function sendRegister(params) {
   fetch("../php/coop25.php", {
        body: params,
        method: "POST",
        
    })
        .then(response => response.text())
        .then(data => {
            console.log(data)
            if (data === "error") {
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Ha habido un error al editar el producto"
                  });
            } else {
                Swal.fire({
                    icon: "success",
                    title: "¡Editado!",
                    text: "Producto Editado"
                  })
                  .then(function(){
                     window.location.href = "./misproductos.html"
                })
            }
        }) 
}
function load() {
    var params = new FormData()
    params.append("opcion", "TC")
    fetch("../php/coop25.php", {
         method: "POST",
         body: params,
     })
         .then(response => response.json())
         .then(data => {
            data.forEach(e => {
                var opt = document.createElement("option")
                opt.innerHTML = e.nombre
                opt.value = e.id
                document.getElementById("cat").appendChild(opt)
            });
         }) 
 }

f.addEventListener('submit', event => {
    event.preventDefault()
    register()
    if (corr == true) {
        window.location.href = "./misproductos.html"
        event.preventDefault()
    }
})
foto.addEventListener('change', function () {
    console.log(foto.files[0])
    img.src = window.URL.createObjectURL(foto.files[0])
})
load()
load2()