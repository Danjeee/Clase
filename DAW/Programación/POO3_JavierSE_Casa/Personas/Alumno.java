package Personas;

public class Alumno extends Personas{
    protected int nota;

    public Alumno(String nombre, int edad, String sexo, int nota) {
        super(nombre, edad, sexo);
        this.per = 50;
        this.disponible = polimorfismo();
        this.nota = comprobarNota(nota);
    }
    private int comprobarNota(int nota){
        if (nota < 0 || nota > 10){
            return 5;
        } else {
            return nota;
        }
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
}
