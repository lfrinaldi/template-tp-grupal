package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

public class ChildrenSizeEqualsCondition extends GameCondition<String> {

    private int size;

    public ChildrenSizeEqualsCondition(Game game, Parameter parameter, int size) {
        super(game, parameter);
        this.size = size;
    }

    @Override
    public boolean isSatisfiedBy(String command) {
        GameObject scene = game.getScene();
        GameObject parent = getParentOf(scene, command);
        int currentSize = parent.getChildren().size();
        return (currentSize == size);
    }

    private GameObject getParentOf(GameObject scene, String value) {
        String name = parameter.value(value);
        return scene.find(name);
    }

}
