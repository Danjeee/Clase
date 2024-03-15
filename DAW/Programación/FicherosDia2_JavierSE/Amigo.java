import java.io.Serializable;

public class Amigo implements Serializable {
    private String nombre;
    private transient int edad;
    private String tlf;

    public Amigo(String nombre, int edad, String tlf) {
        this.nombre = nombre;
        this.edad = edad;
        this.tlf = tlf;
    }

    public Amigo(String nombre, String tlf) {
        this.nombre = nombre;
        this.tlf = tlf;
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

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }
    @Override
    public String toString() {
        return "Hola, me llamo " +this.nombre +", tengo " +this.edad +" y mi tlf es "+this.tlf;
    }
}
