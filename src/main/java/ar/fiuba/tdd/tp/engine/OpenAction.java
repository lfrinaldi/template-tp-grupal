package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.object.*;
import ar.fiuba.tdd.tp.game.object.Character;

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
