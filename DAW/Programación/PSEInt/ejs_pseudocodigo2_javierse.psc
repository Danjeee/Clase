Algoritmo sin_titulo
	//general//
	Definir menu Como Entero
	Definir repet Como Entero
	repet=0
	Definir a Como real
	Definir b Como real
	Definir c Como real
	Definir d Como real
	Definir e Como real
	Definir g Como Real
	//1//
	Definir nombre Como Caracter
	//4//
	Definir num Como Entero
Repetir
Repetir
	//igualar a 0//
	a=0
	b=0
	c=0
	d=0
	e=0
	g=0

	//Script//
	Escribir "Menu, selecciona un ejercicio"
	Escribir "1) Promedio"
	Escribir "2) Aprobado o suspendido"
	Escribir "3) Promedio estricto"
	Escribir "4) Notas grupales"
	Escribir "0) Cerrar"
	Leer menu
	Segun menu Hacer
		1:
			Escribir "Escribe el nº del expediente del alumno"
			Leer a
			Escribir "Escribe el nombre del alumno"
			Leer nombre
			Para x=1 Hasta 5 Con Paso 1
				Escribir "Escribe la nota nº" x
				Leer b
				c=c+b
			FinPara
			c=c/5
			Escribir "La nota promedia de " nombre " es " c
		2:
			Escribir "Escribe el nº del expediente del alumno"
			Leer a
			Escribir "Escribe el nombre del alumno"
			Leer nombre
			Para x=1 Hasta 5 Con Paso 1
				Escribir "Escribe la nota nº" x
				Leer b
				c=c+b
			FinPara
			c=c/5
			Si c<5
				Escribir nombre " esta suspendido"
			FinSi
			Si c>=5
				Escribir nombre " esta aprobado"
			FinSi
		3:
			Escribir "Escribe el nº del expediente del alumno"
			Leer a
			Escribir "Escribe el nombre del alumno"
			Leer nombre
			Para x=1 Hasta 5 Con Paso 1
				Escribir "Escribe la nota nº" x
				Leer b
				c=c+b
				Si b<5
					d=1
				FinSi
			FinPara
			c=c/5
			Si d=0
				Escribir "La nota promedia de " nombre " es " c
			SiNo
				Escribir "El alumno " nombre " esta suspendido porque ha suspendido una o más asignaturas"
			FinSi
		4:
			Escribir "Escribe el número de alumnos de los que quieres hayar el promedio"
			Leer num
			Dimension arreglo(num+1)
			Dimension arreglon(num+1)
			Dimension arregloa(num+1)
			Para g=1 Hasta num Con Paso 1 Hacer
				Escribir "Escribe el nº del expediente del alumno"
				Leer arregloa(g)
				Escribir "Escribe el nombre del alumno"
				Leer arreglon(g)
				Para x=1 Hasta 5 Con Paso 1
					Escribir "Escribe la nota nº" x
					Leer b
					c=c+b
				FinPara
				c=c/5
				arreglo(g)=c
			FinPara
			Para x=1 Hasta num Con Paso 1 Hacer
				Escribir "La nota media de " arreglon(x) " es " arreglo(x)
			FinPara
		0:
			Escribir "adios"
			repet=1
		De Otro Modo:
			Escribir menu " no es una opción valida, intentalo de nuevo"
	FinSegun
	Si repet=0
		Esperar 2 Segundos
		Limpiar Pantalla
	FinSi
Hasta Que menu>=0 y menu<=4
Hasta Que repet=1
FinAlgoritmo