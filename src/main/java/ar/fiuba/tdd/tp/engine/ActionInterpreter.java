package ar.fiuba.tdd.tp.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ActionInterpreter {
    private ArrayList<String> validActions;
    private ArrayList<String> validObjects;
    private static Map<String, Function<String, Action>> actionMap = new HashMap<>();

    static {
        //actionMap.put("open", value -> new OpenAction());
        //actionMap.put("pick", value -> new PickAction());
        //TODO: WHAAAAT
        //actionMap.put("look around", value -> new InvalidAction());
    }

    public ActionInterpreter() {
        this.validActions = new ArrayList<>(Arrays.asList("pick", "open", "look around", "move", "leave"));
        this.validObjects = new ArrayList<>(Arrays.asList("key", "stick", "sheep", "door", "box", "cupboard", "col",
                "wolf", "treasure"));
    }

    public Action interpret(String string) {
        //Action action = new InvalidAction();
        for (String actionName : this.validActions) {
            if (string.matches("^" + actionName + ".*")) {
                //action = createNewAction(string, actionName);
            }
        }
        return null;//action;
    }

    private Action createNewAction(String string, String action) {
        String object = "";
        if (action.length() < string.length()) {
            object = string.substring(action.length() + 1);
        }
        if (this.validObjects.contains(object)
                || (action.equals("look around") && action.length() == string.length())) {
            return mapAction(action, object);
        }
        return null;//new InvalidAction();
    }

    private Action mapAction(String actionName, String objectName) {
        Action action = actionMap.get(actionName).apply(actionName);
        //action.setElementName(objectName);
        return action;
    }

}
