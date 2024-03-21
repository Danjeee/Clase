import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class for_javierse {
    public static void main(String[] args) {
        boolean mailok=false;
        Scanner sc = new Scanner(System.in);
        while (!mailok) {
            System.out.println("Introduce un email");
            String mail = sc.nextLine();

            for (int i = 0; i < mail.length(); i++) {
                if (mail.charAt(i) == '@') {
                    System.out.println("Correo correcto");
                    mailok = true;
                    break;
                }
            }
            if (mailok == false) {
                System.out.println("Correo incorrecto, intentelo de nuevo");
            }
        }
    }
}