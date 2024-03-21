package Funciones;

import java.util.Scanner;

public class Mates {
    static Scanner sc = new Scanner(System.in);
    public static int sumarvotos(int pos, int[] votos, int bl, int nul){
        int suma=0;
        suma += nul;
        suma += bl;
        for (int i=0; i<pos; i++){
            suma+=votos[i];
        }
        return suma;
    }
    public static void porcentaje(int pos, int[] votos, float[] per, int total){
        for (int i=0; i<pos; i++){
            per[i] = ((float) votos[i] /total)*100;
        }
    }
}
