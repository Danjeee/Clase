use tienda;
/*1. Lista todas las columnas de la tabla producto. */
select *
from producto;

/*2. Lista los nombres y los precios de todos los productos de la tabla producto.*/
select nombre, precio
from producto;

/*3. Lista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses ($).*/
select nombre, concat(precio,"$"), concat(precio,"€")
from producto;

/*4. Modifica la consulta anterior para añadir los siguientes alias para las columnas: nombre de
producto, euros, dólares. */
select nombre as "nombre de producto", concat(precio,"$") as "dolares", concat(precio,"€") as "euros"
from producto;

/*5. Lista los nombres y los precios de todos los productos de la tabla producto, convirtiendo los
nombres a mayúscula.*/
select upper(nombre) as "NOMBRE", precio
from producto;

/*6. Lista los nombres y los precios de todos los productos de la tabla producto, añdiendo dos columnas
nuevas, una redondeando el valor del precio y otra truncado el valor del precio para mostrarlo sin
ninguna cifra decimal. Asigna alias a las columnas: nombre, precio, redondeado, truncado.*/
select nombre, precio, round(precio) as "redondeado", truncate(precio,0) as "truncado"
from producto;

/*7. Lista el identificador de los fabricantes que tienen productos en la tabla producto, eliminando los
identificadores que aparecen repetidos.*/
select distinct id_fabricante
from producto;

/*8. Lista los nombres de los productos ordenados en primer lugar por el nombre de forma ascendente
y en segundo lugar por el precio de forma descendente.*/
select nombre, precio
from producto
order by nombre, precio desc;

/*9. Devuelve una lista con 2 filas a partir de la cuarta fila de la tabla fabricante. La cuarta fila también se
debe incluir en la respuesta.*/
select *
from fabricante
limit 2
offset 3;

/*10. Lista el nombre y el precio del producto más barato. (Utilice solamente las cláusulas ORDER BY y
LIMIT)*/
select nombre, precio
from producto
order by precio
limit 1;

/*11. Lista el nombre de todos los productos del fabricante cuyo identificador de fabricante es igual a 2.*/
select *
from producto
where id_fabricante = 2;

/*12. Lista el nombre de los productos que tienen un precio menor o igual a 120€.*/
select nombre, precio
from producto
where precio <= 120;

/*13. Lista el nombre de los productos que no tienen un precio mayor o igual a 400€.*/
select nombre, precio
from producto
where precio >= 400;

/*14. Lista todos los productos que tengan un precio entre 60€ y 200€. Utilizando el operador BETWEEN.*/
select nombre, precio
from producto
where precio BETWEEN 60 AND 200;

/*15. Lista todos los productos que tengan un precio entre 60€ y 200€ (sin utilizar el operador BETWEEN)
y que el identificador de fabricante sea igual a 6.*/
select nombre, precio, id_fabricante
from producto
where precio >= 60 and precio <=200 and id_fabricante = 6;

/*16. Lista todos los productos donde el identificador de fabricante sea 1, 3 o 5. Utilizando el operador IN.*/
select *
from producto
where id_fabricante in (1,3,5);

/*17. Lista el nombre y el precio de los productos en céntimos (Habrá que multiplicar por 100 el valor del
precio). Cree un alias para la columna que contiene el precio que se llame céntimos.*/
select nombre, precio*100 as "centimos"
from producto;

/*18. Lista los nombres de los fabricantes cuyo nombre empiece por la letra S.*/
select nombre
from fabricante
where nombre Like "S%";

/*19. Lista los nombres de los fabricantes cuyo nombre contenga el carácter w.*/
select nombre
from fabricante
where nombre Like "%w%";

/*20. Lista los nombres de los fabricantes cuyo nombre sea de 4 caracteres.*/
select nombre
from fabricante
where char_length(nombre)=4;

/*21. Devuelve una lista con el nombre de todos los productos que contienen la cadena Monitor en el
nombre y tienen un precio inferior a 215 €.*/
select nombre, precio
from producto
where nombre like "%Monitor%" and precio < 215;

/*22. Lista el nombre y el precio de todos los productos que tengan un precio mayor o igual a 180€.
Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el
nombre (en orden ascendente).*/
select nombre, precio
from producto
where precio >= 180
order by precio desc, nombre;

/*23. Calcula el número total de productos que hay en la tabla productos.*/
select count(nombre) as "total"
from producto;

/*24. Calcula el número total de fabricantes distintos que hay en la tabla productos.*/
select count(distinct id) as "total"
from fabricante;

/*25. Calcula la media del precio de todos los productos.*/
select avg(precio) as "media"
from producto;

/*26. Lista el nombre y el precio del producto más barato.*/
select nombre,precio
from producto
order by precio
limit 1;

/*27. Calcula la media del precio de todos los productos del fabricante Asus (id=1).*/
select avg(precio) as "media asus"
from producto
where id_fabricante = 1;

/*28. Calcula el precio más barato de todos los productos del fabricante Asus (id=1).*/
select nombre,precio
from producto
where id_fabricante=1
order by precio
limit 1;

/*29. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el
fabricante Crucial (id=6).*/
select max(precio) as "max", min(precio) as "min", avg(precio) as "media", count(nombre) as "total"
from producto
where id_fabricante=6;

/*30. Calcula el número de productos que tienen un precio mayor o igual a 180€*/
select count(nombre) as "total (mayores de 180)"
from producto
where precio >= 180;