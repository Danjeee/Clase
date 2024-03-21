use empleados;
/*1. Inserta un nuevo departamento indicando su código, nombre y presupuesto.*/
insert into departamento (nombre, presupuesto, gastos)
values ("Novo",150000, 0);

/*2. Inserta un nuevo departamento indicando su nombre y presupuesto.*/
insert into departamento (nombre, presupuesto, gastos)
values ("Ovo",0, 12000);

/*3. Inserta un nuevo departamento indicando su código, nombre, presupuesto y gastos.*/
insert into empleado (id, nif, nombre, apellido1, apellido2, id_departamento)
values (55, "80576789H", "Caca", "Gomez", "Hola", 4);

/*4. Inserta un nuevo empleado asociado a uno de los nuevos departamentos. La sentencia de
inserción debe incluir: código, nif, nombre, apellido1, apellido2 y codigo_departamento.*/
insert into empleado (nif, nombre, apellido1, apellido2, id_departamento)
values ("80576669H", "Julian", "Ramirez", "Hola", 4);

/*5. Inserta un nuevo empleado asociado a uno de los nuevos departamentos. La sentencia de
inserción debe incluir: nif, nombre, apellido1, apellido2 y codigo_departamento.*/


/*6. Crea una nueva tabla con el nombre departamento_backup que tenga las mismas columnas
que la tabla departamento. Una vez creada copia todos las filas de tabla departamento en
departamento_backup. (Utiliza una solo instrucción para la creación y la inserción).*/
CREATE TABLE departamento_backup (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  presupuesto DOUBLE UNSIGNED NOT NULL,
  gastos DOUBLE UNSIGNED NOT NULL
);
insert into departamento_backup
select *
from departamento;

/*7. Elimina el departamento Proyectos. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios
debería realizar para que fuese posible borrarlo?*/
delete from departamento
where id = (select id from departamento where nombre = "Proyectos");

/*8. Actualiza el código del departamento Recursos Humanos y asígnale el valor 30. ¿Es posible
actualizarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese actualizarlo?
9. Actualiza el código del departamento Publicidad y asígnale el valor 40. ¿Es posible actualizarlo?
Si no fuese posible, ¿qué cambios debería realizar para que fuese actualizarlo?
10. Actualiza el presupuesto de los departamentos sumándole 50000 € al valor del presupuesto
actual, solamente a aquellos departamentos que tienen un presupuesto menor que 20000 €.*/
select *
from departamento;














update departamento
set id = 30
where id = 3