package ar.fiuba.tdd.tp.action.simple;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.Condition;
import ar.fiuba.tdd.tp.model.GameObject;

public class ChangeAttributeSimpleAction extends SimpleAction {

    private Parameter whichParameter;
    private String attributeName;
    private String attributeValue;

    public ChangeAttributeSimpleAction(ComplexAction parent, Condition<String> condition,
                                       Parameter whichParameter, String attributeName, String attributeValue, String result) {
        super(parent, condition, result);

        this.whichParameter = whichParameter;
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    @Override
    public String execute(String command) {

        String wichName = whichParameter.value(command);
        GameObject which = scene.find(wichName);
        boolean changed = which.changeAtribute(attributeName, attributeValue);

        return result;
    }
}
