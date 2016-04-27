package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.GameObject;

public class Poison extends GameObject {

    public Poison(String description) {
        super(description);
    }


    @Override
    public String use(Action action) {
        return super.use(action);
    }
}
