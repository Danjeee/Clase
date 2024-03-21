package Libro;

public class LibroFisico extends Libro {
    public String estado;

    public LibroFisico(String titulo, String autor, int cant, int pag, String estado) {
        super(titulo, autor, cant, pag);
        this.estado = comprobarEstado(estado);
        this.disp = disponibilidad();
    }

    private String comprobarEstado(String estado){
        if (!estado.equals("Bien") && !estado.equals("Regular") && !estado.equals("Mal")) {
            return "Regular";
        } else {
            return estado;
        }
    }
    @Override
    public String toString() {
        return super.toString() +" " +this.estado;
    }
}
