package Empresa;

public abstract class Empleado {
    public String nombre;
    public double salario;
    
    public double salarioAnual(){
        double sa = this.salario*14;
        System.out.println("Salario anual: " +sa);
        return sa;
    }

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }
}
