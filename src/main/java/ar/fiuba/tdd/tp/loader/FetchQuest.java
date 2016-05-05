package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.ComplexObject;
import ar.fiuba.tdd.tp.game.Player;
import ar.fiuba.tdd.tp.game.RolGame;
import ar.fiuba.tdd.tp.game.SimpleObject;

/**
 * Fetch Quest
 * El jugador comienza en una habitación, con un palo ubicado en dicha habitación.
 * Es necesario tomar el palo.
 */
public class FetchQuest extends RolGame {

    public FetchQuest() {
        SimpleObject stick = new SimpleObject();
        stick.setName("stick");
        ComplexObject room = new ComplexObject();
        room.setName("room");
        room.addObject(stick);
        setCurrentRoom(room);
        player = new Player(1);
    }

    @Override
    public boolean checkEndGame() {
        return player.hasElement("stick");
    }

    @Override
    public String receiveMessage(String input) {
        return null;
    }
}


