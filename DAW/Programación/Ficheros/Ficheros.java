
//C:\Users\alumnoM\Desktop\programacion\Ficheros\src
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ficheros {
    public static void main(String[] args) {
        FileWriter file;
        try {
            file = new FileWriter("C:\\Users\\alumnoM\\Desktop\\programacion\\Ficheros\\src\\prueba.txt");
            file.write("Hola caracola!");
            file.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        FileReader read = null;
        try {
            read = new FileReader("C:\\\\Users\\\\alumnoM\\\\Desktop\\\\programacion\\\\Ficheros\\\\src\\\\prueba.txt");
            int i;
            while ((i = read.read()) != -1)
                System.out.print((char) i);
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        //bin
        FileOutputStream binwr;
        try{
            binwr = new FileOutputStream("C:\\Users\\alumnoM\\Desktop\\programacion\\Ficheros\\src\\pruebabin.txt");
            String s = "Cacerola";
            byte[] b = s.getBytes();
            binwr.write(b);
            binwr.close();
        } catch (IOException e){
            System.out.println(e);
        }
        FileInputStream binre;
        try{
            binre = new FileInputStream("C:\\Users\\alumnoM\\Desktop\\programacion\\Ficheros\\src\\pruebabin.txt");
            int i;
            while ((i = binre.read()) != -1) {
                System.out.println((char)i);
            }
            binre.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }
}