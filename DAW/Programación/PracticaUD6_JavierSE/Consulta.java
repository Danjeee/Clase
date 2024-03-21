import java.util.ArrayList;

public class Consulta {
    private String tipo;
    public static int totalConsultas = 0;
    private ArrayList<String> paciente = new ArrayList<>();
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Consulta(String tipo) {
        this.tipo = tipo;
        Consulta.totalConsultas++;
    }
    public void añadirconsulta(Paciente a){
        this.paciente.add(a.getDNI() +": " +a.getNombre());
    }
    public void mostrarConsultas(){
        System.out.println("Pacientes que han solicitado " +this.getClass().getSimpleName() +":");
        for (String i : this.paciente){
            System.out.println(i);
        }
        System.out.println("Total: " +this.paciente.size() +" pacientes");
    }
    @Override
    public String toString() {
        return this.tipo;
    }
}
