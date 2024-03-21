package Animales;

public class Perro extends Mamifero{
    private String raza;

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Perro(String raza, String sexo) {
        super(sexo);
        this.raza = raza;
        this.sonido = "Guau";
    }

    public void perseguirGato(){
        System.out.println("El " +this.getClass().getSimpleName() +" persigue al Gato");
    }
    
}
