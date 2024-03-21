package Ventas;

public class ProductoRopa extends Producto {
    public String talla;

    public ProductoRopa(String nombre, double precio, String talla) {
        super(nombre, precio);
        this.iva = 15;
        this.talla = comprobarTalla(talla);
        this.precio = calcularPrecioIMP();
    }
    private String comprobarTalla(String talla){
        if (!talla.equals("S") && !talla.equals("M") && !talla.equals("X") && !talla.equals("XL")) {
            talla = "M";
        }
        return talla;
    }
    @Override
    public double calcularPrecioIMP() {
        int aum = 0;
        switch (this.talla) {
            case "S" -> aum = 0;
            case "M" -> aum = 5; 
            case "X" -> aum = 10;
            case "XL" -> aum = 15; 
        }
        this.precio += aum;
        return super.calcularPrecioIMP();
    }
    
}
