package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.action.Action;
import ar.fiuba.tdd.tp.engine.ActionParser;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private ActionParser actionParser;
    private String name;
    private GameObject stage;
    private List<Action> actions;

    public Game() {
        this.actions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameObject getStage() {
        return stage;
    }

    public void setStage(GameObject stage) {
        this.stage = stage;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public void addAction(Action action) {
        this.actions.add(action);
    }

    public String doCommand(String command) {
        Action action = actionParser.interpret(command);
        return action.execute(stage.getObjects());
    }

    public void setActionParser(ActionParser actionParser) {
        this.actionParser = actionParser;
    }
}
