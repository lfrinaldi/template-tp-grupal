package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

public class HasAttributeCondition extends GameCondition<String> {

    private String attributeName;

    public HasAttributeCondition(Game game, Parameter parameter, String attributeName) {
        super(game, parameter);
        this.attributeName = attributeName;
    }

    @Override
    public boolean isSatisfiedBy(String command) {
        return (getObject(command).getAttributes().containsKey(attributeName));
    }

    private GameObject getObject(String command) {
        return game.getScene().find(parameter.value(command));
    }
}
