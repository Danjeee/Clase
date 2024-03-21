import java.util.Scanner;


public class ExcepcionesUsu_JavierSE {
    static Scanner sc = new Scanner(System.in);

    public static void rango(int num) throws ExcepcionIntervalo {
        if ((num > 100) || (num < 0)) {
            throw new ExcepcionIntervalo("Número fuera del intervalo");
        }
    }

    private static int divide() {
        int numerador, denominador, resultado = 0;
        boolean corr = false;
        String respuesta = "";
        while (!corr) {
            corr = true;
            System.out.println("Introduce dos números enteros");
            String str1 = sc.next();
            String str2 = sc.next();

            try {
                numerador = Integer.parseInt(str1);
                denominador = Integer.parseInt(str2);
                rango(numerador);
                rango(denominador);
                resultado = numerador / denominador;
                respuesta = String.valueOf(resultado);
            } catch (NumberFormatException ex) {
                respuesta = "Se han introducido caracteres no numéricos";
                corr = false;
            } catch (ArithmeticException ex) {
                respuesta = "División entre cero";
                corr = false;
            } catch (ExcepcionIntervalo ex) {
                respuesta = ex.getMessage();
                corr = false;
            }
            System.out.println(respuesta);
        }
        
        return resultado;
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Seleccione un ejercicio (3 para cerrar)");
            int menu = sc.nextInt();
            switch (menu) {
                case 1 -> {
                    System.out.println("El resultado es  " + divide());
                }
            }
        }
    }
}