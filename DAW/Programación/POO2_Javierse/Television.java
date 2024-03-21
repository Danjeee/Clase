public class Television extends Electrodomestico{
    protected double resolucion = 20;
    protected boolean sintonizadorTDT = false;
    public Television(int precioBase, String color, char consumo, int peso, double resolucion,
            boolean sintonizadorTDT) {
        super(precioBase, color, consumo, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
        this.precio = PrecioFinal(precioBase, resolucion, sintonizadorTDT);
    }
    public int PrecioFinal(int a, double res, boolean tdt){
        if (res > 40) {
            a += ((a*30)/100);
        }
        if (tdt){
            a += 50;
        }
        return a;
    }
}
