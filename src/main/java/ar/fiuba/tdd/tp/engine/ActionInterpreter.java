package ar.fiuba.tdd.tp.engine;

import java.util.ArrayList;
import java.util.Arrays;

public class ActionInterpreter {
    private ArrayList<String> validActions;
    private ArrayList<String> validObjects;

    public ActionInterpreter() {
        this.validActions = new ArrayList<>(Arrays.asList("pick", "Mirar"));
        this.validObjects = new ArrayList<>(Arrays.asList("Llave", "stick"));
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
        return null;
    }

    private boolean stringsAreValid(String[] words) {
        return actionIsValid(words) && objectsAreValid(words);
    }

    private boolean actionIsValid(String[] words) {
        return this.validActions.contains(words[0]);
    }

    private boolean objectsAreValid(String[] words) {
        for (int i = 1 ; i < words.length ; ++i) {
            if (!this.validObjects.contains(words[i])) {
                return false;
            }
        }
        return true;
    }
}
