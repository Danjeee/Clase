import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void ej1(){
        String cafe = "cafe";
        Cafetera cafetera = new Cafetera();
        boolean finish = false;
        while (!finish) {
            System.out.println("""
                    Menu
                    1.- Llenar Cafetera
                    2.- Servir taza
                    3.- Vaciar cafe
                    4.- Agregar cafe
                    5.- Ver cafetera
                    6.- Salir""");
            int menu = sc.nextInt();
            switch (menu) {
                case 1 -> cafetera.llenarCafetera();
                case 2 -> {
                    System.out.println("Cuanto quieres llenar la taza");
                    int cant = sc.nextInt();
                    cafetera.servirTaza(cant);
                }
                case 3 -> {
                    System.out.println("Estas seguro de tirar " + cafetera.getActual() + "ml de cafe?");
                    String res = sc.next();
                    res = res.toLowerCase();
                    if (res.equals("si")) {
                        cafetera.vaciarCafetera();
                        System.out.println("Cafetera vaciada");
                    } else {
                        System.out.println("ok");
                    }
                }
                case 4 -> {
                    System.out.println("Cuanto cafe quieres agregar");
                    int cant = sc.nextInt();
                    cafetera.agregarCafe(cant);
                }
                case 5 -> System.out.println(cafetera.getActual() + "/" + cafetera.getMAX());
                case 6 -> finish = true;
                default -> System.out.println(menu +"no es una opcion, vuelve a intentarlo");
            }
        }
    }
    public static void ej2(){
        Fraccion fraccion = new Fraccion();
        fraccion.determinar();
        boolean finish = false;
        while (!finish) {
            System.out.println("""
                    Menu
                    1.- Simplificar
                    2.- Invertir
                    3.- Multiplicar
                    4.- Dividir
                    5.- Mostrar
                    6.- Salir""");
            int menu = sc.nextInt();
            switch (menu) {
                case 1 -> fraccion.Simplificar();
                case 2 -> fraccion.invertir();
                case 3 -> {
                    System.out.println("Por que numero quieres multiplicar");
                    int n = sc.nextInt();
                    fraccion.mult(n);
                }
                case 4 -> {
                    System.out.println("Por que numero quieres dividir");
                    int n = sc.nextInt();
                    fraccion.div(n);
                }
                case 5 -> fraccion.mostrar();
                case 6 -> finish = true;
                default -> System.out.println(menu + " no es una opcion, prueba de nuevo");
            }
        }
    }
    public static void main(String[] args){
        ej2();
    }
}