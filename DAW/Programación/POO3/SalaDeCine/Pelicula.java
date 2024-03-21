package SalaDeCine;

public class Pelicula {
    protected String titulo;
    protected int duracion;
    protected int edadMin;
    protected String director;
    protected double precio;
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public int getEdadMin() {
        return edadMin;
    }
    public void setEdadMin(int edadMin) {
        this.edadMin = edadMin;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Pelicula(String titulo, int duracion, int edadMin, String director, double precio) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMin = edadMin;
        this.director = director;
        this.precio = precio;
    }
}
