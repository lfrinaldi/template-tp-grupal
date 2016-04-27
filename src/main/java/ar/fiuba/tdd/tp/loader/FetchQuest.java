package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Game;
import ar.fiuba.tdd.tp.game.Room;
import ar.fiuba.tdd.tp.game.Useable;
import ar.fiuba.tdd.tp.game.object.Character;
import ar.fiuba.tdd.tp.game.object.Stick;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Fetch Quest
 * El jugador comienza en una habitación, con un palo ubicado en dicha habitación.
 * Es necesario tomar el palo.
 */
public class FetchQuest extends Game {
    private Character character;
    private Useable stick;
    private Room room;

    public FetchQuest() {
        character = Character.getInstance();
        stick = new Stick();
        room = new Room("room", new ArrayList<>(Arrays.asList(stick)));
        addRoom(room);
    }

    private boolean checkWinRule() {
        // Gana el juego si el Character tiene el stick
        return character.hasElement(stick);
    }
}


