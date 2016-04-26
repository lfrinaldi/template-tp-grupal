package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Box extends AbstractCloseable {

    public Box(String description, boolean closed) {
        super(description, closed);
    }

    public Box(String name, List<GameObject> objects, boolean closed) {
        super(name, objects, closed);
    }
}
