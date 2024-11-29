let usercomp = JSON.parse(sessionStorage.getItem("user"))
if (usercomp == null || usercomp == undefined) {
    document.body.innerHTML = ""
    Swal.fire({
        icon: "warning",
        title: "No está registrado",
        text: "Por favor inicie sesión o cree una cuenta",
      })
        .then(function(){
            window.location.href = "./registro.html"
        })
}