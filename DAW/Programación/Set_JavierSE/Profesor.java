public class Profesor {
    public String nombre;

    public Profesor(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return "Hola me llamo " +this.nombre +" y soy un " +this.getClass().getSimpleName();
    }
    public int hashCode() {
        return this.getNombre().hashCode();
    }
    public boolean equals( Object objeto ) {
        if (objeto == null) return false;
        
        Profesor profe = (Profesor)objeto;
        if (this.getNombre().equals(profe.getNombre()) )
        return true;
        
        return false;
        }
        
}
