Algoritmo calculadora
	Definir a Como Entero
	Definir b Como Entero
	Definir e Como Entero
	Definir x Como Entero
	x=0
	Escribir "Calculadora"
	Escribir "Introduce un n�mero"
	Leer a
	Escribir "Introduce otro n�mero"
	Leer b
	Repetir
		Limpiar Pantalla
		Escribir "�Que operaci�n quieres hacer?"
		Escribir "1) Suma"
		Escribir "2) Resta"
		Escribir "3) Multiplicaci�n"
		Escribir "4) Divisi�n"
		Leer e
		Segun e Hacer
			1:
				suma=a+b
				Escribir "Has elegido suma, el resultado de " a " + " b " es " suma
				x=1
			2:
				resta=a-b
				resta2=b-a
				Escribir "Has elegido resta, el resultado de " a " - " b " es " resta " y el de " b " - " a " es " resta2
				x=1
			3:
				mult=a*b
				Escribir "Has elegido multiplicaci�n, el resultado de " a " * " b " es " mult
				x=1
			4:
				div=a/b
				div2=b/a
				Escribir "Has elegido divisi�n, el resultado de " a "/" b " es " div " y el de " b "/" a " es " div2
				x=1
			De Otro Modo:
				Escribir e " no es una opci�n valida, vuelve a intentarlo"
				x=0
				Esperar 2 Segundos
		FinSegun
	Hasta Que x=1
FinAlgoritmo
