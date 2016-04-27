package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.GameObject;

public class Antipoison extends GameObject {

    public Antipoison(String description) {
        super(description);
    }


    @Override
    public String use(Action action) {
        return null;
    }
}
