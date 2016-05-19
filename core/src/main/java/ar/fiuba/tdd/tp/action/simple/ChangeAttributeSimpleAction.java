package ar.fiuba.tdd.tp.action.simple;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.core.Condition;
import ar.fiuba.tdd.tp.model.GameObject;

public class ChangeAttributeSimpleAction extends UnarySimpleAction {

    private String attributeName;
    private String attributeValue;

    public ChangeAttributeSimpleAction(ComplexAction parent, Condition<String> condition, Parameter
            parameter, String result, String attributeName, String attributeValue) {
        super(parent, condition, parameter, result);
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    @Override
    public String execute(String command) {
        GameObject which = getObject(command, parameter);
        which.changeAttribute(attributeName, attributeValue);
        return result;
    }
}
