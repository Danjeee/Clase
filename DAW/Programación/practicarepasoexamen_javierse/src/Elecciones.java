import Funciones.Arrays;
import Funciones.Mates;
import static java.lang.Thread.sleep;
import java.util.Scanner;

public class Elecciones {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String[] siglas = new String[20];
        String[] nombre = new String[20];
        int[] votos = new int[20];
        float[] per = new float[20];
        int pos = 0;
        int repet = 0;
        while (repet == 0) {
            System.out.println("""
                    1.- Añadir
                    2.- Quitar
                    3.- Mostrar
                    4.- Salir""");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    if (pos!=siglas.length){
                        Arrays.agregar(siglas,nombre,votos,per,pos);
                        pos++;
                    } else {
                        System.out.println("No caben mas partidos");
                    }
                    break;
                case 2:
                    Arrays.ordenar(siglas,nombre,votos,per,pos);
                    Arrays.mostrarsiglas(siglas,pos);
                    if (Arrays.eliminar(siglas,nombre,votos,per,pos)){
                        pos--;
                    }
                    break;
                case 3:
                    Arrays.ordenar(siglas,nombre,votos,per,pos);
                    Arrays.mostrar(siglas,nombre,votos,per,pos);
                    break;
                case 4:
                    repet = 1;
                    break;
                default:
                    System.out.println(menu + " no es una opción, vuelve a intentarlo");
            }
            sleep(0);
        }
    }
}