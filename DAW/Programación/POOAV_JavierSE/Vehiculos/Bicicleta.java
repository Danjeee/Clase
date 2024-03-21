package Vehiculos;

import java.util.Random;

public class Bicicleta extends Vehiculos{
    public boolean llevaRuedines;

    public boolean isLlevaRuedines() {
        return llevaRuedines;
    }
    public void setLlevaRuedines(boolean llevaRuedines) {
        this.llevaRuedines = llevaRuedines;
    }
    public Bicicleta(boolean llevaRuedines) {
        super();
        this.llevaRuedines = llevaRuedines;
    }
    public void conducir(int km, int velocidad) {
        if (!roto) {
            if (llevaRuedines && velocidad > 10) {
                velocidad = 10;
            }
            this.kilometrosRecorridos += (km * velocidad);
            Vehiculos.kilometrosTotales += (km * velocidad);
        } else {
            System.out.println("Vehiculo roto, reinicia el ejercicio para arreglarlo");
        }
    }
    public void cabakllito(){
        Random r = new Random();
        int km = r.nextInt(20);
        if (!roto){
            System.out.println("Has hecho un caballito con la biciclete y has ganado puntos de estilo, recorriendo " +km +"km");
            this.kilometrosRecorridos += km;
            Vehiculos.kilometrosTotales += km;
            this.roto = r.nextBoolean();
            if (this.roto) {
                System.out.println("Su vehiculo se ha roto!");
            }
        } else{
            System.out.println("Vehiculo roto, reinicia el ejercicio para arreglarlo");
        }
    }
}
