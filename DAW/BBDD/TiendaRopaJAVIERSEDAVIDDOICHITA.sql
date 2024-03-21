drop database if exists Tienda;
create database Tienda;
use Tienda;
create table DEPARTAMENTO(
	codigo INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50)
);
create table ADMINISTRADOR(
	DNI VARCHAR(9) PRIMARY KEY,
    CONSTRAINT check_dni
		check(DNI = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]"),
	Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    TLFNO VARCHAR(9),
    FNacimiento DATE,
    Direccion VARCHAR(50),
    Email VARCHAR(50),
    Rol VARCHAR(50),
    NivelAcceso INT,
    Privilegios VARCHAR(50),
    codigoDEP INT UNSIGNED,
    FOREIGN KEY (codigoDEP) REFERENCES DEPARTAMENTO(codigo)
);
create table METODO_PAGO(
	codigo INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(100)
);
create table CLIENTE(
	DNI VARCHAR(9) PRIMARY KEY,
    CONSTRAINT check_dni2
		check(DNI = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]"),
	Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    TLFNO VARCHAR(9),
    FNacimiento DATE,
    Direccion VARCHAR(50),
    Email VARCHAR(50),
    Cuenta VARCHAR(50),
    numPedidos INT,
    dirEnvio VARCHAR(50),
    tarjIden VARCHAR(50),
    codigoPago INT UNSIGNED,
    FOREIGN KEY (codigoPago) REFERENCES METODO_PAGO(codigo)
);
create table MATERIAL(
	codigo INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    denominacion VARCHAR(50)
);
create table ARTICULO(
	codigo INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    precio FLOAT,
    marca VARCHAR(50),
    descripcion VARCHAR(100),
    codMaterial INT UNSIGNED,
    FOREIGN KEY (codMaterial) REFERENCES MATERIAL(codigo)
);
create table PEDIDO(
	numero INT PRIMARY KEY,
    fecha DATE,
    dirEnvio VARCHAR(50),
    estado ENUM("enviado","por enviar","recibido"),
    DNI_cli VARCHAR(9),
    codigoPago INT UNSIGNED,
    FOREIGN KEY (DNI_cli) REFERENCES CLIENTE(DNI),
    FOREIGN KEY (codigoPago) REFERENCES CLIENTE(codigoPago)
);
create table INCLUIR(
	cantidad INT,
    numeroPed INT,
    codArticulo INT UNSIGNED,
    PRIMARY KEY (numeroPed, codArticulo),
    FOREIGN KEY (numeroPed) REFERENCES PEDIDO(numero),
    FOREIGN KEY (codArticulo) REFERENCES ARTICULO(codigo)
);
create table ROPA(
	codigo INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    talla VARCHAR(10),
    color VARCHAR(50),
    tipoPant VARCHAR(50),
    tieneBols BOOLEAN,
    tipoCierre VARCHAR(50),
    tipoManga VARCHAR(50),
    estampada BOOLEAN,
    impermeable BOOLEAN,
    FOREIGN KEY (codigo) REFERENCES ARTICULO(codigo)
);
create table ACCESORIO(
	codigo INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	tipoCierre VARCHAR(50),
    estilo VARCHAR(50),
    personalizado BOOLEAN,
    talla VARCHAR(10),
    tipoSuela VARCHAR(50),
    capacidad VARCHAR(10),
	FOREIGN KEY (codigo) REFERENCES ARTICULO(codigo)
);