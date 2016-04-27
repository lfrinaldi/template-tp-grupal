package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.Room;
import ar.fiuba.tdd.tp.game.Useable;
import ar.fiuba.tdd.tp.game.object.Box;
import ar.fiuba.tdd.tp.game.object.Character;
import ar.fiuba.tdd.tp.game.object.Key;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
}
