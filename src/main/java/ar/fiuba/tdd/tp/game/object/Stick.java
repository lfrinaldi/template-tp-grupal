package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.Character;
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

/*    @Override
    public Useable getConcreteInstance() {
        return this;
    }*/

    public void deliverTo(Character character) {
        character.addElement(this);
    }

    public String getNoAction() {
        return "not available";
    }
}
