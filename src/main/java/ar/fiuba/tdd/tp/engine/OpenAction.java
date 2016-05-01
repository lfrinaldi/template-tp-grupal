package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.Game;

/**
 * Created by Adrián on 4/27/2016.
 */
public class OpenAction extends GameAction {

    public OpenAction(Game game, String applyTo) {
        super(game, applyTo);
    }

    @Override
    public String execute() {
        return null;
    }
}
