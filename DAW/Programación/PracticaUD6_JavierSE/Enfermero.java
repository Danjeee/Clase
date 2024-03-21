public class Enfermero extends PersonalHospital{
    private int planta;

    public Enfermero(String nombre, char genero, int planta, String dni) {
        super(nombre, genero, dni);
        this.planta = planta;
                if (this.genero == 'M') {
            this.setApodo("Enfermero");
        } else {
            this.setApodo("Enfermera");
        }
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }
    @Override
    public String toString() {
        return super.toString() +" (Planta: "+this.planta +")";
    }
    @Override
    public boolean equals(Object obj) {
        Enfermero a = (Enfermero)obj;
        return this.DNI.equals(a.DNI);
    }
}
