import java.util.Locale;
import java.util.Scanner;

public class Cafetera_javierse {
    static Scanner sc = new Scanner(System.in);
    public final int MAX = 1000;
    private int actual = 0;
    public void llenarCafetera(){
        this.actual = this.MAX;
    }

    public int getMAX() {
        return MAX;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public void agregarCafe(int cant){
        this.actual += cant;
        if (this.actual > this.MAX){
            this.actual = this.MAX;
        }
        System.out.println("El cafe ha sido agregado");
    }
    public void VaciarCafetera() {
        if (this.actual == 0) {
            System.out.println("La cafetera ya esta vacia");
        } else {
            System.out.println("Vas a tirar " + this.actual + "ml, ¿Estas segur@?");
            String res = sc.next();
            res = res.toLowerCase();
            if (res.equals("si")) {
                this.actual = 0;
                System.out.println("Se ha vaciado la cafetera");
            }
        }
    }
    public void servirTaza(int cant){
        if (this.actual < cant){
            System.out.println("No hay suficiente, se ha servido una taza de "+cant);
            this.actual = 0;
        } else{
            System.out.println("Se ha servido la taza de " +cant);
            this.actual = this.actual - cant;
        }
    }
}
