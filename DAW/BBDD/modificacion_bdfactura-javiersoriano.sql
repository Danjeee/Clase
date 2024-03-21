use factura;
ALTER TABLE cliente
MODIFY nom VARCHAR(50) NOT NULL,
ADD apellido1 VARCHAR(50) NOT NULL AFTER nom,
ADD apellido2 VARCHAR(50) NOT NULL AFTER apellido1;

ALTER TABLE article
ALTER stock_min SET DEFAULT 10,
ADD CONSTRAINT check_stock
	CHECK (stock > stock_min);

ALTER TABLE linia_fac
MODIFY preu FLOAT(5,2);