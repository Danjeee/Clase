<?php
header("Access-Control-Allow-Origin: *"); // Permitir solicitudes desde cualquier origen
header("Access-Control-Allow-Methods: GET, POST, OPTIONS"); // Métodos permitidos
header("Access-Control-Allow-Headers: Content-Type, Authorization"); // Cabeceras permitidas
header('Content-Type: application/json');
header('Cache-Control: no-cache, must-revalidate');
header('Expires: Mon, 26 Jul 1997 05:00:00 GMT');

$servidor = "localhost";   // Configuración BD
$basedatos = "prueba";
$usuario = "root";
$password = "javi00";

// --  Crear la conexión al servidor y ejecutar la consulta.
$conexion = mysqli_connect($servidor, $usuario, $password);
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



//-- parametros articulo para registrar articulo en venta (RA) y modificar artículo (MA)
if (isset($_GET['categoria']))
  $cat = $_GET['categoria'];
else if (isset($_POST['categoria']))
  $cat = $_POST['categoria'];
if (isset($_GET['nombre']))
  $art = $_GET['nombre'];
else if (isset($_POST['nombre']))
  $art = $_POST['nombre'];
if (isset($_GET['descripcion']))
  $des = $_GET['descripcion'];
else if (isset($_POST['descripcion']))
  $des = $_POST['descripcion'];
if (isset($_GET['precio']))
  $pre = $_GET['precio'];
else if (isset($_POST['precio']))
  $pre = $_POST['precio'];
if (isset($_GET['imagen']))
  $img = $_GET['imagen'];
else if (isset($_POST['imagen']))
  $img = $_POST['imagen'];

// -- parámetro vendedor
if (isset($_GET['vendedor']))
  $ven = $_GET['vendedor'];
else if (isset($_POST['vendedor']))
  $ven = $_POST['vendedor'];

// -- parámetro idsocio
if (isset($_GET['idsocio']))
  $ids = $_GET['idsocio'];
else if (isset($_POST['idsocio']))
  $ids = $_POST['idsocio'];

// -- parámetro fecha 
if (isset($_GET['fecha']))
  $fec = $_GET['fecha'];
else if (isset($_POST['fecha']))
  $fec = $_POST['fecha'];

// -- parámetro idarticulo
if (isset($_GET['idarticulo']))
  $ida = $_GET['idarticulo'];
else if (isset($_POST['idarticulo']))
  $ida = $_POST['idarticulo'];



// (SR) = Socio Registrado; 
// (SC) = Socio Consulta; 
// (AC) = Articulo Consulta;
// (AV) = Articulos en Venta;
// (AS) = Artículos Socio;
// (TC) = Todas las categorías;
if (
  $opc == "SR" || $opc == "SC" || $opc == "AC" || $opc == "AV" || $opc == "AS" || $opc == "TC" || $opc == "SVS"
) {
  switch ($opc) {
    case "SR": // Socio Registrado
      $sql = "select * from socios where email = '" . $ema . "' and password = '" . $pas . "'";
      break;
    case "SC": // Socio Consulta 
      $sql = "select * from socios where id = '" . $ids . "'";
      break;
    case "AC": // Articulo Consulta
      $sql = "select * from articulos where id = '" . $ida . "'";
      break;
    case "AV": // Articulos en Venta
      $sql = "select * from articulos where estado = 'D'";
      break;
    case "AS": // Artículos del Socio
      $sql = "select * from articulos where vendedor = '" . $ids . "' order by estado";
      break;
    case "TC": // Todas las Categorias
      $sql = "select id, nombre, imagen from categorias";
      break;
    case "SVS": // Seleccionar los articulos que compra un usuario --------------------------------------------------------------
      $sql = "select * from articulos a join ventas v on v.articulo = a.id where v.comprador = '" . $ids . "'";
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
      echo json_encode(['error' => 'Sin datos en la consulta']);
  } catch (Exception $e) {
    echo json_encode(['error' => 'Error en el consulta']);
  }
} else {
  // (RS) = Registrar Socio; 
  // (MS) = Modificar Socio; 
  // (RA) = Registrar Artículo; 
  // (MA) = Modificar Artículo; 
  // (BA) = Borrar Artículo; 
  // (CA) = Comprar Artículo; 
  // (RV) = Registro Venta; 

  switch ($opc) {
    case "RS": // Registro nuevo Socio ------------------------------------------------------------
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

    case "MS": // Modificar Socio ------------------------------------------------------------
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

    case "RA": // Registro nuevo Articulo --------------------------------------------------------
      $archivoImagen = (isset($_FILES['imagen'])) ? $_FILES['imagen'] : null; // subir el archivo al servidor 
      if ($archivoImagen) {
        $ruta_destino_archivo = "../imgs/articulos/";
        $nombre_archivo = $archivoImagen['name'];
        $nombre_archivo = str_replace(' ', '', $nombre_archivo);
        if (is_file($ruta_destino_archivo . $nombre_archivo)) {
          $idunico = time();
          $nombre_archivo = $idunico . "_" . $nombre_archivo;
        }
        $archivo_ok = move_uploaded_file($archivoImagen['tmp_name'], $ruta_destino_archivo . $nombre_archivo);
      }
      $sql = "insert into articulos (categoria, nombre, descripcion, precio, imagen, vendedor) 
                 values ('" . $cat . "','" . $art . "','" . $des . "','" . $pre . "','" . $nombre_archivo . "','" . $ven . "')";
      break;

    case "MA": // Modificar Artículo -----------------------------------------------------
      $archivoImagen = (isset($_FILES['imagen'])) ? $_FILES['imagen'] : null; // subir el archivo al servidor 
      if ($archivoImagen) {
        $ruta_destino_archivo = "../imgs/articulos/";
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
      $sql = "update articulos SET categoria='" . $cat . "', nombre='" . $art . "', descripcion='" . $des . "', imagen='" . $nombre_archivo . "', precio='" . $pre . "', estado='D' WHERE id='" . $ida . "'";
      break;

    case "BA": // Borrar Articulo --------------------------------------------------------------
      $sql = "delete from articulos where id = '" . $ida . "'";
      break;

    case "CA": // Compra Artículo (al comprar se cambia el estado de 'D' (disponible) a 'V' (vendido)     
      $sql = "update articulos set estado = 'V' where id = '" . $ida . "'";
      break;

    case "RV": // Registro Venta -----------------------------------------------------------------
      $sql = "insert into ventas (fecha, socio, articulo, precio, comprador) 
              values ('" . $fec . "','" . $ven . "','" . $ida . "','" . $pre . "','" . $ids . "')";
      break;
  }

  try {
    $resultados = mysqli_query($conexion, $sql);
    if ($resultados == 1) {
      echo json_encode(['ok' => 'Exito en la actualización']);
    } else {
      echo json_encode(['error' => 'Error en la actualización']);
    }
    ;
  } catch (Exception $e) {
    echo json_encode(['error' => $sql]);
  }
}
mysqli_close($conexion);
?>