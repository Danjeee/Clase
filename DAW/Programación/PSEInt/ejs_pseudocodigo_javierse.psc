Algoritmo ejs_pseudocodigo_javierse
	//Variables//
	Definir menu Como Entero
	Definir a Como Real
	Definir b Como Real
	Definir c Como Real
	Definir d Como Real
	Definir x Como Entero
	x=0
	a=0
	b=0
	c=0
	d=0
	//Script//
Repetir
	Escribir "Menu, seleccione un ejercicio"
	Escribir "1) Suma"
	Escribir "2) Leer edad y peso"
	Escribir "3) Calcular el área de un circulo"
	Escribir "4) Calcular el área de un triángulo"
	Escribir "5) Calcular el volumen de un cilindro"
	Escribir "6) Ecuación"
	Escribir "7) ¿+ o -?"
	Escribir "8) >,< o = a 0"
	Escribir "9) Precio medio"
	Escribir "10) Tabla de multiplicar de x"
	Leer menu
	Segun menu Hacer
		1:
			Escribir "Seleccione el primer número:"
			Leer a
			Escribir "Seleccione el segundo número:"
			Leer b
			c=a+b
			Escribir "La suma de " a " + " b " es " c
		2:
			Escribir "Indica tu edad"
			Leer a
			Escribir "Indica tu peso (en kg)"
			Leer b
			Imprimir "Tienes " a " años y pesas " b "kg"
		3:
			Escribir "Vamos a calcular el area de un circulo (en m2, pero sirve con cualquier unidad de superficie), indica el radio"
			Leer a
			b=pi*(a^2)
			Escribir "El área del circulo en cuestión es de " a "m2"
		4:
			Escribir "Vamos a calcular el área de un triángulo (m2), indica la base"
			Leer a
			Escribir "Ahora indica la altura"
			Leer b
			c=(a+b)/2
			Escribir "El área del triangulo en cuestión es de " c "m2"
		5:
			Escribir "Vamos a calcular el volumen de un cilindro (m3) indica el diametro"
			Leer a
			Escribir "Ahora indica la altura"
			Leer b
			c=(((a/2)^2)*pi)*b
			Escribir "El volumen del cilindro en cuestión es de " c "m3"
		6:
			Escribir "Vamos a hallar Y en la ecuación Y=3X + 2 +7X - 15, teniendo en cuenta que vamos a sustituir la X"
			Escribir "Indica el valor de x"
			Leer a
			b=(3*a)+2+(7*a)-15
			Escribir "El resultado de Y=3*" a " + 2 + 7*" a " -15 es Y = " b
		7:
			Escribir "Elija un número y te diré si es positivo o negativo"
			Leer a
			Si a<0
				Escribir a " es un número negativo"
			SiNo
				Si a=0
					Escribir a " es 0"
				SiNo
					Escribir a " es positivo"
				FinSi
			FinSi
		8:
			Escribir "Elija un número y te diré si es positivo o negativo"
			Leer a
			Si a<0
				Escribir a " es un menor a 0"
			SiNo
				Si a=0
					Escribir a " es 0"
				SiNo
					Escribir a " es mayor a 0"
				FinSi
			FinSi
		9:
			Escribir "Vamos a hallar el precio medio teniendo en cuenta 3 precios distintos"
			Escribir "Escribe el primer precio"
			Leer a
			Escribir "Escribe el segundo precio"
			Leer b
			Escribir "Escribe el tercer precio"
			Leer c
			d=(a+b+c)/3
			Escribir "El precio medio de " a b " y " c " es " d
		10:
			Escribir "Seleccione un número para hallar su tabla de multiplicar"
			Leer a
			Para x=0 hasta 10 Con Paso 1 Hacer
				b=a*x
				Escribir a " * " x " = " b
			FinPara
		De Otro Modo:
			Escribir menu " no es una opción, intentalo de nuevo"
			Esperar 1 Segundos
			Limpiar Pantalla
	FinSegun
Hasta Que menu>=1 y menu<=10
FinAlgoritmo
