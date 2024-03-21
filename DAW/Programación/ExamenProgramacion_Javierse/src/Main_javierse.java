import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Thread.sleep;

import Juego.Juego;
import Varios.*;

public class Main_javierse {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean exit=false;
        ArrayList<String> top = new ArrayList<>();
        ArrayList<Integer> topp = new ArrayList<>();
        while (!exit) {
            System.out.println("""
                    MENU
                    1.- Jugar
                    2.- Puntuaciones
                    0.- Salir""");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    Juego.Juego(top,topp);

                    break;
                case 2:
                    Ordenacion.Ordenar(top, topp);
                    Arrym.Lista(top,topp);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println(menu +" no es una opcion, vuelve a intentarlo");
                    break;
            }
        }
    }
}