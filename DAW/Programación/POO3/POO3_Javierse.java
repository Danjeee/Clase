import Rectangulo.*;

import java.util.ArrayList;
import java.util.Scanner;

import Personas.*;
import SalaDeCine.Espectador;
import SalaDeCine.Pelicula;
import SalaDeCine.SalaDeCine;
import SalaDeCine.SalaDeCine.*;

public class POO3_Javierse {
    static Scanner sc = new Scanner(System.in);

    static void ej1() {
        Rectangulo r1 = new Rectangulo(0, 0, 10, 10, "carlos");
        Rectangulo r2 = new Rectangulo(10, 5, 20, 15, "marc");
        Rectangulo r3 = new Rectangulo(100, 100, 1000, 1000, "Bob");
        System.out.println("Perimetro: " + r1.calcularPerimetro());
        System.out.println("Superficie: " + r1.calcularSuperficie());
    }

    static void ej2() {
        System.out.println("Cuantas aulas quieres crear");
        int naulas = sc.nextInt();
        ArrayList<Aula> Aulas = new ArrayList<Aula>();
        ArrayList<Alumno> Alumnos = new ArrayList<Alumno>();
        ArrayList<Integer> Alumnosenaulas = new ArrayList<Integer>();
        ArrayList<Profesor> profes = new ArrayList<Profesor>();
        for (int i = 0; i < naulas; i++) {
            System.out.println("Que tipo de aula es");
            String m = sc.next();
            System.out.println("Cuantos alumnos tiene");
            int nalumnos = sc.nextInt();
            Alumnosenaulas.add(nalumnos);
            for (int j = 0; j < nalumnos; j++) {
                System.out.println("Nombre del alumno " + (j + 1));
                String nom = sc.next();
                System.out.println("Edad del alumno " + (j + 1));
                int edad = sc.nextInt();
                System.out.println("Sexo del alumno " + (j + 1));
                String sex = sc.next();
                System.out.println("Nota del alumno " + (j + 1));
                int nota = sc.nextInt();
                Alumnos.add(new Alumno(nom, edad, sex, nota));
            }
            System.out.println("Nombre del profesor");
            String nom = sc.next();
            System.out.println("Edad del profesor");
            int edad = sc.nextInt();
            System.out.println("Sexo del profesor");
            String sex = sc.next();
            System.out.println("Materia del profesor");
            String mat = sc.next();
            profes.add(new Profesor(nom, edad, sex, mat));
            Aulas.add(new Aula(m, profes.get(i), Alumnos));
        }
        System.out.println("Que aula quieres ver");
        for (int i = 0; i < Aulas.size(); i++) {
            System.out.println(i + "Aula " + (i) + " (" + Aulas.get(i).getTipoDeAula() + ")");
        }
        int menuaulas = sc.nextInt();
        int start = 0;
        int ma = 0;
        int ms = 0;
        int fa = 0;
        int fs = 0;
        for (int i = 0; i < menuaulas - 1; i++) {
            start += Alumnosenaulas.get(i);
        }
        for (int i = start; i < (start + Alumnosenaulas.get(menuaulas)); i++) {
            if (Alumnos.get(i).getSexo().equals("M") && Alumnos.get(i).getNota() > 5) {
                ma++;
            }
            if (Alumnos.get(i).getSexo().equals("M") && Alumnos.get(i).getNota() < 5) {
                ms++;
            }
            if (Alumnos.get(i).getSexo().equals("F") && Alumnos.get(i).getNota() > 5) {
                fa++;
            }
            if (Alumnos.get(i).getSexo().equals("F") && Alumnos.get(i).getNota() < 5) {
                fs++;
            }
        }
        if (Aulas.get(menuaulas).sePuede) {
            System.out.println("En este aula hay " + Alumnosenaulas.get(menuaulas) + "Alumnos, de los cuales " + ma
                    + "son hombres aprobados, " + ms + ", suspendidos, " + fa + " son mujeres aprobadas" + fs
                    + ", suspendidas");
        } else {
            System.out.println("Este aula esta cerrada");
        }
    }

