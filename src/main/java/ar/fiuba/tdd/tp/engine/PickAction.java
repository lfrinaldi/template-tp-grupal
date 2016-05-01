package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.Game;

public class PickAction extends GameAction {

    public PickAction(Game game, String applyTo) {
        super(game, applyTo);
    }

    @Override
    public String execute() {
        System.out.print(this.applyTo);
        System.out.print(this.game.toString());
        return null;
    }
}
