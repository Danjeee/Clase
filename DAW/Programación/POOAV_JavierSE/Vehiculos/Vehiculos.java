package Vehiculos;

public abstract class Vehiculos {
    public static int vehiculoscreados;
    public static int kilometrosTotales;
    protected int kilometrosRecorridos;
    protected boolean roto;

    public static int getVehiculoscreados() {
        return vehiculoscreados;
    }
    public static void setVehiculoscreados(int vehiculoscreados) {
        Vehiculos.vehiculoscreados = vehiculoscreados;
    }
    public static int getKilometrosTotales() {
        return kilometrosTotales;
    }
    public static void setKilometrosTotales(int kilometrosTotales) {
        Vehiculos.kilometrosTotales = kilometrosTotales;
    }
    public int getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }
    public void setKilometrosRecorridos(int kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }
    public Vehiculos() {
        this.kilometrosRecorridos = 0;
        this.roto = false;
        Vehiculos.vehiculoscreados++;
    }
    public void verKilometrajeThis(){
        System.out.println(this.getClass().getSimpleName() + ": " +this.kilometrosRecorridos);
    }
}
