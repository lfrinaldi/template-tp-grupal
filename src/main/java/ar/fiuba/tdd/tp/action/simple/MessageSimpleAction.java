package ar.fiuba.tdd.tp.action.simple;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.condition.core.Condition;

public class MessageSimpleAction extends SimpleAction {

    public MessageSimpleAction(ComplexAction parent, Condition<String> condition, String result) {
        super(parent, condition, result);
    }

    @Override
    public String execute(String command) {
        return result;
    }
}
