package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Cupboard extends AbstractCloseable {


    public Cupboard(String name, List<GameObject> objects, boolean closed) {
        super(name, objects, closed);
    }

    @Override
    public String use(Action action) {
        return null;
    }
}
