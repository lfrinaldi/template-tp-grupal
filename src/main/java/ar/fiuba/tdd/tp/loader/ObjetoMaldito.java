package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Game;
import ar.fiuba.tdd.tp.game.GameObject;
import ar.fiuba.tdd.tp.game.Room;
import ar.fiuba.tdd.tp.game.object.Box;
import ar.fiuba.tdd.tp.game.object.Door;
import ar.fiuba.tdd.tp.game.object.Key;
import ar.fiuba.tdd.tp.game.object.Thief;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Objeto Maldito
 * Hay tres habitaciones en serie: En la primera, hay un objeto “maldito” que el jugador debe poseer para abrir la
 * primer puerta, pero del que no puede deshacerse por acción propia.
 * La segunda puerta se abre si el jugador no posee el objeto maldito.
 * Para ayudar al jugador, en la segunda habitación hay un ladrón que toma todos los objetos del jugador
 * cuando interactúa con él.
 * Gana al llegar a la tercer habitacion.
 */
public class ObjetoMaldito extends Game {
//    private GameObject character;
//    private GameObject evil;
//    private Thief thief;
//    private Door door1;
//    private Door door2;
//    private Room room1;
//    private Room room2;
//    private Room room3;

    public ObjetoMaldito() {
//        character = new GameObject("character");
//        room3 = new Room("Room 3", new ArrayList<>(Arrays.asList()));
//        door2 = new Door("Door 2", true, true);
//        door2.addNextRoom(room3);
//        thief = new Thief("Thief", new ArrayList<>(Arrays.asList()));
//        room2 = new Room("Room 2", new ArrayList<>(Arrays.asList(thief, door2)));
//        door1 = new Door("Door 1", true, true);
//        door1.addNextRoom(room2);
//        evil = new  GameObject("Evil");
//        room1 = new Room("Room 1", new ArrayList<>(Arrays.asList(evil, door1)));
//        addRoom(room1);
//        addRoom(room2);
//        addRoom(room3);
    }

//    private boolean checkWinRule() {
//        // Gana el juego si el Character esta en el Room 3
//        // es decir si la Door 2 esta abierta
//        //return door2.isOpen();
//        return !character.getObjects().contains(evil);
//    }
}
