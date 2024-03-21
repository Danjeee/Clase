package Varios;

import java.util.ArrayList;
import java.util.Scanner;

public class Ordenacion {
    public static void Ordenar(ArrayList<String> top, ArrayList <Integer> topp){
            int n = top.size();
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if (topp.get(j) > topp.get(j+1)) {
                        int tempp = topp.get(j);
                        String temp = top.get(j);
                        top.set(j, top.get(j+1));
                        top.set((j+1), temp);
                        topp.set(j, topp.get(j+1));
                        topp.set((j+1), tempp);
                    }

    }
    static Scanner sc = new Scanner(System.in);
}
