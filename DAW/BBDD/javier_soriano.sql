use discografica;

/*
----------------------------------------------------------------------------- 1 -----------------------------------------------------------------------------
*/

drop procedure if exists discos_grupo;
delimiter $$carmenapruebametequieroporfavor$$
create procedure discos_grupo(in grupo varchar(30), out cant_discos int unsigned, out total_duración double(15,5))
begin
declare cod_grupo int unsigned;
set cod_grupo = (SELECT cod from grupo where nombre = grupo);
set cant_discos = (SELECT count(cod) from disco where cod_gru = cod_grupo);
set total_duración = (select sum(C.duracion) from cancion C, esta E, disco D where C.cod = E.can and E.cod = D.cod and D.cod_gru = cod_grupo);
end
$$carmenapruebametequieroporfavor$$
delimiter ;

-- Comprobamos
call discos_grupo("Simple Minds",@discos,@duracion);
select @discos, @duracion;

/*
----------------------------------------------------------------------------- 2 -----------------------------------------------------------------------------
*/

drop function if exists miembros_grupo;
delimiter $$carmenapruebametequieroporfavor$$
create function miembros_grupo(grupo varchar(30)) returns int unsigned deterministic
begin
	return (select count(P.dni) from pertenece P, grupo G WHERE P.cod = G.cod and G.nombre = grupo);
end
$$carmenapruebametequieroporfavor$$
delimiter ;

-- Comprobamos
select miembros_grupo("Simple Minds") as "Miembros";

/*
----------------------------------------------------------------------------- 3 -----------------------------------------------------------------------------
*/

drop procedure if exists artistas_por_grupo;
delimiter $$carmenapruebametequieroporfavor$$
create procedure artistas_por_grupo()
begin
	select G.nombre, miembros_grupo(G.nombre) as "Miembros" from grupo G;
end
$$carmenapruebametequieroporfavor$$
delimiter ;

-- Comprobamos
call artistas_por_grupo;

/*
----------------------------------------------------------------------------- 4 -----------------------------------------------------------------------------
*/

drop function if exists canciones_por_grupo;
delimiter $$carmenapruebametequieroporfavor$$
create function canciones_por_grupo(grupo varchar(30)) returns int unsigned deterministic
begin
	return (select count(E.can) from disco D, grupo G, esta E WHERE D.cod_gru = G.cod and E.cod = D.cod and G.nombre = grupo);
end
$$carmenapruebametequieroporfavor$$
delimiter ;

-- Comprobamos
select canciones_por_grupo("Simple Minds") as "Canciones del grupo Simple Minds";

/*
----------------------------------------------------------------------------- 5 -----------------------------------------------------------------------------
*/

drop procedure if exists canciones_grupo;
delimiter $$carmenapruebametequieroporfavor$$
create procedure canciones_grupo()
begin
	declare nom_gru varchar(30);
    declare nom_can varchar(30);
    declare fun varchar(15);
    declare v_fin boolean default false;
	declare cursor_grupo cursor for select dni, cod, funcion from pertenece;
    declare continue handler for not found set v_fin = true;
	drop table if exists canciones_grupo;
    create table canciones_grupo(
		nombre_cantante VARCHAR(30),
        nombre_grupo VARCHAR(30),
        num_canciones int unsigned
    );
    open cursor_grupo;
    repeat
		fetch cursor_grupo into nom_can, nom_gru, fun;
        if fun = "voz"
			then
				set nom_can = (select nombre from artista where dni = nom_can);
                set nom_gru = (select nombre from grupo where cod = nom_gru);
				insert into canciones_grupo(nombre_cantante, nombre_grupo, num_canciones) values(nom_can, nom_gru, (select canciones_por_grupo(nom_gru)));
		end if;
    until v_fin = true
    end repeat;
    close cursor_grupo;
end
$$carmenapruebametequieroporfavor$$
delimiter ;

-- Comprobamos
call canciones_grupo();
select * from canciones_grupo;

/*
----------------------------------------------------------------------------- 6 -----------------------------------------------------------------------------
*/

drop table if exists inventario;
create table inventario(
	grupo varchar(30),
    componentes int unsigned,
    num_discos int unsigned,
    num_canciones int unsigned,
    num_club_fans int unsigned
);
drop procedure if exists rellenar_inventario;
delimiter $$carmenapruebametequieroporfavor$$
create procedure rellenar_inventario()
begin
	declare nom_gru varchar(30);
    declare v_fin boolean default false;
	declare cursor_grupo cursor for select nombre from grupo;
    declare continue handler for not found set v_fin = true;
    delete from inventario;
    open cursor_grupo;
    repeat
		fetch cursor_grupo into nom_gru;
        call discos_grupo(nom_gru, @discos, @duracion);
        insert into inventario(grupo, componentes, num_discos, num_canciones, num_club_fans) values(nom_gru, miembros_grupo(nom_gru), @discos, canciones_por_grupo(nom_gru), (select count(C.cod) from club C, grupo G WHERE C.cod_gru = G.cod and G.nombre = nom_gru));
    until v_fin = true
    end repeat;
    close cursor_grupo;
end
$$carmenapruebametequieroporfavor$$
delimiter ;

-- Comprobamos
call rellenar_inventario();
select * from inventario;

/*
----------------------------------------------------------------------------- 7 -----------------------------------------------------------------------------
*/

/*Trigger para cuando se insertan datos*/

drop trigger if exists actualizar_tras_insertar;
delimiter $$carmenapruebametequieroporfavor$$
create trigger actualizar_tras_insertar after insert on disco for each row
begin
	update inventario
		set num_discos = num_discos+1
        where grupo = (select nombre from grupo where cod = new.cod_gru);
end
$$carmenapruebametequieroporfavor$$
delimiter ;

-- Comprobamos
delete from disco where cod = "69 ";
select * from inventario;
insert into disco(cod, nombre, fecha, cod_comp, cod_gru) values("69 ", "Carmen apruebame",now(),"1  ", "1  ");
select * from disco;
select * from inventario;

/*Trigger para cuando se borran datos*/

drop trigger if exists actualizar_tras_borrar;
delimiter $$carmenapruebametequieroporfavor$$
create trigger actualizar_tras_borrar before delete on disco for each row
begin
	update inventario
		set num_discos = num_discos-1
        where grupo = (select nombre from grupo where cod = old.cod_gru);
end
$$carmenapruebametequieroporfavor$$
delimiter ;
-- Comprobamos
select * from inventario;
delete from disco where cod = "69 ";
select * from disco;
select * from inventario;