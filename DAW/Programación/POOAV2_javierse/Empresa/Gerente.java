package Empresa;

public class Gerente extends Empleado {
    public int bono;
    public Gerente(String nombre, double salario, int bono){
        super(nombre, salario);
        this.bono = bono;
    }
    @Override
    public double salarioAnual() {
        double sa = this.salario*14;
        sa += (sa*(this.bono/100));
        System.out.println("Salario anual: " +sa);
        return sa;
    }
}
