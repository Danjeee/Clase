import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ejerciciosbucleclase_javierse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rand = (int)(Math.random()*100);
        boolean ad = false;
        while (!ad) {
            System.out.println("Ingrese un numero entre el 0 y el 100");
            int r = sc.nextInt();
            if (r == rand){
                ad = true;
            }
        }

    }
}