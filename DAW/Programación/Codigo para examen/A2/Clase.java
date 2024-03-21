public class Clase implements Comparable<Clase> {
    private String DNI;
    private String edad;
    public static int total = 0;

    public Clase(String edad) {
        Clase.total++;
        this.DNI = generarDNI();
        this.edad = edad;
    }

    private String generarDNI() {
        String dni = "";
        int rn1 = 99999999 - 10000000 + 1;
        int rn2 = 90 - 65 + 1;
        dni += Integer.toString((int) (Math.random() * rn1) + 10000000);
        dni += Character.toString((char) (Math.random() * rn2) + 65);
        return dni;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.DNI);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "Holas";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Clase) {
            Clase a = (Clase) obj;
            if (a.hashCode() == this.hashCode()) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("No es una "+this.getClass().getSimpleName());
            return false;
        }
    }
    @Override
    public int compareTo(Clase o) {
        return o.getDNI().compareTo(this.DNI);
    }
    
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
