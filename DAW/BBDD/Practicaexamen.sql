use jardineria;

delimiter $$
drop function if exists total_ventas_producto$$
create function total_ventas_producto(nomprod varchar(50)) returns int unsigned deterministic
begin
    declare cod varchar(10);
    set cod = (select codigo_producto from producto where nombre = nomprod);
    return (select sum(cantidad) from detalle_pedido where codigo_producto = cod);
end
$$

drop procedure if exists numero_empleados$$
create procedure numero_empleados(in codof varchar(10), out total int unsigned)
begin
	set total = (select count(codigo_empleado) from empleado where codigo_oficina = codof);
end
$$

drop trigger if exists control_stock$$
create trigger control_stock after insert on detalle_pedido for each row
begin
	update producto
		set cantidad_en_stock = cantidad_en_stock + NEW.cantidad
        where codigo_producto = NEW.codigo_producto;
end
$$

drop trigger if exists control_stock2$$
create trigger control_stock2 after delete on detalle_pedido for each row
begin
	update producto
		set cantidad_en_stock = cantidad_en_stock - Old.cantidad
        where codigo_producto = old.codigo_producto;
end
$$
drop function if exists precio_pedido$$
create function precio_pedido(codped varchar(10)) returns double(10,2) deterministic
begin
	return concat((select sum((precio_unidad*cantidad)) from detalle_pedido where codigo_pedido = codped));
end
$$
drop function if exists suma_pedidos$$
create function suma_pedidos(codcli int) returns double(10,2) deterministic
begin
	return (select sum(precio_pedido(codigo_pedido)) from pedido where codigo_cliente = codcli);
end
$$
drop function if exists suma_pagos$$
create function suma_pagos(codcli int) returns double(10,2) deterministic
begin
	return (select sum(total) from pago where codigo_cliente = codcli);
end
$$

drop procedure if exists calcular_pagos_pendientes$$
create procedure calcular_pagos_pendientes()
begin
	drop table if exists clientes_con_pagos_pendientes;
    create table clientes_con_pagos_pendientes(
		id_cliente int unsigned primary key,
        suma_total_pedidos double(10,2),
        suma_total_pagos double(10,2),
        pendiente_de_pago double(10,2)
    );
    insert into clientes_con_pagos_pendientes select codigo_cliente, suma_pedidos(codigo_cliente), suma_pagos(codigo_cliente), concat(suma_pedidos(codigo_cliente) - suma_pagos(codigo_cliente)) from cliente having suma_pedidos(codigo_cliente)>suma_pagos(codigo_cliente);
end
$$

drop procedure if exists compras_inmediatas$$
create procedure compras_inmediatas()
begin
	drop table if exists productos_sin_stock;
    create table productos_sin_stock(
		id int unsigned auto_increment primary key,
        codigo_producto varchar(15),
        nombre_producto varchar(70),
        cantidad int unsigned
    );
    insert into productos_sin_stock(codigo_producto, nombre_producto, cantidad) select codigo_producto, nombre, cantidad_en_stock from producto where cantidad_en_stock <= 5;
end
$$
delimiter ;;

call calcular_pagos_pendientes();
select * from clientes_con_pagos_pendientes;
call compras_inmediatas();
select * from productos_sin_stock;
select total_ventas_producto("Mejorana");
call numero_empleados("TAL-ES", @a);
select @a;
select concat(precio_pedido(15),"€");
select concat(suma_pedidos(7),"€");
select cantidad_en_stock from producto where codigo_producto="FR-67";
insert into detalle_pedido values (3,"FR-67",10,70.00,31);
select cantidad_en_stock from producto where codigo_producto="FR-67";