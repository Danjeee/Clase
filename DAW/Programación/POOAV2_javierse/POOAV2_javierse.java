import java.util.Scanner;
import static java.lang.Thread.sleep;
import Empresa.Desarrollador;
import Empresa.Gerente;
import Figuras.Circulo;
import Figuras.Cuadrado;
import Figuras.Triangulo;
import Libro.Libro;
import Libro.LibroDigital;
import Libro.LibroFisico;
import Personas.Alumno;
import Personas.Profesor;
import Transporte.Camion;
import Transporte.Coche;
import Transporte.Motocicleta;
import Transporte.Vehiculo;
import Ventas.Producto;
import Ventas.ProductoAlimenticio;
import Ventas.ProductoElectronico;
import Ventas.ProductoRopa;

public class POOAV2_javierse {
    static Scanner sc = new Scanner(System.in);
    static void ej1(){
        System.out.println("Nuevo cuadrado");
        System.out.println("Lado: ");
        int l = sc.nextInt();
        Cuadrado c1 = new Cuadrado(l);
        System.out.println("Perimetro: " +c1.calcularPerimetro());
        System.out.println("Area: " +c1.calcularArea());
        System.out.println("Nuevo triangulo");
        System.out.println("Tipo de triangulo");
        String tipo = sc.next();
        if (tipo.equals("Equilatero")) {
            System.out.println("Lado: ");
            l = sc.nextInt();
            Triangulo t1 = new Triangulo(l, l, l, tipo);
            System.out.println("Perimetro: " +t1.calcularPerimetro());
            System.out.println("Area " +t1.calcularArea());
        } else if (tipo.equals("Isosceles")){
            System.out.println("Lado diferente");
            l = sc.nextInt();
            System.out.println("Lados iguales");
            int l2 = sc.nextInt();
            Triangulo t1 = new Triangulo(l, l2, l2, tipo);
            System.out.println("Perimetro: " +t1.calcularPerimetro());
            System.out.println("Area " +t1.calcularArea());
        } else {
            System.out.println("Lado 1");
            l = sc.nextInt();
            System.out.println("Lados 2");
            int l2 = sc.nextInt();
            System.out.println("Lado 3");
            int l3 = sc.nextInt();
            Triangulo t1 = new Triangulo(l, l2, l3, tipo);
            System.out.println("Perimetro: " +t1.calcularPerimetro());
            System.out.println("Area " +t1.calcularArea());
        }
        System.out.println("Circulo");
        System.out.println("Radio");
        int radio = sc.nextInt();
        Circulo cir1 = new Circulo(radio);
        System.out.println("Perimetro: " +cir1.calcularPerimetro());
        System.out.println("Area " +cir1.calcularArea());
    }
    static void ej2(){
        Alumno a1 = new Alumno("Juan", "Gonzalez Rivera", "12-12-2002", "DAW", 7);
        System.out.println(a1);
        Profesor p1 = new Profesor("Mario", "Gonzalez Lopez", "12-03-1988", 1500, "Matematicas");
        System.out.println(p1);
    }
    static void ej3(){
        Gerente g1 = new Gerente("juan", 1100, 33);
        Desarrollador d1 = new Desarrollador("Julio", 1100, "web");
        Gerente g2 = new Gerente("juan2", 1500, 15);
        Desarrollador d2 = new Desarrollador("Julio2", 1900, "web");
        Gerente g3 = new Gerente("juan3", 1200, 30);
        g1.salarioAnual();
        g2.salarioAnual();
        g3.salarioAnual();
        d1.salarioAnual();
        d2.salarioAnual();
        double total = g1.salarioAnual() + g2.salarioAnual() + g3.salarioAnual() + d1.salarioAnual() + d2.salarioAnual();
        System.out.println(total);
    }
    static void ej4(){
        Producto[] p1 = new Producto[3];
        p1[0] = new ProductoElectronico("Lavadora", 200, 'F');
        p1[1] = new ProductoAlimenticio("Platano", 1.60, true);
        p1[2] = new ProductoRopa("Pantalon", 20, "X");
        for (Producto i : p1){
            System.out.println(i);
        }
    }
    static void ej5(){
        Vehiculo[] v1 = new Vehiculo[3];
        v1[0] = new Coche("Nisan", "M4", 2000);
        v1[1] = new Camion("Opel", "Camionsa", 4500);
        v1[2] = new Motocicleta("Motorola", "Marcelo", 200);
        for (Vehiculo i : v1){
            System.out.println(i);
        }
    }
    static void ej6(){
        Libro[] libros = new Libro[4];
        libros[0] = new LibroFisico("Narnia", "Robbie", 4, 222, "Bien");
        libros[1] = new LibroDigital("BibliaIsaacVer", "Steam", 20, 150, "pdf", 260);
        libros[2] = new LibroFisico("Oz", "Anonimo", 0, 222, "Bien");
        libros[3] = new LibroDigital("Minecraftia", "Mojang", 40, 150, "wav", 320);
        for (Libro i : libros){
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int repet = 0;
        while (repet == 0) {
            System.out.println(" ");
            System.out.println("Elije que ejercicio va a ejecutar");
            System.out.println("(Para cerrar el bucle pulse 7)");
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
                    repet = 1;
                    break;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(2000);
        }
    }
}