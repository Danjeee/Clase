use concesionario2;
/*1.- */
select concat(marca," ",modelo," ",motor) as "Marca modelo y motor"
from coche;

/*2.- */
select distinct C.ciudad, count(Co.marca) as "Total"
from coche Co, concesionario C, distribucion D
where Co.Codcoche = D.Codcoche and D.Cif = C.Cif and C.ciudad = "Barcelona";

/*3.- */
select Co.*
from coche Co, concesionario C, distribucion D
where Co.Codcoche = D.Codcoche and D.Cif = C.Cif and C.ciudad = "Madrid";

/*4.- */
select Co.*
from coche Co, concesionario C, venta D, cliente Cli
where Co.Codcoche = D.Codcoche and D.Cif = C.Cif and Cli.DNI = D.DNI and C.ciudad = "Madrid" and Cli.ciudad = "Madrid";

/*5.- */
select concat(Cli.nombre," ",Cli.apellidos) as "Cliente", C.nombre as "Concesionario"
from cliente Cli, concesionario C, venta V
where Cli.DNI = V.DNI and C.Cif = V.Cif and Cli.ciudad != C.ciudad; 

/*6.- */
select Co.*, avg(D.stock) as "Media distribuida"
from coche Co, distribucion D, concesionario C
where Co.Codcoche = D.Codcoche and D.Cif = C.Cif
group by Co.Codcoche
order by 5 desc;

/*7.- */
select Cli.*
from cliente Cli
where Cli.DNI in (select Cli.DNI
					from cliente Cli, concesionario C, venta V
                    where Cli.DNI = V.DNI and V.Cif = C.Cif and C.ciudad = "Valencia");
                    
/*8.- */
select Co.*
from coche Co
where exists (select Co.*
				from coche Co, concesionario C, venta V
                    where Co.Codcoche = V.Codcoche and V.Cif = C.Cif and C.ciudad != "Valencia");
                    
/*9.- */
select distinct Co.marca, Co.modelo
from coche Co, venta D, concesionario C
where Co.Codcoche = D.Codcoche and D.Cif = C.Cif and Co.Codcoche != ALL(select Co.Codcoche
							from coche Co, venta D, concesionario C
							where Co.Codcoche = D.Codcoche and D.Cif = C.Cif and C.ciudad != "Valencia");
                            
/*10.- */
select distinct Cli.nombre, Cli.apellidos
from cliente Cli, venta V, coche C
where Cli.DNI = V.DNI and V.Codcoche = C.Codcoche and C.motor = "hdi" and V.color = "negro";

/*11.- */
select distinct Cli.nombre, Cli.apellidos
from cliente Cli, venta V, coche C
where Cli.DNI = V.DNI and V.Codcoche = C.Codcoche and Cli.DNI in (select Cli.DNI
																	from cliente Cli, venta V, coche C
																	where Cli.DNI = V.DNI and V.Codcoche = C.Codcoche and V.color = "rojo") and Cli.DNI in (select Cli.DNI
																																						from cliente Cli, venta V, coche C
																																						where Cli.DNI = V.DNI and V.Codcoche = C.Codcoche and V.color = "verde");

/*12.- */
select C.nombre, avg(D.stock) as "Media"
from concesionario C join distribucion D on C.Cif = D.cif
where C.ciudad != "Madrid"
group by C.Cif
having avg(D.stock) > 5;

/*13.- */
select Co.marca, Co.modelo, Co.motor, D.stock
from coche Co left join distribucion D on D.Codcoche = Co.Codcoche
where Co.Codcoche not in (select Co.Codcoche
						from coche Co join venta V on Co.Codcoche = V.Codcoche)
order by D.stock desc;

/*14.- */
select Co.marca, Co.modelo, Co.motor
from coche Co left join distribucion D on D.Codcoche = Co.Codcoche
where D.stock is null or Co.Codcoche not in (select Co.Codcoche
												from coche Co join distribucion V on Co.Codcoche = V.Codcoche);
                                              
/*15.- */
select C.cif
from concesionario C
where C.Ciudad = (select Cli.Ciudad
						from concesionario C, venta V, cliente Cli
						where C.Cif = V.Cif and V.DNI = Cli.DNI
                        order by C.ciudad desc
						limit 1);

/*16.- */
select C.Cif
from concesionario C, distribucion D
where C.Cif = D.cif and C.ciudad != "Madrid"
group by C.Cif
having avg(D.stock) = (select avg(D.stock)
						from concesionario C, distribucion D
						where C.Cif = D.cif and C.ciudad != "Madrid"
						group by C.Cif
                        order by 1 asc
                        limit 1);

/*17.- */
select C.cif
from concesionario C, distribucion D
where C.Cif = D.cif
group by C.cif
having avg(D.stock) > 7;

/*18.- */
select Cli.nombre
from cliente Cli
where exists (select Cli.nombre
				from cliente Cli, venta V, concesionario C
				where Cli.DNI = V.DNI and V.Cif = C.Cif and C.cif = all(select C.cif
																		from concesionario C));
                                                                            
/*19.- */
select Cli.DNI
from cliente Cli
where Cli.ciudad = (select C.ciudad
					from concesionario C
					order by C.ciudad desc
					limit 1);
                    
/*20.- */
select Cli.*, count(C.cif) as "Total concesionarios"
from cliente Cli left join venta C on C.DNI = Cli.DNI
group by Cli.DNI;

