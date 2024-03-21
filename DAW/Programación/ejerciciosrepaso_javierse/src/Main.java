import java.util.Scanner;

import static java.lang.Thread.sleep;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner sc = new Scanner(System.in);

    static void ej1() {
        int esp,espp, as, ass, h;
        as = 1;
        ass = as;
        h = 13;
        esp=h/2;
        espp=esp;
        for (int i=0; i<h;i++){
            for (int j=0; j<7; j++){
                if (esp!=0){
                    System.out.print(" ");
                    esp--;
                } else if (ass!=0){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            if (i>h/2){
                espp++;
                esp=espp;
                as++;
            }
            if (i<h/2){
                espp--;
                esp=espp;
                as--;
            }
            ass=as;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ej1();
    }
}