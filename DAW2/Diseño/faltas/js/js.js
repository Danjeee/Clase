let cursos = ["1ESO", "2ESO", "3ESO", "4ESO", "1SMR(M)", "1SMR(T)", "2SMR(M)", "2SMR(T)"]
let selected = ["1ESO", "2ESO", "3ESO", "4ESO"]
var limit = 5
function showcursos(){
    let cursoscont = document.createElement('divv')
    cursos.forEach(element => {
        cursoscont.innerHTML += "<br><input type='checkbox' value='"+element+"' name='"+element+"><label for='"+element+"'>"+element+"</label>"
    });
}