package ar.fiuba.tdd.tp.action.simple;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.core.Condition;
import ar.fiuba.tdd.tp.model.GameObject;

public abstract class UnarySimpleAction extends SimpleAction {

    protected Parameter parameter;

    public UnarySimpleAction(ComplexAction parent, Condition<String> condition, Parameter parameter, String result) {
        super(parent, condition, result);
        this.parameter = parameter;
    }

    public abstract String execute(String command);

    protected GameObject getObject(String command, Parameter parameter) {
        String whichName = parameter.value(command);
        return scene.find(whichName);
    }

    /*private String getIdentifierName(String whichName) {
        String identifierName = whichName;
        if (this.game.isMultiPlayer() && this.isPlayer(whichName))
            identifierName = game.getCurrentPlayerId();
        return identifierName;
    }*/

    /*private boolean isPlayer(String whichName) {
        return whichName.toLowerCase().contains("player");
    }*/
}
