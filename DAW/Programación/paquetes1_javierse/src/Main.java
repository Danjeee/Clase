import matematicas.Varias;
import matematicas.Geometria;
import java.util.Scanner;


import static java.lang.Thread.sleep;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    static void ej3(int x){
        System.out.println(" NUMEROS PRIMOS ");
        System.out.println();
        for (int i = 1; i<=1000; i++){
            if (matematicas.Varias.esPrimo(i)){
                System.out.print(i +" ");
            }
        }
        System.out.println();
        System.out.println(" NUMEROS CAPICUA ");
        System.out.println();
        for (int i = 1; i<=99999; i++){
            if (matematicas.Varias.esCapicua(i)){
                System.out.print(i +" ");
            }
        }
        System.out.println();
        System.out.println(" BINARIO A DECIMAL ");
        System.out.println();
        String b = String.valueOf(x);
        int suma = 0;
        int ii = 0;
        String cero = "";
        if (Integer.parseInt(String.valueOf(b.charAt(b.length()-1))) == 0){
            ii = 1;
            cero = "0";
        }
        b = String.valueOf(Varias.voltea(Integer.parseInt(b)));
        for (int i = 0; i<b.length(); i++){
            if (Integer.parseInt(String.valueOf(b.charAt(i))) == 1){
                suma+=matematicas.Varias.potencia(2,(i+ii));
            }
        }
        b = String.valueOf(Varias.voltea(Integer.parseInt(b)));
        System.out.println(b +cero +" en decimal es " +suma);
    }
    public static void main(String[] args) throws InterruptedException {
        int repet = 0;
        while (repet == 0) {
            System.out.println(" ");
            System.out.println("Elije que ejercicio va a ejecutar");
            System.out.println("(Para cerrar el bucle pulse 16)");
            int menu = sc.nextInt();
            System.out.println("Escriba un numero(si es el 15, escriba el numero en binario): ");
            int x = sc.nextInt();
            switch (menu) {
                case 1:
                    if(matematicas.Varias.esCapicua(x)){
                        System.out.println(x +" es capicua");
                    } else {
                        System.out.println(x + " no es capicua");
                    }
                    break;
                case 2:
                    if (matematicas.Varias.esPrimo(x)){
                        System.out.println(x +" es primo");
                    } else {
                        System.out.println(x + " no es primo");
                    }
                    break;
                case 3:
                    System.out.println(matematicas.Varias.sigPrimo(x));
                    break;
                case 4:
                    System.out.println("Exponente: ");
                    int e = sc.nextInt();
                    System.out.println(matematicas.Varias.potencia(x,e));
                    break;
                case 5:
                    System.out.println(matematicas.Varias.digitos(x));
                    break;
                case 6:
                    System.out.println(matematicas.Varias.voltea(x));
                    break;
                case 7:
                    System.out.println(matematicas.Varias.digitoN(x));
                    break;
                case 8:
                    System.out.println(matematicas.Varias.posisicionDeDigito(x));
                    break;
                case 9:
                    System.out.println(matematicas.Varias.quitaPorDetras(x));
                    break;
                case 10:
                    System.out.println(matematicas.Varias.quitaPorDelante(x));
                    break;
                case 11:
                    System.out.println(matematicas.Varias.pegaPorDetras(x));
                    break;
                case 12:
                    System.out.println(matematicas.Varias.pegaPorDelante(x));
                    break;
                case 13:
                    System.out.println(matematicas.Varias.trozoDeNumero(x));
                    break;
                case 14:
                    System.out.println(matematicas.Varias.juntaNumeros(x));
                    break;
                case 15:
                    ej3(x);
                    break;
                case 16:
                    repet = 1;
                    break;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(2000);
        }
    }
}