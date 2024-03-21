package Ventas;

public class ProductoAlimenticio extends Producto {
    public boolean esSano;

    public ProductoAlimenticio(String nombre, double precio, boolean esSano) {
        super(nombre, precio);
        this.esSano = esSano;
        if (esSano) {
            this.iva = 4;
        } else {
            this.iva = 21;
            precio = calcularPrecioIMP();
        }
    }
    
}
