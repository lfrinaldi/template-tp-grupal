package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.ArrayList;
import java.util.Arrays;

public class ActionInterpreter {
    private ArrayList<String> validActions;
    private ArrayList<String> validObjects;

    public ActionInterpreter() {
        this.validActions = new ArrayList<>(Arrays.asList("Usar", "Mirar"));
        this.validObjects = new ArrayList<>(Arrays.asList("Llave", "Puerta"));
    }

    public Action interpret(String string) {
        String[] words = string.split(" ");
        if (stringsAreValid(words)) {
            return createNewAction(words);
        }
        return null;
    }

    private Action createNewAction(String[] words) {
        ArrayList<GameObject> objects = new ArrayList<>();
        for (int i = 1 ; i < words.length ; ++i) {
            objects.add(new GameObject(words[i]));
        }
        return new Action(words[0], objects);
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
