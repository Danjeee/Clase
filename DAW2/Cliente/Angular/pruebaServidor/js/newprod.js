let user = JSON.parse(sessionStorage.getItem("user"))
let f = document.getElementById("f")
let nombre = document.getElementById("nombre")
let desc = document.getElementById("desc")
let foto = document.getElementById("imagen")
let cat = document.getElementById("cat")
let precio = document.getElementById("precio")
let img = document.getElementById("imgfile")
var corr = false;
function register() {
    document.getElementById("errorlist").innerHTML = ""
    let params = new FormData()
    params.append("opcion", "RA")
    params.append("nombre", nombre.value)
    params.append("descripcion", desc.value)
    params.append("precio", precio.value)
    params.append("categoria", cat.value)
    params.append("vendedor", user.id)
    params.append("imagen", foto.files[0])
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
    if (foto.value=="") {
        corr=false
        errormsg("errmail", "La imagen no puede estar vacia")
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
            if (data === "error") {
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Ha habido un error al registrar el producto"
                  });
            } else {
                Swal.fire({
                    icon: "success",
                    title: "¡Realizado!",
                    text: "Producto Añadido"
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