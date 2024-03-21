package Juego;
import Varios.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
    static Scanner sc = new Scanner(System.in);
    static String[][] tablero = new String[3][3];
    static String[] jugador = new String[2];
    static int[][] t = new int[3][3];
    static int turno = 0;
    static String[] ficha = {"X","O"};
    static boolean win = false;
    static boolean pos = false;
    static int estado = 0;
    static int punt=0;
    public static void Juego(ArrayList<String> top, ArrayList <Integer> topp){
        Varios.SeleccionarJugador(jugador);
        Arrym.Llenar(t);
        turno = 0;
        win = false;
        estado = 0;
        punt=0;
        while (!win){
            System.out.println("Turno de " +jugador[turno]);
            pos=false;
            while (!pos) {
                System.out.println("En que posicion quiere poner la ficha");
                System.out.print("Fila: ");
                int fila = sc.nextInt();
                System.out.print("Columna: ");
                int columna = sc.nextInt();
                if (columna<1 || columna>3 || fila<1 || fila>3){
                    System.out.println("Posicion no valida, intentelo de nuevo");
                } else {
                    if (t[fila-1][columna-1] != -1){
                        System.out.println("Esa posición ya esta ocupada, intentelo de nuevo");
                    } else {
                        t[fila-1][columna-1] = turno;
                        pos=true;
                    }
                }
            }
            Arrym.CambiarTablero(t,tablero,ficha);
            Arrym.Mostrar(tablero);
            estado=Arrym.Comprobar(t);
            punt++;
            if (estado!=0){
                win=true;
            }
            if (!win){
                turno=Varios.AlterTurnos(turno);
            }
        }
        if (estado==1 || estado==2){
            System.out.println("¡" +jugador[estado-1] +" ha ganado!");
            int o=0;
            for (int i=0; i<top.size();i++){
                if (top.get(i).equals(jugador[estado-1])){
                    o++;
                }
            }
            if (o==0){
                top.add(jugador[estado-1]);
                topp.add(punt);
            }else {
                topp.set(top.indexOf(jugador[estado - 1]), (topp.get(top.indexOf(jugador[estado - 1])) + punt));
            }
        }
        if (estado==3){
            System.out.println("¡Empate! (El tablero se ha llenado)");
        }
    }

}
