package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Sheep extends GameObject {

    public Sheep(String description) {
        super(description);
    }


    @Override
    public String use(Action action) {
        return null;
    }
}
