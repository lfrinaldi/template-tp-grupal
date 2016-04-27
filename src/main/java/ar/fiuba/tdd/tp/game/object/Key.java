package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Key extends GameObject {

    public Key(String description) {
        super(description);
    }


    @Override
    public String use(Action action) {
        return super.use(action);
    }

}
