create database if not exists Practica2;
use Practica2;
create table if not exists ALUMNO (
	ID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    NIF VARCHAR(9) NOT NULL,
    grupo VARCHAR(5) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido1 VARCHAR(50),
    apellido2 VARCHAR(50)
);
create table if not exists EXAMEN_TEORICO(
	ID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(50) NOT NULL,
    numero_preguntas INT,
    fecha DATE (current_data())
);
create table if not exists ALUMNO_HACE_EXAMEN_TEORICO (
	id_alumno INT UNSIGNED NOT NULL,
    id_examen INT UNSIGNED NOT NULL,
    nota FLOAT UNSIGNED CHECK(nota <=10) NOT NULL,
    FOREIGN KEY (id_alumno) REFERENCES ALUMNO(ID),
    FOREIGN KEY (id_examen) REFERENCES EXAMEN_TEORICO(ID),
    PRIMARY KEY (id_alumno,id_examen)
);