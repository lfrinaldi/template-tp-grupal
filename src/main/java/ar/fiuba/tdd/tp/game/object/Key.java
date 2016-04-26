package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Key extends GameObject {

    public Key(String description) {
        super(description);
    }

    public Key(String name, List<GameObject> objects) {
        super(name, objects);
    }
}
