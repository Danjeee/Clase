package Transporte;

public class Camion extends Vehiculo {
    private double peso;

    private double calcularPeso(int pesov){

        if (peso<3500) {
            pesov = 3500;
        }
        System.out.println("indique la cantidad de pasajeros");
        int pas = sc.nextInt();
        if (pas>2) {
            pas = 2;
        }
        pesov = pesov + (pas*80);
        return pesov;
    }
    private double calcularPermas(){
        double pini = this.peso/2000;
        return pini;
    }
    public Camion(String marca, String modelo, int peso) {
        super(marca, modelo);
        this.peso = calcularPeso(peso);
        this.permas = calcularPermas();
        this.consumo = calcularConsumo(this.permas);
    }
}
