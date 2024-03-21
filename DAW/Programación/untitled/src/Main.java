// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        int cantidad;
        int a = 0;
        int e = 0;
        int o = 0;
        int u = 0;
        int i = 0;

        int num = 0;
        System.out.println("veces a comprobar");
        cantidad = sc.nextInt();

        for (int x = 0; x < cantidad; x++) {
            System.out.println("introduce una palabra");
            String palabra = sc1.nextLine();

            if (palabra.contains("a")){
                a = 1;
            }
            if (palabra.contains("e")){
                e = 1;
            }
            if (palabra.contains("o")){
                o = 1;
            }
            if (palabra.contains("u")){
                u = 1;
            }
            if (palabra.contains("i")){
                i = 1;
            }

            if (a + e + o + u + i >= 5){
                System.out.println("SI");

            } else {
                System.out.println("NO");
            }


        }
    }
}