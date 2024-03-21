use ventas;
/*a) Consultas con operadores básicos de comparación
1. Devuelve un listado con todos los pedidos que ha realizado Adela Salas Díaz. (Sin utilizar INNER
JOIN).*/
select P.*
from pedido P, cliente C
where P.id_cliente=C.id and C.nombre = "Adela" and C.apellido1 = "Salas" and C.apellido2 = "Diaz";

/*2. Devuelve el número de pedidos en los que ha participado el comercial Daniel Sáez Vega. (Sin utilizar
INNER JOIN)*/
select P.*
from pedido P, comercial C
where P.id_comercial=C.id and C.nombre = "Daniel" and C.apellido1 = "Sáez" and C.apellido2 = "Vega";

/*3. Devuelve los datos del cliente que realizó el pedido más caro en el año 2019. (Sin utilizar INNER
JOIN)*/
select C.*
from cliente C, pedido P
where P.id_cliente = C.id and P.total = (select max(total) from pedido where year(fecha) = '2019');

/*4. Devuelve la fecha y la cantidad del pedido de menor valor realizado por el cliente Pepe Ruiz
Santana.*/
select P.fecha, P.total
from cliente C, pedido P
where P.id_cliente = C.id and P.total = (select min(total) from pedido P, cliente C where P.id_cliente = C.id and C.nombre = "Pepe" and C.apellido1 = "Ruiz" and C.apellido2 = "Santana") and C.nombre = "Pepe" and C.apellido1 = "Ruiz" and C.apellido2 = "Santana";

/*5. Devuelve un listado con los datos de los clientes y los pedidos, de todos los clientes que han
realizado un pedido durante el año 2017 con un valor mayor o igual al valor medio de los pedidos
realizados durante ese mismo año.*/
select distinct *
from pedido P, cliente C
where P.total > (select avg(total) from pedido P where year(fecha) = 2017) and year(P.fecha) = 2017;

/*b) Subconsultas con ALL y ANY
6. Devuelve el pedido más caro que existe en la tabla pedido si hacer uso de MAX, ORDER BY ni LIMIT.*/
select *
from pedido
where total >= ALL(select total from pedido);

/*7. Devuelve un listado de los clientes que no han realizado ningún pedido. (Utilizando ANY o ALL).*/
select distinct C.*
from pedido P, cliente C
where C.id != ALL(select C.id from pedido P, cliente C where P.id_cliente = C.id);

/*8. Devuelve un listado de los comerciales que no han realizado ningún pedido. (Utilizando ANY o ALL).*/
select distinct C.*
from pedido P, comercial C
where C.id != ALL(select C.id from pedido P, comercial C where P.id_comercial = C.id);

/*c) Subconsultas con IN y NOT IN
9. Devuelve un listado de los clientes que no han realizado ningún pedido. (Utilizando IN o NOT IN).*/
select distinct C.*
from pedido P, cliente C
where C.id not in (select C.id from pedido P, cliente C where P.id_cliente = C.id);

/*10. Devuelve un listado de los comerciales que no han realizado ningún pedido. (Utilizando IN o NOT
IN).*/
select distinct C.*
from pedido P, comercial C
where C.id not in (select C.id from pedido P, comercial C where P.id_comercial = C.id);

/*d) Subconsultas con EXISTS y NOT EXISTS
11. Devuelve un listado de los clientes que no han realizado ningún pedido. (Utilizando EXISTS o NOT
EXISTS).*/
select C.*
from cliente C
where not exists (select P.id_cliente from pedido P where P.id_cliente = C.id);

/*12. Devuelve un listado de los comerciales que no han realizado ningún pedido. (Utilizando EXISTS o
NOT EXISTS).*/
select C.*
from comercial C
where not exists (select P.id_cliente from pedido P where P.id_comercial = C.id);
