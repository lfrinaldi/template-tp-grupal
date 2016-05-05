package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Game;

/**
 * Busqueda del Tesoro
 * Se tienen 5 habitaciones. Algunas están cerradas y otras no.
 * En cada habitación hay cajas, baúles, armarios, inicialmente todos cerrados.
 * Puede ser que dentro de un armario o un baúl haya cajas. En ellos hay escondidos distintos elementos que el
 * jugador tiene que ir recolectando,
 * pero nunca puede tener más de dos en su posesión, por lo cual debería ir dejandolos cuando no le sirvan más. En
 * las cajas se puede guardar sólo un elemento, pero en los baúles y los armarios se pueden guardar más de uno.
 * Los elementos que se pueden encontrar son:
 * + Llaves: sirven para abrir puertas. Una llave funciona con una puerta en particular.
 * + Venenos: Cuando el player encuentra un veneno, esto no lo mata pero por razones que no alcanza a comprender si
 * intenta salir de la habitación se muere. El jugador se envenena simplemente al abrir la caja/baúl/armario que
 * tiene el veneno.
 * + Antídotos: Se usan para curar al player cuando encuentra un veneno. Los antídotos funcionan con cualquier veneno,
 * así que mejor tener uno a mano!.
 * + Tesoro
 * El jugador gana al encontrar el tesoro y volver a la habitación inicial.
 */
public class BusquedaTesoro extends Game {
//    private ComplexObject character;
//    private Treasure treasure;
//    private Room cave;
//    private Poison poison;
//    private Antipoison antipoison;
//    private Box blueBox;
//    private Box redBox;
//    private Box greenBox;

    public BusquedaTesoro() {
//        character = new ComplexObject("character");
//        treasure = new Treasure("Treasure");
//        greenBox = new Box("GreenBox", new ArrayList<>(Arrays.asList(treasure)), true);
//        poison = new Poison("Poison");
//        redBox = new Box("RedBox", new ArrayList<>(Arrays.asList(poison)), true);
//        antipoison = new Antipoison("Antipoison");
//        blueBox = new Box("BlueBox", new ArrayList<>(Arrays.asList(antipoison)), true);
//        cave = new Room("Cave", new ArrayList<>(Arrays.asList(blueBox, redBox, greenBox)));
//        addRoom(cave);
    }

//    private boolean checkWinRule() {
//        // Gana el juego si el Player tiene el Treasure
//        return character.getObjects().contains(treasure);
//    }

    @Override
    public String receiveMessage(String input) {
        return null;
    }

    @Override
    public boolean checkEndGame() {
        return false;
    }
}
