use ventas;
/*1. Devuelve un listado con el identificador, nombre y los apellidos de todos los clientes que han
realizado algún pedido. El listado debe estar ordenado alfabéticamente por el primer apellido y se
deben eliminar los elementos repetidos.*/
select distinct cliente.id, cliente.nombre, cliente.apellido1, cliente.apellido2
from cliente join pedido
on cliente.id = pedido.id_cliente
order by cliente.apellido1;

/*2. Devuelve un listado que muestre todos los pedidos que ha realizado cada cliente. El resultado debe
mostrar todos los datos de los pedidos y del cliente. El listado debe mostrar los datos de los clientes
ordenados alfabéticamente por el nombre.*/
select *
from pedido inner join cliente
on cliente.id = pedido.id_cliente
order by cliente.nombre;


/*3. Devuelve un listado que muestre todos los pedidos en los que ha participado un comercial. El
resultado debe mostrar todos los datos de los pedidos y de los comerciales. El listado debe mostrar
los datos de los comerciales ordenados alfabéticamente por el nombre.*/
select *
from comercial inner join pedido
on comercial.id = pedido.id_comercial
order by comercial.nombre;

/*4. Devuelve un listado que muestre todos los clientes, con todos los pedidos que han realizado y con
los datos de los comerciales asociados a cada pedido.*/
select *
from pedido, cliente, comercial
where comercial.id = pedido.id_comercial and cliente.id = pedido.id_cliente;

/*5. Devuelve un listado de todos los clientes que realizaron un pedido durante el año 2017, cuya
cantidad esté entre 300 € y 1000 €.*/
select cliente.nombre
from cliente inner join pedido
on cliente.id = pedido.id_cliente
where pedido.fecha between '2017-01-01'  and '2017-12-31' and pedido.total between 300 and 1000;

/*6. Devuelve el nombre de todos los clientes que han realizado algún pedido con el comercial Daniel
Sáez Vega.*/
select distinct cliente.nombre
from pedido, cliente, comercial
where comercial.id = pedido.id_comercial and cliente.id = pedido.id_cliente and comercial.nombre = "Daniel" and comercial.apellido1 = "Sáez" and comercial.apellido2 = "Vega";

/*7. Devuelve un listado con todos los clientes junto con los datos de los pedidos que han realizado.
Este listado también debe incluir los clientes que no han realizado ningún pedido. El listado debe
estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los clientes.
(Utilizar composición externa, LEFT JOIN o RIGHT JOIN)
8. Devuelve un listado con todos los comerciales junto con los datos de los pedidos que han realizado.
Este listado también debe incluir los comerciales que no han realizado ningún pedido. El listado
debe estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los
comerciales. (Utilizar composición externa, LEFT JOIN o RIGHT JOIN)*/
/*9. Devuelve un listado que solamente muestre los clientes que no han realizado ningún pedido.
(Utilizar composición externa, LEFT JOIN o RIGHT JOIN)*/
select *
from cliente left join pedido on cliente.id = pedido.id_cliente
where pedido.id is null;

/*10. Devuelve un listado que solamente muestre los comerciales que no han realizado ningún pedido.
(Utilizar composición externa, LEFT JOIN o RIGHT JOIN)*/
select comercial.*
from comercial left join pedido on comercial.id = pedido.id_comercial
where pedido.id is null

/*11. Devuelve un listado con los clientes que no han realizado ningún pedido y de los comerciales que
no han participado en ningún pedido. Ordene el listado alfabéticamente por los apellidos y el
nombre. En en listado deberá diferenciar de algún modo los clientes y los comerciales. (Utilizar
composición externa, LEFT JOIN o RIGHT JOIN)*/
select *
from cliente left join pedido on pedido.id_cliente

/*12. Calcula cuál es el valor máximo de categoría para cada una de las ciudades que aparece en la tabla
cliente.
13. Calcula cuál es el máximo valor de los pedidos realizados durante el mismo día para cada uno de los
clientes. Es decir, el mismo cliente puede haber realizado varios pedidos de diferentes cantidades el
mismo día. Se pide que se calcule cuál es el pedido de máximo valor para cada uno de los días en
los que un cliente ha realizado un pedido. Muestra el identificador del cliente, nombre, apellidos, la
fecha y el valor de la cantidad.
14. Calcula cuál es el máximo valor de los pedidos realizados durante el mismo día para cada uno de los
clientes, teniendo en cuenta que sólo queremos mostrar aquellos pedidos que superen la cantidad
de 2000 €.
15. Calcula el máximo valor de los pedidos realizados para cada uno de los comerciales durante la fecha
2016-08-17. Muestra el identificador del comercial, nombre, apellidos y total.
16. Devuelve un listado con el identificador de cliente, nombre y apellidos y el número total de pedidos
que ha realizado cada uno de clientes. Tenga en cuenta que pueden existir clientes que no han
realizado ningún pedido. Estos clientes también deben aparecer en el listado indicando que el
número de pedidos realizados es 0.
17. Devuelve un listado con el identificador de cliente, nombre y apellidos y el número total de pedidos
que ha realizado cada uno de clientes durante el año 2017.
18. Devuelve un listado que muestre el identificador de cliente, nombre, primer apellido y el valor de la
máxima cantidad del pedido realizado por cada uno de los clientes. El resultado debe mostrar
aquellos clientes que no han realizado ningún pedido indicando que la máxima cantidad de sus
pedidos realizados es 0. Puede hacer uso de la función IFNULL.
19. Devuelve cuál ha sido el pedido de máximo valor que se ha realizado cada año.
20. Devuelve el número total de pedidos que se han realizado cada año.*/
