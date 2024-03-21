import java.util.Scanner;

public class Poo1_Javierse {
    static Scanner sc = new Scanner(System.in);

    static void ej1() {
        Cafetera_javierse cafe1 = new Cafetera_javierse();
        boolean a = true;
        while (a) {
            System.out.println("""
                    Menu
                    1.- Ver cafetera
                    2.- llenar cafetera
                    3.- servir taza
                    4.- vaciar cafetera
                    5.- agregar cafe
                    6.- cerrar""");

            int menu = sc.nextInt();
            int cant = 0;
            switch (menu) {
                case 1:
                    System.out.println(cafe1.getActual() + " / " + cafe1.getMAX());
                    break;
                case 2:
                    cafe1.llenarCafetera();
                    System.out.println("Se ha llenado la cafetera");
                    break;
                case 3:
                    System.out.println("Indica la cantidad de la taza a servir");
                    cant = sc.nextInt();
                    cafe1.servirTaza(cant);
                    break;
                case 4:
                    cafe1.VaciarCafetera();
                    break;
                case 5:
                    System.out.println("Cuanto cafe quieres añadir?");
                    cant = sc.nextInt();
                    cafe1.agregarCafe(cant);
                    break;
                case 6:
                    a=false;
                    break;
                default:
                    System.out.println(menu + " no es una opcion");
                    break;
            }
        }

    }
    public static void main(String[] args) {
        ej1();
    }
}