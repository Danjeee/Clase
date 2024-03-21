// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Thread.sleep;
public class foreach_javierse {
    static Scanner sc = new Scanner(System.in);
    static void ej1(){
        String[] x = {"corazon", "diamante", "herradura", "campana", "limon"};
        String[] y = new String[3];
        int a=0;
        for (int i=0; i<3; i++){
            int rand = (int) (Math.random()*5);
            y[i]=x[rand];
        }
        for (int i=0;i<3;i++){
            System.out.print(y[i]);
            if (i!=2){
                System.out.print(", ");
            }
        }
        System.out.println();

        for (String i : y){
            if (i.equals(y[0])) {
                a++;
            }
            if (i.equals(y[1])) {
                a++;
            }
            if (i.equals(y[2])) {
                a++;
            }
        }
        System.out.println(a);
        if (a<=3){
            System.out.println("Has perdido");
        } else if (a!=9) {
            System.out.println("Has recuperado tu moneda");
        } else {
            System.out.println("Has ganado");
        }
    }
    static void ej2(){
        System.out.println("Escribe tu nombre");
        String nom = sc.nextLine();
        int a=0;
        String[] let = new String[nom.length()];
        for (int i=0; i<nom.length();i++){
            let[i]= String.valueOf(nom.charAt(i));
        }
        for (String i : let){
            a++;
            System.out.print(i);
            if (a==2){
                System.out.print(" ");
                a=0;
            }
        }
    }
    static void ej3(){
        System.out.println("Escriba la frase");
        String fr = sc.nextLine();
        for (String i : fr.split(" ")){
            System.out.println(i);
        }
    }
    static void ej4(){
        System.out.println("Escriba los numeros separados por espacios");
        String x = sc.nextLine();
        int suma = 0;
        int[] y = new int[x.length()];
        int a=0;
        for (String i : x.split(" ")){
            y[a] = Integer.parseInt(i);
            a++;
        }
        for (int j : y) {
            suma += j;
        }
        System.out.println(suma);
    }
    public static void main(String[] args) throws InterruptedException {
        int repet = 0;
        while (repet == 0) {
            System.out.println(" ");
            System.out.println("Elije que ejercicio va a ejecutar");
            System.out.println("(Para cerrar el bucle pulse 5)");
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
                    repet = 1;
                    break;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(2000);
        }
    }
}