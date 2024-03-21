package Varios;

import java.util.Scanner;

public class Varios {
    static Scanner sc = new Scanner(System.in);
    public static void SeleccionarJugador(String[] jugador){
        System.out.println("Escriba el nombre de un jugador");
        String j1 = sc.nextLine();
        System.out.println("Escriba el nombre de otro jugador");
        String j2 = sc.nextLine();
        if (j1.compareTo(j2)<=0){
            jugador[0] = j1;
            jugador[1] = j2;
            System.out.println(j1 +" será el primer jugador");
        } else {
            jugador[0] = j2;
            jugador[1] = j1;
            System.out.println(j2 +" será el primer jugador");
        }
    }
    public static int AlterTurnos(int turno){
        if (turno==0){
            return 1;
        }
        if (turno==1){
            return 0;
        }
        return 0;
    }
}
