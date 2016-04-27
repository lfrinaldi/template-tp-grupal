package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.engine.ActionInterpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 4/23/2016.
 */
public abstract class Game {

    private List<Room> rooms;
    private ActionInterpreter interpreter;

    public Game() {
        interpreter = new ActionInterpreter();
    }

    public Game(List<Room> rooms) {
        this.rooms = rooms;
        interpreter = new ActionInterpreter();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    private boolean checkWinRule() {
        // There's no way you win this game
        return false;
    }

    private boolean checkLoseRule() {
        // There's no way you lost this game
        return false;
    }

    public String receiveMessage(String message) {
        Action action = interpreter.interpret(message);
        // Send action to the current room
        String response = null;
        if (!this.rooms.isEmpty()) {
            response = this.rooms.get(0).execute(action);
        }
        if (checkWinRule()) {
            response = "You won the game!";
        }
        // if (checkLoseRule()) {
        //     response = "You lose!";
        // }
        return response;
    }
}
