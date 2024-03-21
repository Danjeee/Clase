public class TorreDeHanoi {

    // Método principal para resolver la Torre de Hanoi
    public static void resolverHanoi(int n, char origen, char auxiliar, char destino) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
            return;
        }

        // Mover n-1 discos de la torre de origen a la torre auxiliar
        resolverHanoi(n - 1, origen, destino, auxiliar);

        // Mover el disco restante de la torre de origen a la torre de destino
        System.out.println("Mover disco " + n + " de " + origen + " a " + destino);

        // Mover los n-1 discos de la torre auxiliar a la torre de destino
        resolverHanoi(n - 1, auxiliar, origen, destino);
    }

    public static void main(String[] args) {
        int numeroDeDiscos =  3; // Puedes cambiar este valor según tus necesidades

        resolverHanoi(numeroDeDiscos, 'A', 'B', 'C');
    }
}
