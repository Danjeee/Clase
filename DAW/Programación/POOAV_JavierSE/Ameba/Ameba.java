package Ameba;

public class Ameba {
    public int peso;
    public void come(Ameba a2){
        if (a2.peso != 0) {
            this.peso += (a2.peso - 1);
            a2.peso = 0;
        } else {
            System.out.println("No vale la pena comerse esa ameba");
        }
    }
    public void come(int n){
        if (n <= 0) {
            System.out.println("No puedes no comer nada");
        } else {
            this.peso += (n-1);
        }
    }
    @Override
    public String toString() {
        return "Soy una ameba y peso " +this.peso +" microgramos";
    }
    public Ameba() {
        this.peso = 3;
    }
}
