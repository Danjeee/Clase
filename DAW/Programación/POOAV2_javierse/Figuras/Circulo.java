package Figuras;

public class Circulo extends FiguraGeometrica {
    private final double PI = 3.14159263;
    public int radio;
    public Circulo(int radio) {
        this.radio = radio;
    }
    @Override
    public double calcularArea() {
        return (PI*Math.pow(radio, 2));
    }
    @Override
    public double calcularPerimetro() {
        return (2*PI*radio);
    }
}
