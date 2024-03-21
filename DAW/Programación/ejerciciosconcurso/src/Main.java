import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Thread.sleep;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
        static Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        String y = null;
        int nigga = 0;
        int normal = 0;
        while (!x.equals(".")){
            if (x.equals("N")){
                nigga++;
            } else if (x.equals("G")) {
                normal++;
            }
            x=sc.nextLine();
        }
        int comp1 = nigga%2;
        int comp2 = normal%2;
        if (comp1 == 0 && comp2 == 0){
            System.out.println("Emparejados");
        }
        if (comp1 == 0 && comp2== 1){
            System.out.println("Gris solitario");
        }
        if (comp1==1 && comp2==0){
            System.out.println("Negro solitario");
        }
        if (comp1==1 && comp2==1){
            System.out.println("Pareja mixta");
        }
    }