package ar.fiuba.tdd.tp.action.simple;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.core.Condition;
import ar.fiuba.tdd.tp.model.GameObject;

import java.util.List;

public class LookAroundSimpleAction extends UnarySimpleAction {


    public LookAroundSimpleAction(ComplexAction parent, Condition<String> condition, Parameter
            parameter, String result) {
        super(parent, condition, parameter, result);
    }

    @Override
    public String execute(String command) {
        GameObject which = getObject(command, this.parameter);
        List<GameObject> siblings = which.getSiblingsList();
        return this.result.replaceAll("<siblings>", formatSiblingsResult(siblings));
    }

    private String formatSiblingsResult(List<GameObject> siblings) {

        StringBuffer result = new StringBuffer();

        if (!siblings.isEmpty()) {

            int siblingsSize = siblings.size();

            for (int index = 0; index < siblingsSize - 1; ++index) {
                result.append("a " + siblings.get(index).getName());
                result.append((index < siblingsSize - 2) ? ", " : "");
            }

            result.append((siblingsSize > 1) ? " and " : "");
            result.append("a " + siblings.get(siblingsSize - 1).getName());
        }

        return result.toString();
    }
}
