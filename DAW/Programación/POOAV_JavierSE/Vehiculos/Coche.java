package Vehiculos;

import java.util.Random;

public class Coche extends Vehiculos {
    private int gasolina;
    private int kmMax;
    private int usage;
    private int plazas;

    public int getGasolina() {
        return gasolina;
    }

    public void setGasolina(int gasolina) {
        this.gasolina = gasolina;
    }

    public Coche(int gasolina, int kmMax, int plazas) {
        super();
        this.gasolina = gasolina;
        this.kmMax = kmMax;
        this.plazas = plazas;
        this.usage = usageSet();
    }

    private int usageSet() {
        return (int) this.plazas / 2;
    }

    public void conducir(int km, int velocidad) {
        if (!roto) {
            if (gasolina * usage < km) {
                km = gasolina * usage;
            }
            if (velocidad > kmMax) {
                velocidad = kmMax;
            }
            this.kilometrosRecorridos += (km * velocidad);
            Vehiculos.kilometrosTotales += (km * velocidad);
            gasolina -= usage * km;
        } else {
            System.out.println("Vehiculo roto, reinicia el ejercicio para arreglarlo");
        }
    }

    public int getKmMax() {
        return kmMax;
    }

    public void setKmMax(int kmMax) {
        this.kmMax = kmMax;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public void quemarRueda(int km, int velocidad) {
        Random r = new Random();
        if (!roto) {
            if (gasolina * usage < km) {
                km = gasolina * usage;
            }
            if (velocidad > kmMax) {
                velocidad = kmMax;
            }
            velocidad *= 2;
            this.kilometrosRecorridos += (km * velocidad);
            Vehiculos.kilometrosTotales += (km * velocidad);
            gasolina -= usage * km;
            this.roto = r.nextBoolean();
            if (this.roto) {
                System.out.println("Su vehiculo se ha roto!");
            }
        } else{
            System.out.println("Vehiculo roto, reinicia el ejercicio para arreglarlo");
        }
    }
}
