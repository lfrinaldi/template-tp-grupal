package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Stack extends GameObject {

    public Stack(String description) {
        super(description);
    }

    public Stack(String name, List<GameObject> objects) {
        super(name, objects);
    }
}
