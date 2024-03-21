import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class ArrayList_JavierSE {
    static Scanner sc = new Scanner(System.in);

    static void ej1() {
        ArrayList<String> compas = new ArrayList<String>();
        for (int i = 0; i < 6; i++) {
            System.out.println("Escribe un nombre");
            compas.add(sc.next());
        }
        for (String i : compas) {
            System.out.println(i);
        }
    }

    static void ej2() {
        Random r = new Random();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int sice = r.nextInt(10) + 10;
        for (int i = 0; i < sice; i++) {
            nums.add(r.nextInt(100));
        }
        System.out.println(nums);
        // suma
        int res = 0;
        for (int i : nums) {
            res += i;
        }
        System.out.println("Suma: " + res);
        // avg
        res /= nums.size();
        System.out.println("Media: " + res);
        nums.sort(Comparator.naturalOrder());
        System.out.println("Min: " + nums.get(0));
        System.out.println("Max: " + nums.get(nums.size() - 1));
    }

    static void ej3() {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            System.out.println("Escribe un numero");
            nums.add(sc.nextInt());
        }
        nums.sort(Comparator.naturalOrder());
        System.out.println(nums);
    }

    static void ej4() {
        ArrayList<String> wors = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            System.out.println("Escribe una palabra");
            wors.add(sc.next());
        }
        wors.sort(Comparator.naturalOrder());
        System.out.println(wors);
    }

    static void ej5() {
        ArrayList<Cancion> Disco = new ArrayList<Cancion>();
        ArrayList<Cancion> borradas = new ArrayList<Cancion>();
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Menu
                    1.- Añadir cancion
                    2.- Mover cancion
                    3.- Borrar cancion
                    4.- Ver x cancion
                    5.- Ver canciones
                    6.- Ver borradas
                    7.- Salir
                    """);
            int menu = sc.nextInt();
            switch (menu) {
                case 1 -> {
                    System.out.println("Nombre");
                    String n = sc.next();
                    System.out.println("Grupo");
                    String g = sc.next();
                    System.out.println("Duracion");
                    int d = sc.nextInt();
                    Disco.add(new Cancion(n, g, d));
                }
                case 2 -> {
                    for (Cancion i : Disco) {
                        System.out.println(Disco.indexOf(i) + " " + i.nombre);
                    }
                    System.out.println("Que cancion quieres mover (num)");
                    int m1 = sc.nextInt();
                    System.out.println("A que posicion");
                    int m2 = sc.nextInt();
                    Cancion aux = Disco.get(m1);
                    Disco.set(m1, Disco.get(m2));
                    Disco.set(m2, aux);
                }
                case 3 -> {
                    for (Cancion i : Disco) {
                        System.out.println(Disco.indexOf(i) + " " + i.nombre);
                    }
                    System.out.println("Que cancion quieres borrar (num)");
                    int rem = sc.nextInt();
                    borradas.add(Disco.get(rem));
                    Disco.remove(Disco.get(rem));
                }
                case 4 -> {
                    for (Cancion i : Disco) {
                        System.out.println(Disco.indexOf(i) + " " + i.nombre);
                    }
                    System.out.println("Que cancion quieres ver (num)");
                    int ver = sc.nextInt();
                    System.out.println(Disco.get(ver).nombre + " " + Disco.get(ver).grupo + " " + Disco.get(ver).dur);
                }
                case 5 -> {
                    for (Cancion i : Disco) {
                        System.out.println(Disco.indexOf(i) + " " + i.nombre);
                    }
                }
                case 6 -> {
                    for (Cancion i : borradas) {
                        System.out.println(borradas.indexOf(i) + " " + i.nombre);
                    }
                }
                case 7 -> {
                    exit = true;
                }
                default -> {
                    System.out.println(menu + " no es una opcion, intentalo de nuevo");
                }
            }
        }
    }

    static String getTipo(String a) {
        String tipom = a;
        Random r = new Random();
        while (tipom.equals(a)) {

            int tipo = r.nextInt(8);
            switch (tipo) {
                case 0 -> {
                    tipom = "1 centimo";
                }
                case 1 -> {
                    tipom = "2 centimos";
                }
                case 2 -> {
                    tipom = "5 centimos";
                }
                case 3 -> {
                    tipom = "10 centimos";
                }
                case 4 -> {
                    tipom = "20 centimos";
                }
                case 5 -> {
                    tipom = "50 centimos";
                }
                case 6 -> {
                    tipom = "1 euro";
                }
                case 7 -> {
                    tipom = "2 euros";
                }
            }
        }
        return tipom;
    }
    static String getEstado(String a){
        if (a.equals("Cara")) {
            return "Cruz";
        } else {
            return "Cara";
        }
    }

    static void ej6() {
        ArrayList<Moneda> dolars = new ArrayList<Moneda>();
        Random r = new Random();
        boolean cara;
        cara = r.nextBoolean();
        String tipom = getTipo("");

        String caram = "";
        if (cara) {
            caram = "Cara";
        } else {
            caram = "Cruz";
        }
        dolars.add(new Moneda(tipom, caram));
        for (int i = 1; i < 6; i++) {
            if (r.nextBoolean()) {
                dolars.add(new Moneda(getTipo(dolars.get(i-1).tipo), dolars.get(i-1).estado));
            } else {
                dolars.add(new Moneda(dolars.get(i-1).tipo, getEstado(dolars.get(i-1).estado)));
            }
        }
        for (Moneda i : dolars){
            System.out.println(i);
        }
    }
    static String tipoCarta(){
        Random r = new Random();
        switch (r.nextInt(4)) {
            case 0 -> {return "Bastos";}
            case 1 -> {return "Oros";}
            case 2 -> {return "Espadas";}
            case 3 -> {return "Copas";}
        }
        return "";
    }
    static void ej7(){
        Random r = new Random();
        ArrayList<Carta> cartas = new ArrayList<>();
        cartas.add(new Carta(tipoCarta(), r.nextInt(12)+1));
        for (int i=1; i<10; i++){
            
        }
    }
    public static void main(String[] args) {
        ej6();
    }
}