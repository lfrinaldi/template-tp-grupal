package action;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.MessageSimpleAction;
import ar.fiuba.tdd.tp.condition.FalseCondition;
import ar.fiuba.tdd.tp.condition.TrueCondition;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("CPD-START")
public class ComplexActionTest {

    Game game;
    ComplexAction complexAction;
    GameObject scene;

    @Before
    public void setup() {
        scene = new GameObject("scene");
        game = new Game(scene, "Test");
        complexAction = new ComplexAction("Test", "help test", game);
    }

    @Test
    public void itShouldExecuteTheFirstStepThatConditionIsSatisfied() {
        SimpleAction simpleAction = new MessageSimpleAction(complexAction, new FalseCondition(), "Nop");
        complexAction.addAction(simpleAction);
        simpleAction = new MessageSimpleAction(complexAction, new TrueCondition(), "Yeah");
        complexAction.addAction(simpleAction);
        simpleAction = new MessageSimpleAction(complexAction, new FalseCondition(), "Nop");
        complexAction.addAction(simpleAction);
        Assert.assertEquals("Yeah", complexAction.execute("A command"));
    }

}
