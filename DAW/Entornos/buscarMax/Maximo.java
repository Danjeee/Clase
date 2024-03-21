public class Maximo {
    public static int GetMax(int[] lista) {
        int max = 0;
        if (lista.length > 0) {
            max = lista[0];
            for (int i = 1; i < lista.length; i++) {
                if (lista[i] > max)
                    max = lista[i];
            }
        }
        
        return max;
    }
}