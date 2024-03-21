public class b {
    public static int Mayor(int a, int b) {
        int mayor = a;
        if (b > a)
            mayor = b;
        return mayor;
    }

    public static boolean EsMayor(int a, int b) {
        return a > b;
    }

    @Test
    void mayor() {
        int mayorUltimo = Mayor.Mayor(3, 4);
        assertEquals(4, mayorUltimo);
        int mayorPrimero = Mayor.Mayor(4, 3);
        assertEquals(4, mayorPrimero);
        int mayorIguales = Mayor.Mayor(4, 4);
        assertEquals(4, mayorIguales);
        int mayorNegativos = Mayor.Mayor(-3, -4);
        assertEquals(-3, mayorNegativos);
    }

    @Test
    void esMayor() {
        assertTrue(Mayor.EsMayor(4, 3));
        assertTrue(Mayor.EsMayor(-3, -4));
        assertFalse(Mayor.EsMayor(3, 4));
        assertFalse(Mayor.EsMayor(4, 4));
        assertFalse(Mayor.EsMayor(-4, -3));
    }
}
