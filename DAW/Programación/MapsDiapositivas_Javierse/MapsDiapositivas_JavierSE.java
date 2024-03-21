import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

public class MapsDiapositivas_JavierSE {
    static Scanner sc = new Scanner(System.in);

    static void ej1() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("one", "uno");
        map.put("two", "dos");
        map.put("three", "tres");
        map.put("four", "cuatro");
        map.put("five", "cinco");
        map.put("six", "seis");
        map.put("seven", "siete");
        map.put("eight", "ocho");
        map.put("nine", "nueve");
        map.put("ten", "diez");
        System.out.println("Escribe un numero en ingles");
        String key = sc.next();
        if (map.containsKey(key)) {
            System.out.println(map.get(key));
        } else {
            System.out.println(key +" no es un numero en ingles");
        }
    }
    static void ej2(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("enero", "jaunary");
        map.put("febrero", "february");
        map.put("marzo", "march");
        map.put("abril", "april");
        map.put("mayo", "may");
        map.put("junio", "june");
        map.put("julio", "july");
        map.put("agosto", "august");
        map.put("septiembre", "september");
        map.put("octubre", "october");
        map.put("noviembre", "november");
        map.put("diciembre", "december");
        System.out.println("Escribe un mes en español");
        String key = sc.next();
        if (map.containsKey(key)) {
            System.out.println(map.get(key));
        } else {
            System.out.println(key +" no es un numero en ingles");
        }
    }
    static void ej3(){
        System.out.println("Introduzca su codigo en java");
        Map<String,String> map = new HashMap<>();
        map.put("System.out.println", "WriteLine");
        map.put("nextLine", "ReadLine");
        map.put("String", "string");
        String code = sc.nextLine();
        String[] codecode = code.split(" ");
        for (int i = 0; i<codecode.length; i++){
            String parta = comprobarpar(codecode[i]);
            String partb = comprobarpar2(codecode[i]);
            if (map.containsKey(parta)) {
                codecode[i] = map.get(parta);
                codecode[i] += partb;
            }
        }
        for (String i : codecode){
            System.out.print(i +" ");
        }
    }
    static String comprobarpar(String a){
        String b = "";
        for (int i=0; i<a.length(); i++){
            if (a.charAt(i) == '(') {
                int fin = i;
                for (int j = 0; j<fin; j++){
                    b+=a.charAt(j);
                }
                return b;
            }
        }
        return a;
    }
    static String comprobarpar2(String a){
        String b = "";
        for (int i=0; i<a.length(); i++){
            if (a.charAt(i) == '(') {
                int fin = i;
                for (int j = fin; j<a.length(); j++){
                    b+=a.charAt(j);
                }
                return b;
            }
        }
        return "";
    }
    static void ej4(){
        Map<Integer, Empleado> map = new HashMap<>();
        map.put(1, new Empleado("Juan", 200));
        map.put(2, new Empleado("Pepe", 2000));
        map.put(3, new Empleado("Alberto", 20000));
        map.put(4, new Empleado("Caca", 200000));
        map.put(5, new Empleado("Si", 2000000));
        System.out.println(map);
        map.get(3).setNombre("Señor");
        map.remove(5);
        System.out.println(map);
        map.clear();
        System.out.println(map);
    }

    public static void main(String[] args) {
        ej4();
    }
}