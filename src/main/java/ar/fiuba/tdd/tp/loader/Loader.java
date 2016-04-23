package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Playable;

import java.util.Optional;

/**
 * Created by leandro on 22/04/16.
 */
public interface Loader {
    Optional<Playable> get(String name);
}
