package Rectangulo;

public class Rectangulo {
    protected double x1;
    protected double x2;
    protected double y1;
    protected double y2;
    public static int numRectangulos = 0;
    public String nombre;
    protected String nombreFigura = "Rectangulo";
    public final double PI = 3.1416;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double calcularSuperficie(){
        double altura = this.y2 - this.y1;
        double anchura = this.x2 - this.x1;
        double area = altura*anchura;
        return area;
    }
    public double calcularPerimetro(){
        double altura = this.y2 - this.y1;
        double anchura = this.x2 - this.x1;
        double perimetro = altura*2 + anchura*2;
        return perimetro;
    }
    public void desplazar(double x, double y){
        this.x1 += x;
        this.x2 += x;
        this.y1 += y;
        this.y2 += y;
    }
    public static int getNumRectangulos() {
        return numRectangulos;
    }
    public Rectangulo(double x1, double y1, double x2, double y2, String nombre) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.nombre = nombre;
    }
}
