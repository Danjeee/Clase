public class Persona {
    protected String nombre;
    protected String apellidos;
    protected String FN;
     public Persona(String nombre, String apellidos, String FN){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.FN = FN;
    }
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
    public String getFN() {
        return FN;
    }
    public void setFN(String fN) {
        FN = fN;
    }
   
}