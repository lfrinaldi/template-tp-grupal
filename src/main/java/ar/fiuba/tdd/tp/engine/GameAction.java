package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.Game;

public abstract class GameAction implements Action {

    protected Game game;
    protected String applyTo;

    public GameAction(Game game, String applyTo) {
        this.game = game;
        this.applyTo = applyTo;
    }
}
