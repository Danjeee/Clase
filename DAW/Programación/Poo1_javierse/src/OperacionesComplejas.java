import java.util.ArrayList;

public class OperacionesComplejas {
    public static void CalcDivisores(int num, ArrayList<Integer> Divisores) {
        while (num != 1)
            if (num <= 0){
                System.out.println("No tiene divisores");
            } else {
                for (int i = 2; i < num; i++) {
                    if (num % i == 0) {
                        Divisores.add(i);
                        num /= i;
                    }
                }
            }
    }
}
