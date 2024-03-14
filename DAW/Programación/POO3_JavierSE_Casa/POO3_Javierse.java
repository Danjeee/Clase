import Rectangulo.*;
import Personas.*;
public class POO3_Javierse {
    static void ej1(){
        Rectangulo r1 = new Rectangulo(0, 0, 10, 10, "carlos");
        Rectangulo r2 = new Rectangulo(10, 5, 20, 15, "marc");
        Rectangulo r3 = new Rectangulo(100, 100, 1000, 1000, "Bob");
        System.out.println("Perimetro: " +r1.calcularPerimetro());
        System.out.println("Superficie: " +r1.calcularSuperficie());
    }
    public static void main(String[] args) {
        ej1();
    }
}