package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.model.GameObject;

import java.util.List;

public abstract class Action {
    //protected Game game;

    abstract String execute(List<GameObject> objects);

    //public void setGame(Game game) {
    //    this.game = game;
    //}

}
