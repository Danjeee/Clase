package Personas;

public class Profesor extends Personas{
    protected String materia;

    public Profesor(String nombre, int edad, String sexo, String materia) {
        super(nombre, edad, sexo);
        this.per = 20;
        this.disponible = polimorfismo();
        this.materia = comprobarmateria(materia);
    }
    private String comprobarmateria(String materia){
        if (materia.equals("Matematicas") || materia.equals("Filosofia") || materia.equals("Fisica")){
            return materia;
        } else {
            return "Matematicas";
        }
    }
}
