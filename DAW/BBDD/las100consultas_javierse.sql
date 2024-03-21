use jardineria;
/*a) Consultas sobre una tabla:
1. Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.*/
select codigo_oficina, ciudad
from oficina;

/*2. Devuelve un listado con la ciudad y el teléfono de las oficinas de España.*/
select ciudad, telefono
from oficina;

/*3. Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de
jefe igual a 7.*/
select nombre, apellido1, apellido2, email
from empleado
where codigo_jefe = 7;

/*4. Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa.*/
select *
from empleado
where codigo_jefe is null;

/*5. Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean
representantes de ventas.*/
select nombre, apellido1, apellido2, puesto
from empleado
where puesto != "Representante Ventas";

/*6. Devuelve un listado con el nombre de los todos los clientes españoles.*/
select *
from cliente
where pais = "Spain";

/*7. Devuelve un listado con los distintos estados por los que puede pasar un pedido.*/
select distinct estado
from pedido;

/*8. Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008.
Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan repetidos. Resuelva
la consulta:
◦ Utilizando la función YEAR de MySQL.*/
select codigo_cliente
from pedido
where year(fecha_pedido) = 2008;

/*◦ Utilizando la función DATE_FORMAT de MySQL.*/
select codigo_cliente
from pedido
where date_format(fecha_pedido, "%Y") = "2008";

/*◦ Sin utilizar ninguna de las funciones anteriores.*/
select codigo_cliente
from pedido
where fecha_pedido like "2008%";

/*9. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega
de los pedidos que no han sido entregados a tiempo.*/
select codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
from pedido
where fecha_esperada < fecha_entrega;

/*10. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega
de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha esperada.
◦ Utilizando la función ADDDATE de MySQL.*/
select codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
from pedido
where adddate(fecha_esperada, interval 2 day) = fecha_entrega;

/*◦ Utilizando la función DATEDIFF de MySQL.*/
select codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
from pedido
where datediff(fecha_entrega, fecha_esperada) between 0 and 2;

/*◦ ¿Sería posible resolver esta consulta utilizando el operador de suma + o resta -?*/
select codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
from pedido
where day(fecha_entrega) >= day(fecha_esperada)-2;

/*11. Devuelve un listado de todos los pedidos que fueron rechazados en 2009.*/
select *
from pedido
where year(fecha_pedido) = 2009 and estado="rechazado";

/*12. Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de cualquier
año.*/
select *
from pedido
where month(fecha_pedido) = 1;

/*13. Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal. Ordene
el resultado de mayor a menor.*/
select *
from pago
where year(fecha_pago) = 2008 and forma_pago="PayPal"
order by total desc;

/*14. Devuelve un listado con todas las formas de pago que aparecen en la tabla pago (sin repetir).*/
select distinct forma_pago
from pago;

/*15. Devuelve un listado con todos los productos que pertenecen a la gama Ornamentales y que tienen
más de 100 unidades en stock. El listado deberá estar ordenado por su precio de venta, mostrando
en primer lugar los de mayor precio.*/
select *
from producto
where gama = "Ornamentales" and cantidad_en_stock > 100
order by precio_venta desc;

/*16. Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo representante de
ventas tenga el código de empleado 11 o 30.*/
select *
from cliente
where codigo_empleado_rep_ventas in (11,30);

/*b) Consultas multitabla (Composición interna): Resuelve las consultas utilizando la sintaxis SQL1 o SQL2.
1. Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de
ventas.*/
select distinct C.nombre_cliente, E.nombre, E.apellido1
from cliente C, empleado E
where C.codigo_empleado_rep_ventas = E.codigo_empleado;

/*2. Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus
representantes de ventas.*/
select distinct C.nombre_cliente
from cliente C, empleado E, pago P
where C.codigo_empleado_rep_ventas = E.codigo_empleado and C.codigo_cliente in (select C.codigo_cliente
																						from pago P, cliente C
                                                                                        where P.codigo_cliente = C.codigo_cliente);


