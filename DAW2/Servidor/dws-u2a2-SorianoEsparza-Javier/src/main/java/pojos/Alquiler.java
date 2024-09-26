/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author ciclom
 */
public class Alquiler {
    private String pelicula;
    private int dias;
    private String edad;
    private String pago;
    private String extra;

    public Alquiler() {
        super();
    }

    public void setAlquiler(String pelicula, int dias, String edad, String pago, String extra) {
        this.pelicula = pelicula;
        this.dias = dias;
        this.edad = edad;
        this.pago = pago;
        this.extra = extra;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return this.pelicula +" " +this.pago +" " +this.edad +" " +this.dias;
    }
    
    
}
