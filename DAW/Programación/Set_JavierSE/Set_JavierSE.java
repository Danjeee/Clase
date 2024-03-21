import java.util.*;

public class Set_JavierSE {
    static void ej1() {
        List<String> listaConDuplicados = Arrays.asList("perro", "gato", "perro", "loro", "gato",
                "elefante");
        // Utilizar un HashSet para eliminar duplicados
        Set<String> conjuntoSinDuplicados = new HashSet<>();
        conjuntoSinDuplicados.addAll(listaConDuplicados);
        System.out.println("Lista original: " + listaConDuplicados);
        System.out.println("Lista sin duplicados: " + conjuntoSinDuplicados);
    }

    static void ej2(){
        Set<Integer> conjunto1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> conjunto2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        for (Integer i : conjunto1){
            if (conjunto2.contains(i)){
                System.out.println("Comun: " +i);;
            }
        }
    }
    static void ej3(){
        Alumno a1 = new Alumno("Carlos");
        Alumno a2 = new Alumno("Carlos");
        Alumno a3 = new Alumno("Juan");
        Alumno a4 = new Alumno("Caca");
        Profesor p1 = new Profesor("Julian");
        Profesor p2 = new Profesor("Marco");
        Profesor p3 = new Profesor("Kirby");
        Profesor p4 = new Profesor("Julian");
        Set<Alumno> alumnos = new TreeSet<>();
        alumnos.add(a1);
        alumnos.add(a2);
        alumnos.add(a3);
        alumnos.add(a4);
        Set<Profesor> profes = new HashSet<>();
        profes.add(p1);
        profes.add(p2);
        profes.add(p3);
        profes.add(p4);
        for (Alumno i : alumnos){
            System.out.println(i);
        }
        System.out.println();
        for (Profesor i : profes){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ej3();
    }
}