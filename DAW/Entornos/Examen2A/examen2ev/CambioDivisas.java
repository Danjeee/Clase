package examen2ev;

/**
 *
 * @author mcsafont Ejercicio 3: Refacorización
 */
import java.util.Scanner;

public class CambioDivisas {
    static Scanner scanner = new Scanner(System.in);
    static final double EuroADolar = 1.07;
    static final double DolarAEuro = 0.93;

    static double pedirDivisas(String a){
        System.out.println(a);
        return scanner.nextDouble();
    }
    static double conversion(char tipoDivisa, double divisaOriginal){
        if (tipoDivisa=='e') {
            return divisaOriginal*EuroADolar;
        } else if(tipoDivisa=='d') {
            return divisaOriginal*DolarAEuro;
        } else {
            return 0;
        }
        //De esta manera, solo bastará con añadir else-if si queremos añadir otro tipo de moneda
    }

    public static void main(String[] args) {
        System.out.println("Seleccione la Divisa a cambiar (E/D):");
        char d1 = scanner.next().toLowerCase().charAt(0);

        // Cambiar de Euros a Dolares
        switch (d1) {
            case 'e' -> {
                String NombreDivisa = "Euros";
                double divisaOriginal = pedirDivisas("Introduce la cantidad en "+NombreDivisa+":");
                double divisaFinal = conversion(d1, divisaOriginal);
                System.out.println(divisaOriginal + "€ son " + divisaFinal + "$");
            }
            case 'd' -> {
                String NombreDivisa = "Dolares";
                double divisaOriginal = pedirDivisas("Introduce la cantidad en "+NombreDivisa+":");
                double divisaFinal = conversion(d1, divisaOriginal);
                System.out.println(divisaOriginal + "$ son " + divisaFinal + "€");
            }
            default -> {
                System.out.println("La divisa selecciona para realizar el cambio no existe.");
            }
        }
    }
}