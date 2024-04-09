use tienda;
delimiter $$
drop procedure if exists calcular_max_min_media$$
create procedure calcular_max_min_media (in id int, out max int unsigned, out min int unsigned, out media int unsigned)
begin
	set max = (select max(precio)
				from producto
				where id_fabricante = id);
	set min = (select min(precio)
				from producto
				where id_fabricante = id);
	set media = (select avg(precio)
				from producto
				where id_fabricante = id);
end
$$
delimiter ;
call calcular_max_min_media(1, @max, @min, @media);
select @max, @min, @media;

delimiter $$
drop procedure if exists calcular_max_min_media$$
create procedure calcular_max_min_media (in id int, out max int unsigned, out min int unsigned, out media int unsigned)
begin
	(select max(precio)
				from producto
				where id_fabricante = id) into max;
	(select min(precio)
				from producto
				where id_fabricante = id) into min;
	(select avg(precio)
				from producto
				where id_fabricante = id) into media;
end
$$
delimiter ;
call calcular_max_min_media(1, @max, @min, @media);
select @max, @min, @media;
