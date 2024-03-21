package Animales;

public class Mamifero extends Animal {
    public Mamifero(String sexo){
        super(sexo);
    }
    public void amamantar(){
        System.out.println(this.getClass().getSimpleName() +" ha amamantado a sus crias");
    }
    public void procrear(){
        System.out.println("El " +this.getClass().getSimpleName() +" ha tenido crias");
    }
}
