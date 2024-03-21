import java.util.Scanner;
import java.util.Stack;

import javax.print.DocFlavor.STRING;
import javax.swing.plaf.synth.SynthTabbedPaneUI;
import javax.xml.transform.stax.StAXResult;

public class Concurso2 {
    public static void main(String[] args) {

        // ejercicio1();
        // ejercicio2();
        ejercicio3();

    }

    public static void ejercicio1() {

        Scanner sc = new Scanner(System.in);

        String numeros1 = "0";

        numeros1 = sc.nextLine();

        while (!numeros1.equals("-1")) {

            Stack<Integer> pila1 = new Stack<>();

            for (int i = 0; i < numeros1.length(); i++) {

                pila1.push(Integer.parseInt(String.valueOf(numeros1.charAt(i))));

            }

            int resultado = 0;

            for (int i : pila1) {

                System.out.print(i + " ");
                resultado += i;
            }

            System.out.println("= " + resultado);
            numeros1 = sc.nextLine();

        }

    }

    public static void ejercicio2() {

        Scanner sc = new Scanner(System.in);

        String numeros2 = sc.nextLine();

        boolean no = false;

        while (!no) {

            Stack<Character> ejercicio2 = new Stack<>();

            for (int i = 0; i < numeros2.length(); i++) {

                ejercicio2.push(numeros2.charAt(i));

            }
            int size = ejercicio2.size();
            for (int i = 0; i < size; i++) {
                char ii = ejercicio2.get(i);
                if (ii == '(') {
                    no = true;
                    int jj = 0;
                    for (int j = 0; j < size; j++) {
                        char jjj = ejercicio2.get(j);
                        if (jjj == ')') {
                            jj = j;
                            no = false;
                            break;
                        }
                    }
                    if (!no) {
                        ejercicio2.remove(i);
                        ejercicio2.remove(jj - 1);
                        size -= 2;
                    }
                    if (size <= i) {
                        break;
                    }
                }
                if (ii == '{') {
                    no = true;
                    int jj = 0;
                    for (int j = 0; j < size; j++) {
                        char jjj = ejercicio2.get(j);
                        if (jjj == '}') {
                            jj = j;
                            no = false;
                            break;
                        }
                    }
                    if (!no) {
                        ejercicio2.remove(i);
                        ejercicio2.remove(jj - 1);
                        size -= 2;
                    }
                    if (size <= i) {
                        break;
                    }
                }
                if (ii == '[') {
                    no = true;
                    int jj = 0;
                    for (int j = 0; j < size; j++) {
                        char jjj = ejercicio2.get(j);
                        if (jjj == ']') {
                            jj = j;
                            no = false;
                            break;
                        }
                    }
                    if (!no) {
                        ejercicio2.remove(i);
                        ejercicio2.remove(jj - 1);
                        size -= 2;
                    }
                    if (size <= i) {
                        break;
                    }
                }
                if (ii == ')') {
                    no = true;
                }
                if (ii == '}') {
                    no = true;
                }
                if (ii == ']') {
                    no = true;
                }

            }

            if (no) {
                System.out.println("no");
            } else {
                System.out.println("yes");
                numeros2 = sc.nextLine();
            }
        }

    }

    public static boolean esPar(int a) {
        if (a==0) {
            return true;
        }
        if (a % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void ejercicio3() {

        Scanner sc = new Scanner(System.in);

        Stack<Integer> pila11 = new Stack<>();
        Stack<Integer> pial22 = new Stack<>();

        String linea1 = sc.nextLine();

        while (!linea1.equals("0")) {

            String linea2 = sc.nextLine();
            for (int i = 0; i < linea1.length(); i++) {
                if (linea1.charAt(i) == '-') {
                    break;
                }
                if (linea1.charAt(i) != ' ') {
                    pila11.push(Integer.parseInt(String.valueOf(linea1.charAt(i))));
                }
                
            }
            System.out.println(pila11);

            for (int i = 0; i < linea2.length(); i++) {
                if (linea2.charAt(i) != ' ') {
                    pial22.push(Integer.parseInt(String.valueOf(linea2.charAt(i))));
                }

            }
            System.out.println(pial22);
            int veces = 0;
            int inicio = 0;
            int vueltas = 0;
            for (int i = 0; i < pial22.size(); i++) {

                if (veces == 2) {
                    Stack<Integer> vuelta = new Stack<>();
                    for (int j = pila11.size()-1; j>=inicio; j--){
                        vuelta.push(pila11.get(j)) ;                       
                    }
                    if (!esPar(vueltas)) {
                        Stack<Integer> vuelta2 = new Stack<>();
                        int u = 0;
                        for (int j = vuelta.size()-1; j>=0; j--){
                            vuelta2.push(vuelta.get(u));
                            u++;
                        }
                        vuelta = vuelta2;
                        for(int j = inicio; j<pila11.size(); j++){
                            pila11.remove(i);
                        }
                        for (int j = 0; j<vuelta.size(); j++){
                            pila11.push(vuelta.get(j));
                        }
                    }
                    
                    
                    inicio = 0;
                    veces = 0;
                }
                if (veces == 0) {
                    inicio = pial22.get(i);
                }
                if (veces == 1) {
                    vueltas = pial22.get(i);
                }
                veces++;
            }
            if (veces != 2) {
                Stack<Integer> vuelta = new Stack<>();
                for (int j = pila11.size()-1; j>=inicio; j--){
                    vuelta.push(pila11.get(j)) ;                       
                }
                if (!esPar(vueltas)) {
                    Stack<Integer> vuelta2 = new Stack<>();
                    int u = 0;
                    for (int j = vuelta.size()-1; j>=0; j--){
                        vuelta2.push(vuelta.get(u));
                        u++;
                    }
                    vuelta = vuelta2;
                    for(int j = inicio; j<pila11.size(); j++){
                        pila11.pop();
                    }
                    for (int j = 0; j<vuelta.size(); j++){
                        pila11.push(vuelta.get(j));
                    }
                }
                
                inicio = 0;
                veces = 0;
            }
            System.out.println(pila11);
            System.out.println(pila11.get(0));
            linea1 = sc.nextLine();
        }

    }

}