package ar.fiuba.tdd.tp.game;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by leandro on 23/04/16.
 */
public class BasicGameTest {

    @Test
    public void createBasicGameTest() {
        Playable game = new Game("TorreHanaoi");
        Useable disco = new GameObject("disco");
        game.addUseable(disco);
        Assert.assertTrue(game.play().length() > 0);
    }
}
