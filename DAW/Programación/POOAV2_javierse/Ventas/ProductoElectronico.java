package Ventas;

public class ProductoElectronico extends Producto {
    public char consumo;

    public ProductoElectronico(String nombre, double precio, char consumo) {
        super(nombre, precio);
        this.consumo = consumo;
        this.iva = 21;
        this.precio = calcularPrecioIMP();
    }
    
    @Override
    public double calcularPrecioIMP() {
        double precio = super.calcularPrecioIMP();
        int aumento = 0;
        for (char i = 65; i!=this.consumo; i++){
            aumento += 5;
        }
        precio += aumento;
        return precio;
    }
}
