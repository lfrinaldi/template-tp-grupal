package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.game.Game;
import ar.fiuba.tdd.tp.game.GameObject;
import ar.fiuba.tdd.tp.game.Playable;
import ar.fiuba.tdd.tp.game.Useable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTests {

    @Test
    public void dummy() {
        assertEquals(0, 0);
    }

    public void games() {
        Playable game = new Game("TorreHanaoi");
        Useable disco = new GameObject("disco");
        game.addUseable(disco);
    }
}