/*3. Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus
representantes de ventas.*/
select distinct C.nombre_cliente
from cliente C, empleado E, pago P
where C.codigo_empleado_rep_ventas = E.codigo_empleado and C.codigo_cliente not in (select C.codigo_cliente
																						from pago P, cliente C
                                                                                        where P.codigo_cliente = C.codigo_cliente);

/*4. Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes junto
con la ciudad de la oficina a la que pertenece el representante.*/
select distinct C.nombre_cliente, E.nombre, O.ciudad
from cliente C, empleado E, pago P, oficina O
where C.codigo_cliente = P.codigo_cliente and E.codigo_oficina = O.codigo_oficina and C.codigo_empleado_rep_ventas = E.codigo_empleado and C.codigo_cliente in (select C.codigo_cliente
																						from pago P, cliente C
                                                                                        where P.codigo_cliente = C.codigo_cliente);

/*5. Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes
junto con la ciudad de la oficina a la que pertenece el representante.*/
select distinct C.nombre_cliente, E.nombre, O.ciudad
from cliente C, empleado E, pago P, oficina O
where C.codigo_cliente = P.codigo_cliente and E.codigo_oficina = O.codigo_oficina and C.codigo_empleado_rep_ventas = E.codigo_empleado and C.codigo_cliente not in (select C.codigo_cliente
																						from pago P, cliente C
                                                                                        where P.codigo_cliente = C.codigo_cliente);

/*6. Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.*/
select O.linea_direccion1, O.linea_direccion2
from oficina O, cliente C, empleado E
where E.codigo_oficina = O.codigo_oficina and C.codigo_empleado_rep_ventas = E.codigo_empleado and C.ciudad = "Fuenlabrada";


/*7. Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad de la
oficina a la que pertenece el representante.*/
select distinct C.nombre_cliente, E.nombre, O.ciudad
from cliente C, empleado E, oficina O
where C.codigo_empleado_rep_ventas = E.codigo_empleado and E.codigo_oficina = O.codigo_oficina;

/*8. Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.*/
select E.nombre, concat(J.nombre) as "nombre jefe"
from empleado E, empleado J
where E.codigo_jefe = J.codigo_empleado;

/*9. Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre
del jefe de sus jefe.*/
select E.nombre, concat(J.nombre) as "nombre jefe", concat(JJ.nombre) as "nombre jefazo (jefe jefe)"
from empleado E, empleado J, empleado JJ 
where E.codigo_jefe = J.codigo_empleado and J.codigo_jefe = JJ.codigo_empleado;

/*10. Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.*/
select distinct C.nombre_cliente
from cliente C, pedido P
where P.codigo_cliente = C.codigo_cliente and P.fecha_esperada < P.fecha_entrega;

/*11. Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.*/
select distinct C.nombre_cliente, P.gama
from cliente C, pedido Pe, producto P, detalle_pedido D
where C.codigo_cliente = Pe.codigo_cliente and Pe.codigo_pedido = D.codigo_pedido and D.codigo_producto = P.codigo_producto;

/*c) Consultas multitabla (Composición externa): Resuelve las consultas utilizando LEFT JOIN o RIGHT JOIN.
1. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.*/
select distinct C.*
from cliente C left join pago P
on P.codigo_cliente = C.codigo_cliente
where P.codigo_cliente is null;

/*2. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.*/
select distinct C.*
from cliente C left join pedido P
on P.codigo_cliente = C.codigo_cliente
where P.codigo_cliente is null;

/*3. Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han
realizado ningún pedido.*/
select distinct C.*
from cliente C left join pago P
on P.codigo_cliente = C.codigo_cliente
where P.codigo_cliente is null or C.codigo_cliente in (select C.codigo_cliente
															from cliente C left join pedido Pe
															on C.codigo_cliente = Pe.codigo_cliente
                                                            where Pe.codigo_cliente is null);

/*4. Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.*/
select E.*
from empleado E left join oficina O on E.codigo_oficina = O.codigo_oficina
where E.codigo_oficina is null;

