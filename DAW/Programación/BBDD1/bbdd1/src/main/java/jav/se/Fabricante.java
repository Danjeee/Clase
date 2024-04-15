package jav.se;

public class Fabricante {
    private int clave_fabricante;
    private String nombre;
    public Fabricante(int clave_fabricante, String nombre) {
        this.clave_fabricante = clave_fabricante;
        this.nombre = nombre;
    }
    public int getClave_fabricante() {
        return clave_fabricante;
    }
    public void setClave_fabricante(int clave_fabricante) {
        this.clave_fabricante = clave_fabricante;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
