/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adivina;

import java.util.Scanner;

/**
 *
 * @author adminroot
 */
public class Adivina {

    public static void main(String[] args) {

        int n = 50, max = 100, m = 0;
        char r;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Piensa un número del 1 al 100 ¡Voy a adivinarlo!\n");
        do {
            System.out.println("¿El número que estás pensando es igual \"=\", mayor \">\" o menor \"<\" a " + n + "?");
            r = entrada.next().charAt(0);
            while ((r != '<') && (r != '>') && (r != '=')) {
                System.out.println("No te he entendido, por favor responde \">\", \"<\" o \"=\" y pulsa \"enter\": ");
                r = entrada.next().charAt(0);
            }
            if (r == '<') {
                max = n - 1;
                n = (max + n) / 2;
            } else if (r == '>') {
                m = n + 1;
                n = (max + n) / 2;
            }
        } while (r != '=');

        System.out.println("¡Acerté!");

    }

}
