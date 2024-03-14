import java.util.ArrayList;
import java.util.Scanner;

import Operaciones.Operaciones;

public class Fraccion {
    static Scanner sc = new Scanner(System.in);
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
    public void translate(int n, int n2, int d, int d2){
        boolean comp = false;
        boolean comp2 = false;
        if (n%d == 0){
            comp = true;
        }
        if (n2%d2 == 0){
            comp2 = true;
        }
        if (!comp & comp2){
            System.out.println(n +"/" +d +" -> " +n2 +"/" +d2 +" (" +(n2/d2) +")");
        }else if (!comp & !comp2){
            System.out.println(n +"/" +d +" -> " +n2 +"/" +d2);
        }else if (comp & !comp2){
            System.out.println("("+(n/d)+") " +n +"/" +d +" -> " +n2 +"/" +d2);
        }else if(comp & comp2){
            System.out.println("("+(n/d)+") " +n +"/" +d +" -> " +n2 +"/" +d2 +" (" +(n2/d2) +")");
        }
    }
    public void invertir(){
        boolean comp = false;
        boolean comp2 = false;
        int d = this.denominador;
        int n = this.numerador;
        int aux = this.numerador;
        this.numerador = this.denominador;
        this.denominador = aux;
        translate(n, this.numerador, d, this.denominador);
    }
    public void determinar(){
        System.out.println("Indica numerador: ");
        int n = sc.nextInt();
        System.out.println("Indica denominador: ");
        int d = sc.nextInt();
        this.denominador = d;
        this.numerador = n;
    }
    public void Simplificar(){
        int d = this.denominador;
        int n = this.numerador;
        boolean comp = false;
        boolean comp2 = false;
        ArrayList<Integer> PN = new ArrayList<>();
        ArrayList<Integer> PD = new ArrayList<>();
        Operaciones.Hallarprimos(PN, this.numerador);
        Operaciones.Hallarprimos(PD, this.denominador);
        Operaciones.simplificar(PN, PD);
        this.numerador= Operaciones.replace(PN);
        this.denominador= Operaciones.replace(PD);
        translate(n, this.numerador, d, this.denominador);
    }
    public void mostrar(){
        if (this.numerador % this.denominador == 0){
            System.out.println("Numero entero: "+(this.numerador/this.denominador));
            System.out.println("Fraccion:");
            System.out.println(this.numerador);
            System.out.println("—");
            System.out.println(this.denominador);
        }else {
            System.out.println(this.numerador);
            System.out.println("—");
            System.out.println(this.denominador);
        }
    }
    public void div(int n){
        int num = this.numerador;
        int d = this.denominador;
        this.denominador *= n;
        translate(num,this.numerador ,d ,this.denominador);
    }
    public void mult(int n){
        int num = this.numerador;
        int d = this.denominador;
        this.denominador *= n;
        this.numerador *= n;
        translate(num, this.numerador, d, this.denominador);
    }
}
