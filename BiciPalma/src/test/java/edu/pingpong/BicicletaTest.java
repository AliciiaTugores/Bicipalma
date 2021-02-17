package edu.pingpong;

import edu.pingpong.bicicleta.Bicicleta;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BicicletaTest {

    Bicicleta bici = null;

    @Before
    public void setup() {
        this.bici = new Bicicleta(9999);
    }

    @Test
    public void constructorTest() {
        assertEquals(9999, bici.getId());
    }

    @Test
    public void toStringTest() {
        assertEquals("9999", bici.toString());
    }

    @Test
    public void implementationMovilTest() {
        assertEquals(9999, bici.getId());
    }
}
