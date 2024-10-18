let p = new XMLHttpRequest()
p.open("GET", "../prueba.txt")
p.addEventListener('load', function(){
    if (p.status == 200){
        document.querySelector('h1').innerHTML = p.responseText
    }
})
p.send()