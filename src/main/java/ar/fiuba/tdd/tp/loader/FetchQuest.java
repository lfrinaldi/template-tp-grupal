package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Character;
import ar.fiuba.tdd.tp.game.Game;
import ar.fiuba.tdd.tp.game.Room;
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
    private Stick stick;
    private Room room;

    public FetchQuest() {
        character = Character.getInstance();
        stick = new Stick();
        stick.setName("stick");
        room = new Room("room", new ArrayList<>(Arrays.asList(stick)));
        character.setCurrentRoom(room);
    }

    @Override
    protected boolean checkWinRule() {
        // Gana el juego si el Character tiene el stick
        return character.hasElement(stick);
    }

    @Override
    protected boolean checkLoseRule() {
        return false;
    }

    public String execute(String instruction) {
        return this.room.execute(this.interpreter.interpret(instruction));
    }
}


