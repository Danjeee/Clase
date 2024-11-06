let f = document.getElementById("f")
let nombre = document.getElementById("nombre")
let aps = document.getElementById("aps")
let mail = document.getElementById("mail")
let foto = document.getElementById("foto")
let pass = document.getElementById("pass")
let passc = document.getElementById("passc")
let img = document.getElementById("imgfile")
function register() {
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
    sendRegister(data)

}
function sendRegister(params) {
    fetch("../php/coop25.php", {
        method: "POST",
        body: params,
    })
        .then(response => response.text())
        .then(data => {
            if (data === "error") {
                alert("Error al registrar el usuario")
            } else {
                alert("Usuario registrado")
            }
        })
}
function setUser(mail, passwd) {
    fetch("../php/coop25.php?opcion=SR&email=" + mail + "&password=" + passwd, {
        method: "GET",
    })
        .then(response => response.json())
        .then(data => {
            sessionStorage.setItem("user",JSON.stringify(data[0]))
        })
}
f.addEventListener('submit', event => {
    event.preventDefault()
    if (pass.value == passc.value) {
        register()
        setUser(mail.value, pass.value)
        window.location.href = "./inicio.html"


    } else {
        event.preventDefault()
        alert("Las contraseñas no coinciden")
    }
    event.preventDefault()
})
foto.addEventListener('change', function () {
    img.src = window.URL.createObjectURL(foto.files[0])
})