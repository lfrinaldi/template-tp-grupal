package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.Action;

/**
 * Created by leandro on 27/04/16.
 */
public interface Useable {
    String use(Action action);

    public String getName();
}
