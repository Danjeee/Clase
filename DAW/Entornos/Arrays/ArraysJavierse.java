public class ArraysJavierse {
    public static boolean sonIguales(int[] a, int[] b) {
        boolean resp = true;
        int i;
        if (a.length != b.length) {
            resp = false;
        }
        i = 0;
        while (i < a.length && resp == true) {
            if (a[i] != b[i]) {
                resp = false;
            }
            i++;
        }
        return resp;
    }

    public static int[] mayoresQue(int[] lista, int n) {
        int[] resultado = new int[lista.length];
        for (int i = 0; i < lista.length; i++) {
            resultado[i] = (lista[i] > n) ? lista[i] : -1;
        }
        return resultado;
    }

    public static void main(String[] args) {

    }
}