import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Thread.sleep;

public class POO2_Javierse{
    static Random r = new Random();
    static Scanner sc = new Scanner(System.in);
    public static void ej1() {
        System.out.println("Introduce nombre");
        String n = sc.next();
        System.out.println("Introduce edad");
        int e = sc.nextInt();
        System.out.println("Introduce el sexo");
        String s = sc.next();
        System.out.println("Introduce peso (en kg)");
        double p = sc.nextDouble();
        System.out.println("Introduce altura (en metros)");
        double a = sc.nextDouble();
        Persona p1 = new Persona(n, e, s, p, a);
        System.out.println("Introduce nombre");
         n = sc.next();
        System.out.println("Introduce edad");
         e = sc.nextInt();
        System.out.println("Introduce el sexo");
         s = sc.next();
        Persona p2 = new Persona(n, e, s, 0, 0);
        Persona p3 = new Persona("Paco", 22, "Coche", 55, 1.61);
        System.out.println(p1.nombre + ideal(p1.calcularIMC(p1.peso, p1.altura)));
        System.out.println(p2.nombre + ideal(p2.calcularIMC(p2.peso, p2.altura)));
        System.out.println(p3.nombre + ideal(p3.calcularIMC(p3.peso, p3.altura)));
        System.out.println(esMayor(p1));
        System.out.println(esMayor(p2));
        System.out.println(esMayor(p3));
        p1.toSrtings();
        p2.toSrtings();
        p3.toSrtings();
    }
    public static String ideal(int n){
        if (n == -1) {
            return " esta por debajo de su peso ideal";
        }
        if (n == 0) {
            return " esta en su peso ideal";
        }
        if (n == 1){
            return " esta por encima de su peso ideal";
        }
        return "hola";
    }
    public static String esMayor(Persona a){
        if (a.esMayorDeEdad(a.edad)){
            return (a.nombre + " es mayor de edad");
        } else {
            return (a.nombre + " es menor de edad");
        }
    }
    public static void ej2(){
        System.out.println("Cuantas contraseñas quieres crear");
        int numc = sc.nextInt();
        System.out.println("Que longitud quieres que tengan");
        int len = sc.nextInt();
        Password[] arrayPass = new Password[numc];
        boolean[] str = new boolean[numc];
        for (int i=0; i<numc; i++){
            arrayPass[i] = new Password(len);
            str[i] = arrayPass[i].esFuerte(arrayPass[i].getContraseña());
        }
        for (int i=0; i<numc; i++){
            System.out.println("Contraseña " +arrayPass[i].getContraseña());
            if (str[i]) {
                System.out.println("Es fuerte");
            } else {
                System.out.println("Es debil");
            }
        }
    }
    public static void ej3(){
        int random;
        ArrayList<Electrodomestico> electro = new ArrayList<Electrodomestico>();
        for (int i = 0; i<10; i++){
            random = r.nextInt(3);
            if (random == 0) {
                int precio = r.nextInt(100);
                int peso = r.nextInt(200);
                int carga = r.nextInt(50);
                char consumo = (char)(r.nextInt(6) + 65);
                electro.add(new Lavadora(precio, "azul", consumo, peso, carga));
            }
            if (random == 1) {
                int precio = r.nextInt(100);
                int peso = r.nextInt(200);
                char consumo = (char)(r.nextInt(6) + 65);
                double resol = r.nextDouble(100);
                boolean tdt = r.nextBoolean();
                electro.add(new Television(precio, "negro", consumo, peso, resol, tdt));
            }
            if (random == 2) {
                int precio = r.nextInt(100);
                int peso = r.nextInt(200);
                char consumo = (char)(r.nextInt(6) + 65);
                electro.add(new Electrodomestico(precio, "gris", consumo, peso));
            }
        }
            int e = 0;
            int l = 0;
            int t = 0;       
        for (Electrodomestico k : electro){
            if (k instanceof Electrodomestico) {
                e+=k.PrecioFinal(k.precio, k.consumo, k.peso);
            }
            if (k instanceof Lavadora) {
                e+=k.PrecioFinal(k.precio, k.consumo, k.peso);
                l+=k.PrecioFinal(k.precio, k.consumo, k.peso);
            }
            if (k instanceof Television) {
                e+=k.PrecioFinal(k.precio, k.consumo, k.peso);
                t+=k.PrecioFinal(k.precio, k.consumo, k.peso);
            }
        }
            System.out.println("Electrodomesticos: " +e);
            System.out.println("Televisiones: " +t);
            System.out.println("Lavadoras: " +l);
    }
    public static void main(String[] args) throws InterruptedException {
        int repet = 0;
        while (repet == 0) {
            System.out.println(" ");
            System.out.println("Elije que ejercicio va a ejecutar");
            System.out.println("(Para cerrar el bucle pulse 4)");
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
                    repet = 1;
                    break;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(2000);
        }
    }
}