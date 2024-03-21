package Personas;

import java.util.Random;

public abstract class Personas {
    protected String nombre;
    protected int edad;
    protected String sexo;
    protected boolean disponible;
    protected int per;

    protected boolean polimorfismo(){
        Random r = new Random();
        if (r.nextInt(100) <= this.per){
            return false;
        } else {
            return true;
        }
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Personas(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
}
