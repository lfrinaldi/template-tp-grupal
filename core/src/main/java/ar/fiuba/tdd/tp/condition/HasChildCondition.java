package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

import java.util.Map;

public class HasChildCondition extends GameCondition<String> {
    private Parameter childParameter;

    public HasChildCondition(Game game, Parameter parameter, Parameter childParameter) {
        super(game, parameter);
        this.childParameter = childParameter;
    }

    @Override
    public boolean isSatisfiedBy(String command) {
        String childName = childParameter.value(command);
        return (getParentChildrenMap(command).containsKey(childName));
    }

    private Map<String, GameObject> getParentChildrenMap(String command) {
        String parentName = parameter.value(command);
        return game.getScene().find(parentName).getChildrenMap();
    }
}
