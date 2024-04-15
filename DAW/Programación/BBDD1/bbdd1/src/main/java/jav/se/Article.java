package jav.se;

public class Article {
    private int clave_articulo;
    private String nombre;
    private double precio;
    private int c_fab;
    public Article(int clave_articulo, String nombre, int precio, int c_fab) {
        this.clave_articulo = clave_articulo;
        this.nombre = nombre;
        this.precio = precio;
        this.c_fab = c_fab;
    }
    public int getClave_articulo() {
        return clave_articulo;
    }
    public void setClave_articulo(int clave_articulo) {
        this.clave_articulo = clave_articulo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getC_fab() {
        return c_fab;
    }
    public void setC_fab(int c_fab) {
        this.c_fab = c_fab;
    }
}
