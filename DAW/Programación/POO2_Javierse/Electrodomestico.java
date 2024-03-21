public class Electrodomestico {
    protected int precio = 100;
    protected String color = "blanco";
    protected char consumo = 'F';
    protected int peso;
    public Electrodomestico(int precioBase, String color, char consumo, int peso) {
        this.color = comprobarColor(color);
        this.consumo = comprobarConsumo(consumo);
        this.peso = peso;
        this.precio = PrecioFinal(precioBase,this.consumo, this.peso);
    }
    private char comprobarConsumo(char a){
        if (a == ('F' - 'A')) {
            return a;
        } else {
            a = 'F';
            return a;
        }
    }
    private String comprobarColor(String a){
        a.toLowerCase();
        if (a.equals("blanco") || a.equals("negro") || a.equals("rojo") || a.equals("azul") || a.equals("gris")){
            return a;
        } else {
            return "blanco";
        }
    }
    public int PrecioFinal(int a, char c, int t){
        switch (c) {
            case 'A':
                a += 100;
                break;
            case 'B':
                a += 80;
                break;
            case 'C':
                a += 60;
                break; 
            case 'D':
                a += 50;
                break;
            case 'E':
                a += 30;
                break;
            case 'F':
                a += 10;
                break;            
        }
        if (t <= 19) {
            a += 10;
        }
        if (t >= 20 && t <= 49){
            a += 50;
        }
        if (t >= 50 && t <= 79){
            a += 80;
        }
        if (t >= 80) {
            a += 100;
        }
        return a;
    }
    public int getPrecioBase() {
        return precio;
    }
    public void setPrecioBase(int precio) {
        this.precio = precio;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public char getConsumo() {
        return consumo;
    }
    public void setConsumo(char consumo) {
        this.consumo = consumo;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
}
