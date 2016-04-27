package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.ComplexObject;
import ar.fiuba.tdd.tp.game.Room;

public class Box extends ComplexObject {


/*    public Box(String name, List<Useable> objects) {
        super(name, objects);
    }*/

    @Override
    public String use(Action action) {
        return action.execute(this);
    }

    public void deliverTo(Character character) {
        character.addElement(this);
    }

    public void deliverTo(Room room) {
        room.addObjects(this.getObjects());
    }

    public String getNoAction() {
        return "no action";
    }
}
