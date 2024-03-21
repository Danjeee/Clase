public class Moneda {
    public String tipo;
    public String estado;
    public Moneda(String tipo, String estado) {
        this.tipo = tipo;
        this.estado = estado;
    }
    @Override
    public String toString() {
        return tipo + " - " +estado;
    }
}
