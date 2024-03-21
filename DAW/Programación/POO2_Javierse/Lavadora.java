

public class Lavadora extends Electrodomestico{
    protected int carga = 5;
    public Lavadora(int precio, String color, char consumo, int peso, int carga){
        super(precio, color, consumo, peso);
        this.carga = carga;
        this.precio = PrecioFinal(precio, this.carga);
    }
    public int PrecioFinal(int a, int carga){
        if (carga > 30){
            a += 50;
        }
        return a;
    }
    public int getCarga() {
        return carga;
    }
    public void setCarga(int carga) {
        this.carga = carga;
    }

}
