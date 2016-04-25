package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.GameLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by leandro on 22/04/16.
 */
public class GameLoaderTest {

    private Loader gameLoader;

    @Before
    public void setup() {
        gameLoader = new GameLoader();
    }

}
