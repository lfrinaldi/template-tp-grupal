package ar.fiuba.tdd.tp.action.simple;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.Condition;
import ar.fiuba.tdd.tp.model.GameObject;

public class GetAttributeSimpleAction extends SimpleAction {

    private Parameter whichParameter;
    private String attributeName;

    public GetAttributeSimpleAction(ComplexAction parent, Condition<String> condition,
                                    Parameter whichParameter, String attributeName, String result) {
        super(parent, condition, result);

        this.whichParameter = whichParameter;
        this.attributeName = attributeName;
    }

    @Override
    public String execute(String command) {

        String wichName = whichParameter.value(command);
        GameObject which = scene.find(wichName);
        String attributeValue = which.getAttribute(attributeName);
        String result = this.result.replaceAll("<attribute>", attributeValue);

        return result;
    }
}
