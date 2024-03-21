import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Thread.sleep;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ordenacion_javierse {
    static Scanner sc = new Scanner(System.in);
    static void ej1(){
        float[] x = new float[6];
        for (int i=0; i<6; i++){
            System.out.println("Escriba el numero num " +(i+1));
            x[i]=sc.nextFloat();
        }
        float aux = x[0];
        int pos=0;
        int cont=0;
        while (cont<6) {
            for (int i = cont; i < 6; i++) {
                if (aux > x[i]) {
                    aux = x[i];
                    pos = i;
                }
            }
            x[pos] = x[cont];
            x[cont] = aux;
            cont++;
            if (cont!=6){
                aux=x[cont];
                pos=cont;
            }
        }
        for (int i=0; i<6; i++){
            System.out.print(x[i]);
            if (i!=5){
                System.out.print(", ");
            }
        }
    }
    static void ej2(){
        String[] x = new String[5];
        System.out.println();
        for (int i=0; i<5; i++){
            System.out.println("Escriba el nombre nº" +(i+1));
            x[i] = sc.nextLine();
        }
        String aux = x[0];
        int pos=0;
        int cont=0;
        int comp=x[0].compareTo(x[1]);
        while (cont<5) {
            for (int i = cont; i < 5; i++) {

                if (x[i].compareTo(x[pos]) < 0) {
                    aux = x[i];
                    pos = i;
                }
            }
            x[pos] = x[cont];
            x[cont] = aux;
            cont++;
            if (cont!=5){
                aux=x[cont];
                pos=cont;
            }
        }
        for (int i=0; i<5; i++){
            System.out.print(x[i]);
            if (i!=4){
                System.out.print(", ");
            }
        }
    }
    static void ej3(){
        String x = " ";
        ArrayList<Integer> n = new ArrayList<>();
        int cont = 0;
        int pos=0;
        int aux=0;
        while (!x.equals("fin")){
            System.out.println("Escriba un numero");
            x=sc.nextLine();
            if (!x.equals("fin")) {
                n.add(Integer.parseInt(x));
            }
            cont=0;
            pos=0;
            aux=n.get(0);
            while (cont<n.size()) {
                for (int i = cont; i < n.size(); i++) {
                    if (aux > n.get(i)) {
                        aux = n.get(i);
                        pos = i;
                    }
                }
                n.set(pos, n.get(cont));
                n.set(cont, aux);
                cont++;
                if (cont!=n.size()){
                    aux=n.get(cont);
                    pos=cont;
                }
            }
            for (int i=0; i<n.size(); i++){
                System.out.print(n.get(i));
                if (i!=n.size()-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
    static void ej4(){
        String x = "0";
        ArrayList<Integer> n = new ArrayList<>();
        int cont = 0;
        int pos=0;
        int aux=0;
        int xx=0;
        boolean pp=false;
        while (!x.equals("fin")){
            System.out.println("Escriba un numero");
            x=sc.nextLine();
            if (!x.equals("fin") && !x.equals("preguntar")) {
                xx=Integer.parseInt(x);
            }
            if (!x.equals("fin")) {
                if (x.equals("preguntar")) {
                    System.out.println("Que valor quieres averiguar");
                    int v = sc.nextInt();
                    pp = false;
                    for (int i : n) {
                        if (i == v) {
                            pp = true;
                        }
                    }
                    if (pp) {
                        System.out.println(v + " si esta en los datos");
                    } else {
                        System.out.println(v + " no esta en los datos");
                    }
                    break;
                } else {
                    n.add(xx);
                    cont=0;
                    pos=0;
                    aux=n.get(0);
                    while (cont<n.size()) {
                        for (int i = cont; i < n.size(); i++) {
                            if (aux > n.get(i)) {
                                aux = n.get(i);
                                pos = i;
                            }
                        }
                        n.set(pos, n.get(cont));
                        n.set(cont, aux);
                        cont++;
                        if (cont!=n.size()){
                            aux=n.get(cont);
                            pos=cont;
                        }
                    }
                    for (int i=0; i<n.size(); i++){
                        System.out.print(n.get(i));
                        if (i!=n.size()-1){
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int repet = 0;
        while (repet == 0) {
            System.out.println(" ");
            System.out.println("Elije que ejercicio va a ejecutar");
            System.out.println("(Para cerrar el bucle pulse 5)");
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
                    repet = 1;
                    break;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(2000);
        }
    }
}