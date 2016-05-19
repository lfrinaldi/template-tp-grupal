package ar.fiuba.tdd.tp.action.simple.parameter;

import ar.fiuba.tdd.tp.model.GameObject;

public class ImplicitCurrentParentParameter implements Parameter {

    private GameObject element;

    public ImplicitCurrentParentParameter(GameObject element) {
        this.element = element;
    }

    @Override
    public String value(String command) {
        return element.getParent().getName();
    }
}
