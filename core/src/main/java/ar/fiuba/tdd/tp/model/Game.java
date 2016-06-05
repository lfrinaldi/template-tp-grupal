package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.action.ComplexAction;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private GameObject scene;
    private String name;
    private List<ComplexAction> actions = new ArrayList<>();


    public GameObject getScene() {
        return scene;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public String doCommand(String command, int playerId) {

        GameObject player = this.scene.findPlayer(playerId);

        for (ComplexAction complexAction : actions) {

            if (command.startsWith(complexAction.getName())) {
                return complexAction.execute(command);
            }
        }

        return null;
    }

    public Game(GameObject scene) {
        this.scene = scene;
    }
}
