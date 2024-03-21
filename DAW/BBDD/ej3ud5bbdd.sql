/*18. Devuelve un listado con dos columnas, donde aparezca en la primera columna el nombre de los
alumnos y en la segunda, el nombre con todos los caracteres invertidos.*/
select nombre, reverse(nombre) as 'Nombre invertido'
from instituto.alumno;

/*19. Devuelve un listado con dos columnas, donde aparezca en la primera columna el nombre y los
apellidos de los alumnos y en la segunda, el nombre y los apellidos con todos los caracteres invertidos.*/
select Concat(nombre, ' ' ,apellido1, ' ', apellido2) as 'Nombre y apellidos', reverse(Concat(nombre, ' ', apellido1, ' ', apellido2)) as 'Invertidos'
from instituto.alumno;

/*20. Devuelve un listado con dos columnas, donde aparezca en la primera columna el nombre y los
apellidos de los alumnos en mayúscula y en la segunda, el nombre y los apellidos con todos los
caracteres invertidos en minúscula.*/
select upper(Concat(nombre, ' ' ,apellido1, ' ', apellido2)) as 'NOMBRE Y APELLIDOS', lower(Concat(nombre, ' ' ,apellido1, ' ', apellido2)) as 'nombre y apellidos'
from instituto.alumno;

/*21. Devuelve un listado con tres columnas, donde aparezca en la primera columna el nombre y los
apellidos de los alumnos, en la segunda, el número de caracteres que tiene en total el nombre y los
apellidos y en la tercera el número de bytes que ocupa en total.*/
select Concat(nombre, ' ' ,apellido1, ' ', apellido2) as 'Nombre y apellidos', char_length(Concat(nombre,apellido1, apellido2)) as 'Longitud', length(Concat(nombre,apellido1, apellido2)) as 'Bytes'
from instituto.alumno;

/*22. Devuelve un listado con dos columnas, donde aparezca en la primera columna el nombre y los dos
apellidos de los alumnos. En la segunda columna se mostrará una dirección de correo electrónico que
vamos a calcular para cada alumno. La dirección de correo estará formada por el nombre y el primer
apellido, separados por el carácter . y seguidos por el dominio @iescamp.es . Tenga en cuenta que
la dirección de correo electrónico debe estar en minúscula. Utilice un alias apropiado para cada
columna.*/
select Concat(nombre, ' ' ,apellido1, ' ', apellido2) as 'Nombre y apellidos', Concat(lower(nombre),'.',lower(apellido1),'@iescamp.es') as 'Correo electronico'
from instituto.alumno;

/*23. Devuelve un listado con tres columnas, donde aparezca en la primera columna el nombre y los dos
apellidos de los alumnos. En la segunda columna se mostrará una dirección de correo electrónico que
vamos a calcular para cada alumno. La dirección de correo estará formada por el nombre y el primer
apellido, separados por el carácter . y seguidos por el dominio @iescamp.es . Tenga en cuenta que
la dirección de correo electrónico debe estar en minúscula. La tercera columna será una contraseña
que vamos a generar formada por los caracteres invertidos del segundo apellido, seguidos de los
cuatro caracteres del año de la fecha de nacimiento. Utilice un alias apropiado para cada columna.*/
select Concat(nombre, ' ' ,apellido1, ' ', apellido2) as 'Nombre y apellidos', Concat(lower(nombre),'.',lower(apellido1),'@iescamp.es') as 'Correo electronico', Concat(reverse(apellido2),year(fecha_nacimiento)) as 'Contraseña'
from instituto.alumno;


/*24. Devuelva un listado con cuatro columnas, donde aparezca en la primera columna la fecha de
nacimiento completa de los alumnos, en la segunda columna el día, en la tercera el mes y en la cuarta
el año. Utilice las funciones DAY , MONTH y YEAR .*/
select fecha_nacimiento, day(fecha_nacimiento) as 'dia', month(fecha_nacimiento) as 'mes', year(fecha_nacimiento) as 'año'
from instituto.alumno;

/*25. Devuelva un listado con tres columnas, donde aparezca en la primera columna la fecha de nacimiento
de los alumnos, en la segunda el nombre del día de la semana de la fecha de nacimiento y en la
tercera el nombre del mes de la fecha de nacimiento.*/
/*26. Resuelva la consulta utilizando las funciones DAYNAME y MONTHNAME .*/
select fecha_nacimiento, dayname(fecha_nacimiento) as 'dia', monthname(fecha_nacimiento) as 'mes'
from instituto.alumno;

/*27. Resuelva la consulta utilizando la función DATE_FORMAT .*/
select date_format(fecha_nacimiento,%a)
from instituto.alumno;

/*28. Devuelva un listado con dos columnas, donde aparezca en la primera columna la fecha de nacimiento
de los alumnos y en la segunda columna el número de días que han pasado desde la fecha actual
hasta la fecha de nacimiento. Utilice las funciones DATEDIFF y NOW .*/
select fecha_nacimiento, datediff(now(), fecha_nacimiento) as 'dias pasados'
from instituto.alumno;

/*
Consulte la documentación
oficial de MySQL para DATEDIFF
29. Devuelva un listado con dos columnas, donde aparezca en la primera columna la fecha de nacimiento
de los alumnos y en la segunda columna la edad de cada alumno/a. La edad (aproximada) la podemos
calcular realizando las siguientes operaciones:
Calcula el número de días que han pasado desde la fecha actual hasta la fecha de nacimiento.
Utilice las funciones DATEDIFF y NOW .
Divida entre 365.25 el resultado que ha obtenido en el paso anterior. (El 0.25 es para compensar
los años bisiestos que han podido existir entre la fecha de nacimiento y la fecha actual).
Trunca las cifras decimales del número obtenido.*/
select fecha_nacimiento,  truncate(datediff(now(), fecha_nacimiento)/365.25, 0) as 'edad'
from instituto.alumno;

