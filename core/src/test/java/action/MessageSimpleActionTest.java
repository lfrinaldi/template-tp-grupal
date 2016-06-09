package action;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.MessageSimpleAction;
import ar.fiuba.tdd.tp.condition.TrueCondition;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("CPD-START")
public class MessageSimpleActionTest {

    Game game;
    ComplexAction complexAction;

    @Before
    public void setup() {
        GameObject scene = new GameObject("scene");
        game = new Game(scene, "Test");
        complexAction = new ComplexAction("Test", "help test", game);
    }

    @Test
    public void itShouldReturnAMessage() {
        String message = "Response";
        SimpleAction simpleAction = new MessageSimpleAction(complexAction, new TrueCondition(), message);
        Assert.assertEquals("Response", simpleAction.execute("A command"));
    }

}
