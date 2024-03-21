public class Main {
    public static void main(String[] args){
        Alumno a1 = new Alumno("pepe", "garcia", "05/12/2002", "A1", 7);
        a1.setNombre("ramon");
        System.out.println(a1.getNombre());
    }
}