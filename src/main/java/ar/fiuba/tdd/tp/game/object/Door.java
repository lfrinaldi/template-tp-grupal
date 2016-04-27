package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.ComplexObject;
import ar.fiuba.tdd.tp.game.Room;

import java.util.List;

public class Door extends ComplexObject {
    private Room nextRoom;


/*
    public Door(String name, List<ComplexObject> objects) {
        super(name);
    }
*/

    public void addNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    @Override
    public String use(Action action) {
        /*return action.execute(this);*/
        return null;
    }
}
