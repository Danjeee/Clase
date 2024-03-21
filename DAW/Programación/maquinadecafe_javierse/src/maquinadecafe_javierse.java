import java.util.Scanner;
import static java.lang.Thread.sleep;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class maquinadecafe_javierse {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int cafe;
        int x = 0;
        String name=null;
        do {
            System.out.println("Elije una opción");
            System.out.println("1.- Café Solo");
            System.out.println("2.- Café con leche");
            System.out.println("3.- Café cortado");

            cafe=sc.nextInt();
            switch (cafe){
                case 1: System.out.println("Preparando café solo");
                        name="café solo";
                        break;
                case 2: System.out.println("Preparando café con leche");
                        name="café con leche";
                        break;
                case 3: System.out.println("Preparando café cortado");
                        name="café cortado";
                        break;
                default: System.out.println("Lo siento, ese café no esta disponible");
            }
        }while (cafe<1 || cafe>3);
        while (x!=5){
            System.out.println(".");
            x++;
            sleep(1000);
        }
        System.out.println("Su " +name +" está listo");
    }
}