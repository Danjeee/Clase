/* 7. Devuelve los datos del alumno cuyo id es igual a 1.*/
select *
from instituto.alumno
where id = 1;

/* 8. Devuelve los datos del alumno cuyo teléfono es igual a 692735409.*/
select *
from instituto.alumno
where teléfono = '692735409';

/* 9. Devuelve un listado de todos los alumnos que son repetidores.*/
select *
from instituto.alumno
where es_repetidor = 'si';

/*10. Devuelve un listado de todos los alumnos que no son repetidores.*/
select *
from instituto.alumno
where es_repetidor = 'no';

/*11. Devuelve el listado de los alumnos que han nacido antes del 1 de enero de 1993.*/
select *
from instituto.alumno
where fecha_nacimiento <= '1993-01-01';

/*12. Devuelve el listado de los alumnos que han nacido después del 1 de enero de 1994.*/
select *
from instituto.alumno
where fecha_nacimiento >= '1994-01-01';

/*13. Devuelve el listado de los alumnos que han nacido después del 1 de enero de 1994 y no son
repetidores.*/
select *
from instituto.alumno
where fecha_nacimiento >= '1994-01-01' and es_repetidor = 'no';

/* 14. Devuelve el listado de todos los alumnos que nacieron en 1998.*/
select *
from instituto.alumno
where fecha_nacimiento BETWEEN '1998-01-01' and '1998-12-31';

/* 15. Devuelve el listado de todos los alumnos que no nacieron en 1998 */
select *
from instituto.alumno
where fecha_nacimiento not BETWEEN '1998-01-01' and '1998-12-31';