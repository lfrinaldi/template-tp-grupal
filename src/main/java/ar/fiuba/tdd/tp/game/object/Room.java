package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Room extends GameObject {

    public Room(String description) {
        super(description);
    }

    public Room(String name, List<GameObject> objects) {
        super(name, objects);
    }
}
