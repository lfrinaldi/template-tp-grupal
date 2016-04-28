package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.Character;
import ar.fiuba.tdd.tp.game.SimpleObject;

public class Antipoison extends SimpleObject {

/*    public Antipoison(String description) {
        super(description);
    }*/


/*    public String use(Action action) {
        return action.execute(this);
    }*/

    public void deliverTo(Character character) {
        character.addElement(this);
    }

    @Override
    public String use(Action action) {
        return null;
    }
}
