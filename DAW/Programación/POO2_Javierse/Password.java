import java.util.Random;

public class Password {
    private int longitud = 8;
    private String contraseña;
    public Password(int longitud) {
        this.longitud = longitud;
        this.contraseña = generarContraseña(this.longitud);
    }
    static String generarContraseña(int l){
        String c = "";
        Random r = new Random();
        boolean num = false;
        for (int i=0; i<l; i++){
            if (r.nextInt(2) == 0) {
                num = false;
            } else {
                num = true;
            }
            if (num) {
                c += Integer.toString(r.nextInt(10));
            } else {
                if (r.nextInt(2) == 0){
                    c += Character.toString((char)(r.nextInt('z' - 'a' + 1) + 'a'));
                } else {
                    c += Character.toString((char)(r.nextInt('Z' - 'A' + 1) + 'A'));
                }
            }
        }
        return c;
    }
    public boolean esFuerte(String c){
        int may = 0;
        int min = 0;
        int num = 0;
        for (int i = 0; i<c.length(); i++){
            if (Character.isDigit(c.charAt(i))) {
                num++;
            }
            if (Character.isUpperCase(c.charAt(i))){
                may++;
            }
            if (Character.isLowerCase(c.charAt(i))){
                min++;
            }
        }
        if (may >= 2 && min >= 1 && num >= 5) {
            return true;           
        } else{
            return false;
        }
    }
    public int getLongitud() {
        return longitud;
    }
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    public String getContraseña() {
        return contraseña;
    }
}
