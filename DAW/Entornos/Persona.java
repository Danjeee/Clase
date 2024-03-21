public class Persona {
    protected String nombre = null;
    protected int edad = 0;
    private String dni ="";
    protected String sexo = "M";
    protected double peso = 0;
    protected double altura = 0;
    public Persona(String nombre, int edad, String sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
        dni = generaDNI();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getDni() {
        return dni;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public int calcularIMC(double peso, double altura){
        double imc = peso/(Math.pow(altura, 2));
        if (imc < 20) {
            return -1;
        }
        if (imc >= 20 && imc <=25){
            return 0;
        }
        if (imc > 25) {
            return 1;
        }
        return 0;
    }
    public boolean esMayorDeEdad(int edad){
        if (edad < 18) {
            return false;
        } else {
            return true;
        }
    }
    public String comprobarSexo(String sexo){
        if (sexo.equals("M") || sexo.equals("H")){
            return sexo;
        } else{
            return "H";
        }
    }
    public void toSrtings(){
        System.out.println("Nombre: " +this.nombre);
        System.out.println("Edad: " +this.edad);
        System.out.println("DNI: " +this.dni);
        System.out.println("Sexo: " +sexo);
        System.out.println("Peso: " +peso +"kg");
        System.out.println("Altura: " +altura +"m");
    }
    public String generaDNI(){
        String dni = "";
        int rn1 = 99999999-10000000+1;
        int rn2 = 90-65+1;
        dni += Integer.toString((int)(Math.random()*rn1)+10000000);
        dni += Character.toString((char)(Math.random()*rn2)+65);
        return dni;
    }
}
