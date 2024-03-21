import a.A;

import java.util.Scanner;

import static a.A.*;

public class ahorcado_javierse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String peli = peli();
        String[] letra = peli.split("");
        int errores=0;
        boolean mas = false;
        boolean muerte = false;
        llenararray(letra);
        boolean correcto = false;
        while (!correcto) {
            mas = false;
            clear();
            dibujar(letra, errores);
            if (muerte){
                System.out.println("¡Has perdido!");
                break;
            }
            String l = sc.nextLine();
            l = primeraletra(l);
            mas = check(peli,letra,l);
            cambiar(peli,letra,l);
            if (mas){
                errores++;
            }
            correcto=correcto(letra,peli);
            muerte=muerte(errores);
        }
        if (correcto){
            clear();
            dibujar(letra,errores);
            System.out.println("¡Has ganado!");
        }
    }
}