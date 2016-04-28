package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.engine.ActionInterpreter;
import ar.fiuba.tdd.tp.game.object.Character;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 4/23/2016.
 */
public abstract class Game {

    private List<Room> rooms;
    protected ActionInterpreter interpreter;

    public Game() {
        interpreter = new ActionInterpreter();
        rooms = new ArrayList<>();
    }

    public Game(List<Room> rooms) {
        this.rooms = rooms;
        interpreter = new ActionInterpreter();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    protected abstract boolean checkWinRule();

    protected abstract boolean checkLoseRule();

    public String receiveMessage(String message) {
        Action action = interpreter.interpret(message);
        // Send action to the current room
        String response = null;
        response = Character.getInstance().getRoom().execute(action);

        if (checkWinRule()) {
            response = "You won the game!";
        } else if (checkLoseRule()) {
            response = "You lose!";
        }
        return response;
    }
}
