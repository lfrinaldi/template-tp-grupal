package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

public class IsBiggerThanAttributeCondition extends GameCondition<String> {

    private String attributeName;
    private Parameter parameter2;

    public IsBiggerThanAttributeCondition(Game game, Parameter parameter, Parameter parameter2, String attributeName) {
        super(game, parameter);
        this.attributeName = attributeName;
        this.parameter2 = parameter2;
    }

    @Override
    public boolean isSatisfiedBy(String command) {
        int first = 0;
        if (getObject(command) != null) {
            first = Integer.parseInt(getObject(command).getAttributes().get(attributeName));
        }
        int second = 0;
        if (getObject2(command) != null) {
            second = Integer.parseInt(getObject2(command).getAttributes().get(attributeName));
        }
        return first > second;
    }

    private GameObject getObject(String command) {
        return game.getScene().find(parameter.value(command));
    }

    private GameObject getObject2(String command) {
        return game.getScene().find(parameter2.value(command));
    }

}
