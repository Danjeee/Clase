import java.util.Scanner;
import static java.lang.Thread.sleep;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static void ej1(){
        int x=1;
        int xx=1;
        int num=0;
        int sp1=0;
        int sp2=0;
        System.out.println("¿Que altura quieres que tenga la escalera?");
        num=sc.nextInt();
        x=num;
        sp1= 0;
        sp2= num+1;
        while (x>=0){
            while (xx<=num){
                if (xx>sp1 && xx<sp2){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
                xx++;
            }
            x=x-2;
            xx=1;
            sp1++;
            sp2--;
            System.out.println();
        }
    }

    public static void main(String[] args) {
     ej1();
    }
}