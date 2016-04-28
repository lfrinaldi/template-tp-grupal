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
        actionMap.put("open", value -> new OpenAction());
        actionMap.put("pick", value -> new PickAction());
    }

    public ActionInterpreter() {
        this.validActions = new ArrayList<>(Arrays.asList("pick", "open", "lookArround", "move", "leave"));
        this.validObjects = new ArrayList<>(Arrays.asList("key", "stick", "sheep", "door", "box", "cupboard", "col", "wolf", "treasure"));
    }

    public Action interpret(String string) {
        String[] words = string.split(" ");
        if (stringsAreValid(words)) {
            return createNewAction(words);
        }
        return null;
    }

    private Action createNewAction(String[] words) {

        /*ArrayList<String> objects = new ArrayList<>();
        objects.addAll(Arrays.asList(words).subList(1, words.length));
        switch (words[0]) {
            case "pick": return new PickAction(words[0], objects);
            default: return null;
        }*/
        Action action = actionMap.get(words[0]).apply(words[0]);
        action.setElementName(words[1]);

        return action;
    }

    private boolean stringsAreValid(String[] words) {
        return actionIsValid(words) && objectsAreValid(words);
    }

    private boolean actionIsValid(String[] words) {
        return this.validActions.contains(words[0]);
    }

    private boolean objectsAreValid(String[] words) {
        for (int i = 1; i < words.length; ++i) {
            if (!this.validObjects.contains(words[i])) {
                return false;
            }
        }
        return true;
    }
}
