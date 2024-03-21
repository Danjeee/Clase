package Animales;

public class Gato extends Mamifero {
    private String raza;

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Gato(String sexo, String raza) {
        super(sexo);
        this.raza = raza;
        this.sonido="Miau";
    }
    
    public void trepar(){
        System.out.println("El " +this.getClass().getSimpleName() +" trepa felizmente");
    }
}
