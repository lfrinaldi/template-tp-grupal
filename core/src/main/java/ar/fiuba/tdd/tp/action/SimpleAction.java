package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.condition.core.Condition;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

public abstract class SimpleAction implements Action {

    protected Condition<String> condition;
    protected String result;
    protected Game game;
    protected GameObject scene;

    public SimpleAction(ComplexAction parent, Condition<String> condition, String result) {
        this.condition = condition;
        this.result = result;
        game = parent.getGame();
        scene = game.getScene();
    }

    public Condition<String> getCondition() {
        return condition;
    }

    @Override
    public abstract String execute(String command);
}
