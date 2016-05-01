package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Game;

/**
 * Fetch Quest
 * El jugador comienza en una habitación, con un palo ubicado en dicha habitación.
 * Es necesario tomar el palo.
 */
public class FetchQuest extends Game {
    /*private Player character;
    private Stick stick;
    private Room room;*/

    public FetchQuest() {
        /*character = Player.getInstance();
        stick = new Stick();
        stick.setName("stick");
        room = new Room("room", new ArrayList<>(Arrays.asList(stick)));
        character.setCurrentRoom(room);*/
    }

    @Override
    public boolean checkEndGame() {
        return false;
    }

    public String execute(String instruction) {
        return null;//this.room.execute(this.interpreter.interpret(instruction));
    }
}


