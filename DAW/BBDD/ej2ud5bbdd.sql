/*17. Devuelve una lista con 5 filas a partir de la tercera fila de la tabla empleado. La tercera fila se debe
incluir en la respuesta. La respuesta debe incluir todas las columnas de la tabla empleado.*/
select *
from empleados.empleado
LIMIT 5 offset 3;

/*18. Devuelve una lista con el nombre de los departamentos y el presupuesto, de aquellos que tienen un
presupuesto mayor o igual a 150000 euros.*/
select nombre, presupuesto
from empleados.departamento
where presupuesto >= 150000;

/*19. Devuelve una lista con el nombre de los departamentos y el presupesto, de aquellos que tienen un
presupuesto entre 100000 y 200000 euros. Sin utilizar el operador BETWEEN.*/
select nombre, presupuesto
from empleados.departamento
where presupuesto >=100000 and presupuesto <=200000;

/*20. Devuelve una lista con el nombre de los departamentos que no tienen un presupuesto entre
100000 y 200000 euros. Utilizando el operador BETWEEN.*/
select nombre, presupuesto
from empleados.departamento
where presupuesto between 100000 and 200000;

/*21. Devuelve una lista con el nombre de los departamentos, gastos y presupuesto, de quellos
departamentos donde los gastos sean mayores que el presupuesto del que disponen.*/
select nombre, presupuesto, gastos
from empleados.departamento
where gastos>presupuesto;

/*22. Devuelve una lista con el nombre de los departamentos, gastos y presupuesto, de aquellos
departamentos donde los gastos sean menores que el presupuesto del que disponen.*/
select nombre, presupuesto, gastos
from empleados.departamento
where gastos<presupuesto;

/*23. Devuelve una lista con el nombre de los departamentos, gastos y presupuesto, de aquellos
departamentos donde los gastos sean iguales al presupuesto del que disponen.*/
select nombre, presupuesto, gastos
from empleados.departamento
where gastos=presupuesto;

/*24. Lista todos los datos de los empleados cuyo segundo apellido sea NULL.*/
select *
from empleados.empleado
where apellido2 is null;

/*25. Lista todos los datos de los empleados cuyo segundo apellido no sea NULL.*/
select *
from empleados.empleado
where apellido2 is not null;

/*26. Lista todos los datos de los empleados cuyo segundo apellido sea López.*/
select *
from empleados.empleado
where apellido2 ='López';

/*27. Lista todos los datos de los empleados cuyo segundo apellido sea Díaz o Moreno. Sin utilizar el
operador IN.*/
select *
from empleados.empleado
where apellido2 ='Moreno' or apellido2 ='Díaz';

/*28. Lista todos los datos de los empleados cuyo segundo apellido sea Díaz o Moreno. Utilizando el
operador IN.*/
select *
from empleados.empleado
where apellido2 IN('Moreno', 'Díaz');

/*29. Lista los nombres, apellidos y nif de los empleados que trabajan en el departamento 3.*/
select id_departamento, nombre, apellido1, apellido2, nif
from empleados.empleado
where id_departamento = 3;

/*30. Lista los nombres, apellidos y nif de los empleados que trabajan en los departamentos 2, 4 o 5.*/
select id_departamento, nombre, apellido1, apellido2, nif
from empleados.empleado
where id_departamento IN(2,4,5);

/*31. Calcula la suma del presupuesto de todos los departamentos.*/
select sum(presupuesto) as 'Total presupuesto'
from empleados.departamento;

/*32. Calcula la media del presupuesto de todos los departamentos.*/
select avg(presupuesto) as 'Media presupuesto'
from empleados.departamento;

/*33. Calcula el valor mínimo del presupuesto de todos los departamentos.*/
select min(presupuesto) as 'Presupuesto minimo'
from empleados.departamento;

/*34. Calcula el nombre del departamento y el presupuesto que tiene asignado, del departamento con
menor presupuesto.*/
select nombre, min(presupuesto)
from empleados.departamento

/*35. Calcula el valor máximo del presupuesto de todos los departamentos.
36. Calcula el nombre del departamento y el presupuesto que tiene asignado, del departamento con
mayor presupuesto.
37. Calcula el número total de empleados que hay en la tabla empleado.
38. Calcula el número de empleados que no tienen NULL en su segundo apellido.
39. Calcula el número de empleados que trabajan en cada uno de los departamentos. El resultado de
esta consulta también tiene que incluir aquellos departamentos que no tienen ningún empleado
asociado.
40. Calcula el número de empleados que trabajan en cada unos de los departamentos que tienen un
presupuesto mayor a 200000 euros*/