package Personas;

public class Profesor extends Persona {
    protected double salario;
    protected String especialidad;
    @Override
    public String getNombre() {
        return "Profesor: " +super.getNombre();
    }
    protected double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public Profesor(String nombre, String apellidos, String fechaN, double salario, String especialidad) {
        super(nombre, apellidos, fechaN);
        this.salario = salario;
        this.especialidad = especialidad;
    }
    @Override
    public String toString() {
        return super.toString() + ", Salario: " +this.salario +", Especialidad: " +this.especialidad;
    }
}
