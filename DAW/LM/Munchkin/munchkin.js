var vidas = []
function addplayer() {
    vidas.push(1);
    console.log(vidas);
    var playercont = document.getElementById("playercont");
    playercont.innerHTML = "";
    reload()
}
function reload() {
    for (var i = 0; i < vidas.length; i++) {
        createplayer(i, vidas[i])
    }
}
function createplayer(id, lives) {
    console.log("id: " + id)
    console.log("vidas: " + lives)
    const newPlayer = document.createElement("player" + id);
    newPlayer.style.display = "flex";
    const add = document.createElement("add");
    add.id = "add";
    add.onclick = function () { addlvl(id); };
    console.log(add.onclick)
    const vidas = document.createTextNode(lives);
    const rest = document.createElement("rest");
    rest.id = "rest";
    rest.onclick = function () { rmlvl(id); };
    newPlayer.appendChild(add)
    newPlayer.appendChild(vidas)
    newPlayer.appendChild(rest)
    var playercont = document.getElementById("playercont");
    playercont.appendChild(newPlayer);
}
function addlvl(id) {
    for (var i = 0; i < vidas.length; i++) {
        if (id == i) {
            if (vidas[i] != 10) {
                vidas[i]++
            }
            var playercont = document.getElementById("playercont");
            playercont.innerHTML = "";
            reload()
            break
        }
    }
}
function rmlvl(id) {
    for (var i = 0; i < vidas.length; i++) {
        if (id == i) {
            if (vidas[i] != 1) {
                vidas[i]--
            }
            var playercont = document.getElementById("playercont");
            playercont.innerHTML = "";
            reload()
            break
        }
    }
}