package Figuras;

public abstract class FiguraGeometrica {
    protected int base;
    protected int altura;
    protected int[] lados;
    public double calcularPerimetro(){
        double per = 0;
        for (int i = 0; i<this.lados.length; i++){
            per+=this.lados[i];
        }
        return per;
    }
    public double calcularArea(){
        int ar = this.base*this.altura;
        return ar;
    }
    public int getBase() {
        return base;
    }
    public void setBase(int base) {
        this.base = base;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public int[] getLados() {
        return lados;
    }
    public void setLados(int[] lados) {
        this.lados = lados;
    }
}
