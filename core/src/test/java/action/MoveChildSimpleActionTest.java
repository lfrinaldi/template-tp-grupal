package action;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.MoveChildSimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.ExplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.ImplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.TrueCondition;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("CPD-START")
public class MoveChildSimpleActionTest {

    Game game;
    ComplexAction complexAction;
    GameObject scene;
    GameObject player;

    @Before
    public void setup() {
        scene = new GameObject("scene");
        player = new GameObject("player");
        scene.addChild(player);
        GameObject gameObject = new GameObject("key");
        scene.addChild(gameObject);
        game = new Game(scene, "Test");
        complexAction = new ComplexAction("Test", "help test", game);
    }

    @Test
    public void itShouldMoveThatChild() {
        Parameter keyParameter = new ImplicitParameter("key");
        Parameter playerParameter = new ImplicitParameter("player");

        String message = "There you go!";
        SimpleAction simpleAction = new MoveChildSimpleAction(complexAction, new TrueCondition(), keyParameter,
                playerParameter, message);

        // Mueve la llave al inventario del player
        simpleAction.execute("A command");

        Assert.assertEquals("key", player.find("key").getName());
    }

}
