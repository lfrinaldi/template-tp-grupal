package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.SimpleObject;

public class Stick extends SimpleObject {

/*
    public Stick(String name) {
        super(name);
    }
*/


    @Override
    public String use(Action action) {
        return action.execute(this);
    }

    public void deliverTo(Character character) {
        character.addElement(this);
    }

    public String getNoAction() {
        return "not available";
    }
}
