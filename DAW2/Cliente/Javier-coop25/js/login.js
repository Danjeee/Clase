let f = document.getElementById("f")
let mail = document.getElementById("mail")
let pass = document.getElementById("pass")

function login(){
    fetch("../php/coop25.php?opcion=SR&email=" + mail.value + "&password=" + pass.value, {
        method: "GET",
    })
        .then(response => response.text())
        .then(data => {
            if(data === "error"){
                alert("El usuario no existe")
            } else {
                data = JSON.parse(data)
                console.log(data[0])
                sessionStorage.setItem("user",JSON.stringify(data[0]))
                //window.location.href = "./inicio.html"
            }
        })
}

f.addEventListener('submit', event => {
    event.preventDefault()
    login()
})