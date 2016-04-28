package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Game;

/**
 * Abrir Puerta 2
 * El jugador está en una habitación que contiene una caja con una llave dentro y una puerta.
 * Gana al atravesar la puerta y pasar a la siguiente habitación.
 */
public class AbrirPuerta2 extends Game {
//    private ComplexObject character;
//    private Key key;
//    private Box box;
//    private Door door;
//    private Room bank;
//    private Room vault;

    public AbrirPuerta2() {
//        character = new ComplexObject("character");
//        key = new Key("Key");
//        box = new Box("Box", new ArrayList<>(Arrays.asList(key)), true);
//        vault = new Room("Vault", new ArrayList<>(Arrays.asList()));
//        door = new Door("Door", true, true);
//        door.addNextRoom(vault);
//        bank = new Room("Bank", new ArrayList<>(Arrays.asList(box, door)));
//        addRoom(bank);
//        addRoom(vault);
    }

    @Override
    protected boolean checkWinRule() {
        return false;
    }

    @Override
    protected boolean checkLoseRule() {
        return false;
    }
}
