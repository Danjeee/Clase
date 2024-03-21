public class Profesor implements Comparable<Profesor> {
    public String nombre;
    public int edad;
    public Profesor(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public int hashCode() {
        return this.getNombre().hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        Profesor pc = (Profesor)obj;
        if (pc.nombre.equals(this.nombre)&&pc.edad == this.edad) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        return "("+this.nombre +", " +this.edad +")";
    }
    @Override
    public int compareTo(Profesor o) {
       int comp = this.nombre.compareTo(o.nombre);
       if (comp == 0) {
            return this.edad-o.edad;
       } else {
        return comp;
       }
    }
}
