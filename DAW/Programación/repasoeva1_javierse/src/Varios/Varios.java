package Varios;

public class Varios {
    public static void arrayrandomizar(int a[]){
        for (int i = 0; i<a.length; i++){
            a[i] = (int)(Math.random()*1000);
        }
    }
    public static void matrizrandom(int a[][]){
        for (int i = 0; i<a.length; i++){
            for (int j=0; j<a.length; j++){
                a[i][j] = (int)(Math.random()*1000);
            }
        }
    }
    public static void mostrarm(int a[][]){
        for (int i = 0; i<a.length; i++){
            for (int j=0; j<a[i].length; j++){
                System.out.print(a[i][j] +" ");
            }
            System.out.println();
        }
    }
    public static void mostrar(int a[]){
        for (int i = 0; i<a.length; i++){
            System.out.print(a[i]);
            if (i!=a.length-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    public static int max(int[] a){
        int max = a[0];
        for (int i=0;i<a.length;i++){
            if (a[i]>max){
                max=a[i];
            }
        }
        return max;
    }
    public static void ordenarburbuja(int[] a){
        int x;
        for(int i = 0; i < a.length-1; i++ )
            for (int j = 0 ; j < a.length-1; j++) {
                if (a[j+1] < a[j]) {
                    x = a[j];
                    a[j] = a[j+1];
                    a[j+1] = x;
                }
            }
    }
    public static void sumamatrices(int[][] a, int[][] b, int[][] res){
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[i].length;j++){
                res[i][j] = a[i][j] + b[i][j];
            }
        }
    }
    public static void restamatrices(int[][] a, int[][] b, int[][] res){
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[i].length;j++){
                res[i][j] = a[i][j] - b[i][j];
            }
        }
    }
    public static void multmatrices(int[][] a, int b, int[][] res){
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[i].length;j++){
                res[i][j] = a[i][j] * b;
            }
        }
    }
    public static int min(int[] a){
        int min = a[0];
        for (int i=0;i<a.length;i++){
            if (a[i]<min){
                min=a[i];
            }
        }
        return min;
    }
    public static int sumararray(int[] a){
        int suma = 0;
        for (int i = 0; i<a.length; i++){
            suma+=a[i];
        }
        return suma;
    }
}
