package ar.fiuba.tdd.tp.action.simple;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.Condition;
import ar.fiuba.tdd.tp.model.GameObject;

public class MoveChildSimpleAction extends SimpleAction {

    private Parameter childParameter;
    private Parameter targetParameter;

    public MoveChildSimpleAction(ComplexAction parent, Condition<String> condition,
                                 Parameter childParameter, Parameter targetParameter, String result) {
        super(parent, condition, result);

        this.childParameter = childParameter;
        this.targetParameter = targetParameter;
    }

    @Override
    public String execute(String command) {

        String childName = childParameter.value(command);
        String targetName = targetParameter.value(command);
        GameObject child = scene.find(childName);
        GameObject target = scene.find(targetName);
        GameObject source = child.getParent();
        boolean moved = source.moveChild(childName, target);

        return result;
    }
}
