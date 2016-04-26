package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Fetch Quest
 * El jugador comienza en una habitación, con un palo ubicado en dicha habitación.
 * Es necesario tomar el palo.
 */
public class FetchQuest extends Game {
    public FetchQuest() {
        GameObject stick = new GameObject("stick");
        Level room = new Level("room", new ArrayList<Useable>(Arrays.asList(stick)));
        addPlayable(room);
    }

    // Compatibilidad con verisones anteriores
    public FetchQuest(String description) {
        // TODO: Remove constructor from Game
    }

    // Compatibilidad con verisones anteriores
    public FetchQuest(String description, List<Playable> playables) {
        //TODO: Remove constructor from Game
    }
}