/*5. Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.*/
select E.*
from empleado E left join cliente C on E.codigo_empleado = C.codigo_empleado_rep_ventas
where C.codigo_empleado_rep_ventas is null;

/*6. Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado junto
con los datos de la oficina donde trabajan.*/
select *
from empleado E left join oficina O on O.codigo_oficina = E.codigo_oficina
where E.nombre not in (select E.nombre
						from empleado E left join cliente C on E.codigo_empleado = C.codigo_empleado_rep_ventas
						where C.codigo_empleado_rep_ventas is null);


/*7. Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no
tienen un cliente asociado.*/
select E.*
from empleado E left join oficina O on E.codigo_oficina = O.codigo_oficina
where E.codigo_oficina is null or E.nombre not in (select E.nombre
						from empleado E left join cliente C on E.codigo_empleado = C.codigo_empleado_rep_ventas
						where C.codigo_empleado_rep_ventas is null);

/*8. Devuelve un listado de los productos que nunca han aparecido en un pedido.*/
select distinct P.*
from producto P left join detalle_pedido Pe on Pe.codigo_producto = P.codigo_producto
where Pe.codigo_producto is null;


/*9. Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe
mostrar el nombre, la descripción y la imagen del producto.*/
select distinct P.nombre, P.descripcion, G.imagen
from producto P left join gama_producto G on P.gama = G.gama
where P.codigo_producto in (select distinct P.codigo_producto
							from producto P left join detalle_pedido Pe on Pe.codigo_producto = P.codigo_producto
							where Pe.codigo_producto is null);

/*10. Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los
representantes de ventas de algún cliente que haya realizado la compra de algún producto de la
gama Frutales.*/
select distinct O.*
from oficina O left join empleado E on E.codigo_oficina = O.codigo_oficina
where E.codigo_empleado not in (select E.codigo_empleado
								from empleado E, cliente C, pedido Pe, producto P, detalle_pedido D
                                where E.codigo_empleado = C.codigo_empleado_rep_ventas and Pe.codigo_cliente = C.codigo_cliente and D.codigo_producto = P.codigo_producto and P.gama != "Frutales");

select distinct O.*
from oficina O
where O.codigo_oficina not in (select O.codigo_oficina
								from empleado E, cliente C, pedido Pe, producto P, detalle_pedido D, oficina O
                                where O.codigo_oficina = E.codigo_oficina and E.codigo_empleado = C.codigo_empleado_rep_ventas and Pe.codigo_cliente = C.codigo_cliente and D.codigo_producto = P.codigo_producto and P.gama != "Frutales");
/*11. Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún
pago.*/
select distinct C.*
from cliente C left join pago P on P.codigo_cliente = C.codigo_cliente
where P.codigo_cliente is null and C.codigo_cliente in (select C.codigo_cliente
														from cliente C left join pedido D on C.codigo_cliente = D.codigo_cliente
														where D.codigo_cliente is not null);

/*12. Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de
su jefe asociado.*/
select E.*, concat(J.nombre) as "jefe"
from empleado E left join empleado J on E.codigo_jefe = J.codigo_empleado
where E.codigo_empleado in (select E.codigo_empleado
								from empleado E left join cliente C
								on E.codigo_empleado = C.codigo_empleado_rep_ventas
								where C.codigo_empleado_rep_ventas is null);

/*d) Consultas resumen
1. ¿Cuántos empleados hay en la compañía?*/
select count(*) as "Total empleados"
from empleado;

/*2. ¿Cuántos clientes tiene cada país?*/
select C.pais, count(C.codigo_cliente) as "Total clientes"
from cliente C
group by C.pais;

/*3. ¿Cuál fue el pago medio en 2009?*/
select avg(total) as "pago medio"
from pago
where year(fecha_pago) = 2009;

/*4. ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el nº de
pedidos.*/
select estado, count(*) as "Total pedidos"
from pedido
group by estado
order by 2 desc;

/*5. Calcula el precio de venta del producto más caro y más barato en una misma consulta.*/
select max(precio_venta) as "mas caro", min(precio_venta) as "mas barato"
from producto;

