/*1. Traure tota la informació dels pobles*/
select *
from factura.poble;

/*2. Traure el codi postal, el nom i l'adreça, per aquest ordre, de tots els venedors*/
select cp, nom, adreca
from factura.venedor;

/*3. Traure el codi d'article, la descripció, preu i preu incrementat en un 5%, de tots els articles.*/
select cod_a, descrip, preu, truncate(preu + (preu*0.05), 2) as 'preu + 5%'
from factura.article;

/*5. Traure el num_f, data i cod_ven de les factures amb les següents capçaleres
respectivament: Número Factura, data i Codi Venedor*/
select concat(num_f) as 'Numero factura', concat(fecha) as 'data', concat(cod_ven) as 'Codi Venedor'
from factura.factura;

/*6. Donar àlias als camps que ho necessiten de la taula ARTICLE*/
select *
from factura.article;

/*7. Traure els clients de la ciutat amb codi 12309.*/
select  *
from factura.cliente
where cod_pob = '12309';

/*8. Traure totes les factures del mes de març de 2015.*/
select *
from factura.factura
where fecha between '2015-03-01' and '2015-03-31';

/*9. Traure tots els articles de la categoria BjcOlimpia amb un stock entre 2 i 7 unitats.*/
select *
from factura.article
where cod_cat='BjcOlimpia' and stock between 2 and 7;

/*10. Traure tots els clients que no tenen introduït el codi postal.*/
select *
from factura.cliente
where cp is null;

/*11. Traure tots els articles amb el stock introduït però que no tenen introduït el stock mínim.*/
select *
from factura.article
where stock is not null and stock_min is null;

/*12. Traure tots els clients, el primer cognom dels quals és VILLALONGA.*/ 
select *
from factura.cliente
where substring(nom, 1, char_length('VILLALONGA')) = 'VILLALONGA';

/*13. Modificar l'anterior per a traure tots els que són VILLALONGA de primer o de segon
cognom.*/
select *
from factura.cliente
where nom like '%VILLALONGA%';


/*14. Modificar l'anterior per a traure tots els que no són VILLALONGA ni de primer ni de segon
cognom.*/
select *
from factura.cliente
where nom not like '%VILLALONGA%';


/*15. Traure els articles "Pulsador" (la descripció conté aquesta paraula), el preu dels quals oscila
entre 2 i 4 € i dels quals tenim un stock estrictament major que el stock mínim*/
select *
from factura.article
where descrip like '%Pulsador%' and stock>stock_min and preu between 2 and 4
