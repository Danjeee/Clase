import java.util.Objects;
import java.util.Scanner;
import static java.lang.Thread.sleep;

public class ejercicioscond_javierse {

    static Scanner sc = new Scanner(System.in);
    static void ej1(){
        System.out.println("Escribe un numero");
        int a = sc.nextInt();
        System.out.println("Escribe otro numero");
        int b = sc.nextInt();
        if (a > b){
            System.out.println(a +" es el mayor");
        } else{
            System.out.println(b +" es el mayor");
        }
    }
    static void ej2(){
        int x = 3;
        int xx= x+1;
        int y = 2;
        int j = 1;
        double b = -9999999;
        int c = 0;
        double[] m = new double[x+1];
        double[] a = new double[x+1];
        double mayor = 2;
        System.out.println("Escribe un numero");
        a[1] = sc.nextDouble();
        while (y != x+1){
            System.out.println("Escribe otro numero");
            a[y] = sc.nextDouble();
            y=y+1;
        }
        while (j != xx) {
            x = xx-1;
            while (x != 0) {
                if (a[x] > b) {
                    b = a[x];
                    c = x;
                }
                x = x - 1;
            }
            m[j] = b;
            a[c] = 0;
            b=-999999;
            j=j+1;
        }
        j=1;
        while (j != xx){
            System.out.print(m[j] +", ");
            j=j+1;
        }
        System.out.println(" ");

    }
    static void ej3(){
        int x = 0;
        int xy = 0;
        while (x != 1){
            System.out.println("Escribe un numero del 0 al 99999");
            xy = sc.nextInt();
            if (xy<0 || xy>99999){
                System.out.println(xy +" no es un número valido, intentelo de nuevo");
            } else {
                x=1;
            }
        }
        String yy = String.valueOf(xy);
        System.out.println("El número " +xy +" tiene " +yy.length() +" cifras");

    }
    static void ej4(){
        String nom="Javierse";
        String psw="4522";
        int nomc=0;
        int pswc=0;
        int c=0;
            while (c != 2) {
                c=0;
                System.out.println("Iniciar sesión");
                System.out.print("Nombre de usuario: ");
                nom = sc.nextLine();
                if (Objects.equals(nom, "Javierse")) {
                    nomc = 1;
                    c++;
                } else {
                    nomc = 0;
                }
                System.out.println(" ");
                System.out.print("Contraseña: ");
                psw = sc.nextLine();
                if (Objects.equals(psw, "4522")) {
                    pswc = 1;
                    c++;
                } else {
                    pswc = 0;
                }
                if (nomc == 0) {
                    System.out.println("Nombre de usuario incorrecto, intentelo de nuevo");
                }
                if (pswc == 0) {
                    System.out.println("Contraseña incorrecta, intentelo de nuevo");
                }
        }
        System.out.println("Sesión iniciada, bienvenid@ " +nom);
    }
    static void ej5(){
        double dto=0;
        double pf=0;
        int y=0;
        System.out.println("Inserte el precio base");
        double x = sc.nextDouble();
        System.out.println("¿Como se realiza el pago?");
        System.out.println("1.- Contado");
        System.out.println("2.- Tarjeta");
        y = sc.nextInt();
        switch (y){
            case 1:
                System.out.println("El pago se realiza al contado, se aplica un 7% de descuento");
                dto=(x*7/100);
                pf=x-dto;
                System.out.println("El precio final es de " +pf +", aplicando " +dto +"€ de descuento a " +x);
            case 2:
                System.out.println("El pago se realiza con tarjeta, se incrementa el precio un 2%");
                dto=(x*2/100);
                pf=x+dto;
                System.out.println("El precio final es de " +pf +", aumentando " +dto +"€ el precio de " +x);
        }
    }
    static void ej6(){
        int dia = 0;
        double precio = 0;
        int dto = 0;
        double total = 0;
        int repet = 0;
        while (repet==0) {
            System.out.println("Ingresa el precio de la compra: ");
            precio = sc.nextDouble();
            System.out.println("Inserte el dia de la semana (1-7)");
            dia = sc.nextInt();
            if (dia == 1 || dia == 3) {
                dto = 30;
                repet = 1;
            } else if (dia < 1 || dia > 7) {
                System.out.println(dia + " no es un dia válido, intentalo de nuevo");
                repet = 0;
            }
        }
            total = precio - ((precio*dto)/100);
        System.out.println("El precio a pagar es de " +total +" teniendo en cuenta que se aplica un descuento del " +dto +"% al precio de " +precio);

    }
    static void ej7(){
        int t = 0;
        System.out.println("Inserte la temperatura y te dire el clima que hace");
        t = sc.nextInt();
        if (t<=10){
            System.out.println("El clima es frío");
        } else if (t>10 && t<=20) {
            System.out.println("El clima es templado");
        } else if (t>20 && t<=30) {
            System.out.println("El clima es Caluroso");
        }else {
            System.out.println("El clima es tropical");
        }
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
