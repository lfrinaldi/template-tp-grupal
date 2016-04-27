package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.ComplexObject;
import ar.fiuba.tdd.tp.game.SimpleObject;

public class Col extends SimpleObject {

/*
    public Col(String description) {
        super(description);
    }
*/


    @Override
    public String use(Action action) {
        /*return action.execute(this);*/ return null;
    }
}
