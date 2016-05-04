package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.ActionInterpreter;

public abstract class Game {

    protected ActionInterpreter interpreter;

    public Game() {
        interpreter = new ActionInterpreter();
    }

    public ActionInterpreter getInterpreter() {
        return interpreter;
    }

    public void setInterpreter(ActionInterpreter interpreter) {
        this.interpreter = interpreter;
    }

    protected String error(Exception exception) {
        return "error";
    }

    public abstract String receiveMessage(String input);

    public abstract boolean checkEndGame();
}
