package Libro;

public abstract class Libro {
    public String titulo;
    public String autor;
    public boolean disp;
    public int cant;
    public int pag;

    public Libro(String titulo, String autor, int cant, int pag) {
        this.titulo = titulo;
        this.autor = autor;
        this.cant = cant;
        this.pag = pag;
    }
    protected boolean disponibilidad(){
        if (this.cant<=0) {
            this.cant = 0;
            return false;
        } else {return true;}
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName() +" " +this.titulo +" " +this.autor +" " +this.pag +" " +this.cant +" " +this.disp;
    }
}
