package Figuras;

import java.util.Arrays;

public class Triangulo extends FiguraGeometrica {
    public String tipoTriangulo;

    public Triangulo(int l1, int l2, int l3, String tipoTriangulo) {
        this.tipoTriangulo = tipoTriangulo;
        this.base = l1/2;
        if (tipoTriangulo.equals("Equilatero")) {
            Arrays.fill(lados, l1);
        } else if (tipoTriangulo.equals("Isosceles")){
            lados[0] = l1;
            lados[1] = l2;
            lados[2] = l2;
        } else {
            lados[0] = l1;
            lados[1] = l2;
            lados[2] = l3;
        }
        this.altura = calcularH();
    }
    public int calcularH(){
        int b = this.base;
        int a = this.lados[1];
        int c = (int)Math.sqrt((double)Math.pow(a, 2) - (double)Math.pow(b, 2));
        return c;
    }
    @Override
    public double calcularArea() {
        return (super.calcularArea()/2);
    }
}
