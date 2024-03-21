import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Colas_Javierse {
    static final double ENTRADA_5_10_ANYOS = 1;
    static final double ENTRADA_11_17_ANYOS = 2.5;
    static final double ENTRADA_ADULTOS = 3.5; 
    static final double ENTRADA_SENIOR = 2;
    static Scanner sc = new Scanner(System.in);
    static void cargarPersonasCola(Queue<Persona> colaCine){
        System.out.println("cuantas personas quieres crear");
        int n = sc.nextInt();
        Random r = new Random();
        for (int i=0; i<n;i++){
            colaCine.offer(new Persona(r.nextInt(100)));
        }
    }
    static double calcularRecaudacion(Queue<Persona> colaCine){
        int res= 0;
        for (Persona i : colaCine){
            if (i.edad >= 5 && i.edad <= 10) {
                res+=ENTRADA_5_10_ANYOS;
            }
            if (i.edad >= 11 && i.edad <= 17) {
                res+=ENTRADA_11_17_ANYOS;
            }
            if (i.edad >= 18 && i.edad <= 65) {
                res+=ENTRADA_ADULTOS;
            }
            if (i.edad > 65) {
                res+=ENTRADA_SENIOR;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Queue<Persona> colaCine = new LinkedList<>();
        cargarPersonasCola(colaCine);
        System.out.println(calcularRecaudacion(colaCine));;
    }
}