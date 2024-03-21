import java.util.*;

public class Set2_JavierSE {
    static void ej1(){
        Profesor p1 = new Profesor("Juan", 22);
        Profesor p2 = new Profesor("Ruben", 22);
        Profesor p3 = new Profesor("Juan", 66);
        Profesor p4 = new Profesor("Juan", 22);
        Set<Profesor> profesores = new HashSet<>();
        profesores.add(p1);
        profesores.add(p2);
        profesores.add(p3);
        profesores.add(p4);
        System.out.println(profesores);
    }
    static void ej2(){
        Profesor p1 = new Profesor("Juan", 22);
        Profesor p2 = new Profesor("Ruben", 22);
        Profesor p3 = new Profesor("Juan", 66);
        Profesor p4 = new Profesor("Juan", 22);
        TreeSet<Profesor> profesores = new TreeSet<>();
        profesores.add(p1);
        profesores.add(p2);
        profesores.add(p3);
        profesores.add(p4);
        System.out.println(profesores);
    }
    static void ej3(){
        Profesor p1 = new Profesor("Juan", 22);
        Profesor p2 = new Profesor("Ruben", 22);
        Profesor p3 = new Profesor("Juan", 66);
        Profesor p4 = new Profesor("Juan", 22);
        LinkedHashSet<Profesor> profesores = new LinkedHashSet<>();
        profesores.add(p1);
        profesores.add(p2);
        profesores.add(p3);
        profesores.add(p4);
        System.out.println(profesores);
    }
    public static void main(String[] args) {
        ej3();
    }
}