import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Thread.sleep;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class arrayshabituales_javierse {
    static Scanner sc = new Scanner(System.in);
    static void ej1(){
        int[] a = {0,1,2,2,3,4,4,4};
        int cont=0;
        System.out.println("Introduzca un numero y comprobaremos si se encuentra (Están los numeros 0,1,2,3,4)");
        int b= sc.nextInt();
        for (int i=0; i<a.length; i++){
            if (a[i]==b){
                cont++;
            }
        }
        if (cont==0){
            System.out.println("El dato " +b +" no se encuentra");
        } else {
            System.out.println("El dato " +b +" se ha encontrado " +cont +" veces");
        }
    }
    static void ej2(){
        ArrayList<Integer> a = new ArrayList<Integer>();
        int[] b = {0,1,2,2,3,4,4,4};
        for (int i=0; i<b.length; i++){
            a.add(i, b[i]);
        }
        int cont=0;
        System.out.println("Introduzca un dato para añadir a los existentes");
        a.add(sc.nextInt());
        System.out.println("Introduzca un numero y comprobaremos si se encuentra (Están los numeros 0,1,2,3,4)");
        int c= sc.nextInt();
        for (int i=0; i<a.size(); i++){
            if (a.get(i)==c){
                cont++;
            }
        }
        if (cont==0){
            System.out.println("El dato " +c +" no se encuentra");
        } else {
            System.out.println("El dato " +c +" se ha encontrado " +cont +" veces");
        }
    }
    static void ej3(){
        int[] a = {0,1,2,2,3,4,4,4};
        int cont=0;
        System.out.println("Introduzca un dato para cambiarlo en una poscion");
        int dato=sc.nextInt();
        System.out.println("Introduzca la posicion");
        int pos= sc.nextInt();
        boolean si=false;
        while (!si) {
            if (pos > a.length || pos < 0) {
                System.out.println(pos + " esta fuera de los limites de la array, intentalo de nuevo");
                pos= sc.nextInt();
            } else {
                si=true;
                a[pos]=dato;
            }
        }
        System.out.println("Introduzca un numero y comprobaremos si se encuentra (Están los numeros 0,1,2,3,4)");
        int b= sc.nextInt();
        for (int i=0; i<a.length; i++){
            if (a[i]==b){
                cont++;
            }
        }
        if (cont==0){
            System.out.println("El dato " +b +" no se encuentra");
        } else {
            System.out.println("El dato " +b +" se ha encontrado " +cont +" veces");
        }
    }
    static void ej4(){
        int[] a = {0,1,2,2,3,4,4,4};
        int cont=0;
        System.out.println("Introduzca la posicion de la que quiere eliminar el dato (se cambiara por un 0)");
        int pos= sc.nextInt();
        boolean si=false;
        while (!si) {
            if (pos > a.length || pos < 0) {
                System.out.println(pos + " esta fuera de los limites de la array, intentalo de nuevo");
                pos= sc.nextInt();
            } else {
                si=true;
                a[pos]= -1;
            }
        }
        System.out.println("Introduzca un numero y comprobaremos si se encuentra (Están los numeros 0,1,2,3,4)");
        int b= sc.nextInt();
        for (int i=0; i<a.length; i++){
            if (a[i]==b){
                cont++;
            }
        }
        if (cont==0){
            System.out.println("El dato " +b +" no se encuentra");
        } else {
            System.out.println("El dato " +b +" se ha encontrado " +cont +" veces");
        }
    }
    static void ej5(){
        String[] a = new String[10];
        int ult=0;
        int pos=0;
        String b=null;
        boolean si=false;
        boolean rep=true;
        while (rep){
        si=false;
        System.out.println("Menu");
        System.out.println("1.- Añadir un dato al final");
        System.out.println("2.- Añadir un dato en una posición");
        System.out.println("3.- Borrar el dato en x posición");
        System.out.println("4.- Mostrar array");
        System.out.println("5.- Cerrar");
        int menu = sc.nextInt();
        switch (menu) {
            case 1:
                System.out.println("Escriba el nombre (Reemplazara el ultimo en caso de estar llena)");
                sc.nextLine();
                a[ult] = sc.nextLine();
                if (ult !=9){
                    ult++;
                }
                break;
            case 2:
                System.out.println("Escriba la posicion (Reemplazara al ultimo en caso de estar llena)");
                pos = sc.nextInt();
                pos--;
                while (!si) {
                    if (pos > a.length || pos < 0) {
                        System.out.println(pos+1 + " esta fuera de los limites de la array, intentalo de nuevo");
                        pos = sc.nextInt();
                        pos--;
                    } else {
                        for (int i = a.length-1; i > pos; i--) {
                            a[i] = a[i - 1];
                        }
                        System.out.println("Escriba el nombre que quiere que vaya en esa posición");
                        if (pos>ult){
                            sc.nextLine();
                            a[ult] = sc.nextLine();
                        } else {
                            sc.nextLine();
                            a[pos] = sc.nextLine();
                        }
                        if (ult !=9){
                            ult++;
                        }
                        si = true;
                    }
                }
                break;
            case 3:
                System.out.println("Que posicion quiere borrar");
                pos = sc.nextInt();
                pos--;
                while (!si) {
                    if (pos > a.length || pos < 0) {
                        System.out.println(pos+1 + " esta fuera de los limites de la array, intentalo de nuevo");
                        pos = sc.nextInt();
                        pos--;
                    } else {
                        for (int i = pos; i < a.length; i++) {
                            if (i!=a.length-1){
                                a[i] = a[i + 1];
                            }
                        }
                        a[ult]=" ";
                        ult--;
                        si = true;
                    }
                }
                break;
            case 4:
                for (int i = 0; i < a.length; i++) {
                    System.out.print(a[i]);
                    if (i!=a.length-1){
                        System.out.print(", ");
                    }
                }
                System.out.println();
                break;
            case 5:
                rep=false;
                break;
            default:
                System.out.println(menu +" no es una opcion valida, intentalo de nuevo");
        }
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