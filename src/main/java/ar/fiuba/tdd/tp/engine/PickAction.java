package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.object.*;
import ar.fiuba.tdd.tp.game.object.Character;

public class PickAction implements Action {

    private static final String NO_ACTION_STACK = "CAN NOT PICK STACK";
    private static final String NO_ACTION_WOLF = "CAN NOT PICK WOLF";
    private static final String NO_ACTION_CUPBOARD = "CAN NOT PICK CUPBOARD";
    private static final String NO_ACTION_TREASURE = "CAN NOT PICK NO_ACTION_TREASURE";
    private static final String NO_ACTION_THIEF = "CAN NOT PICK NO_ACTION_THIEF ";
    private String elementName;

    private static final String PICK_RESPONSE = "PICK ";

    private static final String NO_ACTION = "CAN NOT PICK ";

    private static final String NO_ACTION_BOX = "CAN NOT PICK BOX";
    private static final String NO_ACTION_FOR_CHEST = "CAN NOT PICK CHEST";
    private static final String NO_ACTION_DISK = "CAN NOT PICK DISK";
    private static final String NO_ACTION_COL = "CAN NOT PICK COL";
    private static final String NO_ACTION_DOOR = "CAN NOT PICK DOOR";
    private static final String NO_ACTION_SHEEP = "CAN NOT PICK SHEEP";

    public Character getCharacter() {
        return Character.getInstance();
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementName() {
        return elementName;
    }

/*    @Override
    public String execute(Useable useable) {
        return null;
    }*/

    @Override
    public String execute(Stick stick) {
        stick.deliverTo(Character.getInstance());
        return PICK_RESPONSE + stick.getName();

    }

    @Override
    public String execute(Key key) {
        key.deliverTo(Character.getInstance());
        return PICK_RESPONSE + key.getName();
    }

    @Override
    public String execute(Door door) {
        return door.getNoAction();
    }

    @Override
    public String execute(Box box) {

        return box.getNoAction();
    }

    @Override
    public String execute(Disk disk) {

        return disk.getNoAction();
    }

/*

    @override
    public string execute(antipoison antipoison) {
        antipoison.apdeliverto(character.getinstance());
        return pick_response + antipoison.getname();
    }



    @Override
    public String execute(Chest chest) {

        return NO_ACTION_FOR_CHEST;
    }

    @Override
    public String execute(Col col) {
        return NO_ACTION_COL;
    }

    @Override
    public String execute(Door door) {
        return NO_ACTION_DOOR;
    }

    @Override
    public String execute(Sheep sheep) {
        return NO_ACTION_SHEEP;

    }

   @Override
    public String execute(Stack stack) {
        return NO_ACTION_STACK;
    }

    @Override
    public String execute(Thief thief) {
        return NO_ACTION_THIEF;
    }

    @Override
    public String execute(Treasure treasure) {
        return NO_ACTION_TREASURE;
    }

    @Override
    public String execute(Cupboard cupboard) {
        return NO_ACTION_CUPBOARD;
    }

    @Override
    public String execute(Wolf wolf) {
        return NO_ACTION_WOLF;

    }

    @Override
    public String execute(Poison poison) {
        Character.getInstance().addElement(poison);

        return PICK_RESPONSE + poison.getName();
    }*/
}
