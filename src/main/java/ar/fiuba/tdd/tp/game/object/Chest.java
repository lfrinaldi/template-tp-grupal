package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Chest extends AbstractCloseable {

    public Chest(String description, boolean closed) {
        super(description, closed);
    }

    public Chest(String name, List<GameObject> objects, boolean closed) {
        super(name, objects, closed);
    }
}
