package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.action.Action;
import ar.fiuba.tdd.tp.model.Game;

import java.util.*;

public class ActionParser {
    private List<String> validActionsRegex;
    private List<String> validObjectsRegex;
    private Game game;

    public ActionParser(Game game) {
        this.game = game;
    }

    public void setValidActionsRegex(List<String> validActionsRegex) {
        this.validActionsRegex = validActionsRegex;
    }

    public void setValidObjectsRegex(List<String> validObjectsRegex) {
        this.validObjectsRegex = validObjectsRegex;
    }

    public Action interpret(String command) {
        Action action = interpretAction(command);

        if (action != null) {
            int length = action.getName().length();
            String objectName = command.substring(length).trim();
            if (!isValidObject(objectName)) {
                action = null;
            }
        }

        return action;
    }

    private Action interpretAction(String command) {
        Action action = null;
        for (String actionName : this.validActionsRegex) {
            if (command.contains(actionName)) {
                action = searchAction(actionName);
            }
        }
        return action;
    }

    private boolean isValidObject(String name) {
        boolean valid = false;
        for (String objectName : this.validObjectsRegex) {
            if (name.matches("^" + objectName + ".*")) {
                valid = true;
            }
        }
        return valid;
    }

    private Action searchAction(String actionName) {
        List<Action> actions = game.getActions();
        Action actionToReturn = null;
        for (Action action : actions) {
            if (action.getName().equals(actionName)) {
                actionToReturn = action;
            }
        }
        return actionToReturn;
    }


}
