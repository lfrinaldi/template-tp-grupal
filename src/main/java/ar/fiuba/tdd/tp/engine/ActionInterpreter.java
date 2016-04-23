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
        ArrayList<String> objects = new ArrayList<>();
        objects.addAll(Arrays.asList(words).subList(1, words.length));
        if (isRoomAction(words[0])) {
            return new RoomAction(words[0], objects);
        } else {
            return new ObjectAction(words[0], objects);
        }
    }

    private boolean isRoomAction(String word) {
        //TODO: Clean this mess
        return word.equals("Lookaround");
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
