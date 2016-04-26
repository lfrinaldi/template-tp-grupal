package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Door extends AbstractLockeable {

    public Door(String description, boolean closed, boolean locked) {
        super(description, closed, locked);
    }

    public Door(String name, List<GameObject> objects, boolean closed, boolean locked) {
        super(name, objects, closed, locked);
    }
}