    static void ej3() {
        System.out.println("Elija el asiento del espectador por defecto");
        ArrayList<Pelicula> pelis = new ArrayList<Pelicula>();
        ArrayList<SalaDeCine> salas = new ArrayList<SalaDeCine>();
        ArrayList<Espectador> gente = new ArrayList<Espectador>();
        int salanum = 1;
        pelis.add(new Pelicula("Default", 90, 18, "Default", 2));
        salas.add(new SalaDeCine("Default", 9, 8, pelis, 1));
        gente.add(new Espectador("juan", 22, 100, 1, salas));
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Menu
                    1.- Ver salas
                    2.- Ver peliculas
                    3.- Ver espectadores
                    4.- Añadir Espectador
                    5.- Añadir Pelicula
                    6.- Añadir sala
                    7.- Asignar espectadores
                    8.- Ver asientos
                    9.- Cerrar
                    """);
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    for (int i = 0; i<salas.size(); i++){
                        System.out.println("Sala " +salas.get(i).salanum +" Pelicula: " +salas.get(i).tituloPelicula +" Precio: " +salas.get(i).precio +" Edad: " +salas.get(i).edadMin);
                    }
                    break;
                case 2:
                    for (int i=0; i<pelis.size(); i++){
                        System.out.println("Pelicula: " +pelis.get(i).getTitulo() +" Director: " +pelis.get(i).getDirector() +" Duracion: " +pelis.get(i).getDuracion() +" Edad: " +pelis.get(i).getEdadMin());
                    }    
                    break;
                case 3:
                    for (int i=0; i<gente.size(); i++){
                        System.out.print("Nombre: " +gente.get(i).getNombre() +" Edad: " +gente.get(i).getEdad() + " Dinero: " +gente.get(i).getDinero() +" Asignado?: " +gente.get(i).estaAsignado());
                        if (gente.get(i).asignado) {
                            System.out.println(" Sala: " +gente.get(i).getSala() + " Asiento: " +gente.get(i).getAsiento());
                        } else{
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nombre: ");
                    String nom = sc.next();
                    System.out.println("Edad: ");
                    int edad = sc.nextInt();
                    System.out.println("De cuanto dinero dispone");
                    double dinero = sc.nextDouble();
                    System.out.println("En que sala quiere intentar entrar?");
                    int intsala = sc.nextInt();
                    gente.add(new Espectador(nom, edad, dinero, intsala, salas));
                    break;

                case 5:
                    System.out.println("Titulo: ");
                    String tit = sc.next();
                    System.out.println("Director: ");
                    String dir = sc.next();
                    System.out.println("Duracion: ");
                    int dur = sc.nextInt();
                    System.out.println("Edad minima: ");
                    int edadmin = sc.nextInt();
                    System.out.println("Precio: ");
                    double pre = sc.nextDouble();
                    pelis.add(new Pelicula(tit, dur, edadmin, dir, pre));
                    break;
                case 6:
                    System.out.println("Pelicula: ");
                    String pel = sc.next();
                    System.out.println("Columnas: ");
                    int col = sc.nextInt();
                    System.out.println("Filas: ");
                    int fil = sc.nextInt();
                    salanum++;
                    salas.add(new SalaDeCine(pel, col, fil, pelis, salanum));
                    break;
                case 7:
                    for (int i = 0; i<gente.size(); i++){
                        if (!gente.get(i).asignado) {
                            System.out.println("A que sala quiere asignarlo");
                            int salaassign = sc.nextInt();
                            gente.get(i).setSala(salaassign);
                            gente.get(i).asignar(salas, salaassign);
                        }
                    }
                    break;
                case 8:
                    System.out.println("De que sala quiere ver los asientos");
                    int salaass = sc.nextInt();
                    salas.get(salaass-1).dibujarSala();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println(menu +" no es una opcion, intentalo de nuevo");
                    break;
            }
        }

    }

    public static void main(String[] args) {
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
        }
    }
}