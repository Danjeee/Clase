let user = JSON.parse(sessionStorage.getItem("user"))
let f = document.getElementById("f")
let nombre = document.getElementById("nombre")
let aps = document.getElementById("aps")
let mail = document.getElementById("mail")
let foto = document.getElementById("foto")
let pass = document.getElementById("pass")
let passc = document.getElementById("passc")
let img = document.getElementById("imgfile")
var corr = false;
const validateEmail = (email) => {
    return String(email)
      .toLowerCase()
      .match(
        /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
      );
  };
  const validatePass = (pass) => {
    return String(pass)
      .match(
       // /^(?=(.*[a-zA-Z]){5,})(?=(.*\d)){1,}/ antiguo
       /^(?=.*\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{5,10}$/
      );
  };
function register() {
    document.getElementById("errorlist").innerHTML = ""
    let params = new FormData()
    params.append("opcion", "MS")
    params.append("idsocio", user.id)
    params.append("nombre", nombre.value)
    params.append("apellidos", aps.value)
    params.append("email", mail.value)
    if (foto.files[0] != null || foto.files[0] != undefined) {
        params.append("foto", foto.files[0])
    } else {
        params.append("camb", "nocamb")
        params.append("foto", img.src.substring(img.src.lastIndexOf("/")+1))
    }
    params.append("password", pass.value)
    const data = new URLSearchParams(params);
    var corr = true;
    if (nombre.value=="") {
        corr=false
        errormsg("errnom", "El nombre no puede estar vacio")
    } else {
        removeerror("errnom")
    }
    if (aps.value=="") {
        corr=false
        errormsg("erraps", "El/los apellido(s) no puede(n) estar vacio(s)")
    } else {
        removeerror("erraps")
    }
    if (mail.value=="") {
        corr=false
        errormsg("errmail", "El mail no puede estar vacio")
    } else {
        if (!validateEmail(mail.value)) {
            corr = false
            errormsg("errmail", "Mail incorrecto")
        } else {
            removeerror("errmail")
        }
    }
    if (pass.value=="") {
        corr=false
        errormsg("errpass", "La contraseña no puede estar vacia")
    } else {
        if (!validatePass(pass.value)) {
            corr = false
            errormsg("errpass", "La contraseña es incorrecta (Debe contener 6 caracteres de los cuales 1 es un numero)")
        } else {
            removeerror("errpass")
        }
        
    }
    if (passc.value=="") {
        corr=false
        errormsg("errpassc", "La confirmación de contraseña no puede estar vacia")
    } else {
        removeerror("errpassc")
    }

    if (pass.value!=passc.value) {
        corr=false
        errormsg("errconf", "Las contraseñas no coinciden")
    } else {
        removeerror("errconf")
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
        method: "POST",
        body: params,
    })
        .then(response => response.text())
        .then(data => {
            if (data === "error") {
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Ha habido un error al actualizar el usuario"
                  });
            } else {
                Swal.fire({
                    icon: "success",
                    title: "Actualizado!",
                    text: "Usuario actualizado"
                  })
                  .then(function(){
                    setTimeout(() => {
                        window.location.href = "./miperfil.html" 
                    }, 100);
                })
            }
        })
}
function load(){
    let params = new FormData()
    params.append("opcion", "SC")
    params.append("idsocio", user.id)
    fetch("../php/coop25.php", {
        method: "POST",
        body: params,
    })
    .then(response => response.json())
    .then(data => {
        let usuario = data[0]
        nombre.value = usuario.nombre
        aps.value = usuario.apellidos
        mail.value = usuario.email
        img.src = "../imgs/socios/"+usuario.foto
    })
    document.getElementById("passcont").style.display = "none"
    document.getElementById("foto").style.display = "none"
    document.getElementById("passcontc").style.display = "none"
    document.getElementById("fotolab").style.display = "none"
    document.getElementById("fotobut").style.display = "none"
    document.getElementById("submit").style.display = "none"
    document.getElementById("canc").style.display = "none"
    document.getElementById("nombre").setAttribute("readonly", true)
    document.getElementById("aps").setAttribute("readonly", true)
    document.getElementById("mail").setAttribute("readonly", true)
}
f.addEventListener('submit', event => {
    event.preventDefault()
    register()
})
foto.addEventListener('change', function () {
    img.src = window.URL.createObjectURL(foto.files[0])
})
document.getElementById("canc").addEventListener("click", function(){
    document.getElementById("passcont").style.display = "none"
    document.getElementById("foto").style.display = "none"
    document.getElementById("passcontc").style.display = "none"
    document.getElementById("fotolab").style.display = "none"
    document.getElementById("fotobut").style.display = "none"
    document.getElementById("submit").style.display = "none"
    document.getElementById("canc").style.display = "none"
    document.getElementById("nombre").setAttribute("readonly", true)
    document.getElementById("aps").setAttribute("readonly", true)
    document.getElementById("mail").setAttribute("readonly", true)
    document.getElementById("edit").style.display = ""
})
document.getElementById("edit").addEventListener("click", function(){
    document.getElementById("passcont").style.display = ""
    document.getElementById("foto").style.display = ""
    document.getElementById("passcontc").style.display = ""
    document.getElementById("fotolab").style.display = ""
    document.getElementById("fotobut").style.display = ""
    document.getElementById("submit").style.display = ""
    document.getElementById("canc").style.display = ""
    document.getElementById("nombre").removeAttribute("readonly")
    document.getElementById("aps").removeAttribute("readonly")
    document.getElementById("mail").removeAttribute("readonly")
    document.getElementById("edit").style.display = "none"
})
load()