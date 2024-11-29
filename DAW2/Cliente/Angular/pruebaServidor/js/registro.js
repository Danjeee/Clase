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
    params.append("opcion", "RS")
    params.append("nombre", nombre.value)
    params.append("apellidos", aps.value)
    params.append("email", mail.value)
    if (!(img.src).includes("user.png")) {
        params.append("foto", foto.files[0])
        console.log(foto.files[0])
    }
    params.append("password", pass.value)
    const data = new URLSearchParams(params);
    corr = true;
    if (nombre.value == "") {
        corr = false
        errormsg("errnom", "El nombre no puede estar vacio")
    } else {
        removeerror("errnom")
    }
    if (aps.value == "") {
        corr = false
        errormsg("erraps", "El/los apellido(s) no puede(n) estar vacio(s)")
    } else {
        removeerror("erraps")
    }
    if (mail.value == "") {
        corr = false
        errormsg("errmail", "El mail no puede estar vacio")
    } else {
        if (!validateEmail(mail.value)) {
            corr = false
            errormsg("errmail", "Mail incorrecto")
        } else {
            checkexistentmail(mail.value)
        }
    }
    if (pass.value == "") {
        corr = false
        errormsg("errpass", "La contraseña no puede estar vacia")
    } else {
        if (!validatePass(pass.value)) {
            corr = false
            errormsg("errpass", "La contraseña es incorrecta (Debe contener 6 caracteres de los cuales 1 es un numero)")
        } else {
            removeerror("errpass")
        }

    }
    if (passc.value == "") {
        corr = false
        errormsg("errpassc", "La confirmación de contraseña no puede estar vacia")
    } else {
        removeerror("errpassc")
    }

    if (pass.value != passc.value) {
        corr = false
        errormsg("errconf", "Las contraseñas no coinciden")
    } else {
        removeerror("errconf")
    }


    setTimeout(() => {
        if (corr) {
            sendRegister(params)
        } 
    }, 200);


}
function checkexistentmail(mail){
    let params = new FormData()
    params.append("opcion", "TS")
    fetch("../php/coop25.php", {
        method: "POST",
        body: params,
    })
        .then(response => response.json())
        .then(data => {
            data.forEach(e => {
                if (e.email == mail) {
                    corr = false
                    errormsg("errmail2", "Este email ya esta registrado")
                }
            });
        })
    
}
function errormsg(id, text) {
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
function removeerror(id) {
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
                    text: "Ha habido un error al registrar el usuario"
                });
            } else {
                Swal.fire({
                    icon: "success",
                    title: "¡Realizado!",
                    text: "Usuario registrado"
                })
                    .then(function () {
                        setUser(mail.value, pass.value)
                        setTimeout(() => {
                            window.location.href = "./inicio.html"
                        }, 100);
                    })
            }
        })
}
function setUser(mail, passwd) {
    fetch("../php/coop25.php?opcion=SR&email=" + mail + "&password=" + passwd, {
        method: "GET",
    })
        .then(response => response.json())
        .then(data => {
            sessionStorage.setItem("user", JSON.stringify(data[0]))
        })
}
f.addEventListener('submit', event => {
    event.preventDefault()
    register()
})
foto.addEventListener('change', function () {
    img.src = window.URL.createObjectURL(foto.files[0])
})