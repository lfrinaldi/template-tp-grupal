package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.action.Action;

import java.util.List;

public class Game {
    private String name;
    private GameObject stage;
    private List<Action> actions;

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

    public String doCommand(String command) {
        return command;

    }
}
