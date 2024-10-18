<?php
// Cabeceras para no hacer cache de los datos.
header('Cache-Control: no-cache, must-revalidate');
header('Expires: Mon, 26 Jul 1997 05:00:00 GMT');
// pausa para mostrar un gif animado 
sleep(4);
if (isset($_GET['nombre'])) //si se recibe el parámetro nombre mediante GET
    echo "Saludos GET desde el servidor: hola {$_GET['nombre']} {$_GET['apellidos']}. " ;
else
    if (isset($_POST['nombre'])) //si se recibe el parámetro nombre mediante POST
        echo "<br> Saludos POST desde el servidor: hola {$_POST['nombre']} {$_POST['apellidos']}. ";

// Mostramos la fecha y hora del servidor web.
echo "<br> <br> La fecha y hora del Servidor Web: ";
echo date("j/n/Y G:i:s");
?>
