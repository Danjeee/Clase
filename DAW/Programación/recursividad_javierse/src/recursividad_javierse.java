import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class recursividad_javierse {
    static Scanner sc = new Scanner(System.in);
    public static void ej1(){
        System.out.println(recursividad.Recursivo(5));
        System.out.println("El algoritmo funciona sumando el cuadrado de n con todos los cuadrados anteriores");
    }
    public static void ej2(){
        System.out.println("indica n");
        int n=sc.nextInt();
        System.out.println("La suma de todos los numeros naturales hasta " +n +" es de " +recursividad.suma(n));
    }
    public static void ej3(){
        System.out.println("Escribe un numero");
        int n=sc.nextInt();
        int len = Integer.toString(n).length();
        int e=0;
        int inv = 0;
        int ii=len-1;
        int i=len-1;
        System.out.println(recursividad.invertir(inv, n,e,i,ii));
    }
    public static void ej4(){
        System.out.println("Escribe una palabra");
        String p = sc.next();
        int n = p.length();
        System.out.println(recursividad.invertirpalabra(n,p));
    }
    public static void ej5(){
        System.out.println("Escribe la base");
        int b = sc.nextInt();
        System.out.println("Escribe el exponente");
        int e = sc.nextInt();
        System.out.println(recursividad.potencia(b,e));
    }
    public static void ej6(){
        System.out.println("Escribe un numero");
        int n = sc.nextInt();
        int len = Integer.toString(n).length();
        int ii=len-1;
        int sum=0;
        System.out.println(recursividad.sumar(sum,n,ii));
    }
    public static void ej7a(){
        String n = "";
        int index=0;
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (!Objects.equals(n, "salir")) {
            System.out.println("Escribe un numero");
            n = sc.next();
            if (!n.equals("salir")) {
                array.add(index, Integer.parseInt(n));
                index++;
            }
        }
        index-=1;
        int max = array.get(0);
        System.out.println(recursividad.maximo(array,index,max));
    }
    public static void ej7b(){
        String n = "";
        int index=0;
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (!Objects.equals(n, "salir")) {
            System.out.println("Escribe un numero");
            n = sc.next();
            if (!n.equals("salir")) {
                array.add(index, Integer.parseInt(n));
                index++;
            }
        }
        index-=1;
        int max = array.get(0);
        System.out.println(recursividad.minimo(array,index,max));
    }
    public static void main(String[] args) throws InterruptedException {
        int repet = 0;
        while (repet == 0) {
            System.out.println(" ");
            System.out.println("Elije que ejercicio va a ejecutar");
            System.out.println("(Para cerrar el bucle pulse 9)");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    ej1();
                    break;
                case 2:
                    ej2();
                    break;
                case 3:
                    ej3();
                    break;
                case 4:
                    ej4();
                    break;
                case 5:
                    ej5();
                    break;
                case 6:
                    ej6();
                    break;
                case 7:
                    ej7a();
                    break;
                case 8:
                    ej7b();
                    break;
                case 9:
                    repet = 1;
                    break;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(2000);
        }
    }
}