package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Treasure extends GameObject {

    public Treasure(String description) {
        super(description);
    }

    public Treasure(String name, List<GameObject> objects) {
        super(name, objects);
    }
}
