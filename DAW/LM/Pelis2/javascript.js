function chbg1() {
    document.getElementById('a').style.backgroundImage = "url(img/fondoshrek.jpg)";
}   
function chbg2() {
    document.getElementById('a').style.backgroundImage = "url(img/spaceballsfondo.jpg)";
}  
function chbg3() {
    document.getElementById('a').style.backgroundImage = "url(img/bocadillofondo.jpg)";
}  
function chbgdef() {
    document.getElementById('a').style.backgroundImage = "url()";
}
var x = 1;
function move(){
    let a = document.getElementById('b');
    x *= -1;
    if (x<0){
        a.style.marginTop = "200px";
    } else {
        a.style.marginTop = "50px";
    };
    
}