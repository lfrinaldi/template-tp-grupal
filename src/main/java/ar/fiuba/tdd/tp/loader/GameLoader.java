package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Playable;

import java.util.Optional;

/**
 * Created by leandro on 22/04/16.
 */
public class GameLoader implements Loader {

    @Override
    public Optional<Playable> get(String name) {
        return Optional.ofNullable(null);
    }
}
