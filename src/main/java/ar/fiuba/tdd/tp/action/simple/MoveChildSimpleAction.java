package ar.fiuba.tdd.tp.action.simple;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.Condition;
import ar.fiuba.tdd.tp.model.GameObject;

public class MoveChildSimpleAction extends UnarySimpleAction {

    private Parameter childParameter;

    @Override
    public String execute(String command) {
        GameObject child = getChild(command);
        GameObject target = getTargetObject(command);
        GameObject source = child.getParent();
        move(child, source, target);
        return result;
    }

    private boolean move(GameObject objectToMove, GameObject objectFrom, GameObject objectTo) {
        return objectFrom.moveChild(objectToMove.getName(), objectTo);
    }

    private GameObject getChild(String command) {
        return getObject(command, childParameter);
    }

    private GameObject getTargetObject(String command) {
        return getObject(command, parameter);
    }

    public MoveChildSimpleAction(ComplexAction parent, Condition<String> condition, Parameter
            childParameter, Parameter parameter, String result) {
        super(parent, condition, parameter, result);
        this.childParameter = childParameter;
    }
}
