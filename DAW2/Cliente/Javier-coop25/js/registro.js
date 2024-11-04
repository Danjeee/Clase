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
        if (!(document.getElementById("imgfile").src).includes("user.png")) {
            params.append("foto", foto.files[0])
        }
        params.append("password", pass.value)
        console.log(pass)
        console.log(nombre.value)
        sendRegister(params)
}
function sendRegister(params) {
    let p = new XMLHttpRequest()

    p.open('POST', "../php/coop25.php")
    p.send(params)
}
f.addEventListener('submit', event => {
    if (pass.value == passc.value) {
        register()
        window.open("../coop.html")
    } else {
        event.preventDefault()
        alert("Las contraseñas no coinciden")
    }
})
foto.addEventListener('change', function(){
    img.src = window.URL.createObjectURL(foto.files[0])
    console.log(foto.files[0])
})