import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class busquedabinaria_javierse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x = new int[1000];
        for (int i=0;i<1000;i++){
            x[i]= (int) (Math.random()*1001);
        }
        int aux = x[0];
        int pos=0;
        int cont=0;
        while (cont<999) {
            for (int i = cont; i < 1000; i++) {
                if (aux > x[i]) {
                    aux = x[i];
                    pos = i;
                }
            }
            x[pos] = x[cont];
            x[cont] = aux;
            cont++;
            if (cont!=999){
                aux=x[cont];
                pos=cont;
            }
        }
        int c=0;
        System.out.println("Escriba un numero para buscarlo en el array");
        int n=sc.nextInt();
        boolean corr=false;
        int mitad, inicio=0, fin=x.length;
        while (inicio<=fin){
            c++;
            mitad=(inicio+fin)/2;
            if (n==x[mitad]){
                corr=true;
                break;
            }
            if (n>x[mitad]){
                inicio=mitad+1;
            }
            if (n<x[mitad]){
                fin=mitad-1;
            }
        }
        if (corr){
            System.out.println("Se ha encontrado el numero en el array partiendolo " +c +" veces");
        } else {
            System.out.println("No se ha encontrado el numero en el array");
        }
    }
}