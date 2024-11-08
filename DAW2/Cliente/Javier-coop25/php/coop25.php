<?php
header('Content-Type: application/json');
header('Cache-Control: no-cache, must-revalidate');
header('Expires: Mon, 26 Jul 1997 05:00:00 GMT');

$servidor = "localhost";   // Configuración BD
$basedatos = "coop25";
$usuario = "root";
$password = "";

// --  Crear la conexión al servidor y ejecutar la consulta.
$conexion = mysqli_connect($servidor, $usuario, $password) or die(mysqli_error($conexion));
mysqli_query($conexion, "SET NAMES 'utf8'");
mysqli_select_db($conexion, $basedatos) or die(mysqli_error($conexion));


// --  párametro opción para determinar la select a realizar -------
if (isset($_GET['opcion']))
  $opc = $_GET['opcion'];
else if (isset($_POST['opcion']))
  $opc = $_POST['opcion'];

// -- parámetros socio para consulta socio registrado (SR) y registrar socio (RS)      
if (isset($_GET['email']))
  $ema = $_GET['email'];
else if (isset($_POST['email']))
  $ema = $_POST['email'];
if (isset($_GET['password']))
  $pas = $_GET['password'];
else if (isset($_POST['password']))
  $pas = $_POST['password'];
if (isset($_GET['nombre']))
  $nom = $_GET['nombre'];
else if (isset($_POST['nombre']))
  $nom = $_POST['nombre'];
if (isset($_GET['apellidos']))
  $ape = $_GET['apellidos'];
else if (isset($_POST['apellidos']))
  $ape = $_POST['apellidos'];
if (isset($_GET['foto']))
  $img = $_GET['foto'];
else if (isset($_POST['foto']))
  $img = $_POST['foto'];

// -- parámetro idsocio (SC)
if (isset($_GET['idsocio']))
  $ids = $_GET['idsocio'];
else if (isset($_POST['idsocio']))
  $ids = $_POST['idsocio'];





// (SR) = Socio Registrado; (AV) = Articulos en Venta; (SC) = un Socio Consulta; 
if ( $opc == "SR" || $opc == "AV" || $opc == "SC") {
  switch ($opc) {
    case "SR": // Socio Registrado
      $sql = "select * from socios where email = '" . $ema . "' and password = '" . $pas . "'";
      break;
    case "SC": // Socio Consulta 
      $sql = "select * from socios where id = '" . $ids . "'";
      break;
        
    case "AV": // Articulos en Venta
      $sql = "select * from articulos where estado = 'D'";
      break;
    
  }
  $datos = null;
  try {
    $resultados = mysqli_query($conexion, $sql);
    if (mysqli_num_rows($resultados) > 0) {
      while ($fila = mysqli_fetch_array($resultados)) {
        $datos[] = $fila;
      }
      echo json_encode($datos);
    } else
      echo "error";
  } catch (Exception $e) {
    echo false;
  }
} else {
  switch ($opc) {
    case "RS": // Registro nuevo Socio
      $archivoImagen = (isset($_FILES['foto'])) ? $_FILES['foto'] : null; // subir el archivo al servidor 
      if ($archivoImagen) {
        $ruta_destino_archivo = "../imgs/socios/";
        $nombre_archivo = $archivoImagen['name'];
        $nombre_archivo = str_replace(' ', '', $nombre_archivo);
        if (is_file($ruta_destino_archivo . $nombre_archivo)) {
          $idunico = time();
          $nombre_archivo = $idunico . "_" . $nombre_archivo;
        }
        $archivo_ok = move_uploaded_file($archivoImagen['tmp_name'], $ruta_destino_archivo . $nombre_archivo);
      } else {
        $nombre_archivo = "user.png";
      }
      $sql = "insert into socios (nombre, apellidos, email, foto, password) 
               values ('" . $nom . "','" . $ape . "','" . $ema . "','" . $nombre_archivo . "','" . $pas . "')";
      break;

      
    
    
    case "MS": // Modificar Socio
      $archivoImagen = (isset($_FILES['foto'])) ? $_FILES['foto'] : null; // subir el archivo al servidor 
      if ($archivoImagen) {
        $ruta_destino_archivo = "../imgs/socios/";
        $nombre_archivo = $archivoImagen['name'];
        $nombre_archivo = str_replace(' ', '', $nombre_archivo);
        if (is_file($ruta_destino_archivo . $nombre_archivo)) {
          $idunico = time();
          $nombre_archivo = $idunico . "_" . $nombre_archivo;
        }
        $archivo_ok = move_uploaded_file($archivoImagen['tmp_name'], $ruta_destino_archivo . $nombre_archivo);
      } else {
        $nombre_archivo = $img;
      }
      $sql = "update socios SET nombre='" . $nom . "', apellidos='" . $ape . "', email='" . $ema . "', foto='" . $nombre_archivo . "', password='" . $pas . "' WHERE id='" . $ids . "'";
      break;

      }
  try {
    $resultados = mysqli_query($conexion, $sql);
    if ($resultados == 1) {
      echo "ok";
    } else {
      echo "error";
    }
    ;
  } catch (Exception $e) {
    echo "error";
  }
}
mysqli_close($conexion);
?>