use universidad;
/*1. Devuelve un listado con el primer apellido, segundo apellido y el nombre de todos los alumnos. El
listado deberá estar ordenado alfabéticamente de menor a mayor por el primer apellido, segundo
apellido y nombre.*/


/*2. Averigua el nombre y los dos apellidos de los alumnos que no han dado de alta su número de
teléfono en la base de datos.
IES Camp de Morvedre (Sagunto) 1
EXAMEN TIPO B
3. Devuelve un listado con los nombres de todos los profesores y los departamentos que tienen
vinculados. El listado también debe mostrar aquellos profesores que no tienen ningún
departamento asociado. El listado debe devolver cuatro columnas, nombre del departamento,
primer apellido, segundo apellido y nombre del profesor. El resultado estará ordenado
alfabéticamente de menor a mayor por el nombre del departamento, apellidos y el nombre.
4. Devuelve un listado con todos los departamentos que tienen alguna asignatura que no se haya
impartido en ningún curso escolar. El resultado debe mostrar el nombre del departamento y el
nombre de la asignatura que no se haya impartido nunca. (Sin usar JOINS y haciendo uso de
subconsultas)
5. Devuelve el número total de alumnas que hay.
IES Camp de Morvedre (Sagunto) 2
EXAMEN TIPO B
6. Calcula cuántos alumnos nacieron en 1999. (Utilizar una función para extraer el año de la fecha)
7. Calcula cuántos profesores hay en cada departamento. El resultado sólo debe mostrar dos
columnas, una con el nombre del departamento y otra con el número de profesores que hay en ese
departamento. El resultado sólo debe incluir los departamentos que tienen profesores asociados y
deberá estar ordenado de mayor a menor por el número de profesores.
8. Devuelve un listado con el número de asignaturas que imparte cada profesor. El listado debe tener
en cuenta aquellos profesores que no imparten ninguna asignatura. El resultado mostrará 5
columnas (tal y como se muestra en la tabla inferior) y deberá estar ordenado de mayor a menor
por el número de asignaturas.
IES Camp de Morvedre (Sagunto) 3
EXAMEN TIPO B
9. Devuelve un listado con el nombre de todos los grados existentes en la base de datos y el número
de asignaturas que tiene cada uno, de los grados que tengan más de 30 asignaturas asociadas.
10. Devuelve todos los datos del alumno más joven (sin usar LIMIT, tienes que utilizar ALL / ANY).
11. Devuelve un listado con los departamentos que no tienen profesores asociados. Usar IN / NOT IN
12. Devuelve un listado con los profesores que tienen un departamento asociado y que no imparten
ninguna asignatura. (Usando EXISTS / NOT EXISTS).
13. Devuelve un listado con las asignaturas que no tienen un profesor asignado.
IES Camp de Morvedre (Sagunto) 4
EXAMEN TIPO B
62 filas
IES Camp de Morvedre (Sagunto) 5
EXAMEN TIPO B
14. Borra los alumnos que han nacido antes del año 1992. (No utilizar BETWEEN, sino la función
correspondiente para extraer el año). El alumno a eliminar es:
15. Crear una tabla llamada “profes_informatica” la cual tendrá los siguientes campos de la
tabla persona (con los mismo tipos): nif, nombre, apellido1, apellido2, ciudad
y telefono
Insertar en ella los datos de los profesores que pertenecen al departamento de Informática.
A continuación consulta la tabla para comprobar que la inserción ha sido correctamente efectuada.