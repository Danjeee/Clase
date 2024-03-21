import java.util.ArrayList;

public class Paciente {
    private String DNI;
    private String nombre;
    private ArrayList<String> consultas = new ArrayList<>();
    public static int totalpacientes = 0;
    public Paciente(String nombre, String dni) {
        this.nombre = nombre;
        this.DNI = dni;
        totalpacientes++;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String dNI) {
        DNI = dNI;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void añadirconsulta(String consultas) {
        this.consultas.add(consultas);
    }
    public void getConsultas(){
        System.out.println(this.getClass().getSimpleName() +": " +this.nombre +". DNI: " +this.DNI +" Consultas Realizadas: ");
        System.out.println();
        for (String i : this.consultas){
            System.out.println(i);
        }
    }
    @Override
    public boolean equals(Object obj) {
        Paciente a = (Paciente)obj;
        return this.DNI.equals(a.DNI);
    }
    @Override
    public String toString() {
        return this.DNI +": " +this.nombre;
    }
    @Override
    public int hashCode() {
        return Integer.parseInt(this.DNI);
    }
}
