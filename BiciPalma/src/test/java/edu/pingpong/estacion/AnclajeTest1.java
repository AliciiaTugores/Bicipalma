package edu.pingpong.estacion;

import edu.pingpong.bicicleta.Movil;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnclajeTest1 {

    Movil bici;

    @Test
    public void anclarBiciTest() {
        Anclaje anclaje = new Anclaje();
        anclaje.anclarBici(bici);
        assertTrue(anclaje.isOcupado());
    }

    @Test
    public void liberarbiciTest() {
        Anclaje anclaje = new Anclaje();
        anclaje.liberarBici();
        assertFalse(anclaje.isOcupado());
    }


}