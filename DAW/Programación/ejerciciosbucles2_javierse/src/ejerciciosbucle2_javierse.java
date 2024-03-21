import java.util.Scanner;
import static java.lang.Thread.sleep;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ejerciciosbucle2_javierse {
    static Scanner sc = new Scanner(System.in);

    static void ej1() {
        int[] x = new int[12];
        int neg = 0;
        int i = 0;
        for (i = 0; i <= 10; i++) {
            System.out.println("Inserta un número");
            x[i] = sc.nextInt();
        }
        while (i != -1) {
            if (x[i] < 0) {
                neg++;
            }
            i--;
        }
        System.out.println("Habian " + neg + " numeros negativos");
    }

    static void ej2() {
        int[] x = new int[7];
        int sus = 0;
        int i = 0;
        for (i = 1; i <= 5; i++) {
            System.out.println("Inserta la nota del alumno " + i);
            x[i] = sc.nextInt();
        }
        while (i != -1) {
            if (x[i] < 5) {
                sus++;
            }
            i--;
        }
        System.out.println("Hay un total de " + sus + " suspensos");
    }

    static void ej3() {
        // Variables //
        int suma, i, j = 0;
        // Comienzo //
        for (i = 3; i >= 0; i--) {
            for (j = 3; j >= 0; j--) {
                suma = i + 10 + j;
                System.out.println(suma);
            }
        }
    }

    static void ej4() {
        // Variables //
        int i, j = 0;
        // Comienzo //
        for (i = 1; i != 3; i++) {
            j = i + 1;
            while (j < 4) {
                System.out.println(j - 1);
                j++;
            }
        }
    }

    static void ej5() {
        int b, h, x = 0;
        System.out.println("¿Cuantos * quieres que hayan por lado?");
        x = sc.nextInt();
        h = x;
        b = x;
        while (h != 0) {
            while (b != 0) {
                System.out.print("*");
                b--;
            }
            h--;
            b = x;
            System.out.println(" ");
        }
    }

    static void ej6() {
        String a = null;
        for (int i = 0; i != 10; i++) {
            if (i == 3) {
                a = "E";
            } else {
                a = String.valueOf(i);
            }
            for (int j = 0; j != 5; j++) {
                System.out.print(a);
                if (j != 4) {
                    System.out.print("-");
                }
            }
            System.out.println(" ");
        }
    }

    static void ej7() {
        System.out.println("Inserte un numero");
        int x = sc.nextInt();
        int suma = 0;
        boolean primo = true;
        for (int i = 2; i < x; i++) {
            primo = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if ((i % j) == 0) {
                    primo = false;
                }
            }
            if (primo) {
                suma++;
            }
        }

        System.out.println("Hay " + suma + " numeros primos entre 1 y " + x);
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