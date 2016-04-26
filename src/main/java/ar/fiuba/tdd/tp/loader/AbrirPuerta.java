package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Game;
import ar.fiuba.tdd.tp.game.GameObject;
import ar.fiuba.tdd.tp.game.Room;
import ar.fiuba.tdd.tp.game.object.Door;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Abrir Puerta
 * El jugador está en una habitación que contiene una llave y una puerta.
 * Gana al atravesar la puerta y pasar a la siguiente habitación.
 */
public class AbrirPuerta extends Game {
    private GameObject character;
    private GameObject key;
    private GameObject door;
    private ar.fiuba.tdd.tp.game.Room room1;
    //private ar.fiuba.tdd.tp.game.object.Room room2;

    public AbrirPuerta() {
        character = new GameObject("character");
        key = new GameObject("Key");
        //room2 = new Room("Room 2", new ArrayList<>(Arrays.asList()));
        door = new Door("Door", true, true);
        //door.addNextRoom(room2);
        room1 = new Room("Room 1", new ArrayList<>(Arrays.asList(key, door)));
        addRoom(room1);
        //addRoom(room2);
    }

    private boolean checkWinRule() {
        // Gana el juego si el Character esta en el Room 2
        return character.getObjects().contains(key);
    }

    private boolean checkLoseRule() {
        // There's no way you lost this game
        return false;
    }
}
