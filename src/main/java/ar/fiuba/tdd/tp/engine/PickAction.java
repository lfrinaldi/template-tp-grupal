package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.GameObject;
import ar.fiuba.tdd.tp.game.object.Stick;

public class PickAction implements Action {
    @Override
    public String execute(GameObject object) {
        return object.use(this);
    }

    private String execute(Stick stick) {
        return null;
    }
}