/*6. Calcula el número de clientes que tiene la empresa.*/
select count(C.codigo_cliente) as "Total clientes"
from cliente C;

/*7. ¿Cuántos clientes existen con domicilio en la ciudad de Madrid?*/
select count(C.codigo_cliente) as "Total clientes"
from cliente C
where ciudad = "Madrid";

/*8. ¿Calcula cuántos clientes tiene cada una de las ciudades que empiezan por M?*/
select C.ciudad, count(C.codigo_cliente) as "Total clientes"
from cliente C
where C.ciudad like("M%")
group by C.ciudad;

/*9. Devuelve el nombre de los representantes de ventas y el nº de clientes al que atiende cada uno.*/
select E.nombre, count(*) as "clientes"
from empleado E join cliente C on E.codigo_empleado = C.codigo_empleado_rep_ventas
group by E.codigo_empleado;

/*10. Calcula el número de clientes que no tiene asignado representante de ventas.*/
select count(*) as "total no asignados"
from cliente
where codigo_empleado_rep_ventas is null;

/*11. Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado deberá
mostrar el nombre y los apellidos de cada cliente.*/
select P.*, C.nombre_cliente,C.nombre_contacto, C.apellido_contacto
from pago P join cliente C on C.codigo_cliente = P.codigo_cliente
where P.fecha_pago = (select max(fecha_pago) from pago) or P.fecha_pago = (select min(fecha_pago) from pago);

/*12. Calcula el número de productos diferentes que hay en cada uno de los pedidos.*/
select codigo_pedido, count(codigo_producto) as "cant. productos"
from detalle_pedido
group by codigo_pedido;

/*13. Calcula la suma de la cantidad total de todos los productos que aparecen en cada uno de los
pedidos.*/
select codigo_pedido, sum(cantidad*precio_unidad) as "Total"
from detalle_pedido
group by codigo_pedido;

/*14. Devuelve un listado de los 20 productos más vendidos y el número total de unidades que se han
vendido de cada uno. El listado deberá estar ordenado por el número total de unidades vendidas.*/
select P.nombre, sum(cantidad) as "cantidad"
from producto P, pedido Pe, detalle_pedido D
where P.codigo_producto = D.codigo_producto and Pe.codigo_pedido = D.codigo_pedido 
group by D.codigo_producto
order by 2 desc
limit 20;

/*15. Lista las ventas totales de los productos que hayan facturado más de 3000 euros. Se mostrará el
nombre, unidades vendidas, total facturado y total facturado con impuestos (21% IVA).*/
select P.nombre, count(*) as "cantidad", sum(cantidad*precio_unidad) as "Total", concat(sum(cantidad*precio_unidad) + sum(cantidad*precio_unidad)*21/100) as "Total con iva"
from producto P, pedido Pe, detalle_pedido D
where P.codigo_producto = D.codigo_producto and Pe.codigo_pedido = D.codigo_pedido
group by D.codigo_producto
having sum(cantidad*precio_unidad) > 3000;

/*3
16. La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el IVA y el
total facturado. La base imponible se calcula sumando el coste del producto por el número de
unidades vendidas de la tabla detalle_pedido. El IVA es el 21 % de la base imponible, y el total la
suma de los dos campos anteriores.*/
select sum(cantidad*precio_unidad) as "base", concat(sum(cantidad*precio_unidad)*21/100) as "IVA", concat(sum(cantidad*precio_unidad) + sum(cantidad*precio_unidad)*21/100) as "Total con iva"
from detalle_pedido;


