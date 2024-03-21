import java.util.Scanner;
import static java.lang.Thread.sleep;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ejerciciosarray2_javierse {
    static Scanner sc = new Scanner(System.in);
    static void ej1(){
        int tmax=0;
        int tmin=0;
        int[] tmedia = new int[24];
        String x=null;
        String[] mes = {"enero", " ", "febrero", " ", "marzo", " ", "abril", " ", "mayo", " ", "junio", " ", "julio", " ", "agosto", " ", "septiembre", " ", "octubre", " ", "noviembre", " ", "diciembre"};
        for (int i=0;i<24;i+=2){
            System.out.println("Escriba la temperatura máxima de " +mes[i]);
            tmax = sc.nextInt();
            System.out.println("Escriba la temperatura minima de " +mes[i]);
            tmin= sc.nextInt();
            tmedia[i]=(tmax + tmin) /2;
        }
        for (int i=0;i<24;i+=2){
            System.out.println(mes[i] +" (" +tmedia[i] +")");
            if (tmedia[i]>0){
                x="[]";
            }else{
                x="()";
                tmedia[i]*=-1;
            }
            for (int j=tmedia[i];j>0; j--){
                System.out.print(x);
            }
            System.out.println();
            System.out.println();
        }
    }
    static void ej2() {
        int[] x= new int[20];
        int[] p= new int[20];
        int[] i= new int[20];
        int pp=0;
        int ii=0;
        System.out.println("Se esta generando el numero... ");
        for (int j=0;j!=20;j++){
            x[j]= (int) (Math.random()*100);
            System.out.println("El numero nº" +(j+1) +" es " +x[j]);
        }
        for (int j=0;j!=20;j++){
            p[j]=-1;
        }
        for (int j=0;j!=20;j++){
            i[j]=-1;
        }
        for (int j=0;j!=20;j++){
            if (x[j] % 2 == 0){
                p[pp]=x[j];
                pp++;
            } else {
                i[ii]=x[j];
                ii++;
            }
        }
        System.out.println();
        int j=0;
        pp=0;
        for (j=j;p[pp]!=-1;j++){
            if (p[pp]==-1){
                break;
            }
            x[j]=p[pp];
            pp++;
        }
        ii=0;
        for (j=j;i[ii]!=-1;j++){
            if (i[ii]==-1){
                break;
            }
            x[j]=i[ii];
            ii++;
        }
        for (j=0;j!=20;j++){
            System.out.print(x[j]);
            if (j!=19){
                System.out.print(", ");
            }

        }
    }
    static void ej3(){
        int[] mesa = new int[11];
        int x=0;
        int cont=0;
        boolean comp=false;
        while (x!=-1){
            System.out.print("¿Cuantos son? (Introduzca -1 para salir del programa): ");
            x=sc.nextInt();
            if (x==-1){
                break;
            }
            for (int i=1; i<=10; i++){
                if (x+mesa[i]<=4 && x+mesa[i]>=0){
                    if (mesa[i]!=0){
                        comp=true;
                    }
                    mesa[i]+=x;
                    cont=i;
                    break;
                }
            }
            if (cont!=0){
                if (comp){
                    System.out.println("Tendran que compartir mesa, porfacor sientense en la mesa numero " +cont);
                } else {
                    System.out.println("Por favor, sientense en la mesa numero " +cont);
                }
            } else {
                System.out.println("Lo siento, en estos momentos no queda sitio");
            }
            cont=0;
            comp=false;
        }
        System.out.println("Gracias. Hasta pronto");
    }
    public static void main(String[] args) throws InterruptedException {
        int repet = 0;
        while (repet == 0) {
            System.out.println(" ");
            System.out.println("Elije que ejercicio va a ejecutar");
            System.out.println("(Para cerrar el bucle pulse 4)");
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
                    repet = 1;
                    break;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(2000);
        }
    }
}