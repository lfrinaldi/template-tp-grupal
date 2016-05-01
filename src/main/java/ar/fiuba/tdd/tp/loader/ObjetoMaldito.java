package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Game;

/**
 * Objeto Maldito
 * Hay tres habitaciones en serie: En la primera, hay un objeto maldito que el jugador debe poseer para abrir la
 * primer puerta, pero del que no puede deshacerse por accion propia.
 * La segunda puerta se abre si el jugador no posee el objeto maldito.
 * Para ayudar al jugador, en la segunda habitacion hay un ladron que toma todos los objetos del jugador
 * cuando interactua con él.
 * Gana al llegar a la tercer habitacion.
 */
public class ObjetoMaldito extends Game {
//    private ComplexObject character;
//    private ComplexObject evil;
//    private Thief thief;
//    private Door door1;
//    private Door door2;
//    private Room room1;
//    private Room room2;
//    private Room room3;

    public ObjetoMaldito() {
//        character = new ComplexObject("character");
//        room3 = new Room("Room 3", new ArrayList<>(Arrays.asList()));
//        door2 = new Door("Door 2", true, true);
//        door2.addNextRoom(room3);
//        thief = new Thief("Thief", new ArrayList<>(Arrays.asList()));
//        room2 = new Room("Room 2", new ArrayList<>(Arrays.asList(thief, door2)));
//        door1 = new Door("Door 1", true, true);
//        door1.addNextRoom(room2);
//        evil = new  ComplexObject("Evil");
//        room1 = new Room("Room 1", new ArrayList<>(Arrays.asList(evil, door1)));
//        addRoom(room1);
//        addRoom(room2);
//        addRoom(room3);
    }

//    private boolean checkWinRule() {
//        // Gana el juego si el Player esta en el Room 3
//        // es decir si la Door 2 esta abierta
//        //return door2.isOpen();
//        return !character.getObjects().contains(evil);
//    }


    @Override
    public boolean checkEndGame() {
        return false;
    }
}
