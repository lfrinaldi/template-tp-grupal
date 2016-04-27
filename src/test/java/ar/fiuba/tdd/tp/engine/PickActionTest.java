package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.object.Box;
import ar.fiuba.tdd.tp.game.object.Key;
import ar.fiuba.tdd.tp.game.object.Stick;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Adrián on 4/27/2016.
 */

public class PickActionTest {

    private PickAction pickAction;

    @Before
    public void setup() {
        pickAction = new PickAction();
    }

    @Test
    public void executeWithKeySuccessfullyTest() {
        String elementName = "key";
        pickAction.setElementName(elementName);
        Key key = new Key();
        key.setName(elementName);

        Assert.assertTrue(pickAction.execute(key).equals("PICK key"));
        Assert.assertTrue(pickAction.getCharacter().hasElement(key));

        Stick stick = new Stick();
        stick.setName("stick");
        Assert.assertFalse(pickAction.getCharacter().hasElement(stick));

        Box box = new Box();
        box.addObject(key);
        box.addObject(stick);

        Assert.assertFalse(pickAction.getCharacter().hasElement(box));
    }


    @Test
    public void executeWithBoxNoPickActionTest() {
        String elementName = "box";
        pickAction.setElementName(elementName);
        Box box = new Box();
        box.setName(elementName);

        Assert.assertTrue(pickAction.execute(box).equals("no action"));
        Assert.assertFalse(pickAction.getCharacter().hasElement(box));

    }


}
