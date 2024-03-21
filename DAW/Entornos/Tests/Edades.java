public class Edades {
    public static String obtenerRangoEdad(int edad) {
        String msg;
        if (edad < 18) {
            msg = "Menor";
        } else if (edad < 65) {
            msg = "Adulto";
        } else
            msg = "Jubilado";
        return msg;
    }
}