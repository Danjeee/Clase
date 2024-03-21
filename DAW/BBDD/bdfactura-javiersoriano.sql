create database if not exists Factura;
use Factura;
create table if not exists CATEGORIA(
	cod_cat VARCHAR(15) PRIMARY KEY,
	descripcion VARCHAR(50)
);
create table if not exists ARTICULO(
	cod_a VARCHAR(10) PRIMARY KEY,
    descripcion VARCHAR(50),
    precio FLOAT,
    stock INT,
    stock_min INT,
    cod_cat VARCHAR(15) NOT NULL,
    FOREIGN KEY (cod_cat) REFERENCES CATEGORIA(cod_cat)
);
create table if not exists PROVINCIA(
	cod_pro INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50)
);
create table if not exists PUEBLO(
	cod_pob INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50),
    cod_pro INT UNSIGNED NOT NULL,
    FOREIGN KEY (cod_pro) REFERENCES PROVINCIA(cod_pro)
);
create table if not exists CLIENTE(
	cod_cli INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100),
    direccion VARCHAR(100),
    cp INT UNSIGNED NOT NULL,
    FOREIGN KEY (cp) REFERENCES PUEBLO(cod_pob)
);
create table if not exists VENDEDOR(
	cod_ven INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100),
    direccion VARCHAR(100),
    cp INT UNSIGNED NOT NULL,
    jefe INT UNSIGNED,
    FOREIGN KEY (cp) REFERENCES PUEBLO(cod_pob),
    FOREIGN KEY (jefe) REFERENCES VENDEDOR(cod_ven)
);
create table if not exists FACTURA(
	num_f INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    cod_cli INT UNSIGNED NOT NULL,
    cod_ven INT UNSIGNED,
    iva INT UNSIGNED,
    dte INT UNSIGNED,
    FOREIGN KEY (cod_ven) REFERENCES VENDEDOR(cod_ven),
    FOREIGN KEY (cod_cli) REFERENCES CLIENTE(cod_cli)
);
create table if not exists LINEA_FAC(
	num_f INT UNSIGNED,
    num_l INT UNSIGNED,
    cod_a VARCHAR(10) NOT NULL,
    cant INT UNSIGNED,
    precio FLOAT,
    dto INT UNSIGNED,
    PRIMARY KEY (num_f, num_l),
    FOREIGN KEY (num_f) REFERENCES FACTURA(num_f),
    FOREIGN KEY (cod_a) REFERENCES ARTICULO(cod_a)
);