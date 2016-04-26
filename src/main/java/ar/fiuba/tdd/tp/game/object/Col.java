package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Col extends GameObject {

    public Col(String description) {
        super(description);
    }

    public Col(String name, List<GameObject> objects) {
        super(name, objects);
    }
}
