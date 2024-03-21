import java.util.ArrayList;

public class recursividad {
    public static int Recursivo(int n) {
        System.out.println("Creamos la variable aux");
        int aux;
        System.out.println("Si 'n' es 0 aux es 0");
        if (n == 0) {
            System.out.println("n es 0");
            aux = 0;
        } else {
            System.out.println("n no es 0, es " + n + " asi que le restamos uno y le sumamos su cuadrado, repetimos la funcion");
            aux = Recursivo(n - 1) + (n * n);
        }
        System.out.println("Devolvemos aux, que vale " + aux);
        return aux;
    }

    public static int suma(int n) {
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += i;
        }
        return suma;
    }

    public static int invertir(int inv, int n, int e, int i, int ii) {
        e = (int) Math.pow(10,i);
        int num = Character.getNumericValue(Integer.toString(n).charAt(ii))*e;
        inv+=num;
        if (ii!=0) {
            ii--;
            i--;
            inv=recursividad.invertir(inv, n, e, i, ii);
        }
        return inv;
    }
    public static int sumar(int sum, int n, int ii) {
        int num = Character.getNumericValue(Integer.toString(n).charAt(ii));
        sum+=num;
        if (ii!=0) {
            ii--;
            sum=recursividad.sumar(sum, n, ii);
        }
        return sum;
    }

    public static int maximo(ArrayList<Integer> array, int index,int max){
        if (max < array.get(index)) {
            return array.get(index);
        }
        if (index > 0){
            index--;
            max=maximo(array, index, max);
        }
        return max;
    }
    public static int minimo(ArrayList<Integer> array, int index,int max){
        if (max > array.get(index)) {
            return array.get(index);
        }
        if (index > 0){
            index--;
            max=minimo(array, index, max);
        }
        return max;
    }
    public static int maximo2(ArrayList<Integer> array, int index,int max){
        if (max < array.get(index)) {
            return array.get(index);
        }
        if (index > 0){
            index--;
            max=maximo(array, index, max);
        }
        return max;
    }
    public static String invertirpalabra(int n, String p) {
        String inv = "";
        for (int i = n - 1; i >= 0; i--) {
            inv += String.valueOf(p.charAt(i));
        }
        return inv;
    }

    public static double potencia(int b, int e) {
        if (e == 0) {
            return 1;
        } else if (e < 0) {
            return potencia(b, e + 1) / b;
        } else {
            return b * potencia(b, e - 1);
        }
    }
}