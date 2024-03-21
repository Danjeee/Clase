package Varios;

import java.util.ArrayList;
import java.util.Scanner;

public class Arrym {
    static Scanner sc = new Scanner(System.in);
    public static void Llenar(int[][] t){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                t[i][j] = -1;
            }

        }
    }
    public static void CambiarTablero(int[][] t, String[][] tablero, String[] ficha){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (t[i][j] == 0){
                    tablero[i][j] = ficha[0];
                }
                if (t[i][j] == 1){
                    tablero[i][j] = ficha[1];
                }
                if (t[i][j] == -1){
                    tablero[i][j] = "_";
                }
            }
        }
    }
    public static void Mostrar(String[][] tablero){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(tablero[i][j] +" ");
            }
            System.out.println();
        }
    }
    public static int Comprobar(int[][] t){
        int j1 = 0;
        int j2 = 0;
        int n=0;
        //Mirar Filas
        for (int i = 0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                if (t[i][j] == 0) {
                    j1++;
                }
                if (t[i][j] == 1) {
                    j2++;
                }
                if (t[i][j] == -1) {
                    n++;
                }
                if (j1 == 3) {
                    return 1;
                }
                if (j2 == 3) {
                    return 2;
                }
            }
            j1 = 0;
            j2 = 0;
        }
        //Mirar Columnas
        for (int i = 0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                if (t[j][i] == 0) {
                    j1++;
                }
                if (t[j][i] == 1) {
                    j2++;
                }
                if (t[j][i] == -1) {
                    n++;
                }
                if (j1 == 3) {
                    return 1;
                }
                if (j2 == 3) {
                    return 2;
                }
            }
            j1 = 0;
            j2 = 0;
        }
        if (n==0){
            return 3;
        }
        //Diagonales
        //Mirar \
        if (t[0][0] == 0 && t[1][1] == 0 && t[2][2] == 0){
            return 1;
        }
        if (t[0][0] == 1 && t[1][1] == 1 && t[2][2] == 1){
            return 2;
        }
        //Mirar /
        if (t[0][2] == 0 && t[1][1] == 0 && t[2][0] == 0){
            return 1;
        }
        if (t[0][2] == 1 && t[1][1] == 1 && t[2][0] == 1){
            return 2;
        }

        return 0;
    }
    public static void Lista(ArrayList<String> top, ArrayList <Integer> topp){
        for (int i=0; i<top.size(); i++){
            System.out.println("Jugador ------------ Puntuacion");
            System.out.println(top.get(i) +" ------------ " +topp.get(i));
        }
    }
}
