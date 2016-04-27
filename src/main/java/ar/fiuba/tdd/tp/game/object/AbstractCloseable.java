package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.ComplexObject;
import ar.fiuba.tdd.tp.game.Useable;

import java.util.List;

public abstract class AbstractCloseable extends ComplexObject {

    private boolean closed = true;

/*
    public AbstractCloseable(String description) {
        super(description);
    }
*/

/*    public AbstractCloseable(String name, List<Useable> objects, boolean closed) {
        super(name, objects);
        this.closed = closed;
    }*/

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public abstract String use(Action action);
}
