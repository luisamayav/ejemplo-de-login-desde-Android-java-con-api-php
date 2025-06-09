<?php
$host = "localhost";
$db = "loginapp";
$user = "root";
$pass = "";

$conn = new mysqli($host, $user, $pass, $db);
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}
 

$usuario = $_POST['usuario'];
$clave = $_POST['clave'];

$sql = "SELECT * FROM usuarios WHERE usuario='$usuario' AND clave='$clave'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo json_encode(["estado" => "ok", "mensaje" => "Login exitoso"]);
} else {
    echo json_encode(["estado" => "error", "mensaje" => "Usuario o clave incorrectos"]);
}

$usuario = $_POST['usuario'];
$clave = $_POST['clave'];

$sql = "SELECT * FROM usuarios WHERE usuario='$usuario' AND clave='$clave'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo json_encode(["estado" => "ok", "mensaje" => "Login exitoso"]);
} else {
    echo json_encode(["estado" => "error", "mensaje" => "Usuario o clave incorrectos"]);
}

$conn->close();
?>