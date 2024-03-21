package Figuras;

import java.util.Arrays;

public class Cuadrado extends FiguraGeometrica {
    public Cuadrado(int lado){
        lados = new int[4];
        Arrays.fill(lados, lado);;
        this.base = lado;
        this.altura = lado;
    }
}
