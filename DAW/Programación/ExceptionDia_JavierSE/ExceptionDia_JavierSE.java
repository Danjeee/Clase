import java.util.Scanner;

public class ExceptionDia_JavierSE {
    static Scanner sc = new Scanner(System.in);

    private static int divide() {
        int num = sc.nextInt();
        int den = sc.nextInt();
        return num / den;
    }

    private static Double convertirStringADouble() {
        System.out.println("Introduce un número que quiera convertir");
        String num = sc.next();
        return Double.parseDouble(num);
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Seleccione un ejercicio (3 para cerrar)");
            int menu = sc.nextInt();
            switch (menu) {
                case 1 -> {
                    boolean corr = false;
                    int res = 0;
                    while (!corr) {
                        corr = true;
                        try {
                            res = divide();
                        } catch (ArithmeticException e) {
                            System.out.println("No se puede dividir entre 0, intentalo de nuevo");
                            corr = false;
                        }
                    }
                    System.out.println("El resultado es " + res);
                }
                case 2 -> {
                    boolean corr = false;
                    double res = 0;
                    while (!corr) {
                        corr = true;
                        try {
                            res = convertirStringADouble();
                        } catch (NumberFormatException e) {
                            System.out.println("Tiene que ser un numero, intentelo de nuevo");
                            corr = false;
                        }
                    }
                    System.out.println("El numero es " + res);
                }
                case 3 -> {
                    exit = true;
                }
                default -> {
                    System.out.println(menu + " no es una opcion valida, intentalo de nuevo");
                }
            }
        }
    }
}