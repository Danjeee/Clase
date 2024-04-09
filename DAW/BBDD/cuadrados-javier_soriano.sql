drop database if exists BD_cuadrados;
create database BD_cuadrados;
use BD_cuadrados;
create table cuadrados(
	numero int unsigned,
    cuadrado int unsigned
);
/*
WHILE
*/
delimiter caca
drop procedure if exists calcular_cuadrados caca
create procedure calcular_cuadrados(in e int unsigned)
begin
	declare i int unsigned;
    declare num int unsigned;
	set i = 0;
    delete from cuadrados;
    while i<e do
		set num = (i+1)*(i+1);
        insert into cuadrados(numero, cuadrado) values(i+1, num);
        set i = i+1;
    end while;
end
caca
delimiter ;
call calcular_cuadrados(9);
select * from cuadrados;
/*
REPEAT
*/
delimiter caca
drop procedure if exists calcular_cuadrados caca
create procedure calcular_cuadrados(in e int unsigned)
begin
	declare i int unsigned;
    declare num int unsigned;
	set i = 0;
    delete from cuadrados;
	repeat
		set num = (i+1)*(i+1);
        insert into cuadrados(numero, cuadrado) values(i+1, num);
        set i = i+1;
    until e<=i
    end repeat;
end
caca
delimiter ;
call calcular_cuadrados(9);
select * from cuadrados;
/*
LOOP
*/
delimiter caca
drop procedure if exists calcular_cuadrados caca
create procedure calcular_cuadrados(in e int unsigned)
begin
	declare i int unsigned;
    declare num int unsigned;
	set i = 0;
    delete from cuadrados;
		bucle : loop
		set num = (i+1)*(i+1);
        insert into cuadrados(numero, cuadrado) values(i+1, num);
        set i = i+1;
        if i >= e then leave bucle;
        end if;
    end loop;
end
caca
delimiter ;
call calcular_cuadrados(9);
select * from cuadrados;
