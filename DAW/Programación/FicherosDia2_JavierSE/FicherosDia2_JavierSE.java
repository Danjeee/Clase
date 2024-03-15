import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;

public class FicherosDia2_JavierSE {
    static Scanner sc = new Scanner(System.in);

    static void ej1() {
        File src = new File("./src");
        src.mkdir();
        String[] nombres = { "Paco", "Juan", "Chayanne", "Pedro" };
        String[] tlfs = { "99999999", "102", "34", "888" };
        try {
            FileOutputStream a = new FileOutputStream("./src/amigos.txt");
            ObjectOutputStream obj = new ObjectOutputStream(a);
            for (int i = 0; i < nombres.length; i++) {
                Amigo aa = new Amigo(nombres[i], (i + 5), tlfs[i]);
                obj.writeObject(aa);
            }
            if (obj != null) {
                obj.close();
                a.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void ej2() {
        ej1();
        try {
            File a = new File("./src/amigos.txt");
            if (a.exists()) {
                FileInputStream stream = new FileInputStream(a);
                ObjectInputStream obj = new ObjectInputStream(stream);
                while (stream.available()>0) {
                    Amigo pana = (Amigo) obj.readObject();
                    System.out.println(pana);
                }
                obj.close();
            } else {
                System.out.println("El fichero no existe");
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e){
            System.out.println(e);
        }
    }
    static void ej3(){
        ej1();
        ej2();
        System.out.println("Cambio de fecha");
        File a = new File("./src/amigos.txt");
        a.setLastModified(new Date().getTime());
        File b = new File("./src2");
        b.mkdir();
        File src = new File("./src");
        String[] aa = src.list();
        for (String g : aa){
            System.out.println(g);
        }
        File[] l = File.listRoots();
        for (File n : l){
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Menu
                    1.- Ej1
                    2.- Ej2
                    3.- Ej3
                    0.- Cerrar
                    """);
            int menu = sc.nextInt();
            switch (menu) {
                case 1 -> {
                    ej1();
                }
                case 2 -> {
                    ej2();
                }
                case 3 -> {
                    ej3();
                }
                case 0 -> {
                    exit = true;
                }
            }
        }
    }
}