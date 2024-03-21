import java.util.Scanner;

public class LecturaValidada {
    static Scanner sc = new Scanner(System.in);
    public LecturaValidada(){
        System.out.println("Escriba un numero entero para verificarlo");
        boolean corr = false;
        int a = 0;
        while (!corr) {
            corr = true;
            try{
            a = sc.nextInt();
            } catch (NumberFormatException e){
                System.out.println("Formato no valido");
                corr = false;
            }
        }
        System.out.println(a +" es valido");
        
    }
}
