public class Empleado {
    public String nombre;
    public int salario;
    public Empleado(String nombre, int salario) {
        this.nombre = nombre;
        this.salario = salario;
    }
    @Override
    public String toString() {
        return this.nombre +" " +this.salario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getSalario() {
        return salario;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }
}
