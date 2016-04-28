package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.game.object.Character;
import ar.fiuba.tdd.tp.game.object.Stick;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Adrián on 4/27/2016.
 */
public class CharacterTest {

    private Character character = Character.getInstance();

    @Test
    public void removeObjectTest() {
        Stick stick = new Stick();
        stick.setName("stick");

        character.addElement(stick);

        Assert.assertTrue(character.removeObject(stick.getName()));

        Assert.assertFalse(character.hasElement(stick));

    }
}
