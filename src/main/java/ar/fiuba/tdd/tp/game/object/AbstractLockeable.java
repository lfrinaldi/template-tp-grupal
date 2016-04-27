package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.Useable;

import java.util.List;

public abstract class AbstractLockeable extends AbstractCloseable {

    private boolean locked = true;

/*
    public AbstractLockeable(String description) {
        super(description);
    }
*/

/*    public AbstractLockeable(String name, List<Useable> objects) {
        super();
    }*/

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public abstract String use(Action action);
}
