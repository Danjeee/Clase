drop database if exists test;
create database test;
use test;
create table alumnos(
	id int unsigned primary key,
    nombre varchar(50),
    apellido1 varchar(50),
	apellido2 varchar(50),
    fecha_nacimiento date
);

insert into alumnos values
(1,"Chayanne","Garcia","Dragos",'1999-01-01'),
(2,"Caca","Culo","Pedopis",'2011-01-01'),
(3,"Jonathan","Joestar","Perez",'1700-05-21'),
(4,"Garcia","Garcia","Oscar",'0009-11-01'),
(5,"Justin","Biever","Styles",'1450-02-11');


delimiter $$
create function calcular_edad(fecha date)
returns int unsigned deterministic
begin
	declare edad int unsigned;
    set edad = datediff(curdate(), fecha)/365;
    return edad;
end
$$
delimiter ;
alter table alumnos
add edad int unsigned;
update alumnos
set edad = calcular_edad(fecha_nacimiento);
select * from alumnos;
/*2*/
alter table alumnos
add email varchar(50);
delimiter $$
create procedure crear_email(in nombre varchar(50), in apellido1 varchar(50), in apellido2 varchar(50), in dominio varchar(50), out email varchar(50))
begin
	declare n varchar(3);
    declare a1 varchar(3);
    declare a2 varchar(3);
    declare email varchar(50);
    set n = left(nombre, 3);
    set a1 = left(apellido1, 3);
    if apellido2 is null
    then
		set a2 = "";
	else 
		set a2 = left(apellido2, 3);
	end if;
    set email = lower(concat(n,a1,a2,'@',dominio));
end
$$
delimiter ;
call crear_email("hola", "cristian", "gomez", "iescamp.es", @email);
select @email;
delimiter $$
create procedure act_columna_email()
begin
	declare nom varchar(50);
    declare a1 varchar(50);
    declare a2 varchar(50);
    declare v_fin int default 0;
    declare cursor_alumno cursor for select nombre, apellido1, apellido2 from alumnos;
    declare continue handler for not found set v_fin = 1;
    open cursor_alumno;
    repeat
		fetch cursor_alumno into nom, a1, a2;
        call crear_email(nom, a1, a2, 'iescamp.es', @email);
        update alumnos
        set email = @email 
        where nom = nombre and a1 = apellido1 and a2 = apellido2;
    until v_fin = 1
    end repeat;
    close cursor_alumno;
end
$$
delimiter ;
call act_columna_email();
select * from alumnos;