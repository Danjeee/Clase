Algoritmo diagramas_javierse
	//---------------------------------------Variables-------------------------------------------//
	Definir menu Como Entero
	//1//
	Definir a Como Real //Tambien para operaciones
	Definir b Como Real //Tambien para operaciones
	Definir suma Como Entero
	//General//
	Definir x Como Real
	//2//
	Definir Suma100 Como Entero
	Suma100=0
	//3//
	Definir num Como Entero
	Definir nums Como Entero
	Definir SumaN Como Entero
	SumaN=0
	//4//
	Definir parc Como Entero
	parc=0
	//5//
	Definir SumaI Como Entero
	SumaI=0
	Definir SumaP Como Entero
	SumaP=0
	Definir mult3 Como Entero
	mult3=0
	//6//
	Definir F1 Como Entero
	Definir F2 Como Entero
	Definir F3 Como Entero
	//7//
	Definir H Como Entero
	Definir M Como Entero
	Definir S Como Entero
	//8//
	Definir ec Como Entero
	Definir c Como Real
	Definir x1 Como Real
	Definir x2 Como Real
	//9//
	Definir I1 Como Real
	Definir iva Como Real
	Definir imp Como Real
	imp=0
	Definir dc Como Real
	dc=0
	//El 10 recicla otras variables//
	//11//
	Definir N1 Como Real
	Definir N2 Como Entero
	Definir N3 Como Entero
	Definir NN1 Como Real
	Definir NN2 Como Entero
	N1=0
	N2=0
	N3=1
	//----------------------------------------Script---------------------------------------------//
