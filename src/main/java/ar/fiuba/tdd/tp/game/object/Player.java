package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Player extends GameObject {

    public Player(String description) {
        super(description);
    }

    public Player(String name, List<GameObject> objects) {
        super(name, objects);
    }
}
