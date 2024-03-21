package SalaDeCine;

import java.util.ArrayList;
import java.util.Scanner;

public class SalaDeCine {
    static Scanner sc = new Scanner(System.in);
    public String tituloPelicula;
    public int edadMin;
    public double precio;
    protected boolean[][] sala;
    protected String[][] saladraw;
    public int salanum;

    public String[][] getSaladraw() {
        return saladraw;
    }

    public void setSaladraw(String[][] saladraw) {
        this.saladraw = saladraw;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public double getPrecio() {
        return precio;
    }

    public int getSalanum() {
        return salanum;
    }

    public void setSalanum(int salanum) {
        this.salanum = salanum;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean[][] getSala() {
        return sala;
    }

    public void setSala(boolean[][] sala) {
        this.sala = sala;
    }

    public SalaDeCine(String tituloPelicula, int columnas, int filas, ArrayList<Pelicula> pelis, int sala) {
        this.tituloPelicula = comprobarPeli(tituloPelicula, pelis);
        this.precio = comprobarPrecio(pelis);
        this.sala = new boolean[columnas][filas];
        this.saladraw = new String[columnas][filas];
        this.salanum = sala;
        this.edadMin = comprobarEdad(pelis);
        crearSala();
    }

    public int getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(int edadMin) {
        this.edadMin = edadMin;
    }

    private String comprobarPeli(String nombre, ArrayList<Pelicula> pelis) {
        boolean corr = false;
        while (!corr) {
            for (int i = 0; i < pelis.size(); i++) {
                if (nombre.equals(pelis.get(i).titulo)) {
                    return nombre;
                }
            }
            System.out.println(nombre + " no existe, intentelo de nuevo");
            System.out.println("Listado de pelis: ");
            for (int i=0; i<pelis.size(); i++){
                System.out.println(pelis.get(i).titulo);
            }
            nombre = sc.next();
        }
        return nombre;
    }
    private double comprobarPrecio(ArrayList<Pelicula> pelis){
        for (int i=0; i<pelis.size(); i++){
            if (this.tituloPelicula.equals(pelis.get(i).titulo)) {
                return pelis.get(i).precio;
            }
        }
        return 0;
    }
    private int comprobarEdad(ArrayList<Pelicula> pelis){
        for (int i=0; i<pelis.size(); i++){
            if (this.tituloPelicula.equals(pelis.get(i).titulo)) {
                return pelis.get(i).edadMin;
            }
        }
        return 0;
    }
    private void crearSala(){
        char fila = 65;
        for (int i = 0; i<this.saladraw.length; i++){
            for (int j=0; j<this.saladraw[i].length; j++){
                this.saladraw[i][j] = "";
                this.saladraw[i][j] += Integer.toString((this.saladraw.length) - i);
                this.saladraw[i][j] += Character.toString(fila);
                fila++;
            }
            fila = 65;
        }
    }
    public void dibujarSala(){
        final String VERDE = "\u001B[32m";
        final String ROJO = "\u001B[31m";
        final String RESET = "\u001B[0m";
        for (int i = 0; i<this.saladraw.length; i++){
            for (int j=0; j<this.saladraw[i].length; j++){
                if (this.sala[i][j]) {
                    System.out.print(ROJO + this.saladraw[i][j] + RESET + " ");
                } else {
                    System.out.print(VERDE + this.saladraw[i][j] + RESET + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(VERDE + "Verde = Libre" +RESET);
        System.out.println(ROJO + "Rojo = Ocupado" +RESET);
    }
}
