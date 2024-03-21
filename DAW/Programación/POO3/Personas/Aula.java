package Personas;

import java.util.ArrayList;

public class Aula {
    private String tipoDeAula;
    private int id;
    public boolean sePuede;
    static public int totalAulas = 0;
    public String getTipoDeAula() {
        return tipoDeAula;
    }
    public void setTipoDeAula(String tipoDeAula) {
        this.tipoDeAula = tipoDeAula;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isSePuede() {
        return sePuede;
    }
    public void setSePuede(boolean sePuede) {
        this.sePuede = sePuede;
    }
    public Aula(String tipoDeAula, Profesor profe, ArrayList<Alumno> alumnos) {
        this.tipoDeAula = comprobarMateria(tipoDeAula);
        this.id = getid();
        this.sePuede = Comprobar(alumnos, profe);
    }
    private int getid(){
        totalAulas++;
        return totalAulas-1;
    }
    private boolean Comprobar(ArrayList<Alumno> Alumnos, Profesor profe){
        int totalal=0;
        for (int i = 0; i<Alumnos.size(); i++){
            if (Alumnos.get(i).disponible){
                totalal++;
            }
        }
        if (profe.materia != this.tipoDeAula) {
            return false;
        }
        if (profe.disponible && totalal>=(Alumnos.size()/2)) {
            return true;
        } else {
            return false;
        }
    }
    private String comprobarMateria(String materia){
        if (materia.equals("Matematicas") || materia.equals("Filosofia") || materia.equals("Fisica")){
            return materia;
        } else {
            return "Matematicas";
        }
    }
}
