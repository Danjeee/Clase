package Transporte;

import java.util.Scanner;

public class Coche extends Vehiculo {
    static Scanner sc = new Scanner(System.in);
    private double peso;

    private double calcularPeso(int pesov){
        if (pesov>3500) {
            pesov = 3500;
        }
        System.out.println("indique la cantidad de pasajeros");
        int pas = sc.nextInt();
        if (pas>5) {
            pas = 5;
        }
        pesov = pesov + (pas*60);
        return pesov;
    }
    private double calcularPermas(){
        double pini = this.peso/2000;
        return pini;
    }
    public Coche(String marca, String modelo, int peso) {
        super(marca, modelo);
        this.peso = calcularPeso(peso);
        this.permas = calcularPermas();
        this.consumo = calcularConsumo(this.permas);
    }
}
