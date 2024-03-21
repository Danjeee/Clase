package Animales;

public class Canario extends Ave {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Canario(String sexo, String color) {
        super(sexo);
        this.color = color;
    }
    public void volar(){
        System.out.println("El " +this.getClass().getSimpleName() +" vuela libre");
    }
    public void cantar(){
        System.out.println("""
            Debes brindar amor para después pedir
            Hay que perdonar para poder seguir
            Recuerda que tenemos sólo un viaje de ida
            Y hay que darle gracias siempre
            A la vida
            A la vida
            A la vida
            A la vida
            Oye, abre tus ojos, mira hacia arriba
            Disfruta las cosas buenas que tiene la vida
            Abre tus ojos, mira hacia arriba
            Disfruta las cosas buenas que tiene la
            La-la-la, lalara, la-la-la (Hey)
            La-la-la, lalara, la-la-la (Hey)
            La-la-la, lalara, la-la-la (Hey)
            La-la-la, lalara, la-la-la (Hey)
            Cuando estés perdido y no sepas dónde vas
            Recuerda 'e dónde vienes y qué bien te sentirás
            Siempre que llueve escampa, son consejos de mamá
            Y con la bendición de tus ancestros llegarás
            Tambor, tambor, tambor, que llama a tambor
            Tambor, tambor, tambor de mi madre Tierra
            Tambor, tambor, tambor, que llama a tambor
            Tambor, tambor, tambor de mi madre Tierra
            Oye, abre tus ojos, mira hacia arriba
            Disfruta las cosas buenas que tiene la vida
            A-a-abre tus ojos, mira hacia arriba
            Disfruta las cosas buenas que tiene la
            La-la-la, lalara, la-la-la (Hey)
            La-la-la, lalara, la-la-la (Hey)
            La-la-la, lalara, la-la-la (Hey)
            La-la-la, lalara, la-la-la (Hey)
            Caer es permitido y levantarse es obligado
            No tires piedras al vecino si de cristal es tu tejado
            Perro que ladra, no te asustes, nunca te morderá
            Que con la bendición de tus ancestros llegarás
            Tambor, tambor, tambor, que llama a tambor
            Tambor, tambor, tambor de mi madre Tierra
            Tambor, tambor, tambor, que llama a tambor
            Tambor, tambor, tambor de mi madre Tierra
            Oye, abre tus ojos, mira hacia arriba
            Disfruta las cosas buenas que tiene la vida
            Abre tus ojos, mira hacia arriba
            Disfruta las co-sas bue-nas
            La-la-la, lalara, la-la-la (Hey)
            La-la-la, lalara, la-la-la (Hey)
            La-la-la, lalara, la-la-la (Hey)
            La-la-la, lalara, la-la-la (Hey)
            Oye, abre tus ojos, mira hacia arriba
            Disfruta las cosas buenas que tiene la vida
            Abre tus ojos mira hacia arriba
            Disfruta las co-sas bue-nas (Hey)
                """);
    }
}
