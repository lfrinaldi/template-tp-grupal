package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.PickAction;
import ar.fiuba.tdd.tp.game.object.Stick;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Adrián on 4/27/2016.
 */
public class RoomTest {

    private Room room;

    @Before
    public void setup() {
        room = new Room("room", new ArrayList<>());
    }

    @Test
    public void roomTest() {

        Stick stick = new Stick();
        stick.setName("stick");

        room.setObjects(Arrays.asList(stick));
        PickAction pickAction = new PickAction();
        pickAction.setElementName("stick");

        Assert.assertTrue(room.execute(pickAction).equals("PICK stick"));
    }
}
