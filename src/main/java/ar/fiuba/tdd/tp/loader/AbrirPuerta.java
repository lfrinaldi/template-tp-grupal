package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Game;
import ar.fiuba.tdd.tp.game.GameObject;
import ar.fiuba.tdd.tp.game.Room;
import ar.fiuba.tdd.tp.game.object.Box;
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
    private GameObject character;
    private Key key;
    private Door door;
    private Room room1;
    private Room room2;

    public AbrirPuerta() {
        character = new GameObject("character");
        key = new Key("Key");
        room2 = new Room("Room 2", new ArrayList<>(Arrays.asList()));
        door = new Door("Door", true, true);
        door.addNextRoom(room2);
        room1 = new Room("Room 1", new ArrayList<>(Arrays.asList(key, door)));
        addRoom(room1);
        addRoom(room2);
    }

    private boolean checkWinRule() {
        // Gana el juego si el Character esta en el Room 2
        return character.getObjects().contains(key);
    }
}