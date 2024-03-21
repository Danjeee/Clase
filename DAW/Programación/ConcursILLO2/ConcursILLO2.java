import java.util.ArrayList;
import java.util.Scanner;

public class ConcursILLO2 {
    static void ej1(){
        Scanner sc = new Scanner(System.in);
        int veces = sc.nextInt();
        sc.nextLine();
        for (int i = veces; i >= 0; i--){
            ArrayList<String> a = new ArrayList<>();
            String b = sc.nextLine();
            int p = 0;
            for (p = 0; p < b.split(" ").length; p++){
                if (b.split(" ")[p].equals("F")) {
                    break;
                }
                a.add(b.split(" ")[p]);
            }
            int camas = Integer.parseInt(b.split(" ")[p+1]);
            int cancion = Integer.parseInt(b.split(" ")[p+2]);
            int j = 0;
            int y = a.size();
            boolean caca = false;
            if (camas == 0) {
                System.out.println("NADIE TIENE CAMAS");
                y = camas;
                caca = true;
            }
            if (camas == a.size()) {
                System.out.println("TODOS TIENEN CAMAS");
                y = camas;
                caca = true;
            }
            while (y != camas) {
                if (j >= y) {
                    j = y;
                }
                for (int h = 0; h<cancion; h++){
                    if (h!=0) {
                        j++;
                    }
                    if (j >= y) {
                        j = 0;
                    }
                }
                a.remove(j);
                y--;
            }
            if (!caca) {
                for (String g : a){
                    System.out.print(g +" ");
                }
                System.out.println();
            }
            a.clear();
        }
    }
    public static void main(String[] args) {
        ej1();
    }
}