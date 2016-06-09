package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.connection.ClientManager;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private GameObject scene;
    private String name;
    private boolean isMultiPlayer = false;
    private List<ComplexAction> actions = new ArrayList<>();
    private List<GameObject> players = new ArrayList<>();
    private List<TimeTask> timeTasks = new ArrayList<>();
    private ClientManager clientManager;

    public Game(GameObject scene, String name) {
        this.scene = scene;
        this.name = name;
    }

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

    public String doCommand(String command, String playerId) {

        GameObject currentPlayer =
                (this.existPlayer(playerId)) ? this.getPlayer(playerId) : this.addNewPlayer(playerId);

        for (ComplexAction complexAction : actions) {

            if (command.startsWith(complexAction.getName())) {
                if (currentPlayer != null) {
                    return complexAction.execute(command + " " + currentPlayer.getName());
                }
            }
        }

        return null;
    }

    public String doCommand(String command) {
        for (ComplexAction complexAction : actions) {

            if (command.startsWith(complexAction.getName())) {
                return complexAction.execute(command);
            }
        }

        return null;
    }

    private GameObject getPlayer(String playerId) {
        for (GameObject player : this.players) {
            if (player.getName() != null && player.getName().equals(playerId))
                return player;
        }
        return null;
    }

    private boolean existPlayer(String playerId) {
        for (GameObject player : this.players) {
            if (player.getName() != null && player.getName().equals(playerId))
                return true;
        }
        return false;
    }

    public GameObject addNewPlayer(String playerId) {
        GameObject newPlayer = null;
        if (!this.existPlayer(playerId)) {
            newPlayer = new GameObject(playerId);
            this.players.add(newPlayer);
            this.scene.addChild(newPlayer);
            this.doCommand("add player " + playerId);
            this.doCommand("init player " + playerId);
        }
        return newPlayer;
    }

    public void addTimeTask(TimeTask timeTask) {
        timeTasks.add(timeTask);
    }

    public void runTimeTasks() {
        if (timeTasks.size() > 0) {
            timeTasks.forEach(e -> e.run(clientManager));
        }
    }

    public void stopTimeTasks() {
        timeTasks.forEach(e -> e.shutDown());
    }

    public boolean isMultiPlayer() {
        return isMultiPlayer;
    }

    public void setMultiPlayer() {
        this.isMultiPlayer = true;
    }

    public String getCurrentPlayerId() {
        return this.players.get(this.players.size() - 1).getName();
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public void broadcast(String string) {
        this.clientManager.broadcastButMe(null, string);
    }
}
