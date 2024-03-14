public class Cafetera {
    private final int MAX = 1000;
    private int actual = 0;
    public int getMAX() {
        return MAX;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }
    public void llenarCafetera(){
        if (this.actual == this.MAX){
            System.out.println("La cafetera ya esta llena");
        }else {
            this.actual = this.MAX;
        }
    }
    public void servirTaza(int cant){
        if (cant > this.actual){
            System.out.println("No hay suficiente café, se ha servido " +this.actual +" en su lugar (lo restante)");
            this.actual = 0;
        }
        if(cant <= 0){
            System.out.println("No se puede servir una taza con estos valores");
        }
        if (cant < this.actual){
            System.out.println("Sirviendo taza...");
            this.actual -= cant;
            System.out.println("Se ha servido una taza de "+cant);
        }
    }
    public void vaciarCafetera(){
        this.actual = 0;
        System.out.println("Se ha vaciado la cafetera");
    }
    public void agregarCafe(int cant){
        if ((cant + this.actual) > this.MAX){
            this.actual = this.MAX;
            System.out.println("Se ha llenado la cafeterá al completo, ha sobrado " +((cant + this.actual)-this.MAX));
        }
        if ((cant + this.actual) < this.MAX){
            if (cant <= 0){
                System.out.println("No se puede llenar la cafetera con estos valores");
            } else {
                this.actual += cant;
                System.out.println("Se ha llenado la cafetera con " + cant + ", ahora tiene " + this.actual);
            }
        }
    }
}
