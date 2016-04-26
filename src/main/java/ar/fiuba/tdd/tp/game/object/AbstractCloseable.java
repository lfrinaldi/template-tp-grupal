package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class AbstractCloseable extends GameObject {

    private boolean closed = true;

    public AbstractCloseable(String description, boolean closed) {
        super(description);
        this.closed = closed;
    }

    public AbstractCloseable(String name, List<GameObject> objects, boolean closed) {
        super(name, objects);
        this.closed = closed;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
