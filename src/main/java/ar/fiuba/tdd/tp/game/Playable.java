package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.Action;

/**
 * Created by leandro on 22/04/16.
 */
public interface Playable {

    String play(Action action);

    void addUseable(Useable useable);

}
