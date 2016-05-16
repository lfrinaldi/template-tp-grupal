package ar.fiuba.tdd.tp.game.builder;

import ar.fiuba.tdd.tp.builder.BusquedaTesoroGameBuilder;
import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Test;

public class BusquedaTesoroGameTest {

    @Test
    public void busquedaTesoroTest() {
        BusquedaTesoroGameBuilder busquedaTesoroGameBuilder = new BusquedaTesoroGameBuilder();
        Game game = busquedaTesoroGameBuilder.build();

        Assert.assertTrue(true);
    }
}