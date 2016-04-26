package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Cupboard extends AbstractCloseable {

    public Cupboard(String description, boolean closed) {
        super(description, closed);
    }

    public Cupboard(String name, List<GameObject> objects, boolean closed) {
        super(name, objects, closed);
    }
}
