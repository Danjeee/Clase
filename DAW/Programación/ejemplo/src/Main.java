import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        final double PUL=2.54;
        double a;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un número en cm para pasar a pulgadas");
        a = sc.nextDouble();
        System.out.print("El resultado es: ");
        System.out.printf("%.2f", a/PUL);
        System.out.println(" Pulgadas");
    }
}