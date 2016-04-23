package ar.fiuba.tdd.tp.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Adrian on 4/23/2016.
 */
public class Game extends BaseGame {

    private List<Playable> playables;

    public Game(String description) {
        super.setDescription(description);
    }

    public Game(String description, List<Playable> playables) {
        super.setDescription(description);
        this.playables = new ArrayList<>(playables);
    }

    public void addPlayable(Playable playable) {
        this.playables.add(playable);
    }

    public List<Playable> getPlayables() {
        return this.playables;
    }

    @Override
    public String play() {
        return "Jugando " + super.getDescription();
    }
}
