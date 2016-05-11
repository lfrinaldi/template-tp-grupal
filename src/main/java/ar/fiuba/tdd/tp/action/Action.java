package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

import java.util.List;

public abstract class Action {
    protected Game game;
    public String name;

    public abstract String execute(List<GameObject> objects);

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
