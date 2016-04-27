package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.object.Stick;
import org.junit.Assert;
import org.junit.Test;

public class ActionInterpreterTest {

    @Test
    public void testInterpretPickAction() {
        ActionInterpreter actionInterpreter = new ActionInterpreter();
        String string = "pick stick";
        Action action = actionInterpreter.interpret(string);
    }
}
