public class Alumno extends Persona {
    protected String grupo;
    protected double notaMedia;
    public Alumno(String nombre, String apellidos, String FN){
        super(nombre, apellidos, FN);
    }
    public Alumno(String nombre, String apellidos, String FN, String grupo, double notaMedia){
        super(nombre, apellidos, FN);
        this.grupo = grupo;
        this.notaMedia = notaMedia;
    }
    public String getGrupo() {
        return grupo;
    }
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    public double getNotaMedia() {
        return notaMedia;
    }
    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }
}
