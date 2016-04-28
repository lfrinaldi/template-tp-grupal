package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.object.*;

public class InvalidAction implements Action {

    private String elementName = "";

    private static final String RESPONSE = "You made a mistake, try again...";

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementName() {
        return elementName;
    }


    @Override
    public String execute(Key key) {
        return RESPONSE;
    }

    @Override
    public String execute(Door door) {
        return RESPONSE;
    }

    @Override
    public String execute(Box box) {
        return RESPONSE;
    }

    @Override
    public String execute(Disk disk) {
        return RESPONSE;
    }

    @Override
    public String execute(Stick stick) {
        return RESPONSE;
    }

}
