import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SumaTest {
    @Test
    public void testSuma() {
        System.out.println("suma");
        int num1 = 3;
        int num2 = 7;
        int expres = 10;
        int res = Suma.suma(num1,num2);
        assertEquals(expres, res);
    }
}
