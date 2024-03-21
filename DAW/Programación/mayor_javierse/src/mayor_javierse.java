import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class mayor_javierse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe 4 numeros y te dire cual es el mayor");
        int[] x = new int[4];
        for (int i=0; i<4; i++){
            System.out.println("Escriba el numero nº" +(i+1));
            x[i]=sc.nextInt();
        }
        int a=x[0];
        for (int i=0; i<4; i++){
            if (a<x[i]){
                a=x[i];
            }
        }
        System.out.print("El numero mas grande de los numeros ");
        for (int i=0;i<4;i++){
            System.out.print(x[i]);
            if (i!=3){
                System.out.print(", ");
            }
        }
        System.out.print(" es " +a);
    }
}