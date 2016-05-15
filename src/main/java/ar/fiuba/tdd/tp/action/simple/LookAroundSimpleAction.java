package ar.fiuba.tdd.tp.action.simple;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.Condition;
import ar.fiuba.tdd.tp.model.GameObject;

import java.util.List;

public class LookAroundSimpleAction extends SimpleAction {

    private Parameter whichParameter;

    public LookAroundSimpleAction(ComplexAction parent, Condition<String> condition,
                                  Parameter whichParameter, String result) {
        super(parent, condition, result);

        this.whichParameter = whichParameter;
    }

    @Override
    public String execute(String command) {

        String whichName = whichParameter.value(command);
        GameObject which = scene.find(whichName);
        List<GameObject> siblings = which.getSiblingsList();
        String result = this.result.replaceAll("<siblings>", formatSiblingsResult(siblings));

        return result;
    }

    private String formatSiblingsResult(List<GameObject> siblings) {

        String result = "";

        if (!siblings.isEmpty()) {

            int siblingsSize = siblings.size();

            for (int index = 0; index < siblingsSize - 1; ++index) {
                result += "a " + siblings.get(index).getName();
                result += (index < siblingsSize - 2) ? ", " : "";
            }

            result += (siblingsSize > 1) ? " and " : "";
            result += "a " + siblings.get(siblingsSize - 1).getName();
        }

        return result;
    }
}
