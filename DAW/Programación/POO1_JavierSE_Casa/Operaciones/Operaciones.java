package Operaciones;

import java.util.ArrayList;

public class Operaciones {
    public static void Hallarprimos(ArrayList<Integer> a, int n){
        a.add(1);
        for (int i=2; n!=1 ; i++){
            if(n % i == 0){
                a.add(i);
                n /= i;
                i=1;
            }
        }
    }
    public static void mostrarArray(ArrayList<Integer> a){
        for (int i=0; i<=a.size(); i++){
            if (i==a.size()){
                break;
            }
            System.out.println(a.get(i));
        }
    }
    public static void simplificar(ArrayList<Integer> n, ArrayList<Integer> d){
        int ii=0;
        boolean end = false;
        while (!end) {
            if (ii==n.size()){
                end = true;
            }
            for (int i = 1; i <= d.size(); i++) {
                if (i == d.size()) {
                    break;
                }
                if (ii == n.size()){
                    ii=1;
                }
                if (d.get(i).equals(n.get(ii))) {
                    n.remove(ii);
                    d.remove(i);
                    ii=1;
                    break;
                }
            }
            ii++;
        }
    }
    public static int replace(ArrayList<Integer> a){
        int suma = 1;
        for (int i=0; i<=a.size(); i++){
            if (i==a.size()){
                break;
            }
            suma*=a.get(i);
        }
        return suma;
    }
}
