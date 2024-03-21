Algoritmo diagramas1325_javierse
	//Variables//
	Definir menu Como Entero
	Definir repet Como Entero
	repet=0
	//Operaciones//
	Definir a Como Real
	Definir aa Como Real
	Definir b Como Real
	Definir bb Como Real
	Definir c Como Real
	Definir d Como Real
	Definir x Como Entero

	//18//
	Definir j Como Entero
	//19//
	Definir dd Como Entero
	//20//
	Definir min Como Entero
	Definir max Como Entero
	Definir s Como Caracter
	Definir dif Como Entero
	//22//
	Definir suma Como Entero
	//24//
	Definir dia Como Entero
	Definir mes Como Entero
	Definir ano Como Entero
	//25//
	Definir mesa Como Entero
	Definir mesb Como Entero
	//Valores a 0//
	Repetir
	x=0
	a=0
	b=1
	c=0
	d=0
	j=1
	dd=0
	min=0
	//Script//
	Escribir "Menu, selecciona un ejercicio"
	Escribir "13) Factorial"
	Escribir "14) Progresión geométrica"
	Escribir "15) Convertir a binario"
	Escribir "17) Máximo"
	Escribir "18) Ordenar"
	Escribir "19) Encontrar posición"
	Escribir "20) Adivinar"
	Escribir "21) Adivinar más"
	Escribir "22) ¿Número perfecto?"
	Escribir "23) Años bisiestos"
	Escribir "24) Día siguiente"
	Escribir "25) Miercoles de ceniza"
	Escribir "0) Cerrar"
	Leer menu
	Repetir
	Segun menu hacer
		13:
			Escribir "Indica un número para hallar su factorial"
			Leer a
			Para x=1 Hasta a Con Paso 1 Hacer
				b=b*x
			FinPara
			Escribir "El factorial de " a " es " b
		14:
			Escribir "Escribe el primer número de la sucesión"
			Leer a
			aa=a
			Escribir "Escribe la razón"
			Leer b
			bb=b
			Escribir "Escribe la cantidad de números de la sucesión que quieres sumar"
			Leer c
			Para x=1 Hasta c Con Paso 1
				d=d+a
				a=a*b
			FinPara
			Escribir "La suma de los primeros " c " términos de la sucesión geométrica cuyo primer término es " aa " y cuya razón es " bb " es " d
		15:
			Escribir "Escribe un número en sistema decimal"
			Leer a
			Dimension arreglo(80)
			x=1
			Repetir
				c=a mod 2
				a=a/2
				a=trunc(a)
				arreglo(x)=c
				x=x+1
			Hasta Que a<=1
			arreglo(x)=a
			Repetir
				Escribir arreglo(x) Sin Saltar
				x=x-1
			Hasta Que x=1
			Escribir arreglo(x)
		17:
			Escribir "De cuantos números quieres averiguar el máximo?"
			Leer a
			aa=a
			Dimension arreglo(a+1)
			Para x=1 hasta a Con Paso 1 Hacer
				Escribir "Escribe el número nª" x
				Leer arreglo(x)
			FinPara
			b=arreglo(x)
			Para x=x hasta 1 Con Paso -1 Hacer
				Si arreglo(x)>b
					b=arreglo(x)
				FinSi
			FinPara
			Escribir "El número más alto de esos " a " números es " b
		18:
			Escribir "Cuantos números quieres ordenar"
			Leer a
			Dimension arreglo(a+1)
			Dimension arreglob(a+1)
			j=1
			aa=a
			Para x=1 Hasta a Con Paso 1 Hacer
				Escribir "Escriba el número nº" x
				Leer arreglo(x)
			FinPara
			b=arreglo(x)
			Repetir
			Para x=aa hasta 1 Con Paso -1
				Si arreglo(x)>b
					b=arreglo(x)
					c=x
				FinSi
			FinPara
			arreglob(j)=b
			arreglo(c)=0
			j=j+1
			b=0
			Hasta Que j=a+1
			Escribir "De mayor a menor"
			Para j=1 Hasta a Con Paso 1 Hacer
				Escribir arreglob(j) ", " Sin Saltar
			FinPara
			Escribir ""
			Escribir "De menor a mayor"
			Para j=a Hasta 1 Con Paso -1 Hacer
				Escribir arreglob(j) ", " Sin Saltar
			FinPara
			Escribir ""
		19:
			Escribir "¿Cuantos números quieres añadir?"
			Leer a
			Dimension arreglo(a+1)
			Dimension arreglob(a+1)
			j=1
			aa=a
			Para x=1 Hasta a Con Paso 1 Hacer
				Escribir "Escriba el número nº" x
				Leer arreglo(x)
			FinPara
			b=arreglo(x)
			Repetir
				Para x=aa hasta 1 Con Paso -1
					Si arreglo(x)>b
						b=arreglo(x)
						c=x
					FinSi
				FinPara
				arreglob(j)=b
				arreglo(c)=0
				j=j+1
				b=0
			Hasta Que j=a+1
			Escribir "Que numero quieres buscar?"
			Leer d
			dd=-1
			c=dd
			Para x=aa Hasta 1 Con Paso -1 Hacer
				Si arreglob(x)=d
					c=x
				FinSi
			FinPara
			Si c=-1
				Escribir d " no esta en esa lista de números"
			SiNo
				Escribir d " es el " c "º número mas grande de la lista"
			FinSi
		20:
			Escribir "Voy a adivinar un número entre 1 y 1000 en el que pienses"
			Esperar 1 Segundos
			min=1
			max=1000
			a=0
			x=1
			Repetir
				Repetir
					b=azar(1000)
				Hasta Que b>=min y b<=max
				Escribir "¿Estabas pensando en el numero " b "?"
				Leer s
				Si s="<"
					max=b
					x=x+1
				SiNo
					Si s=">"
						min=b
						x=x+1
					SiNo
						a=1
					FinSi
				FinSi
				dif=max-min
				Si dif<=1
					Escribir "¡Estas mintiendo!"
					a=1
					min=1
				FinSi
			Hasta Que a=1 o x=10
			Si a=1
				Si dif=1
					Escribir "Eres un mentiroso"
				SiNo
					Escribir "¡Adiviné que pensabas en el número " b "!"
				FinSi
			SiNo
				Escribir "Me has ganado"
			FinSi
		
		21:
			Escribir "Voy a adivinar un número entre 1 y 10000 en el que pienses"
			Esperar 1 Segundos
			min=1
			max=10000
			a=0
			x=1
			Repetir
				Repetir
					b=azar(10000)
				Hasta Que b>=min y b<=max
				Escribir "¿Estabas pensando en el numero " b "?"
				Leer s
				Si s="<"
					max=b
					x=x+1
				SiNo
					Si s=">"
						min=b
						x=x+1
					SiNo
						a=1
					FinSi
				FinSi
				dif=max-min
				Si dif<=1
					Escribir "¡Estas mintiendo!"
					a=1
					min=1
				FinSi
			Hasta Que a=1
			Si dif=1
				Escribir "Eres un mentiroso"
			SiNo
				Escribir "¡Adiviné que pensabas en el número " b " en " x " intentos!"
			FinSi
		22:
			Escribir "Dime un número y te diré si es perfecto o no"
			Leer a
			b=a+1
			Dimension arreglo(999)
			c=1
			j=1
			Repetir
				Si a mod c = 0
					arreglo(j)=c
					j=j+1
				FinSi
				c=c+1
				b=b-1
			Hasta Que b=1
			Para x=j-2 Hasta 1 Con Paso -1 Hacer
				suma=suma+arreglo(x)
			FinPara
			Si suma=a
				Escribir a " es un número perfecto"
			SiNo
				Escribir a " no es un número perfecto"
			FinSi
		23:
			Escribir "Dime un año y te diré si es bisiesto"
			Leer a
			Si a mod 4 = 0
				Si a mod 100 = 0
					Si a mod 400 = 0
						b=1
					SiNo
						b=0
					FinSi
				SiNo
					b=1
				FinSi
			SiNo
				b=0
			FinSi
			Si b=0
				Escribir a " no es un año bisiesto"
			SiNo
				Escribir a " es un año bisiesto"
			FinSi
		24:
			Escribir "Dime una fecha y te diré el día siguiente"
			Escribir "Indica un día"
			Leer dia
			Escribir "Indica un mes"
			Leer mes
			Escribir "Indica un año"
			Leer año
			Escribir "El dia siguiente a " dia "/" mes "/" ano " es " Sin Saltar
			dia=dia+1
			Si mes=1 y dia>=32 o mes=3 y dia>=32 o mes=5 y dia>=32 o mes=7 y dia>=32 o mes=8 y dia>=32 o mes=10 y dia>=32 o mes=12 y dia>=32
				Si mes=12
					dia=1
					mes=1
					ano=ano+1
				SiNo
					dia=1
					mes=mes+1
				FinSi
			FinSi
			Si mes=4 y dia>=31 o mes=6 y dia>=31 o mes=9 y dia>=31 o mes=11 y dia>=31
				dia=1
				mes=mes+1
			FinSi
			Si ano mod 4 = 0
				Si ano mod 100 = 0
					Si ano mod 400 = 0
						b=1
					SiNo
						b=0
					FinSi
				SiNo
					b=1
				FinSi
			SiNo
				b=0
			FinSi
			Si mes=2 y b=1 y dia>=30
				dia=1
				mes=mes+1
			FinSi
			Si mes=2 y b=0 y dia>=29
				dia=1
				mes=mes+1
			FinSi
			Escribir dia "/" mes "/" ano
		25:
			Escribir "Indica el dia del Domingo de Resurrección de un año y te diré que día es el miercoles de ceniza de ese año"
			Escribir "Inserte el dia"
			Leer dia
			Escribir "Inserte el mes"
			Leer mes
			Escribir "Inserte el año"
			Leer ano
			Escribir "El Miércoles de Ceniza del año " ano " es, teniendo en cuenta que el Domingo de Resurrección es el " dia "/" mes "/" ano " el dia: " Sin Saltar
			a=46
			Si mes-2=1 o mes-2=3 o mes-2=5 o mes-2=7 o mes-2=8 o mes-2=10 o mes-2=0
				mesa=31
			SiNo
				Si mes-2=4 o mes-2=6 o mes-2=9 o mes-2=-1
					mesa=30
				SiNo
					Si ano mod 4 = 0
						Si ano mod 100 = 0
							Si ano mod 400 = 0
								mesa=29
							SiNo
								mesa=28
							FinSi
						SiNo
							mesa=29
						FinSi
					SiNo
						mesa=28
					FinSi
				FinSi
			FinSi
			Si mes-1=1 o mes-1=3 o mes-1=5 o mes-1=7 o mes-1=8 o mes-1=10 o mes-1=0
				mesb=31
			SiNo
				Si mes-1=4 o mes-1=6 o mes-1=9 o mes-1=11
					mesb=30
				SiNo
					Si ano mod 4 = 0
						Si ano mod 100 = 0
							Si ano mod 400 = 0
								mesb=29
							SiNo
								mesb=28
							FinSi
						SiNo
							mesb=29
						FinSi
					SiNo
						mesb=28
					FinSi
				FinSi
			FinSi
			a=a-dia
			Si a<mesb
				a=mesb-a
				mes=mes-1
				Si mes=0
					mes=12
					ano=ano-1
				FinSi
				Si mes=-1
					mes=11
					ano=ano-1
				FinSi
				Si mes=-2
					mes=10
					ano=ano-1
				FinSi
			SiNo
				a=a-mesb
				a=mesa-a
				mes=mes-2
				Si mes=0
					mes=12
					ano=ano-1
				FinSi
				Si mes=-1
					mes=11
					ano=ano-1
				FinSi
				Si mes=-2
					mes=10
					ano=ano-1
				FinSi
			FinSi
			Escribir a "/" mes "/" ano
		De Otro Modo:
			Escribir menu " no es una opción valida, intentelo de nuevo"
		0:
			repet=1
	FinSegun
	Si repet=0
		Esperar 2 Segundos
		Limpiar Pantalla
	FinSi
	Hasta Que menu>=13 y menu<=25 y menu<>16 o menu=0
	Hasta Que repet=1
FinAlgoritmo
