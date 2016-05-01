package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.engine.ActionInterpreter;

public abstract class Game {

    protected Room currentRoom;
    protected ActionInterpreter interpreter;
    protected Player player;


    public Game() {
        interpreter = new ActionInterpreter();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public abstract boolean checkEndGame();

    public String receiveMessage(String message) {
        Action action = interpreter.interpret(message);
        // Send action to the current room
        /*String response;
        response = Player.getInstance().getRoom().execute(action);

        if (checkWinRule()) {
            response = "You won the game!";
        } else if (checkLoseRule()) {
            response = "You lose!";
        }*/
        return action.execute();
    }
}
