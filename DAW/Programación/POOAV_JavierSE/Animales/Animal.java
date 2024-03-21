package Animales;

public class Animal {
    public String sonido;
    public String sexo;
    static public int totalAnimales;
    public String getSonido() {
        return sonido;
    }
    public void setSonido(String sonido) {
        this.sonido = sonido;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public static int getTotalAnimales() {
        return totalAnimales;
    }
    public static void setTotalAnimales(int totalAnimales) {
        Animal.totalAnimales = totalAnimales;
    }
    public Animal(String sexo) {
        this.sexo = comprobarSexo(sexo);
        Animal.totalAnimales++;
    }
    public void emitirSonido(){
        System.out.println(this.sonido +" " +this.sonido +" " +this.sonido);
    }
    public void comer(){
        System.out.println(this.getClass().getSimpleName() + " ha comido");
    }
    private String comprobarSexo(String sexo){
        sexo = sexo.toLowerCase();
        if (sexo.equals("m")) {
            return sexo;
        } else if (sexo.equals("f")){
            return sexo;
        } else {
            sexo="m";
            return sexo;
        }
    }
}
