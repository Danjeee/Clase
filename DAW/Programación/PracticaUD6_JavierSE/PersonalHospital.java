public abstract class PersonalHospital {
    protected String DNI;
    protected String nombre;
    protected char genero;
    protected String apodo;
    public static int totalPersonal = 0;
    
    public PersonalHospital(String nombre, char genero, String dni) {
        this.nombre = nombre;
        this.genero = comprobarGenero(genero);
        this.DNI = dni;
        PersonalHospital.totalPersonal++;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String dNI) {
        DNI = dNI;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private char comprobarGenero(char g){
        String gg = Character.toString(g);
        gg = gg.toUpperCase();
        g = gg.charAt(0);
        if (g != 'F' && g != 'M') {
            g = 'M';
        }
        return g;
    }
    public char getGenero() {
        return genero;
    }
    public void setGenero(char genero) {
        this.genero = genero;
    }
    public String getApodo() {
        return apodo;
    }
    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
    public String toString() {
        return this.DNI +": "+this.apodo +" " +this.nombre;
    }
    @Override
    public int hashCode() {
        return Integer.parseInt(this.DNI);
    }
}
