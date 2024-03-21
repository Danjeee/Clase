package matematicas;

import java.util.Objects;
import java.util.Scanner;


public class Varias {
    static Scanner sc = new Scanner(System.in);
    public static boolean esCapicua(int x){
        int ii = 0;
        String xx = String.valueOf(x);
        String[] x1 = new String[xx.length()];
        String[] x2 = new String[xx.length()];
        for (int i = 0; i<xx.length(); i++) {
            x1[i] = String.valueOf(xx.charAt(i));
        }
        for (int i = xx.length()-1; i>=0; i--){
            x2[ii] = String.valueOf(xx.charAt(i));
            ii++;
        }
        for (int i = 0; i<xx.length(); i++) {
            if (!Objects.equals(x1[i], x2[i])){
                return false;
            }
        }
        return true;
    }
    public static boolean esPrimo(int x){
        for (int i=2; i<x;i++){
            if (x%i==0){
                return false;
            }
        }
        return true;
    }
    public static int sigPrimo(int x){
        while (!esPrimo(x)){
            x++;
        }
        return x;
    }
    public static int potencia(int x, int e){
        return (int)Math.pow(x,e);
    }
    public static int digitos(int x){
        String xx = String.valueOf(x);
        return xx.length();
    }
    public static int voltea(int x){
        int ii = 0;
        String xx = String.valueOf(x);
        String[] x2 = new String[xx.length()];
        System.out.println();
        for (int i = xx.length()-1; i>=0; i--){
            x2[ii] = String.valueOf(xx.charAt(i));
            ii++;
        }
        ii = x2.length;
        xx = "";
        for (int i = 0; i<ii; i++) {
            xx += x2[i];
        }
        x = Integer.parseInt(xx);
        return x;
    }
    public static int digitoN(int x){
        System.out.println("Que digito quieres saber ");
        int n = sc.nextInt();
        String xx = String.valueOf(x);
        return Integer.parseInt(String.valueOf(xx.charAt(n-1)));
    }
    public static int posisicionDeDigito(int x) {
        System.out.println("De que numero quieres saber su posicion");
        int n = sc.nextInt();
        int pos = -1;
        String xx = String.valueOf(x);
        for (int i = 0; i < xx.length(); i++) {
            if (n == Integer.parseInt(String.valueOf(xx.charAt(i)))) {
                pos = i + 1;
                break;
            }
        }
        return pos;
    }
    public static int quitaPorDetras(int x){
        System.out.println("Cuantos digitos quieres quitar ");
        int n = sc.nextInt();
        String xx = String.valueOf(x);
        String[] x1 = xx.split("");
        xx="";
        for (int i = 0; i<x1.length-n; i++) {
            xx += x1[i];
        }
        x = Integer.parseInt(xx);
        return x;
    }
    public static int quitaPorDelante(int x){
        System.out.println("Cuantos digitos quieres quitar ");
        int n = sc.nextInt();
        String xx = String.valueOf(x);
        String[] x1 = xx.split("");
        xx="";
        for (int i = n; i<x1.length; i++) {
            xx += x1[i];
        }
        x = Integer.parseInt(xx);
        return x;
    }
    public static int pegaPorDetras(int x){
        System.out.println("Que quieres añadir ");
        int n = sc.nextInt();
        String xx = String.valueOf(x);
        xx+=String.valueOf(n);
        x=Integer.parseInt(xx);
        return x;
    }
    public static int pegaPorDelante(int x){
        System.out.println("Que quieres añadir ");
        int n = sc.nextInt();
        String xx = String.valueOf(x);
        String x1 = xx;
        xx=String.valueOf(n) +x1;
        x=Integer.parseInt(xx);
        return x;
    }
    public static int trozoDeNumero(int x){
        System.out.println("Que digito quieres coger como primera posición");
        int n = sc.nextInt()-1;
        System.out.println("Y como ultima ");
        int n1 = sc.nextInt()-1;
        String xx = String.valueOf(x);
        String[] x1 = xx.split("");
        xx="";
        for (int i = n; i<=n1; i++) {
            xx += x1[i];
        }
        x = Integer.parseInt(xx);
        return x;
    }
    public static int juntaNumeros(int x){
        System.out.println("Introduce otro numero ");
        int y = sc.nextInt();
        String xx = String.valueOf(x);
        xx += String.valueOf(y);
        x = Integer.parseInt(xx);
        return x;
    }
}
