package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.Character;
import ar.fiuba.tdd.tp.game.object.*;

/**
 * Created by Adrián on 4/27/2016.
 */
public class OpenAction implements Action {

    private String elementName;

    private static final String OPEN_RESPONSE = "OPEN";

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementName() {
        return elementName;
    }


    @Override
    public String execute(Key key) {
        return key.getNoAction();
    }

    @Override
    public String execute(Door door) {
        Character character = Character.getInstance();
        if (character.hasElement(door.getKey())) {
            character.removeObject(door.getKey().getName());
            character.setCurrentRoom(door.getNextRoom());
            return "You are in " + door.getNextRoom().getName();
        } else {
            return "Ey! Where do you go?!" + door.getNextRoom().getName() + "is locked.";
        }
    }

    @Override
    public String execute(Box box) {
        box.deliverTo(Character.getInstance().getRoom());
        return "the box is " + OPEN_RESPONSE;
    }

    @Override
    public String execute(Disk disk) {
        return disk.getNoAction();
    }

    @Override
    public String execute(Stick stick) {
        return stick.getNoAction();
    }
}
