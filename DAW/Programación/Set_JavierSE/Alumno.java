public class Alumno implements Comparable<Alumno> {
    public String nombre;

    public Alumno(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Hola me llamo " +this.nombre +" y soy un " +this.getClass().getSimpleName();
    }
    @Override
    public int compareTo(Alumno o) {
        return this.nombre.compareTo(o.nombre);
    }
}
