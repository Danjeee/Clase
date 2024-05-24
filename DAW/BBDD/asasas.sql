DELIMITER $$
CREATE PROCEDURE incrementar_pag()
BEGIN
-- Declaración de variables locales
DECLARE var_id INT; -- Variable que almacenará el código del libro
DECLARE var_paginas INT; -- Variable que almacenará el nº de pág actuales
DECLARE var_titulo VARCHAR(50); -- Variable que almacenará el titulo
DECLARE var_final INT DEFAULT 0; -- Variable de control fin cursor
-- Declaración del cursor
DECLARE cursor1 CURSOR SELECT cod_libro, titulo, paginas FROM libros;
-- Declaramos el final de los resultados
DECLARE CONTINUE HANDLER FOR NOT FOUND SET var_final = 1;
-- Abrimos el cursor
OPEN cursor1;
-- Recorremos hasta llegar al final
bucle: LOOP
FETCH cursor1 INTO var_id, var_titulo, var_paginas;
IF var_fina = 1 THEN
LEAVE bucle;
END IF;
-- Incrementamos las páginas en 10
UPDATE libros SET paginas = var_paginas + 10
WHERE cod_libro = var_id;
-- Mostramos los datos
SELECT var_id AS ‘Título’,
var_paginas AS ‘Anterior’,
paginas AS ‘Incremento’
FROM libros WHERE cod_libro = var_id;
END LOOP bucle;
-- Cerramos cursor
CLOSE cursor1;
END $$


DELIMITER &&
CREATE PROCEDURE numeros_nemores_while (IN num INT)
BEGIN
 IF num < = 0 THEN
SELECT ‘El valor introducido debe ser positivo’;
 ELSE
WHILE num >= 1 DO
 -- Mientras la condición sea cierta repite las siguientes sentencias
SELECT num, ‘ ‘;
SET num = num – 1;
END WHILE;
 END IF;
END &&
DELIMITER ;
-- Llamada y comprobación
CALL numeros_menores_while (0);
CALL numeros_menores_while (0);


DELIMITER &&
CREATE PROCEDURE numeros_nemores_repeat (IN num INT)
BEGIN
 IF num < = 0 THEN num
SELECT ‘El valor introducido debe ser positivo’;
 ELSE
REPEAT -- repite las siguientes sentencias
SELECT num, ‘ ‘;
SET num = num – 1;
UNTIL num < 1;-- hasta que la condición sea cierta
END REPEAT;
 END IF;
END &&
DELIMITER ;
-- Llamada y comprobación
CALL numeros_menores_repeat (0);
CALL numeros_menores_repeat (0);


DELIMITER &&
CREATE PROCEDURE numeros_nemores_loop (IN num INT)
BEGIN
 IF num <= 0 THEN
SELECT 'El valor introducido debe ser positivo';
 ELSE
etiqueta1: LOOP -- repite las siguientes sentencias-/
SELECT num, ‘ ‘;
SET num = num – 1;
IF num<1 THEN /- si la condición es cierta -/
LEAVE b1; /- salir del bucle -/
ELSE /- si la condición no es cierta -/
ITERATE etiqueta1; /- comenzar bucle -/
END LOOP; -/ punto final del bucle -/
 END IF;
END &&
DELIMITER ;
-- Llamada y comprobación
CALL numeros_menores_loop (0);
CALL numeros_menores_loop (0);