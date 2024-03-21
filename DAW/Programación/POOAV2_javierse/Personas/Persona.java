package Personas;

public abstract class Persona {
    protected String nombre;
    protected String apellidos;
    protected String fechaN;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getFechaN() {
        return fechaN;
    }
    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }
    public Persona(String nombre, String apellidos, String fechaN) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaN = fechaN;
    }
    @Override
    public String toString() {
        return "Nombre: " +this.nombre +", Apellidos: " +this.apellidos +", FechaNacimiento: " +this.fechaN;
    }
}
