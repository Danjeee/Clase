package Funciones;

import java.util.Scanner;

public class Arrays {
    static Scanner sc = new Scanner(System.in);
    public static void agregar(String[] siglas, String[] nombre, int[] votos, float[] per, int pos){
        System.out.println("Escribe el nombre del partido");
        nombre[pos] = sc.next();
        System.out.println("Escribe las siglas del partido");
        siglas[pos] = sc.next();
        siglas[pos] = siglas[pos].toUpperCase();
        per[pos] = 0;
        boolean corr = false;
        while (!corr){
            System.out.println("Escriba el numero de votos (0-50M)");
            votos[pos] = sc.nextInt();
            if (votos[pos] > 50000000 || votos[pos] < 0){
                System.out.println(votos[pos] +" no es una cantidad valida, intentelo de nuevo");
            } else {corr=true;}
        }
    }
    public static void mostrarsiglas(String[] siglas, int pos){
        for (int i=0; i<pos; i++){
            System.out.println((i+1) +".- " +siglas[i]);
        }
    }
    public static void mostrar(String[] siglas, String[] nombre, int[] votos, float[] per, int pos){
        int nul = 0;
        int bl = 0;
        float blp = 0;
        float nulp=0;
        System.out.println("Votos en blanco");
        bl=sc.nextInt();
        System.out.println("Votos nulos:");
        nul = sc.nextInt();
        int total = Mates.sumarvotos(pos, votos, bl, nul);
        Mates.porcentaje(pos,votos,per,total);
        System.out.println("Nº  -  SIGLAS  -  NOMBRE  -  VOTOS  -  %");
        for (int i=0; i<pos; i++){
            System.out.println((i+1) +".-  " +siglas[i] +"  -  " +nombre[i] +"  -  " +votos[i] +"  -  " +per[i] +"%");
        }
        blp=((float) bl /total)*100;
        nulp=((float) nul /total)*100;
        System.out.println();
        System.out.println("Blanco  -  "+bl+"  -  "+blp+"%");
        System.out.println("Nulos  -  "+nul+"  -  "+nulp +"%");
    }
    public static boolean eliminar(String[] siglas, String[] nombre, int[] votos, float[] per, int pos){
        System.out.println("Escriba las siglas del partido");
        String e = sc.next();
        e=e.toUpperCase();
        int npos = -1;
        for (int i=0; i<pos; i++){
            if (siglas[i].equals(e)){
                npos=i;
                break;
            }
        }
        if (npos==-1){
            System.out.println("No se ha encontrado el partido con las siglas: " +e);
            return false;
        } else {
            for (int i=npos+1; i<pos; i++){
                siglas[i-1] = siglas[i];
                nombre[i-1] = nombre[i];
                votos[i-1] = votos[i];
                per[i-1] = per[i];
            }
            siglas[pos] = null;
            nombre[pos] = null;
            votos[pos] = 0;
            per[pos] = 0;
            return true;
        }
    }
    public static void ordenar(String[] siglas, String[] nombre, int[] votos, float[] per, int pos){
        int vaux = votos[0];
        String naux = nombre[0];
        String saux = siglas[0];
        float paux = per[0];
        int poss=0;
        int cont=0;
        while (cont<pos) {
            for (int i = cont; i < pos; i++) {

                if (vaux > votos[i]) {
                    poss = i;
                    vaux = votos[i];
                    naux = nombre[i];
                    saux = siglas[i];
                    paux = per[i];
                }
            }
                votos[poss] = votos[cont];
                votos[cont] = vaux;
                nombre[poss] = nombre[cont];
                nombre[cont] = naux;
                siglas[poss] = siglas[cont];
                siglas[cont] = saux;
                per[poss] = per[cont];
                per[cont] = paux;
                cont++;
                if (cont != pos) {
                    vaux = votos[cont];
                    saux = siglas[cont];
                    naux = nombre[cont];
                    paux = per[cont];
                    poss = cont;
                }
            }
        }
    }

