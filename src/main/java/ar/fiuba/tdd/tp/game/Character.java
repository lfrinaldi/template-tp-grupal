package ar.fiuba.tdd.tp.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandro on 27/04/16.
 */
public class Character {

    private static Character character = new Character();

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    private Room currentRoom;

    private List<Useable> useables;

    private Character() {
        this.useables = new ArrayList<Useable>();
    }

    public static Character getInstance() {
        if (character == null) {
            character = new Character();
        }
        return character;
    }

    public void addElement(Useable useable) {
        this.useables.add(useable);
    }

    public boolean hasElement(Useable useable) {
        boolean hasElement = false;
        for (Useable element : this.useables) {
            if (element.getName().equals(useable.getName())) {
                hasElement = true;
                break;
            }
        }
        return hasElement;

    }



    public boolean removeObject(String objectName) {
        return this.useables.removeIf(element -> element.getName().equals(objectName));
    }


    public Room getRoom() {
        return currentRoom;
    }

    public void clearObjects() {
        this.useables.clear();
    }
}
