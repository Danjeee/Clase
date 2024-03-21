package Libro;

public class LibroDigital extends Libro {
    public String formato;
    public double peso;

    public LibroDigital(String titulo, String autor, int cant, int pag, String formato, double peso) {
        super(titulo, autor, cant, pag);
        this.formato = formato;
        this.peso = peso;
        this.disp = disponibilidad();
    }

    @Override
    protected boolean disponibilidad() {
        if (!formato.equals("pdf")) {
            this.cant = 0;
            return false;
        } else {
            return super.disponibilidad();
        }
    }
    @Override
    public String toString() {
        return super.toString() +" " +this.formato +" " +this.peso +"mb";
    }

}
