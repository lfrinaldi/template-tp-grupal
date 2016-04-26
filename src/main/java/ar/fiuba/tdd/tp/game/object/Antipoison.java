package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Antipoison extends GameObject {

    public Antipoison(String description) {
        super(description);
    }

    public Antipoison(String name, List<GameObject> objects) {
        super(name, objects);
    }
}
