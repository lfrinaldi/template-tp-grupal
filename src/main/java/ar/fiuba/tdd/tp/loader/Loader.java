package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Game;
import ar.fiuba.tdd.tp.game.Playable;

import java.util.Optional;

/**
 * Created by leandro on 22/04/16.
 */
public interface Loader {
    Game get(String name);
}
