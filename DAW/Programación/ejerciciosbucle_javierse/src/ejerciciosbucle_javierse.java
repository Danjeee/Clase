import java.util.Scanner;
import static java.lang.Thread.sleep;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ejerciciosbucle_javierse {
    static Scanner sc = new Scanner(System.in);
    static void ej1(){
        int x=1;
        while (x<101){
            System.out.println(x);
            x++;
        };
    }
    static void ej2(){
        int x=1;
        do {
            System.out.println(x);
            x++;
        }while (x < 101);
    }
    static void ej3(){
        int num = 0;
        int numm = 0;
        int corr=0;
        int op = 0;
        while (corr==0){
            System.out.println("Introduce un numero y te dare su factorial");
            num= sc.nextInt();
            if (num<=0){
                System.out.println(num +" es un numero negativo o 0, no es valido asi que intentalo de nuevo");
            }else{
                corr=1;
            }
        }
        numm=num-1;
        op=num;
        System.out.print(num);
        while (numm > 0){
            System.out.print(" * " +numm);
            op=op*numm;
            numm--;
        }
        System.out.print(" = " +op);
        System.out.println(" ");
    }
    static void ej4(){
        int x = 0;
        int xx = x;
        System.out.println("¿Cuantos niveles quieres que tenga la ecala inversa de asteriscos?");
        x=sc.nextInt();
        xx=x;
        while (x>0){
            while (xx>0){
                System.out.print("*");
                xx--;
            }
            x--;
            xx=x;
            System.out.println(" ");
        }
    }
    static void ej5(){
        int x=1;
        int xx=1;
        int num=0;
        System.out.println("¿Que altura quieres que tenga la escalera?");
        num=sc.nextInt();
        while (x<=num){
            while (xx<=x){
                System.out.print(xx);
                xx++;
            }
            x++;
            xx=1;
            System.out.println(" ");
        }
    }
    static void ej6(){
        int x=1;
        int xx=1;
        int num=0;
        int sp1=0;
        int sp2=0;
        System.out.println("¿Que altura quieres que tenga la escalera?");
        num=sc.nextInt();
        sp1= (int)Math.floor(num/2);
        sp2= sp1 + 2;
        while (x<=num){
            while (xx<=num){
                if (xx>sp1 && xx<sp2){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
                xx++;
            }
            x=x+2;
            xx=1;
            sp1--;
            sp2++;
            System.out.println(" ");
        }
    }
    static void ej7(){
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
            System.out.println(" ");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        int repet = 0;
        while (repet == 0) {
            System.out.println(" ");
            System.out.println("Elije que ejercicio va a ejecutar");
            System.out.println("(Para cerrar el bucle pulse 8)");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    ej1();
                    break;
                case 2:
                    ej2();
                    break;
                case 3:
                    ej3();
                    break;
                case 4:
                    ej4();
                    break;
                case 5:
                    ej5();
                    break;
                case 6:
                    ej6();
                    break;
                case 7:
                    ej7();
                    break;
                case 8:
                    repet = 1;
                    break;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(2000);
        }
    }
}