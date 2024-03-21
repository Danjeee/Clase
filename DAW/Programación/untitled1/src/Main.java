import java.util.Scanner;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        int piedras = sc1.nextInt();
        int res = 1;

        while (piedras != 0) {

            res = 1;

            while (piedras >= 0) {
                piedras -= res;
                if (piedras >= res) {
                    res++;
                } else {
                    break;
                }
            }
            System.out.print(res + " ");
            System.out.println(piedras);
            piedras = sc1.nextInt();
            }

        }

    }
