import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArraysJavierseTest {
    @Test
    public void testMayoresQueUmbral() {
        int[] array = {1, 1, 2, 4, 5, 6};
        int[] expected = {-1, -1, -1, 4, 5, 6};
        int n = 3;
        assertArrayEquals(expected, ArraysJavierse.mayoresQue(array, n));
    }

    @Test
    public void testMayoresQueNinguno() {
        int[] array = {2, 4, 3, 4, 5, 6};
        int[] expected = {2, 4, 3, 4, 5, 6};
        int n = 0;
        assertArrayEquals(expected, ArraysJavierse.mayoresQue(array, n));
    }
    @Test
    public void testMayoresQueVacio() {
        int[] array = new int[6];
        int[] expected = {-1, -1, -1, -1, -1, -1};
        int n = 0;
        assertArrayEquals(expected, ArraysJavierse.mayoresQue(array, n));
    }
    @Test
    public void testSonIguales() {
        int[] array = {2, 4, 3, 4, 5, 6};
        int[] expected = {2, 4, 3, 4, 5, 6};
        boolean n = true;
        assertEquals(n, ArraysJavierse.sonIguales(array, expected));
    }
    @Test
    public void testSonIgualesFalse() {
        int[] array = {2, 4, 3, 4, 5, 6};
        int[] expected = {2, 4, 4, 4, 5, 6};
        boolean n = false;
        assertEquals(n, ArraysJavierse.sonIguales(array, expected));
    }
    @Test
    public void testSonIgualesLongitudFalse() {
        int[] array = {2, 4, 3, 4, 5, 6};
        int[] expected = {2, 4, 3, 4, 5, 6, 5, 6};
        boolean n = false;
        assertEquals(n, ArraysJavierse.sonIguales(array, expected));
    }
}
