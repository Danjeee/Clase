import java.util.Scanner;

import static java.lang.Thread.sleep;

public class ejercicios_javierse {
    static Scanner sc = new Scanner(System.in);
    static String a = "   Me gusta Java!   ";
    static String cad1 = "aaaaaabbbbbccccc";
    static String cad2 = "bbbbccccdddd";
    static String var = "En algun lugar de la Mancha";
    static void ej1() {
        System.out.println(a);
        System.out.println(a.length());
    }
    static void ej2(){
        String txtMayus = a.toUpperCase();
        System.out.println(txtMayus);
    }
    static void ej3(){
        String b = a.trim();
        System.out.println(b);
    }
    static void ej4(){
        String txtMinus = a.toLowerCase();
        System.out.println(txtMinus);
    }
    static void ej5(){
        String txtMinus = a.toLowerCase();
        String txtMayus = a.toUpperCase();
        int comp = txtMayus.compareTo(txtMinus);
        System.out.println(comp);
        if (comp != 0) {
            System.out.println(txtMayus + " y " + txtMinus + " son diferentes");
        }else {
            System.out.println(txtMayus +" y " +txtMinus +" son iguales");
        }
    }
    static void ej8(){
        int l1 = cad1.charAt(1);
        int l2 = cad2.charAt(1);
        if (l1<l2){
            System.out.println("La cadena " +cad1 +" va antes alfabeticamente que la cadena " +cad2);
        } else {
            System.out.println("La cadena " +cad2 +" va antes alfabeticamente que la cadena " +cad1);
        }

    }
    static void ej9(){
        int dis = var.indexOf("m");
        int dis2 = var.indexOf("M");
        if (dis >= 0 || dis2 >= 0){
            System.out.println(var +" tiene al menos una m");
        } else {
            System.out.println(var +" no tiene ni una m");
        }
    }
    static void ej10(){
        String i = "a";
        int x = 6;
        while (x != 11){
            i = String.valueOf(var.charAt(x));
            System.out.print(i);
            x++;
        }
    }
    static void ej11(){
        String i = "a";
        int x = 0;
        while (x != var.length()) {
            i = String.valueOf(var.charAt(x));
            if (i.equals("a")) {
                i = "o";
            }
            System.out.print(i);
            x++;
        }
    }
    static void ej12() {
        String e12 = "dabale arroz a la zorra el abad";
        String i = "a";
        int x = e12.length() - 1;
        while (x != -1) {
            i = String.valueOf(e12.charAt(x));
            System.out.print(i);
            x = x - 1;
        }
    }
    static void ej13(){
        String e13 = "Estoy estudiando Java en el IES Camp de Morvedre";
        String i = "a";
        int x = 0;
        while (x != e13.length()) {
            i = String.valueOf(e13.charAt(x));
            if (i.equals(" ")){
            } else {
                System.out.print(i);
            }
            x = x + 1;
        }
    }
    static void ej14(){
        String jun = "www.google.es";
        String sep1 = jun.substring(0,7);
        String sep2 = jun.substring(8,13);
        System.out.println(sep1);
        System.out.println(sep2);
        jun = sep1 + sep2;
        System.out.println(jun);
    }
    public static void main(String[] args) throws InterruptedException {
        int repet = 0;
        while (repet == 0) {
            System.out.println(" ");
            System.out.println("Elije que ejercicio va a ejecutar");
            System.out.println("(Para cerrar el bucle pulse 15, el ejercicio 6 y 7 estan como variables estáticas)");
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
                    ej13();
                    break;
                case 14:
                    ej14();
                    break;
                case 15:
                    repet = 1;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(2000);
        }
    }
}