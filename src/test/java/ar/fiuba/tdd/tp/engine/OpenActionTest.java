package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.Room;
import ar.fiuba.tdd.tp.game.Useable;
import ar.fiuba.tdd.tp.game.object.Box;
import ar.fiuba.tdd.tp.game.object.Character;
import ar.fiuba.tdd.tp.game.object.Door;
import ar.fiuba.tdd.tp.game.object.Key;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Adrián on 4/27/2016.
 */
public class OpenActionTest {

    private OpenAction openAction;

    @Before
    public void setup() {
        openAction = new OpenAction();
        Character.getInstance().setCurrentRoom(new Room("room", new ArrayList<Useable>()));
    }

    @Test
    public void executeWithKeySuccessfullyTest() {
        String elementName = "box";
        openAction.setElementName(elementName);
        Box box = new Box();
        box.setName(elementName);
        Key key = new Key();
        key.setName("key");
        box.addObject(key);

        Assert.assertTrue(openAction.execute(box).equals("the box is OPEN"));
        Assert.assertTrue(Character.getInstance().getRoom().hasElement(key));
    }

    @Test
    public void openDoorTest() {
        Character character = Character.getInstance();
        Key key = new Key();
        key.setName("key");
        Room room2 = new Room("Room2", new ArrayList<>());
        Door door = new Door();
        door.setKey(key);
        door.setName("door");
        door.addNextRoom(room2);
        Room room1 = new Room("Room1", new ArrayList<>(Arrays.asList(key, door)));
        character.setCurrentRoom(room1);
        // Simula un pick key
        character.addElement(key);
        OpenAction open = new OpenAction();
        open.setElementName("door");
        open.execute(door);
        Assert.assertTrue(character.getRoom().getName().equals("Room2"));
    }
}
