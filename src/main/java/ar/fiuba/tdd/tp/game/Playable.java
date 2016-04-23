package ar.fiuba.tdd.tp.game;

import java.util.Optional;

/**
 * Created by leandro on 22/04/16.
 */
public interface Playable {
    String play();

    void addUseable(Useable useable);
}
