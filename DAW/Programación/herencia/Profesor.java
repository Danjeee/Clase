public class Profesor extends Persona {
    protected String especialidad;
    protected int salario;
    public Profesor(String nombre, String apellidos, String FN, int salario, String especialidad){
        super(nombre, apellidos, FN);
        this.salario = salario;
        this.especialidad = especialidad;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public int getSalario() {
        return salario;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }
    
}
