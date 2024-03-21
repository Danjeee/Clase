import java.util.Scanner;
import static java.lang.Thread.sleep;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class modular_javierse {
    static Scanner sc = new Scanner(System.in);
    public static boolean esPrimo(int n, int i){
        for (i = 2; i < n; i++) {
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
    static void ej1(){
        int n=2;
        int i=1;
        int c=0;
        while (n!=1000) {

            if (esPrimo(n,i)){
                System.out.print(n +" ");
                c++;
            }
            if (c==4){
                System.out.println();
                c=0;
            }
            n++;
        }
    }
    public static int suma(int a, int b){return a+b;}
    public static int resta(int a, int b) {return a-b;}
    public static int mult(int a, int b) {return a*b;}
    public static int div(int a, int b) {return a/b;}
    public static int potencia(int a, int b) {return (int)Math.pow(a,b);}
    public static int raiz(int a) {return (int) Math.sqrt(a);}
    static void ej2(){
        boolean exit = true;
        while (exit) {
            System.out.println("1.- Suma");
            System.out.println("2.- Resta");
            System.out.println("3.- Mult");
            System.out.println("4.- Div");
            System.out.println("5.- Potencia");
            System.out.println("6.- Raiz");
            System.out.println("7.- Salir");
            int menu = sc.nextInt();
            int b=0;
            int a=0;
            if (menu != 7) {
            System.out.println("Escribe un numero");
            a=sc.nextInt();
                if (menu != 6) {
                    System.out.println("Escribe otro numero");
                    b = sc.nextInt();
                }
            }
            switch (menu){
                case 1: System.out.println(suma(a,b)); break;
                case 2: System.out.println(resta(a,b)); break;
                case 3: System.out.println(mult(a,b)); break;
                case 4: System.out.println(div(a,b)); break;
                case 5: System.out.println(potencia(a,b)); break;
                case 6: System.out.println(raiz(a)); break;
                case 7: exit=false;
            }
        }
    }
    public static void caja(String s){
        s=sc.nextLine();
        int b = (s.length()+4);
        int h = 5;
        for (int i=0; i<h; i++) {
            for (int j = 0; j < b; j++) {
                if (i==0 || i==4){
                    System.out.print("*");
                } else if (i==2) {
                    System.out.print("* " +s +" *");
                    break;
                } else if (j==0 || j==(b-1)){
                        System.out.print("*");
                }else {System.out.print(" ");}
            }
            System.out.println();
        }
    }
    static void ej3(){
        System.out.println("Escriba una frase");
        String s = null;
        caja(s);
    }
    public static String palo(int n){
        for (int i = 0; i<n; i++){
            System.out.print("|");
        }
        return "";
    }
    static void ej4(){
        System.out.println("Que numero quieres escribir en palos");
        String num = sc.nextLine();
        int n = 0;
        for (int i = 0; i<num.length(); i++){
            n=Integer.parseInt(String.valueOf(num.charAt(i)));
            palo(n);
            if (i!=num.length()-1){
                System.out.print(" - ");
            }
        }
    }
    public static String palabra(int n){
        switch (n){
            case 0: return "cero ";
            case 1: return "uno ";
            case 2: return "dos ";
            case 3: return "tres ";
            case 4: return "cuatro ";
            case 5: return "cinco ";
            case 6: return "seis ";
            case 7: return "siete ";
            case 8: return "ocho ";
            case 9: return "nueve ";
        }
        return"";
    }
    static void ej5(){
        System.out.println("Que numero quieres escribir en letras");
        String num = sc.nextLine();
        int n = 0;
        for (int i = 0; i<num.length(); i++){
            n=Integer.parseInt(String.valueOf(num.charAt(i)));
            System.out.print(palabra(n));
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int repet = 0;
        while (repet == 0) {
            System.out.println(" ");
            System.out.println("Elije que ejercicio va a ejecutar");
            System.out.println("(Para cerrar el bucle pulse 6)");
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
                    repet = 1;
                    break;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(2000);
        }
    }
}