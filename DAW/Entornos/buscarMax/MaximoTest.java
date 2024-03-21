import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximoTest {
    @Test
    public void Arraynormal() {
        int[] array = { 3, 7, 9, 8 };
        assertEquals(9, Maximo.GetMax(array));
    }
    @Test
    public void Duplicados(){
        int[] array = {3, 3, 5, 6, 7};
        assertEquals(7, Maximo.GetMax(array));
    }
    @Test
    public void Primer(){
        int[] array = {8, 3, 5, 6, 7};
        assertEquals(8, Maximo.GetMax(array));
    }
    @Test
    public void Uni(){
        int[] array = {3};
        assertEquals(3, Maximo.GetMax(array));
    }
    @Test
    public void Neg(){
        int[] array = {-3, -3, -5, -6, -7};
        assertEquals(-3, Maximo.GetMax(array));
    }
}
