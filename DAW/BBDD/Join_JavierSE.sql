/*1. Devuelve un listado con los empleados y los datos de los departamentos donde trabaja cada uno.*/
select *
from empleado join departamento
on departamento.id = empleado.id_departamento;

select *
from empleado, departamento
where departamento.id = empleado.id_departamento;

/*2. Devuelve un listado con los empleados y los datos de los departamentos donde trabaja cada uno.
Ordena el resultado, en primer lugar por el nombre del departamento (en orden alfabético) y en
segundo lugar por los apellidos y el nombre de los empleados.*/
select *
from empleado join departamento
on departamento.id = empleado.id_departamento
order by departamento.nombre asc, empleado.nombre asc, empleado.apellido1 asc, empleado.apellido2 asc;

select *
from empleado, departamento
where departamento.id = empleado.id_departamento
order by departamento.nombre asc, empleado.nombre asc, empleado.apellido1 asc, empleado.apellido2 asc;

/*3. Devuelve un listado con el identificador y el nombre del departamento, solamente de aquellos
departamentos que tienen empleados.*/
select distinct departamento.id, departamento.nombre
from empleado join departamento
on departamento.id = empleado.id_departamento;

select distinct departamento.id, departamento.nombre
from empleado, departamento
where departamento.id = empleado.id_departamento;

/*4. Devuelve un listado con el identificador, el nombre del departamento y el valor del presupuesto
actual del que dispone, solamente de aquellos departamentos que tienen empleados. El valor del
presupuesto actual lo puede calcular restando al valor del presupuesto inicial (columna
presupuesto) el valor de los gastos que ha generado (columna gastos).*/
select distinct departamento.id, departamento.nombre, concat(departamento.presupuesto - departamento.gastos) as "Valor actual"
from empleado join departamento
on departamento.id = empleado.id_departamento;

select distinct departamento.id, departamento.nombre, concat(departamento.presupuesto - departamento.gastos) as "Valor actual"
from empleado, departamento
where departamento.id = empleado.id_departamento;


/*5. Devuelve el nombre del departamento donde trabaja el empleado que tiene el nif 38382980M.*/
select distinct departamento.nombre
from empleado join departamento
on empleado.nif = "38382980M";

select distinct departamento.nombre
from empleado, departamento
where empleado.nif = "38382980M";

/*6. Devuelve el nombre del departamento donde trabaja el empleado Pepe Ruiz Santana.*/
select distinct departamento.nombre
from empleado join departamento
on empleado.nombre = "Pepe" and empleado.apellido1 = "Ruiz" and empleado.apellido2 = "Santana";

select distinct departamento.nombre
from empleado, departamento
where empleado.nombre = "Pepe" and empleado.apellido1 = "Ruiz" and empleado.apellido2 = "Santana";

/*7. Devuelve un listado con los datos de los empleados que trabajan en el departamento de I+D.
Ordena el resultado alfabéticamente.*/
select distinct empleado.*
from empleado join departamento
on empleado.id_departamento = 5
order by empleado.nombre asc;

select distinct empleado.*
from empleado, departamento
where empleado.id_departamento = 5
order by empleado.nombre asc;

/*8. Devuelve un listado con los datos de los empleados que trabajan en el departamento de Sistemas,
Contabilidad o I+D. Ordena el resultado alfabéticamente.*/
select distinct empleado.*
from empleado join departamento
on empleado.id_departamento = 5 or empleado.id_departamento = 4 or empleado.id_departamento = 2
order by empleado.nombre asc;

select distinct empleado.*
from empleado, departamento
where empleado.id_departamento = 5 or empleado.id_departamento = 4 or empleado.id_departamento = 2
order by empleado.nombre asc;

/*9. Devuelve una lista con el nombre de los empleados que tienen los departamentos que no tienen un
presupuesto entre 100000 y 200000 euros.*/
select distinct empleado.nombre
from departamento join empleado
on departamento.presupuesto > 100000 and departamento.presupuesto < 200000;

select distinct empleado.nombre
from departamento, empleado
where departamento.presupuesto > 100000 and departamento.presupuesto < 200000;

/*10. Devuelve un listado con el nombre de los departamentos donde existe algún empleado cuyo
segundo apellido sea NULL. Tenga en cuenta que no debe mostrar nombres de departamentos que
estén repetidos.*/
select distinct departamento.nombre
from departamento join empleado
on empleado.apellido2 is null;

select distinct departamento.nombre
from departamento, empleado
where empleado.apellido2 is null;

/*11. Devuelve un listado con todos los empleados junto con los datos de los departamentos donde
trabajan. Este listado también debe incluir los empleados que no tienen ningún departamento
asociado.*/
select *
from empleado left join departamento
on empleado.id_departamento = departamento.id;

/*12. Devuelve un listado donde sólo aparezcan aquellos empleados que no tienen ningún departamento
asociado.*/
select *
from empleado left join departamento
on empleado.id_departamento = departamento.id
where empleado.id_departamento is null;

/*13. Devuelve un listado donde sólo aparezcan aquellos departamentos que no tienen ningún empleado
asociado.*/
select *
from empleado right join departamento
on empleado.id_departamento = departamento.id
where empleado.id_departamento is null;

/*14. Devuelve un listado con todos los empleados junto con los datos de los departamentos donde
trabajan. El listado debe incluir los empleados que no tienen ningún departamento asociado y los
departamentos que no tienen ningún empleado asociado. Ordene el listado alfabéticamente por el
nombre del departamento.*/
select E.*, D.*
from empleado E left join departamento D
on E.id_departamento = D.id
union
select E.*, D.*
from empleado E right join departamento D
on E.id_departamento = D.id
order by 8;




/*15. Devuelve un listado con los empleados que no tienen ningún departamento asociado y los
departamentos que no tienen ningún empleado asociado. Ordene el listado alfabéticamente por el
nombre del departamento.*/

select E.*, D.*
from empleado E left outer join departamento D
on E.id_departamento = D.id
where E.id_departamento is null
union
select E.*, D.*
from empleado E right outer join departamento D
on E.id_departamento = D.id
where E.id_departamento is null
order by 8;

