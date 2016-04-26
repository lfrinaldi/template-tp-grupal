package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Sheep extends GameObject {

    public Sheep(String description) {
        super(description);
    }

    public Sheep(String name, List<GameObject> objects) {
        super(name, objects);
    }
}
