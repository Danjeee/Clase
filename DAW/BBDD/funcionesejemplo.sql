/*
EJERCICIO 1
*/
delimiter $$
drop procedure if exists hola$$
create procedure hola()
begin
	select "¡Hola mundo!";
end
$$
delimiter ;
call hola();
/*
EJERCICIO 2
*/
delimiter $$
drop procedure if exists num$$
create procedure num(i integer)
begin
	declare resultado VARCHAR(50);
	if i=0 then
		set resultado = "Cero";
	elseif i>0 then
		set resultado = "Positivo";
	else set resultado = "Negativo";
    end if;
    select resultado;
end
$$
delimiter ;
call num(5);
/*
EJERCICIO 3
*/
delimiter $$
drop procedure if exists num2$$
create procedure num2(in i INTEGER, out a varchar(50))
begin
	declare resultado VARCHAR(50);
	if i=0 then
		set resultado = "Cero";
	elseif i>0 then
		set resultado = "Positivo";
	else set resultado = "Negativo";
    end if;
    set a = resultado;
end
$$
delimiter ;
call num2(-2,@res);
select @res;
/*
EJERCICIO 4
*/
delimiter $$
drop procedure if exists nota1$$
create procedure nota1(in i INTEGER, out a varchar(50))
begin
	declare resultado VARCHAR(50);
	if i>0 and i<5 then
		set resultado = "Insuficiente";
	elseif i>=5 and i<5 then
		set resultado = "Aprobado";
	elseif i>=6 and i<7 then
		set resultado = "Bien";
	elseif i>=7 and i<9 then
		set resultado = "Notable";
	elseif i>=9 then
		set resultado = "Sobresaliente";
	else set resultado = "Error";
    end if;
    set a = resultado;
end
$$
delimiter ;
call nota1(8,@res);
select @res;
/*
EJERCICIO 5
*/
delimiter $$
drop procedure if exists nota2$$
create procedure nota2(in i INTEGER, out a varchar(50))
begin
	declare resultado VARCHAR(50);
	case
		when i >= 0 and i < 5 then set resultado = "Insuficiente";
        when i >= 5 and i < 6 then set resultado = "Aprobado";
        when i >=6 and i<7 then set resultado ="Bien";
        when i >=7 and i<9 then set resultado="Notable";
        when i>=9 then set resultado = "Sobresaliente";
		else set resultado = "Error";
	end case;
    set a = resultado;
end
$$
delimiter ;
call nota2(8,@res);
select @res;