Repetir
	Escribir "Menu, selecciona un ejercicio"
	Escribir "1) Suma"
	Escribir "2) Suma de 100 n�meros"
	Escribir "3) Suma de x n�meros"
	Escribir "4) Escribir uno de los 100 primeros n�meros pares"
	Escribir "5) Sumar primeros n�meros impares, pares y multiplos de 3"
	Escribir "6) Fibonacci"
	Escribir "7) Reloj"
	Escribir "8) Ecuaci�n de segundo grado"
	Escribir "9) Factura"
	Escribir "10) Suma de pares y producto de impares"
	Escribir "11) MCD"
	Leer menu
	Segun menu hacer
		1:
			Escribir "Selecciona un n�mero"
			Leer a
			Escribir "Selecciona otro n�mero"
			Leer b
			suma=a+b
			Escribir "La suma de " a " + " b " es " suma
		2:
			Para x=1 Hasta 100 Con Paso 1
				Escribir "Selecciona el n�mero n�" x
				Leer num
				Suma100=Suma100+num
			FinPara
			Escribir "La suma de estos 100 n�meros es " Suma100
		3:
			Escribir "�Cuantos n�meros quieres sumar?"
			Leer nums
			Para x=1 Hasta nums Con Paso 1
			Escribir "Selecciona el n�mero n�" x
			Leer num
			SumaN=SumaN+num
			FinPara
			Escribir "La suma de estos " nums " n�meros es " SumaN
		4:
			Escribir "Escribe uno de los 100 primeos n�meros pares"
			Leer a
			Para x=0 Hasta 100 Con Paso 2 Hacer
				Si x=a
					parc=1
				FinSi
			FinPara
			Si parc=1
				Escribir a " es uno de los primeros 100 n�meros pares"
			SiNo
				Escribir a " no es uno de los primeros 100 n�meros pares"
			FinSi
		5:
			Escribir "�Que cantidad de n�meros impares quieres sumar? (Desde 1)"
			Leer nums
			a=1
			Para x=1 Hasta nums Con Paso 1
				SumaI=SumaI+a
				a=a+2
			FinPara
			Escribir "La suma de los primeros " nums " n�meros impares es " SumaI
			Escribir "�Que cantidad de n�meros pares quieres sumar? (Contando 0 como el primero)"
			Leer nums
			a=0
			Para x=1 Hasta nums Con Paso 1
				SumaP=SumaP+a
				a=a+2
			FinPara
			Escribir "La suma de los primeros " nums " n�meros impares es " SumaP
			Escribir "�Que cantidad de multiplos de 3 quieres sumar?"
			Leer nums
			a=3
			Para x=1 Hasta nums Con Paso 1
				a=x*3
				mult3=mult3+a
			FinPara
			Escribir "La suma de los primeros " nums " multiplos de 3 es " mult3
		6:
			Escribir "�Que t�rmino de la sucesi�n de Fibonacci quieres hallar?"
			Leer nums
			F1=1
			F2=1
			Para x=1 Hasta nums Con Paso 1
				F3=F1+F2
				F1=F2
				F2=F3
			FinPara
			Escribir "El " nums "� t�rmino de la sucesi�n de Fibonacci es " F3
		7: 
			H=0
			M=0
			S=0
			Mientras Verdadero
				Limpiar Pantalla
				Escribir "RELOJ"
				Si H<10
					Escribir "0" Sin Saltar
				FinSi
				Escribir H,":" Sin Saltar
				Si M<10
					Escribir "0" Sin Saltar
				FinSi
				Escribir M,":" Sin Saltar
				Si S<10
					Escribir "0" Sin Saltar
				FinSi
				Escribir S
				S=S+1
				Si S=60
					M=M+1
					S=0
				FinSi
				Si M=60
					H=H+1
					M=0
				FinSi
				Esperar 1 Segundos
			FinMientras
		8:
			Repetir
				Escribir "�Que modelo de ecuaci�n de segundo grado quieres resolver?"
				Escribir "1) ax^2 +- bx +-c = 0"
				Escribir "2) ax^2 +- bx = 0"
				Escribir "3) ax^2 +- c = 0"
				Leer ec
				Segun ec Hacer
					1:
						Escribir "Ten en cuenta que si la raiz cuadrada da negativo, aparecer� un error y esto quiere decir que no se puede resolver"
						Escribir "Seleccione el valor de a"
						Leer a
						Escribir "Seleccione el valor de b"
						Leer b
						Escribir "Seleccione el valor de c"
						Leer c
						x1=(-b) +((raiz(b^2 -4*a*c))/(-c))
						x2=(-b) -((raiz(b^2 -4*a*c))/(-c))
					2:
						Escribir "Seleccione el valor de a"
						Leer a
						Escribir "Seleccione el valor de b"
						Leer b
						x1=0
						x2=(-b)/a
					3:
						Escribir "Ten en cuenta que si la raiz cuadrada da negativo, aparecer� un error y esto quiere decir que no se puede resolver"
						Escribir "Seleccione el valor de a"
						Leer a
						Escribir "Seleccione el valor de c"
						Leer c
						x1=raiz((-c)/a)
						x2=-raiz((-c)/a)
					De Otro Modo:
						Escribir ec " no es una opci�n v�lida, vuelve a intentarlo"
						Esperar 1 Segundos
						Limpiar Pantalla
				FinSegun
			Hasta Que ec=1 o ec=2 o ec=3
			Si	ec=1
				Escribir "Los resultados de la ecuaci�n " a "x^2 +" b "x +" c " = 0 son: x1 = " x1 " y x2 = " x2
			FinSi
			Si	ec=2
				Escribir "Los resultados de la ecuaci�n " a "x^2 +" b "x = 0 son: x1 = " x1 " y x2 = " x2
			FinSi
			Si	ec=3
				Escribir "Los resultados de la ecuaci�n " a "x^2 +" c " = 0 son: x1 = " x1 " y x2 = " x2
			FinSi
		9:
			x=0
			a=1
			I1=1
			Repetir
				Escribir "Seleccione el importe n�" a " o escriba 0 para finalizar"
				Leer I1
				Si I1>0
					Escribir "Seleccione el iva de este importe (Solo puede ser 4%, 7% o 16%)"
					Leer iva
					Si iva=4 o iva=7 o iva=16
						Escribir "Importe a�adido con exito"
						imp=((iva*I1)/100)+I1+imp
						a=a+1
					SiNo
						Escribir "El iva est� mal introducido, intentalo de nuevo"
					FinSi
				FinSi
			Hasta Que I1=0
			Si imp>=1000 y imp<10000
				dc=5
				imp=imp-((imp*5)/100)
			FinSi
			Si imp>=10000
				dc=10
				imp=imp-((imp*10)/100)
			FinSi
			Escribir "El total de la suma de los " a " importes es de " imp ", habiendo aplicado un " dc "% de descuento"
		10:
			Escribir "�Con cuantos n�meros quieres operar?"
			Leer nums
			SumaI=1
			Para x=1 Hasta nums Con Paso 1 Hacer
				Escribir "Escribe el n�mero n�" x
				Leer a
				Si a mod 2 = 0
					SumaP=SumaP+a
				SiNo
					SumaI=SumaI*a
				FinSi
			FinPara
			Escribir "La suma de todos los n�meros pares es de " SumaP " y el producto de todos los impares es de " SumaI
		11:
			Escribir "Ten en cuenta que tienes que escribir primero el n�mero m�s grande"
			Escribir "Escribe el primer n�mero"
			Leer N1
			NN1=N1
			Escribir "Escribe el segundo n�mero"
			Leer N2
			NN2=N2
			Repetir
				N3=N1 mod N2
				Si N3>0
					N2=N3
					N1=N2
				FinSi
			Hasta Que N3=0
			Escribir "El MCD de " NN1 " y " NN2 " es " N2
		De Otro Modo:
			Escribir menu " no es una opci�n, intentalo de nuevo"
			Esperar 1 Segundos
			Limpiar Pantalla
	FinSegun
Hasta Que menu>=1 y menu<=11
FinAlgoritmo
