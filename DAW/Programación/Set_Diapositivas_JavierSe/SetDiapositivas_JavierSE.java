import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SetDiapositivas_JavierSE {
    static Scanner sc = new Scanner(System.in);

    static void ej1() {
        Stack<String> pal = new Stack<>();
        System.out.println(pal + " " + pal.size());
        for (int i = 0; i < 20; i++) {
            pal.push("epa" + i);
        }
        System.out.println(pal + " " + pal.size());
    }

    static void ej2() {
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Escriba el numero " + (1 + i));
            nums.add(0, sc.nextInt());
        }
        System.out.println(nums);
    }
    static void ej3(){
        Queue<Double> nums = new LinkedList();
        for (int i = 0; i < 5; i++) {
            System.out.println("Escriba el numero " + (1 + i));
            nums.add(sc.nextDouble());
        }
        System.out.println(nums);
    }

    public static void main(String[] args) {
        ej3();
    }
}