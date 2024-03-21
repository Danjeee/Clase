package Transporte;

import java.util.Scanner;

public abstract class Vehiculo {
    static Scanner sc = new Scanner(System.in);
    public String marca;
    public String modelo;
    public double consumo;
    protected double permas;

    protected double calcularConsumo(double permas){
        System.out.println("Indique los km que tarda en acabarse la gasolina");
        double km = sc.nextDouble();
        System.out.println("Cuanta gasolina tenia");
        int inigas = sc.nextInt();
        km = km/permas;
        double cons = inigas/km;
        return cons;
    }

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName() +" " +this.marca +" " +this.modelo +" " +this.consumo;
    }
}
