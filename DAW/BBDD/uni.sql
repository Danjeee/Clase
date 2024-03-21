use empleados;
/*a) Consultas sobre varias tablas a resolver realizando subconsultas con operadores de comparación:
1. Devuelve un listado con todos los empleados que tiene el departamento de Sistemas. (Sin utilizar
INNER JOIN).*/
select *
from empleado
where id_departamento = (select id from departamento where nombre = "Sistemas");

/*2. Devuelve el nombre del departamento con mayor presupuesto y la cantidad que tiene asignada.*/
select nombre, presupuesto
from departamento
where (select max(presupuesto) from departamento) = presupuesto;

/*3. Devuelve el nombre del departamento con menor presupuesto y la cantidad que tiene asignada.*/
select nombre, presupuesto
from departamento
where (select min(presupuesto) from departamento) = presupuesto;

/*b) Consultas sobre varias tablas a resolver realizando subconsultas con operadores ALL y ANY
4. Devuelve el nombre del departamento con mayor presupuesto y la cantidad que tiene asignada. Sin
hacer uso de MAX, ORDER BY ni LIMIT.*/
select nombre, presupuesto
from departamento
where presupuesto >= all (select presupuesto from departamento);

/*5. Devuelve el nombre del departamento con menor presupuesto y la cantidad que tiene asignada. Sin
hacer uso de MIN, ORDER BY ni LIMIT.
6. Devuelve los nombres de los departamentos que tienen empleados asociados.
7. Devuelve los nombres de los departamentos que no tienen empleados asociados.
c) Consultas sobre varias tablas a resolver realizando subconsultas con operadores IN y NOT IN
8. Devuelve los nombres de los departamentos que tienen empleados asociados.
9. Devuelve los nombres de los departamentos que no tienen empleados asociados.
d) Consultas sobre varias tablas a resolver realizando subconsultas con operadores EXISTS y NOT EXISTS
10. Devuelve los nombres de los departamentos que tienen empleados asociados.*/
select nombre
from departamento
where not exists (select *
				from empleado
				where departamento.id = id_departamento);

/*11. Devuelve los nombres de los departamentos que tienen empleados asociados.*/

use empleados;
select nombre
from departamento
where exists (select *
				from empleado
				where departamento.id = id_departamento);

/*Realizar las siguientes consultas sobre la base de datos Tienda de Informática.
a) Subconsultas correlacionadas

*/use tienda;/*
1. Lista el nombre de cada fabricante con el nombre y el precio de su producto más caro.*/

select producto.nombre, precio, fabricante.nombre
from producto inner join fabricante on fabricante.id=id_fabricante
where precio IN (select max(precio) from producto group by id_fabricante);
/*2. Devuelve un listado de todos los productos que tienen un precio mayor o igual a la media de todos
los productos de su mismo fabricante.*/

select nombre, precio
from producto
where precio >= all (select avg(precio) from producto group by id_fabricante)
;


/*3. Lista el nombre del producto más caro del fabricante Lenovo.
*/select nombre, precio
from producto
where precio = (select max(precio) from producto where id_fabricante=2);

/*
b) Subconsultas (En la cláusula HAVING)
4. Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número de
productos que el fabricante Lenovo*/

select fabricante.nombre
from fabricante join producto
where count((select * from producto where id_fabricante=2)) = count((select * from producto group by id_fabricante));