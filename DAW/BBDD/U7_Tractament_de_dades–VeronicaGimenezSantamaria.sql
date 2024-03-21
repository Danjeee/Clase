use tienda;
select * from producto;
select * from fabricante;
-- 1
insert into producto (id, nombre, precio, id_fabricante) values (15, 'Altavoces', 120, 2);
-- 2
insert into fabricante values (16, 'Lenovo');
-- 3
insert into fabricante (nombre) values ('Asus');
-- 4
insert into producto (id, nombre, precio, id_fabricante) 
values (12, 'Altavoces', 120, (select id from fabricante where nombre = 'Asus'));
-- 5
insert into producto (nombre, precio, id_fabricante) 
values ('Altavoces hd', 122, (select id from fabricante where nombre = 'Lenovo'));
-- 6
delete from fabricante where nombre='Xiaomi'; -- Sí que deja
-- 7
delete from fabricante where nombre='Lexar'; -- No se puede porque no existe
-- 8
update fabricante set id = 20 where nombre='Lenovo';-- No es posible hay que cambiar las restricciones de les claves ajenas.
	-- Modificar la FK: Borrar y crear de nuevo
alter table producto 
drop constraint producto_ibfk_1;
alter table producto
add constraint fk_pro_fab foreign key(id_fabricante)
references fabricante (id) on update cascade;
-- 9
update fabricante set id = 30 where id=12;
-- 10
update producto set precio=precio+5;
-- 11
delete from producto where precio>200;
-- 12
update producto set nombre = 'Impresora Laser' where nombre='product99';
-- 13
update producto set precio=precio-(precio*0.1);
-- 14
update producto set precio=precio-(precio*0.05) where precio>=300;