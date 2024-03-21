import java.io.FileWriter;
import java.io.IOException;

public class EjerciciosFichero_JavierSE {
    public static void main(String[] args) {
        FileWriter c1;
        try {
            c1 = new FileWriter("./src/numerosprimos.txt");
            for (int i=2; i<500; i++){
                if (esPrimo(i)) {
                    String ii = String.valueOf(i);
                    c1.write(ii + "\n");;
                }
            }
            c1.close();
        } catch (IOException e) {
            System.out.println("e");
        }
    }
    static boolean esPrimo(int n){
        for (int i=2; i<n; i++){
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
}