package Terminal;

public class Movil extends Terminal{
    public String tarifa;
    public double precio;
    private double preciotarifa;
    public String getTarifa() {
        return tarifa;
    }
    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getPreciotarifa() {
        return preciotarifa;
    }
    public void setPreciotarifa(double preciotarifa) {
        this.preciotarifa = preciotarifa;
    }
    public Movil(String num, String tarifa) {
        super(num);
        this.tarifa = comprobarTarifa(tarifa);
        this.precio = 0;
        this.preciotarifa = asignarPrecio();
    }
    private String comprobarTarifa(String tarifa){
        tarifa = tarifa.toLowerCase();
        if (tarifa.equals("rata")) {
            return tarifa;
        } else if (tarifa.equals("mono")) {
            return tarifa;
        } else if (tarifa.equals("bisonte")) {
            return tarifa;
        } else {
            return "rata";
        }
    }
    private double asignarPrecio(){
        if (this.tarifa.equals("rata")){
            return 0.06;
        }
        if (this.tarifa.equals("mono")){
            return 0.12;
        }
        if (this.tarifa.equals("bisonte")){
            return 0.3;
        }
        return 0.06;
    }
    @Override
    public void llama(Terminal t2, int ti) {
        super.llama(t2, ti);
        this.precio += this.preciotarifa*ti;
    }
    @Override
    public void print() {
        System.out.println("Nº " +this.num + " - " +t +"s de conversacion - tarifados " +this.precio +" euros");
    }
    
}
