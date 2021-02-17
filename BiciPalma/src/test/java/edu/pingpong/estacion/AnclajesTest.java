package edu.pingpong.estacion;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AnclajesTest{

    @Test
    public void toStringTest(){
        Anclajes anclajes = new Anclajes(6);
        assertEquals("Numero de anclajes: 6", anclajes.toString());
    }

}