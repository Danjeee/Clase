use jardineria;
select *
from cliente;

/*1. Inserta una nueva oficina en Valencia.*/
insert into oficina (codigo_oficina, ciudad, pais, region, codigo_postal, telefono, linea_direccion1, linea_direccion2)
values ("CAC-ES", "Valencia", "España", "Valencia", "46000", "+34 61 345 2345", "Av. Hispanidad, 44", null);

/*2. Inserta un empleado para la oficina de Valencia que sea representante de ventas.*/
insert into empleado (codigo_empleado, nombre, apellido1, apellido2, extension, email, codigo_oficina, codigo_jefe, puesto)
values (32, "Julio", "Martinez", "de la paella", 9929, "juliogangster@jardineria.es", "CAC-ES", 3, "Representante Ventas");

/*3. Inserta un cliente que tenga como representante de ventas el empleado que hemos creado en el
paso anterior.*/
insert into cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, linea_direccion1, linea_direccion2, ciudad, region, pais, codigo_postal, codigo_empleado_rep_ventas, limite_credito)
values (39, "Cacerolos", "Juan", "Magan", "999222333", "999333222", "Av. Hispanidad, 2", null, "Valencia", "Valencia", "España", 46000, 32, 8999999);

/*4. Inserte un pedido para el cliente que acabamos de crear, que contenga dos productos diferentes.*/


/*5. Actualiza el código del cliente que hemos creado en el paso anterior y averigua si hubo cambios en
las tablas relacionadas.*/
update cliente
set codigo_cliente = 50
where codigo_cliente = 39;

/*6. Borra el cliente y averigua si hubo cambios en las tablas relacionadas.*/
delete from cliente
where codigo_cliente = 50;

/*7. Elimina los clientes que no hayan realizado ningún pedido.*/
delete from cliente
where codigo_cliente not in (select codigo_cliente from pedido);

/*8. Incrementa en un 20% el precio de los productos que no tengan pedidos.
9. Borra los pagos del cliente con menor límite de crédito.
10. Establece a 0 el límite de crédito del cliente que menos unidades pedidas tenga del producto 11679.
11. Modifica la tabla detalle_pedido para incorporar un campo numérico llamado total_linea y actualiza
todos sus registros para calcular su valor con la fórmula:
total_linea = precio_unidad*cantidad * (1 + (iva/100));
12. Borra el cliente con menor límite de crédito. ¿Es posible borrarlo con una sola consulta? ¿Por qué?
13. Inserta una oficina con sede en Castellón y tres empleados que sean representantes de ventas.
14. Inserta tres clientes que tengan como representantes de ventas los empleados que hemos creado
en el paso anterior.
15. Borra uno de los clientes y comprueba si hubo cambios en las tablas relacionadas. Si no hubo
cambios, modifica las tablas necesarias estableciendo la clave foránea con la cláusula ON DELETE
CASCADE.*/
