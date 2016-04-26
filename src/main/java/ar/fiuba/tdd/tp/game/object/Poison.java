package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Poison extends GameObject {

    public Poison(String description) {
        super(description);
    }

    public Poison(String name, List<GameObject> objects) {
        super(name, objects);
    }
}
