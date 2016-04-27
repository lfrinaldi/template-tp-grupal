package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.GameObject;

public interface Action {
    String execute(GameObject object);
}
