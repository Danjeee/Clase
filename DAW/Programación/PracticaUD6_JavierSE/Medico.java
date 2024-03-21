public class Medico extends PersonalHospital {
    private String especialidad;

    public Medico(String nombre, char genero, String especialidad, String dni) {
        super(nombre,genero, dni);
        this.especialidad = especialidad;
        if (this.genero == 'M') {
            this.setApodo("Dr.");
        } else {
            this.setApodo("Dra.");
        }
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    @Override
    public String toString() {
        return super.toString() +" (Especialidad: "+this.especialidad +")";
    }
    @Override
    public boolean equals(Object obj) {
        Medico a = (Medico)obj;
        return this.DNI.equals(a.DNI);
    }

}
