package ar.fiuba.tdd.tp.action.simple;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.Condition;
import ar.fiuba.tdd.tp.model.GameObject;

public class GetAttributeSimpleAction extends UnarySimpleAction {

    private String attributeName;

    public GetAttributeSimpleAction(ComplexAction parent, Condition<String> condition, Parameter
            parameter, String attributeName, String result) {
        super(parent, condition, parameter, result);
        this.attributeName = attributeName;
    }

    @Override
    public String execute(String command) {
        return getResponse(getObjectAttribute(command));
    }

    private String getObjectAttribute(String command) {
        GameObject which = getObject(command, parameter);
        return which.getAttribute(attributeName);
    }

    private String getResponse(String attributeValue) {
        return result.replaceAll("<attribute>", attributeValue);
    }
}
