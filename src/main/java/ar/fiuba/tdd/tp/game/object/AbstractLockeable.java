package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class AbstractLockeable extends AbstractCloseable {

    private boolean locked = true;

    public AbstractLockeable(String description, boolean closed, boolean locked) {
        super(description, closed);
        this.locked = locked;
    }

    public AbstractLockeable(String name, List<GameObject> objects, boolean closed, boolean locked) {
        super(name, objects, closed);
        this.locked = locked;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
