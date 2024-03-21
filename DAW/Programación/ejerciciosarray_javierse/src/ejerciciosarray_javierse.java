import java.util.Scanner;
import static java.lang.Thread.sleep;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ejerciciosarray_javierse {
    static Scanner sc = new Scanner(System.in);
    static void ej1(){
        int[] x = new int[4];
        int y=0;
        for (int i=0; i<4; i++){
            System.out.println("Escriba el numero nª" +(i+1));
            x[i] = sc.nextInt();
            y=x[i] + y;
        }
        y=y/5;
        System.out.println("La media de los numeros insertados es " +y);
        System.out.print("Y los numeros insertados eran: ");
        for (int i=0; i<4; i++){
            System.out.print(x[i]);
            if (i!=3){
                System.out.print(", ");
            }
        }
    }
    static void ej2(){
        float[] x = new float[5];
        for (int i=0;i<5;i++){
            System.out.println("Escriba el numero nª" +(i+1));
            x[i] = sc.nextFloat();
        }
        System.out.print("Los numeros al reves son:");
        for (int i=4; i>=0; i--){
            System.out.print(x[i]);
            if (i!=0){
                System.out.print(", ");
            }
        }
    }
    static void ej3(){
        int x[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] n = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "sepriembre", "octubre", "noviembre", "diciembre"};
        System.out.println("¿Que mes quieres visualizar?");
        int r=(sc.nextInt()-1);
        if (r<=11){
            System.out.println(n[r] +" es el mes numero " +(r+1) +" y tiene " +x[r] +" dias");
        } else {
            System.out.println((r+1) +" no es un mes del año, escribe un numero del 1 al 12");
        }
    }
    static void ej4(){
        float[] x = new float[6];
        for (int i=0;i<6;i++){
            System.out.println("Escriba el numero nª" +(i+1));
            x[i] = sc.nextFloat();
        }
        System.out.print("Los numeros al reves son: ");
        for (int i=5; i>=0; i--){
            System.out.print(x[i]);
            if (i!=0){
                System.out.print(", ");
            }
        }
    }
    static void ej5(){
        System.out.println("¿Con cuantos numeros quieres operar?");
        int num =sc.nextInt();
        float m=0;
        float[] x= new float[num];
        for (int i=0;i<num;i++){
            System.out.println("Escribe el numero nº" +(i+1));
            x[i]=sc.nextFloat();
            m=m+x[i];
        }
        m=m/num;
        System.out.print("La media de los " +num +" números: ");
        for (int i=0;i<num;i++){
            System.out.print(x[i]);
            if (i!=(num-1)){
                System.out.print(", ");
            }
        }
        System.out.print(" es " +m);
        System.out.println();

    }
    static void ej6(){
        float[] x = new float[10];
        float m = 0;
        for (int i=0;i<10;i++){
            System.out.println("Escriba el numero nª" +(i+1));
            x[i] = sc.nextFloat();
            m=m+x[i];
        }
        m=m/10;
        System.out.println("La media de los 10 numeros es " +m);
        System.out.print("Y los numeros que estan por encima de esta media son: ");
        for (int i=0;i<10;i++){
            if (x[i] > m){
                System.out.print(x[i] +", ");
            }
        }
        System.out.println();
    }
    static void ej7(){
        int t=0;
        int[] x = {31, 28, 31, 30, 31, 30 ,31 ,31, 30, 31, 30, 31};
        String[] n = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "sepriembre", "octubre", "noviembre", "diciembre"};
        System.out.println("Indique el mes en numero");
        int mes=sc.nextInt();
        System.out.println("Indique el dia");
        int dia=sc.nextInt();
        for (int i=0;i<(mes-1);i++){
            t=t+x[i];
        }
        t=t+dia;
        System.out.println("El dia " +dia +" de " +n[mes-1] +" es el dia " +t +" del año");
    }
    static void ej8(){
        int t=0;
        int[] x = {31, 28, 31, 30, 31, 30 ,31 ,31, 30, 31, 30, 31};
        String[] n = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "sepriembre", "octubre", "noviembre", "diciembre"};
        System.out.println("Indique el mes en numero");
        int mes=sc.nextInt();
        System.out.println("Indique el dia");
        int dia=sc.nextInt();
        for (int i=0;i<(mes-1);i++){
            t=t+x[i];
        }
        t=t+dia;
        t=365-t;
        System.out.println("Desde l dia " +dia +" de " +n[mes-1] +" hasta el final del año quedan " +t +" dias");
    }
    static void ej9() {
        String[] x = new String[10];
        boolean si = false;
        for (int i = 0; i < 10; i++) {
            System.out.println("Escriba el nombre nª" + (i + 1));
            x[i] = sc.nextLine();
        }
        String y = "a";
        while (!y.equals("fin")){
            si=false;
            System.out.println("Escriba un nombre y te diré si esta en los 10 que has indicado antes (para salir escriba fin)");
            y = sc.nextLine();
            for (int i = 0; i < 10; i++) {
                if (x[i].equals(y)){
                    si=true;
                }
            }
            if (si){
                System.out.println(y +" si está en la lista");
            } else if (!y.equals("fin")){
                System.out.println(y +" no esta en la lista");
            }
        }

    }
    static void ej10(){
        boolean cero=true;
        String[] x = new String[10];
        int i=0;
        while (cero){
            System.out.println("Escriba el nombre nº " +(i+1));
            x[i] = sc.nextLine();
            if (i==9 || x[i].equals("0")){
                cero=false;
            }
            i++;
        }
        if (x[i-1].equals("0")){
            i--;
        }
        System.out.println("Has escrito "+(i) +" nombres, los cuales son: ");
        for (int j=0; j<i;j++){
            System.out.print(x[j]);
            if (j!=i-1){
                System.out.print(", ");
            }
        }
    }
    static void ej11(){
        double[] x = new double[3];
        double y = 0;
        for (int i=0; i<3; i++){
            System.out.println("Indique el valor nº " +(i+1));
            x[i]= sc.nextInt();
            x[i]= x[i]*x[i];
        }
        for (int i=0; i<3; i++){
            y=y+x[i];
            x[i]=Math.sqrt(x[i]);
        }
        System.out.println();
        System.out.print("La raiz cuadrada de los numeros ");
        for (int i=0; i<3; i++){
            System.out.print(x[i]);
            if (i!=2){
                System.out.print(", ");
            }
        }
        System.out.print(" es la raiz cuadradada de " +y +" que es ");
        System.out.println(Math.sqrt(y));
    }
    static void ej12(){
        int[] x = new int [3];
        int[] y = new int [3];
        System.out.println("Primer vector");
        for (int i=0; i<3; i++){
            System.out.println("Escriba el numero nº " +(i+1) +" del primer vector");
            x[i]=sc.nextInt();
        }
        for (int i=0; i<3; i++){
            System.out.println("Escriba el numero nº " +(i+1) +" del segundo vector");
            y[i]=sc.nextInt();
        }
        System.out.println();
        System.out.print("El vector resultante es [");
        for (int i=0; i<3; i++){
            System.out.print(x[i] + y[i]);
            if (i!=2){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    public static void main(String[] args) throws InterruptedException {
        int repet = 0;
        while (repet == 0) {
            System.out.println(" ");
            System.out.println("Elije que ejercicio va a ejecutar");
            System.out.println("(Para cerrar el bucle pulse 13)");
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
                    ej8();
                    break;
                case 9:
                    ej9();
                    break;
                case 10:
                    ej10();
                    break;
                case 11:
                    ej11();
                    break;
                case 12:
                    ej12();
                    break;
                case 13:
                    repet = 1;
                    break;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(2000);
        }
    }
}