package ar.fiuba.tdd.tp.engine;

import org.junit.Assert;
import org.junit.Test;

public class ActionInterpreterTest {

    @Test
    public void testInterpretValidAction() {
        ActionInterpreter actionInterpreter = new ActionInterpreter();
        String string = "Usar Puerta";
        Action action = actionInterpreter.interpret(string);
        Assert.assertTrue(action.getName().equals("Usar"));
        Assert.assertTrue(action.getPrimaryObject().getDescription().equals("Puerta"));
    }
}
