create database if not exists Practica1;
use Practica1;
create table if not exists Usuario (
	ID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido1 VARCHAR(50),
    apellido2 VARCHAR(50),
    email VARCHAR(50) NOT NULL,
    psw VARCHAR(50) NOT NULL
);
create table if not exists Video (
	ID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50),
    duracion TIMESTAMP,
    id_usuario INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(ID)
);