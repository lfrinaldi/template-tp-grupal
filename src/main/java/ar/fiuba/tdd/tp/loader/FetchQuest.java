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
    private GameObject character;
    private GameObject stick;
    private Level room;

    public FetchQuest() {
        character = new GameObject("character");
        stick = new GameObject("stick");
        room = new Level("room", new ArrayList<Useable>(Arrays.asList(stick)));
        addPlayable(room);
    }

    private boolean checkWinRule() {
        // Gana el juego si el Character tiene el stick
        return character.getUseable().contains(stick);
    }

    private boolean checkLoseRule() {
        // There's no way you lost this game
        return false;
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


