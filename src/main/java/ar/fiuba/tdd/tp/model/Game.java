package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.action.ComplexAction;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private GameObject scene;
    private String name;
    private GameObject stage;
    private List<ComplexAction> actions = new ArrayList<>();

    public Game(GameObject scene) {
        this.scene = scene;
    }

    public GameObject getScene() {
        return scene;
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

    public List<ComplexAction> getActions() {
        return actions;
    }

    public void setActions(List<ComplexAction> actions) {
        this.actions = actions;
    }

    public void addAction(ComplexAction action) {
        this.actions.add(action);
    }

    public String doCommand(String command) {

        for (ComplexAction complexAction : actions) {

            if (command.startsWith(complexAction.getName())) {
                return complexAction.execute(command);
            }
        }

        return null;
    }
}
