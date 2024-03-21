package Ventas;

public abstract class Producto {
    public String nombre;
    public double precio;
    public int iva;

    public double calcularPrecioDTO(int dto){
        double p = this.precio - (this.precio*dto/100);
        return p;
    }
    public double calcularPrecioIMP(){
        double p = this.precio + (this.precio*this.iva/100);
        return p;
    }
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName() +" " +this.nombre +" " +this.precio +" ";
    }
}
