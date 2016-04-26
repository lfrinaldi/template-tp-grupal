package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;
import ar.fiuba.tdd.tp.game.Room;

import java.util.List;

public class Door extends AbstractLockeable {
    private Room nextRoom;

    public Door(String description, boolean closed, boolean locked) {
        super(description, closed, locked);
    }

    public Door(String name, List<GameObject> objects, boolean closed, boolean locked) {
        super(name, objects, closed, locked);
    }

    public void addNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public Room getNextRoom() {
        return nextRoom;
    }
}
