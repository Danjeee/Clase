package a;
public class A {
    public static void clear(){
        for (int i=0; i<25; i++){
            System.out.println();
        }
    }
    public static String peli(){
        int a = (int) (Math.random()*5);
        switch (a){
            case 0:
                return "Shrek";
            case 1:
                return "Star wars";
            case 2:
                return "Skibiditoilet movie";
            case 3:
                return "asdf movie";
            case 4:
                return "killer bean";
            default:
                return "te imaginas que devuelve esto?";
        }
    }
    public static void llenararray(String[] letra){
        for (int i=0; i<letra.length; i++){
            if (!letra[i].equals(" ")){
                letra[i] = "_";
            }
        }
    }
    public static String primeraletra(String l){
        return String.valueOf(l.charAt(0));
    }
    public static void cambiar(String peli, String[] letra, String l){
        l=l.toLowerCase();
        peli=peli.toLowerCase();
        for (int i=0; i<letra.length; i++){
            if (l.equals(letra[i])){
                System.out.println("¡Ya habias puesto esta letra!");
                break;
            }
            if (l.equals(String.valueOf(peli.charAt(i)))){
                letra[i] = l;
            }
        }

    }
    public static boolean check(String peli, String[] letra, String l){
        boolean e = true;
        l=l.toLowerCase();
        peli=peli.toLowerCase();
        for (int i=0; i<letra.length; i++){
            if (l.equals(String.valueOf(peli.charAt(i)))){
                e = false;
            }
        }
        return e;
    }
    public static boolean correcto(String[] letra, String peli){
        peli=peli.toLowerCase();
        for (int i = 0; i<letra.length; i++){
            if (!letra[i].equals(String.valueOf(peli.charAt(i)))){
                return false;
            }
        }
        return true;
    }
    public static boolean muerte(int errores){
        if (errores == 5){
            return true;
        }
        return false;
    }
    public static void dibujar(String[] letra, int errores){
        switch (errores) {
            case 0: System.out.println("""
                    +---+
                    |
                    |
                    |
                    ===""");
                break;
            case 1: System.out.println("""
                    +---+
                    |   O
                    |
                    |
                    ===""");
                break;
            case 2: System.out.println("""
                    +---+
                    |   O
                    |   |
                    |
                    ===""");
                break;
            case 3: System.out.println("""
                    +---+
                    |   O
                    |  /|
                    |
                    ===""");
                break;
            case 4: System.out.println("""
                    +---+
                    |   O
                    |  /|\\
                    |
                    ===""");
                break;
            case 5: System.out.println("""
                    +---+
                    |   O
                    |  /|\\
                    |  / \\
                    ===""");
                break;
        }
        for (int i=0; i<letra.length; i++){
            System.out.print(letra[i]);
        }
        System.out.println();
    }
}
