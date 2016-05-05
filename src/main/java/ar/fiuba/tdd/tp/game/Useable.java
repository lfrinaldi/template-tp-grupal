package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.Action;

public interface Useable {
    String use(Action action);

    public String getName();

}
