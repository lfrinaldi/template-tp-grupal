package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.GameObject;

/**
 * Created by leandro on 27/04/16.
 */
public class Character extends GameObject {
    public Character(String description) {
        super(description);
    }


    @Override
    public String use(Action action) {
        return null;
    }
}
