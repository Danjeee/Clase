package Animales;

public class Ave extends Animal {
    public Ave(String sexo){
        super(sexo);
    }
    public void incubar(){
    System.out.println(this.getClass().getSimpleName() + " esta incubando sus crias");
    }
    public void procrear(){
        System.out.println("El " +this.getClass().getSimpleName() +" ha puesto un huevo");
    }
}
