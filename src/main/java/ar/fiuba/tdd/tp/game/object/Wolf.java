package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Wolf extends GameObject {

    public Wolf(String description) {
        super(description);
    }

    public Wolf(String name, List<GameObject> objects) {
        super(name, objects);
    }
}
