package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

public class HasChildCondition extends AbstractCondition<String> {

    private Game game;
    private Parameter parentParameter;
    private Parameter childParameter;

    public HasChildCondition(Game game, Parameter parentParameter, Parameter childParameter) {
        this.game = game;
        this.parentParameter = parentParameter;
        this.childParameter = childParameter;
    }

    @Override
    public boolean isSatisfiedBy(String command) {

        GameObject scene = game.getScene();
        String parentName = parentParameter.value(command);
        GameObject parent = scene.find(parentName);
        String childName = childParameter.value(command);
        boolean isSatisfied = (parent.getChildrenMap().containsKey(childName));

        return isSatisfied;
    }
}
