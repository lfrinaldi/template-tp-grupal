package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Stick extends GameObject {

    public Stick(String description) {
        super(description);
    }

    public Stick(String name, List<GameObject> objects) {
        super(name, objects);
    }
}
