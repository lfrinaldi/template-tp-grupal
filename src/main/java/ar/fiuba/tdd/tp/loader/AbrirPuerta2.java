package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Game;

/**
 * Abrir Puerta 2
 * El jugador está en una habitación que contiene una caja con una llave dentro y una puerta.
 * Gana al atravesar la puerta y pasar a la siguiente habitación.
 */
public class AbrirPuerta2 extends Game {


    public AbrirPuerta2() {
        /*character = Player.getInstance();
        key = new Key();
        key.setName("Key");
        box = new Box();
        box.setName("box");
        box.setObjects(new ArrayList<>(Arrays.asList(key)));
        vault = new Room("Vault", new ArrayList<>(Arrays.asList()));
        door = new Door();
        door.setName("Door");
        door.setKey(key);
        door.addNextRoom(vault);
        bank = new Room("Bank", new ArrayList<>(Arrays.asList(box, door)));*/
        //Player.getInstance().setCurrentRoom(AbrirPuertaFactory.createRoomsAbrirPuertaDos());
    }

    @Override
    public String receiveMessage(String input) {
        return null;
    }

    @Override
    public boolean checkEndGame() {
        return false;
    }
}
