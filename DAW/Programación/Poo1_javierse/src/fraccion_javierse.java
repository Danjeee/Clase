import java.lang.reflect.Array;
import java.util.ArrayList;

public class fraccion_javierse {
    private int numerador;
    private int denominador;

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
    public void Invertir(){
        int aux = this.denominador;
        this.denominador = this.numerador;
        this.numerador = aux;
    }
    public void Multiplicar(int cant){
        this.numerador *= cant;
        this.denominador *= cant;
    }
    public void Dividir(int cant){
        boolean sepuede = true;
        if (this.numerador % cant != 0){
            sepuede = false;
        }
        if (this.denominador % cant != 0){
            sepuede = false;
        }
        if (sepuede){
            this.numerador /= cant;
            this.denominador /= cant;
        } else {
            System.out.println("No se puede dividir (no da exacto y no pone que haga fracciones complejas asi que)");
        }
    }
    public void Simplificar(){
        ArrayList <Integer> DivisoresD = new ArrayList<Integer>();
        ArrayList <Integer> DivisoresN = new ArrayList<Integer>();
        OperacionesComplejas.CalcDivisores(this.denominador, DivisoresD);
        OperacionesComplejas.CalcDivisores(this.numerador, DivisoresN);
    }
}
