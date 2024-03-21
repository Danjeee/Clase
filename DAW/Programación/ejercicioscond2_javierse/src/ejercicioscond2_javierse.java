import java.util.Locale;
import java.util.Scanner;
import static java.lang.Thread.sleep;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ejercicioscond2_javierse {
    static Scanner sc = new Scanner(System.in);
    static void ej1(){
        int num = 0;
        int pow = 0;
        double res = 0;
        System.out.println("Inserta un numero para calcular su potencia");
        num=sc.nextInt();
        System.out.println("Inserte el exponente");
        pow=sc.nextInt();
        if (pow == 0){
            res=1;
            System.out.println("El resultado es " +res);
        } else if (pow<0) {
            pow=Math.abs(pow);
            res=1/(Math.pow(num,pow));
            System.out.println("El resultado es " +res);
        }else {
            res=Math.pow(num,pow);
            System.out.println("El resultado es " +res);
        }
    }
    static void ej2(){
        int num = 0;
        int total = 0;
        System.out.println("¿Cuantos alumnos van al viaje?");
        num=sc.nextInt();
        if (num>=100){
            total=num*65;
            System.out.println("El costo total con " +num +" alumnos es " +total);
        } else if (num >= 50 && num <= 99) {
            total=num*70;
            System.out.println("El costo total con " +num +" alumnos es " +total);
        } else if (num >= 30 && num <=49){
            total=num*95;
            System.out.println("El costo total con " +num +" alumnos es " +total);
        } else {
            total=4000;
            System.out.println("El costo total con " +num +" alumnos es " +total);
        }
    }
    static void ej3(){
        int tiempo = 0;
        String dia = null;
        String turno = "a";
        double total = 0;
        int dto = 0;
        System.out.println("¿Cuanto tiempo ha durado la llamada? (en minutos)");
        tiempo=sc.nextInt();
        System.out.println("¿En que día se realizo la llamada?");
        dia=sc.nextLine();
        dia=dia.toLowerCase();
        if (!dia.equals("domingo")){
            System.out.println("¿En que turno se realizó la llamada? (mañana/tarde)");
            turno=sc.nextLine();
            turno=turno.toLowerCase();
        }
        if (tiempo<=5) {
            total=tiempo*1;
        } else if (tiempo > 5 && tiempo <=8) {
            total=tiempo*0.80;
        } else if (tiempo >8 && tiempo <=10) {
            total=tiempo*0.70;
        } else {
            total=tiempo*0.50;
        }
        if (turno.equals("mañana")){
            dto=15;
            total=total+((total*dto)/100);
        } else if (turno.equals("tarde")) {
            dto=10;
            total=total+((total*dto)/100);
        } else {
          dto=3;
          total=total+((total*dto)/100);
        }
        if (!dia.equals("domingo")){
            System.out.println("La llamada cuya duración es de " +tiempo +"min realizada un " +dia +" en el turno de" +turno +" tiene un costo total de " +total +"€");
        } else{
            System.out.println("La llamada cuya duración es de " +tiempo +"min realizada un " +dia +" tiene un costo total de " +total +"€");
        }
    }
    static void ej4(){
        double peso = 0;
        int lugar = 0;
        double total = 0;
        int corr=0;
        String nom = null;
        System.out.println("Introduzca el peso del paquete");
        peso=sc.nextDouble();
        if (peso>5){
            System.out.println("El paquete queda rechazado, no se admiten pesos superiores a 5kg");
        } else{
            while (corr==0) {
                System.out.println("¿En que zona se reparte el paquete?");
                System.out.println("1.- America del Norte");
                System.out.println("2.- America central");
                System.out.println("3.- America del Sur");
                System.out.println("4.- Europa");
                System.out.println("5.- Asia");
                lugar = sc.nextInt();
                switch (lugar) {
                    case 1:
                        total=peso*24;
                        nom = "America del Norte";
                        corr++;
                        break;
                    case 2:
                        total=peso*20;
                        nom="America central";
                        corr++;
                        break;
                    case 3:
                        total=peso*21;
                        nom="America del Sur";
                        corr++;
                        break;
                    case 4:
                        total=peso*10;
                        nom="Europa";
                        corr++;
                        break;
                    case 5:
                        total=peso*18;
                        nom="Asia";
                        corr++;
                        break;
                    default:
                        System.out.println(lugar +" no es una opcioón correcta, intentalo de nuevo");
                }
                System.out.println("El precio total del envio de un paquete de " +peso +"kg en " +nom +" es de " +total +"€");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int repet = 0;
        while (repet == 0) {
            System.out.println(" ");
            System.out.println("Elije que ejercicio va a ejecutar");
            System.out.println("(Para cerrar el bucle pulse 5)");
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
                    repet = 1;
                    break;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(2000);
        }
    }
}