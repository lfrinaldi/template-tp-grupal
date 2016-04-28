package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Game;
import ar.fiuba.tdd.tp.game.Room;
import ar.fiuba.tdd.tp.game.object.Character;
import ar.fiuba.tdd.tp.game.object.Door;
import ar.fiuba.tdd.tp.game.object.Key;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Abrir Puerta
 * El jugador está en una habitación que contiene una llave y una puerta.
 * Gana al atravesar la puerta y pasar a la siguiente habitación.
 */
public class AbrirPuerta extends Game {
    private Character character;
    private Key key;
    private Door door;
    private Room room1;
    private Room room2;

    public AbrirPuerta() {
        character = Character.getInstance();
        key = new Key();
        key.setName("key");
        room2 = new Room("Room2", new ArrayList<>());
        door = new Door();
        door.setName("door");
        door.setKey(key);
        door.addNextRoom(room2);
        room1 = new Room("Room1", new ArrayList<>(Arrays.asList(key, door)));
        character.setCurrentRoom(room1);
        this.addRoom(room1);
        this.addRoom(room2);
    }

    @Override
    protected boolean checkWinRule() {
        // Gana el juego si el Character entra al room 2
        return character.getRoom().getName().equals("Room2");
    }

    @Override
    protected boolean checkLoseRule() {
        return false;
    }
}
