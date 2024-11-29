document.getElementById("user").addEventListener("click", function () {
    Swal.fire({
        icon: "info",
        title: user.nombre,
        text: user.email
    })

})
if (document.getElementById("inicio").className != "selected") {
    document.getElementById("inicio").addEventListener("click", function () {
        window.location.href = "./inicio.html"
    })
}
document.getElementById("cs").addEventListener("click", function () {
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
if (document.getElementById("misprod").className != "selected") {
    document.getElementById("misprod").addEventListener("click", function () {
        window.location.href = "./misproductos.html"
    })
}
if (document.getElementById("miperf").className != "selected") {
    document.getElementById("miperf").addEventListener("click", function () {
        window.location.href = "./miperfil.html"
    })
}