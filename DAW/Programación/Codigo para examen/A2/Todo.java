import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Todo {
    static void leerString() throws CustomException {
        String res;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba un nombre y apellidos");
        String nombre = sc.next();
        try {
            if (Pattern.matches(".*\\d.*", nombre)) {
                System.out.println("aa");
                throw new CustomException("No puedes introducir numeros");
            }
            String apellido1 = sc.next();
            if (Pattern.matches(".*\\d.*", apellido1)) {
                System.out.println("aa");
                throw new CustomException("No puedes introducir numeros");
            }
            String apellido2 = sc.next();
            if (Pattern.matches(".*\\d.*", apellido2)) {
                System.out.println("aa");
                throw new CustomException("No puedes introducir numeros");
            }
            res = nombre + apellido1 + apellido2;
        } catch (CustomException e) {
            res = e.getMessage();
        }
        System.out.println(res);
    }

    static void leerInt() {
        Scanner sc = new Scanner(System.in);
        boolean corr = false;
        int num = 0;
        while (!corr) {
            System.out.println("Introduce un numero");
            try {
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Tienes que introducir un numero");
            }
            corr = true;
        }
        corr = false;
        int num2 = 0;
        while (!corr) {
            System.out.println("Introduce un numero");
            try {
                num2 = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Tienes que introducir un numero");
            }
            corr = true;
        }
        double div = 0;
        String res = "";
        try {
            div = num/num2;
            res += div;
        } catch (ArithmeticException e){
            res = "No puedes dividir entre 0";
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws CustomException {
        leerString();
        leerInt();
    }

}