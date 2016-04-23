package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.loader.Loader;

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