/*17. La misma información que en la pregunta anterior, pero agrupada por código de producto filtrada
por los códigos que empiecen por OR.
18. Muestre la suma total de todos los pagos que se realizaron para cada uno de los años que aparecen
en la tabla pagos.
e) Subconsultas con operadores básicos de comparación
1. Devuelve el nombre del cliente con mayor límite de crédito.
2. Devuelve el nombre del producto que tenga el precio de venta más caro.
3. Devuelve el nombre del producto del que se han vendido más unidades. (Tenga en cuenta que
tendrá que calcular cuál es el número total de unidades que se han vendido de cada producto a
partir de los datos de la tabla detalle_pedido)
4. Los clientes cuyo límite de crédito sea mayor que los pagos que haya realizado. (Sin utilizar INNER
JOIN).
5. Devuelve el producto que más unidades tiene en stock.
6. Devuelve el producto que menos unidades tiene en stock.
7. Devuelve el nombre, los apellidos y el email de los empleados que están a cargo de Alberto Soria.
f) Subconsultas con ALL y ANY
1. Devuelve el nombre del cliente con mayor límite de crédito.
2. Devuelve el nombre del producto que tenga el precio de venta más caro.
3. Devuelve el producto que menos unidades tiene en stock.
g) Subconsultas con IN y NOT IN
1. Devuelve el nombre, apellido1 y cargo de los empleados que no representen a ningún cliente.
2. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
3. Devuelve un listado que muestre solamente los clientes que sí han realizado algún pago.
4. Devuelve un listado de los productos que nunca han aparecido en un pedido.
5. Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que no sean
representante de ventas de ningún cliente.
4
6. Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los
representantes de ventas de algún cliente que haya realizado la compra de algún producto de la
gama Frutales.
7. Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún
pago.
h) Subconsultas con EXISTS y NOT EXISTS
1. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
2. Devuelve un listado que muestre solamente los clientes que sí han realizado algún pago.
3. Devuelve un listado de los productos que nunca han aparecido en un pedido.
4. Devuelve un listado de los productos que han aparecido en un pedido alguna vez.
i) Consultas variadas
1. Devuelve el listado de clientes indicando el nombre del cliente y cuántos pedidos ha realizado.
Tenga en cuenta que pueden existir clientes que no han realizado ningún pedido.
2. Devuelve un listado con los nombres de los clientes y el total pagado por cada uno de ellos. Tenga
en cuenta que pueden existir clientes que no han realizado ningún pago.
3. Devuelve el nombre de los clientes que hayan hecho pedidos en 2008 ordenados alfabéticamente
de menor a mayor.
4. Devuelve el nombre del cliente, el nombre y primer apellido de su representante de ventas y el
número de teléfono de la oficina del representante de ventas, de aquellos clientes que no hayan
realizado ningún pago.
5. Devuelve el listado de clientes donde aparezca el nombre del cliente, el nombre y primer apellido
de su representante de ventas y la ciudad donde está su oficina.*/
select C.nombre_cliente, C.nombre_contacto, C.apellido_contacto, E.nombre as "nombre representante", O.ciudad
from cliente C, empleado E, oficina O
where C.codigo_empleado_rep_ventas = E.codigo_empleado and E.codigo_oficina = O.codigo_oficina;

/*6. Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que no sean
representante de ventas de ningún cliente.*/
select E.nombre, E.apellido1, E.apellido2, E.puesto, E.extension, E.codigo_oficina
from empleado E
where E.codigo_empleado not in (select E.codigo_empleado
								from empleado E join cliente C on C.codigo_empleado_rep_ventas = E.codigo_empleado)

/*7. Devuelve un listado indicando todas las ciudades donde hay oficinas y el número de empleados que
tiene.
j) Realice las siguientes operaciones de manipulación:
1. Inserta una nueva oficina en Valencia.
2. Inserta un empleado para la oficina de Valencia que sea representante de ventas.
3. Inserta un cliente que tenga como representante de ventas el empleado que hemos creado en el
paso anterior.
4. Inserte un pedido para el cliente que acabamos de crear, que contenga dos productos diferentes.
5
5. Actualiza el código del cliente que hemos creado en el paso anterior y averigua si hubo cambios en
las tablas relacionadas.
6. Borra el cliente y averigua si hubo cambios en las tablas relacionadas.
7. Elimina los clientes que no hayan realizado ningún pedido.
8. Incrementa en un 20% el precio de los productos que no tengan pedidos.
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