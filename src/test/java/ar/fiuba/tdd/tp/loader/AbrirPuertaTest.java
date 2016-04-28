package ar.fiuba.tdd.tp.loader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Adrián on 4/27/2016.
 */
public class AbrirPuertaTest {
    private AbrirPuerta abrirPuerta;

    @Before
    public void setup() {
        abrirPuerta = new AbrirPuerta();
    }


    @Test
    public void abrirPuertaTest() {

        abrirPuerta.receiveMessage("pick key");
        Assert.assertTrue(abrirPuerta.receiveMessage("open door").equals("You won the game!"));

    }


}
