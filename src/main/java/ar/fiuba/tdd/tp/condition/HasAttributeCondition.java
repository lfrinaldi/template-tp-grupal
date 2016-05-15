package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

public class HasAttributeCondition extends AbstractCondition<String> {

    private Game game;
    private Parameter parameter;
    private String attributeName;

    public HasAttributeCondition(Game game, Parameter parameter, String attributeName) {
        this.game = game;
        this.parameter = parameter;
        this.attributeName = attributeName;
    }

    @Override
    public boolean isSatisfiedBy(String command) {

        GameObject scene = game.getScene();
        String name = parameter.value(command);
        GameObject gameObject = scene.find(name);
        boolean isSatisfied = (gameObject.getAttributesMap().containsKey(attributeName));

        return isSatisfied;
    }
}
