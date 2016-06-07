package action;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.LookAroundSimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.ImplicitParameter;
import ar.fiuba.tdd.tp.condition.TrueCondition;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("CPD-START")
public class LookAroundSimpleActionTest {

    Game game;
    ComplexAction complexAction;

    @Before
    public void setup() {
        GameObject scene = new GameObject("scene");
        GameObject player = new GameObject("player");
        scene.addChild(player);
        GameObject gameObject = new GameObject("key");
        scene.addChild(gameObject);
        game = new Game(scene, "Test");
        complexAction = new ComplexAction("Test", "help test", game);
    }

    @Test
    public void itShouldSayTheresAKeyOnly() {
        String message = "<siblings>";
        SimpleAction simpleAction = new LookAroundSimpleAction(complexAction, new TrueCondition(),
                new ImplicitParameter("player"), message);
        Assert.assertEquals("a key", simpleAction.execute("A command"));
    }

}
