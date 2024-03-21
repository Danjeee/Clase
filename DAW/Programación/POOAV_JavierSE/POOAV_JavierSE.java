import java.util.Scanner;
import static java.lang.Thread.sleep;
import Ameba.Ameba;
import Animales.Animal;
import Animales.Canario;
import Animales.Gato;
import Animales.Mamifero;
import Animales.Perro;
import Expocoches.Zona;
import Terminal.Movil;
import Terminal.Terminal;
import Tiempo.Tiempo;
import Vehiculos.Bicicleta;
import Vehiculos.Coche;
import Vehiculos.Vehiculos;

public class POOAV_JavierSE {
    static Scanner sc = new Scanner(System.in);

    static void ej1() {
        System.out.println("Cuantas plazas tiene el coche");
        int plazas = sc.nextInt();
        System.out.println("Cuanta gasolina tiene en el deposito");
        int gas = sc.nextInt();
        System.out.println("Cual es su velocidad maxima");
        int velmax = sc.nextInt();
        System.out.println("La bicicleata lleva ruedines?");
        String res = sc.next();
        res = res.toLowerCase();
        boolean ruedines;
        if (res.equals("si")) {
            ruedines = true;
        } else {
            ruedines = false;
        }
        Coche coche = new Coche(gas, velmax, plazas);
        Bicicleta bici = new Bicicleta(ruedines);
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Vehiculos
                    ==============
                    1. Anda con bicicleta
                    2. Haz el caballito con la bici
                    3. Anda con el coche
                    4. Quema rueda con el coche
                    5. Repostar gasolina
                    6. Ver km bici
                    7. Ver km coche
                    8. Ver km total
                    9. Salir
                    """);
            int menu = sc.nextInt();
            switch (menu) {
                case 1 -> {
                    System.out.println("Cuanto tiempo vas a pedalear?");
                    int km = sc.nextInt();
                    System.out.println("A que velocidad");
                    int vel = sc.nextInt();
                    bici.conducir(km, vel);
                }
                case 2 -> {
                    bici.cabakllito();
                }
                case 3 -> {
                    System.out.println("Cuanto tiempo vas a conducir?");
                    int vel = sc.nextInt();
                    System.out.println("A que velocidad");
                    int km = sc.nextInt();
                    coche.conducir(km, vel);
                }
                case 4 -> {
                    System.out.println("Cuanto tiempo vas a conducir?");
                    int vel = sc.nextInt();
                    System.out.println("A que velocidad");
                    int km = sc.nextInt();
                    coche.quemarRueda(km, vel);
                }
                case 5 -> {
                    System.out.println("Con cuanta gasolina vas a llenar el deposito");
                    int gasoil = sc.nextInt();
                    coche.setGasolina(gasoil);
                }
                case 6 -> {
                    bici.verKilometrajeThis();
                }
                case 7 -> {
                    coche.verKilometrajeThis();
                }
                case 8 -> {
                    System.out.println("Km totales: " + Vehiculos.kilometrosTotales);
                }
                case 9 -> {
                    exit = true;
                }

                default -> {
                    System.out.println(menu + " no es una opcion valida, intentalo de nuevo");
                }
            }
        }
    }

    static void ej2() {
        Gato gato = new Gato("M", "Persia");
        Perro perro = new Perro("Bulldog", "F");
        Canario can = new Canario("M", "Rosa");
        can.cantar();
        gato.procrear();
        perro.procrear();
        can.procrear();
        gato.trepar();
        perro.perseguirGato();
    }

    static void ej3() {
        Tiempo t = new Tiempo(0, 0, 0);
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Menu
                    1.- Sumar
                    2.- Restar
                    3.- Mostrar
                    4.- Salir
                    """);
            int menu = sc.nextInt();
            switch (menu) {
                case 1 -> {
                    System.out.println("H: ");
                    int h = sc.nextInt();
                    System.out.println("M: ");
                    int m = sc.nextInt();
                    System.out.println("S: ");
                    int s = sc.nextInt();
                    t.sumar(h, m, s);
                }
                case 2 -> {
                    System.out.println("H: ");
                    int h = sc.nextInt();
                    System.out.println("M: ");
                    int m = sc.nextInt();
                    System.out.println("S: ");
                    int s = sc.nextInt();
                    t.restar(h, m, s);
                }
                case 3 -> {
                    t.mostrar();
                }
                case 4 -> {
                    exit = true;
                }

                default -> {
                    System.out.println(menu + " no es una opcion");
                }
            }
        }
    }

    static void ej4() {
        Zona principal = new Zona(1000);
        Zona cv = new Zona(200);
        Zona vip = new Zona(25);
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Menu
                    1.- Ver zonas
                    2.- Comprar entradas
                    3.- Salir
                    """);
            int menu = sc.nextInt();
            switch (menu) {
                case 1 -> {
                    System.out.println("Zona principal: " + principal.getEntradasPorVender() + "/1000");
                    System.out.println("Zona compra-venta: " + cv.getEntradasPorVender() + "/200");
                    System.out.println("Zona vip: " + vip.getEntradasPorVender() + "/25");
                }
                case 2 -> {
                    System.out.println("""
                            De que zona quiere comprarlas
                            1.- Principal
                            2.- Compra-Venta
                            3.- VIP
                            """);
                    int venta = sc.nextInt();
                    System.out.println("Cuantas quiere comprar");
                    int cant = sc.nextInt();
                    switch (venta) {
                        case 1 -> {
                            principal.vender(cant);
                        }
                        case 2 -> {
                            cv.vender(cant);
                        }
                        case 3 -> {
                            vip.vender(cant);
                        }
                    }
                }
                case 3 -> {
                    exit = true;
                }
                default -> {
                    System.out.println(menu + " no es una opcion valida");
                }
            }
        }
    }

    static void ej5() {
        Terminal t1 = new Terminal("678 11 22 33");
        Terminal t2 = new Terminal("644 74 44 69");
        Terminal t3 = new Terminal("622 32 89 09");
        Terminal t4 = new Terminal("664 73 98 18");
        System.out.println(t1);
        System.out.println(t2);
        t1.print();
        t2.print();
        t1.llama(t2, 320);
        t1.llama(t3, 200);
        t1.print();
        t2.print();
        t3.print();
        t4.print();

    }

    static void ej6() {
        Movil m1 = new Movil("678 11 22 33", "rata");
        Movil m2 = new Movil("644 74 44 69", "mono");
        Movil m3 = new Movil("622 32 89 09", "bisonte");
        m1.print();
        m2.print();
        m1.llama(m2, 320);
        m1.llama(m3, 200);
        m2.llama(m3, 550);
        m1.print();
        m2.print();
        m3.print();
    }

    static void ej7() {
        Ameba a1 = new Ameba();
        a1.come(2);
        System.out.println(a1);
        Ameba a2 = new Ameba();
        a2.come(4);
        System.out.println(a2);
        a1.come(a2);
        System.out.println(a1);
        System.out.println(a2);
        a2.come(3);
        System.out.println(a2);
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