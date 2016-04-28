package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.ComplexObject;
import ar.fiuba.tdd.tp.game.Room;

public class Door extends ComplexObject {
    private Room nextRoom;


/*
    public Door(String name, List<ComplexObject> objects) {
        super(name);
    }
*/

    private Key key;

    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return this.key;
    }

    public void addNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    @Override
    public String use(Action action) {
        return action.execute(this);
    }

    public String getNoAction() {
        return "no action";
    }
}
