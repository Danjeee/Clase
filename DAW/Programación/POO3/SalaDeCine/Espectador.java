package SalaDeCine;

import java.util.ArrayList;
import java.util.Scanner;

public class Espectador {
    protected String nombre;
    protected int edad;
    protected double dinero;
    public boolean asignado = false;
    protected String asiento;
    protected int sala;

    static Scanner sc = new Scanner(System.in);

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public Espectador(String nombre, int edad, double dinero,int sala, ArrayList<SalaDeCine> salas) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
        this.sala = sala;
        asignar(salas, sala);
    }

    public void asignar(ArrayList<SalaDeCine> salas, int sala) {
        if (sala > salas.size()) {
            while (sala > salas.size()) {
                System.out.println("Sala no valida, intentalo de nuevo");
                sala = sc.nextInt();
            }
        }
        sala -= 1;
        if (this.edad < salas.get(sala).edadMin) {
            System.out.println("Demasiado pequeño para ver esta pelicula");
        } else if (this.dinero < salas.get(sala).precio) {
                System.out.println("No tienes suficiente dinero");
        } else{
            System.out.println("Seleccione un asiento");
            salas.get(sala).dibujarSala();
            String asiento = sc.next();
            for (int i = 0; i < salas.get(sala).saladraw.length; i++){
                for (int j = 0; j<salas.get(sala).saladraw[i].length; j++){
                    if (salas.get(sala).sala[i][j]) {
                        System.out.println("Lo sentimos, ese asiento esta ocupado, elija otro");
                    } else {
                        if (asiento.equals(salas.get(sala).saladraw[i][j])) {
                            this.asiento = salas.get(sala).saladraw[i][j];
                            this.asignado = true;
                            salas.get(sala).sala[i][j] = true;
                        }
                    }
                }
            }
        }
    }
    public String estaAsignado(){
        if (this.asignado) {
            return "Si";
        } else {
            return "No";
        }
    }
}
