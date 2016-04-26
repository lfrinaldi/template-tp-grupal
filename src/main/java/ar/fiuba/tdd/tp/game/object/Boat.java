package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Boat extends GameObject {

    public Boat(String description) {
        super(description);
    }

    public Boat(String name, List<GameObject> objects) {
        super(name, objects);
    }
}
