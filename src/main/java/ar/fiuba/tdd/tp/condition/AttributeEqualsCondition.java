package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

public class AttributeEqualsCondition extends GameCondition<String> {

    private String attributeName;
    private String comparable;

    public AttributeEqualsCondition(Game game, Parameter parameter, String attributeName, String comparable) {
        super(game, parameter);
        this.attributeName = attributeName;
        this.comparable = comparable;
    }

    @Override
    public boolean isSatisfiedBy(String command) {
        String attribute = getObject(command).getAttribute(attributeName);
        Boolean booleanResult = false;
        if (attribute != null) {
            booleanResult = attribute.equals(comparable);
        }
        return booleanResult;
    }

    private GameObject getObject(String command) {
        return game.getScene().find(parameter.value(command));
    }
}
