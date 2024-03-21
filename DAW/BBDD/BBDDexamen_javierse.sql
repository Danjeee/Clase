Drop database if exists Taller;
CREATE DATABASE IF NOT EXISTS Taller;
use Taller;
CREATE TABLE IF NOT EXISTS Reparacion(
	ID INT PRIMARY KEY AUTO_INCREMENT,
    Matricula VARCHAR(7) NOT NULL,
    Horas INT,
    Fecha_Entrada DATE NOT NULL,
    Fecha_Salida DATE,
    Averia VARCHAR(100),
    Reparado ENUM("SI", "NO"),
    Observaciones VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS Componente(
	ID VARCHAR(6) PRIMARY KEY,
    CONSTRAINT checkid
		CHECK (ID = "[A-Z][A-Z][A-Z]-[0-9][0-9]"),
    Descripción VARCHAR(100),
    Stock INT NOT NULL,
    Precio FLOAT NOT NULL
);
CREATE TABLE IF NOT EXISTS Incluye(
	Reparacion INT,
    Componente VARCHAR(6),
    Uds INT UNSIGNED,
    FOREIGN KEY (Reparacion) REFERENCES Reparacion(ID) ON UPDATE cascade,
    FOREIGN KEY (Componente) REFERENCES Componente(ID) ON UPDATE cascade,
    PRIMARY KEY (Reparacion, Componente)
);
ALTER TABLE Reparacion
	MODIFY Reparado ENUM("SI","NO") DEFAULT "NO",
    MODIFY Fecha_Entrada DATE DEFAULT now(),
    ADD CONSTRAINT horasnonegativas
		CHECK (Horas>=0);
ALTER TABLE Componente
	MODIFY Precio FLOAT(3,2),
	ADD CONSTRAINT preciononegativo
		CHECK (Precio>=0);
ALTER TABLE Incluye
	ADD CONSTRAINT udsnonegativas
		CHECK (uds>=0);
        