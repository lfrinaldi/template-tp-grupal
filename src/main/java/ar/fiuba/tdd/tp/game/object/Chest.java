package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Chest extends AbstractCloseable {

    public Chest(String description, boolean closed) {
        super(description, closed);
    }


    @Override
    public String use(Action action) {
        return null;
    }
}
