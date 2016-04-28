package ar.fiuba.tdd.tp.engine;

import org.junit.Assert;
import org.junit.Test;

public class ActionInterpreterTest {

    @Test
    public void testInterpretPickAction() {
        ActionInterpreter actionInterpreter = new ActionInterpreter();
        String string = "pick stick";
        Action action = actionInterpreter.interpret(string);
        Assert.assertTrue(action.getElementName().equals("stick"));
        Assert.assertTrue(action.getClass().equals(PickAction.class));
    }

    @Test
    public void testInterpretOpenAction() {
        ActionInterpreter actionInterpreter = new ActionInterpreter();
        String string = "open door";
        Action action = actionInterpreter.interpret(string);
        Assert.assertTrue(action.getElementName().equals("door"));
        Assert.assertTrue(action.getClass().equals(OpenAction.class));
    }

    @Test
    public void testInterpretLookAroundAction() {
        ActionInterpreter actionInterpreter = new ActionInterpreter();
        String string = "look around";
        Action action = actionInterpreter.interpret(string);
        Assert.assertTrue(action.getClass().equals(InvalidAction.class));
    }

    @Test
    public void testInvalidLookAround() {
        ActionInterpreter actionInterpreter = new ActionInterpreter();
        String string = "look arounds";
        Action action = actionInterpreter.interpret(string);
        Assert.assertTrue(action.getClass().equals(InvalidAction.class));
    }

    @Test
    public void testInvalidAction() {
        ActionInterpreter actionInterpreter = new ActionInterpreter();
        String string = "dsd fdvdf dfdcs sdsc";
        Action action = actionInterpreter.interpret(string);
        Assert.assertTrue(action.getClass().equals(InvalidAction.class));
    }

    @Test
    public void testDoubleSpace() {
        ActionInterpreter actionInterpreter = new ActionInterpreter();
        String string = "open  door";
        Action action = actionInterpreter.interpret(string);
        Assert.assertTrue(action.getClass().equals(InvalidAction.class));
    }

}
