package Personas;

public class Alumno extends Persona {
    protected String grupo;
    protected double nota;
    @Override
    public String getNombre() {
       return "Alumno: " +super.getNombre();
    }
    public String getGrupo() {
        return grupo;
    }
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    public Alumno(String nombre, String apellidos, String fechaN, String grupo, double nota) {
        super(nombre, apellidos, fechaN);
        this.grupo = grupo;
        this.nota = nota;
    }
    @Override
    public String toString() {
        return super.toString() + ", Grupo: " +this.grupo +", NotaMedia: "+this.nota;
    }
}
