import Varios.Varios;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static void תרגיל1() {
        int[] array = new int[10];
        int[] p = new int[10];
        int[] i = new int[10];
        Varios.arrayrandomizar(array);
        Varios.mostrar(array);
        for (int j = 0; j < array.length; j++) {
            if (array[j] % 2 == 0) {
                p[j] = array[j];
            } else i[j] = array[j];
        }
        System.out.println("Suma de los pares: " + Varios.sumararray(p));
        System.out.println("Suma de los impares: " + Varios.sumararray(i));
    }

    static void תרגיל2() {
        int[][] matriz = new int[3][3];
        int[] p = new int[9];
        int[] im = new int[9];
        int ii = 0;
        Varios.matrizrandom(matriz);
        Varios.mostrarm(matriz);
        System.out.println();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] % 2 == 0) {
                    p[ii] = matriz[i][j];
                } else im[ii] = matriz[i][j];
                ii++;
            }
        }
        System.out.println("Suma de los pares: " + Varios.sumararray(p));
        System.out.println("Suma de los impares: " + Varios.sumararray(im));
    }

    static void תרגיל3() {
        System.out.println("Cuantos espacios quieres que tenga el array? ");
        int e = sc.nextInt();
        int[] array = new int[e];
        Varios.arrayrandomizar(array);
        Varios.mostrar(array);
        System.out.println("Numero más pequeño: " + Varios.min(array));
        System.out.println("Numero más grande: " + Varios.max(array));
    }

    static void תרגיל4() {
        System.out.println("Cuantos espacios quieres que tenga el array? ");
        int e = sc.nextInt();
        int[] array = new int[e];
        Varios.arrayrandomizar(array);
        Varios.ordenarburbuja(array);
        Varios.mostrar(array);
        System.out.println("Numero más pequeño: " + array[0]);
        System.out.println("Numero más grande: " + array[array.length - 1]);
    }

    static void תרגיל5() {
        boolean repet5 = true;
        while (repet5) {
            int[][] matrizA = {{1, 2, 3}, {4, 5, 6}};
            int[][] matrizB = {{7, 8, 9}, {10, 11, 12}};
            int[][] res = new int[matrizA[0].length][matrizA[0].length];
            System.out.println("Elige que hacer");
            int menu5 = sc.nextInt();
            switch (menu5) {
                case 1:
                    Varios.sumamatrices(matrizA, matrizB, res);
                    Varios.mostrarm(res);
                    break;
                case 2:
                    Varios.restamatrices(matrizA, matrizB, res);
                    Varios.mostrarm(res);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Por que numero quieres multiplicar");
                    int b = sc.nextInt();
                    Varios.multmatrices(matrizA, b, res);
                    Varios.mostrarm(res);
                case 5:
                    repet5 = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        תרגיל5();
    }
}