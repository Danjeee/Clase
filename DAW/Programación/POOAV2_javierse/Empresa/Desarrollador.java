package Empresa;

public class Desarrollador extends Empleado {
    public String hab;
    public Desarrollador(String nombre, double salario, String hab) {
        super(nombre, salario);
        this.hab = hab;
    }
}
