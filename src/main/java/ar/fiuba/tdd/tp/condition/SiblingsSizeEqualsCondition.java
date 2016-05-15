package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

public class SiblingsSizeEqualsCondition extends AbstractCondition<String> {

    private Game game;
    private Parameter parameter;
    private int size;

    public SiblingsSizeEqualsCondition(Game game, Parameter parameter, int size) {
        this.game = game;
        this.parameter = parameter;
        this.size = size;
    }

    @Override
    public boolean isSatisfiedBy(String command) {

        GameObject scene = game.getScene();
        String name = parameter.value(command);
        GameObject gameObject = scene.find(name);
        int currentSize = gameObject.getSiblingsList().size();
        boolean isSatisfied = (currentSize == size);

        return isSatisfied;
    }

}
