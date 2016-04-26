package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.engine.ActionInterpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 4/23/2016.
 */
public class Game extends BaseGame {

    private List<Playable> playables;
    private ActionInterpreter interpreter;

    public Game() {

    }

    public Game(String description) {
        super.setDescription(description);
        interpreter = new ActionInterpreter();
    }

    public Game(String description, List<Playable> playables) {
        super.setDescription(description);
        this.playables = new ArrayList<>(playables);
        interpreter = new ActionInterpreter();
    }

    public void addPlayable(Playable playable) {
        this.playables.add(playable);
    }

    public List<Playable> getPlayables() {
        return this.playables;
    }

    @Override
    public String play(Action action) {
        System.out.print("Jugando " + super.getDescription());
        return "Jugando";
    }

    public String receiveMessage(String message) {
        //System.out.print("Mensaje: " + message);
        Action action = interpreter.interpret(message);
        // Send action to the current level
        String response = null;
        if (!this.playables.isEmpty()) {
            response = this.playables.get(0).play(action);
        }
        return response;
    }

}
