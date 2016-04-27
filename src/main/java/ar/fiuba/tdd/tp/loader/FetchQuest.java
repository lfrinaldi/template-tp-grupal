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
    private Room room;

    public FetchQuest() {
        character = new GameObject("character");
        stick = new GameObject("stick");
        room = new Room("room", new ArrayList<>(Arrays.asList(stick)));
        addRoom(room);
    }

    private boolean checkWinRule() {
        // Gana el juego si el Character tiene el stick
        return character.getObjects().contains(stick);
    }
}


