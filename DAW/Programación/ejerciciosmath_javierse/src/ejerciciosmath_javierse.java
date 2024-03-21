import java.util.Random;
import java.util.Scanner;
import static java.lang.Thread.sleep;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class ejerciciosmath_javierse {
    static Scanner sc = new Scanner(System.in);
    static void ej1(){
        Random rand = new Random();
        int a = rand.nextInt(100);
        System.out.println(a);
    }
    static void ej2(){
        System.out.println("Escribe un numero");
        int a = sc.nextInt();
        System.out.println("Escribe otro numero");
        int b = sc.nextInt();
        if (a > b){
            System.out.println(a +" es mayor que " +b);
        } else{
            System.out.println(b +" es mayor que " +a);
        }
    }
    static void ej3(){
        System.out.println("Escribe un numero");
        int a = sc.nextInt();
        System.out.println("Escribe otro numero");
        int b = sc.nextInt();
        if (a < b){
            System.out.println(a +" es menor que " +b);
        } else{
            System.out.println(b +" es menor que " +a);
        }
    }
    static void ej4(){
        System.out.println("Escribe un numero");
        int a = sc.nextInt();
        System.out.println("Escribe otro numero");
        int b = sc.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a > b){
            System.out.println(a +" es el mayor valor absoluto");
        } else{
            System.out.println(b +" es el mayor valor absoluto");
        }
    }
    static void ej5(){
        System.out.println("La raiz cuadrada de 25 es " +(int)Math.sqrt(25));
    }
    static void ej6(){
        System.out.println("Escribe la nota a redondear");
        double a = sc.nextDouble();
        System.out.println(a +" redondeado a lo alto es " +(int)Math.ceil(a));
        System.out.println(a +" redondeado normal es " +(int)Math.round(a));
        System.out.println(a +" redondeado a lo bajo es " +(int)Math.floor(a));
    }
    static void ej7() {
        System.out.println("Inserta la base de la potencia");
        int a = sc.nextInt();
        System.out.println("Inserta el exponente de la potencia");
        int b = sc.nextInt();
        System.out.println(a +" elevado a " +b +" es " +(int)Math.pow(a,b));
    }
    public static void main(String[] args) throws InterruptedException {
        int repet = 0;
        while (repet == 0) {
            System.out.println(" ");
            System.out.println("Elije que ejercicio va a ejecutar");
            System.out.println("(Para cerrar el bucle pulse 8)");
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
                    ej7();
                    break;
                case 8:
                    repet = 1;
                    break;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(2000);
        }
    }
}
