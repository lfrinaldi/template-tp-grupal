package ar.fiuba.tdd.tp.builder;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.LookAroundSimpleAction;
import ar.fiuba.tdd.tp.action.simple.MessageSimpleAction;
import ar.fiuba.tdd.tp.action.simple.MoveChildSimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.ImplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.ChildrenSizeEqualsCondition;
import ar.fiuba.tdd.tp.condition.Condition;
import ar.fiuba.tdd.tp.condition.SiblingsSizeEqualsCondition;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

public class AbrirPuertaGameBuilder implements GameBuilder {

    @Override
    public Game build() {

        GameObject scene = buildScene();
        Game game = new Game(scene);
        ComplexAction complexAction = buildLookAroundComplexAction(game);
        game.getActions().add(complexAction);
        complexAction = buildOpenDoorComplexAction(game);
        game.getActions().add(complexAction);
        complexAction = buildPickKeyComplexAction(game);
        game.getActions().add(complexAction);

        return game;
    }

    private GameObject buildScene() {

        GameObject scene = new GameObject("scene");
        GameObject room1 = new GameObject("room1");
        GameObject room2 = new GameObject("room2");
        GameObject player = new GameObject("player");
        GameObject key = new GameObject("key");
        GameObject door = new GameObject("door");
        room1.addChild(player);
        room1.addChild(key);
        room1.addChild(door);
        scene.addChild(room1);
        scene.addChild(room2);

        return scene;
    }

    private ComplexAction buildLookAroundComplexAction(Game game) {

        String name = "look around";
        String command = "look around";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildLookAroundSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);
        simpleAction = buildLookAroundNothingSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);

        return complexAction;
    }

    private ComplexAction buildOpenDoorComplexAction(Game game) {

        String name = "open door";
        String command = "open door";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildOpenLockedDoorSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);
        simpleAction = buildOpenUnlockedDoorSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);

        return complexAction;
    }

    private ComplexAction buildPickKeyComplexAction(Game game) {

        String name = "pick key";
        String command = "pick key";
        ComplexAction pickKeyComplexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildPickKeySimpleAction(game, pickKeyComplexAction);
        pickKeyComplexAction.getSteps().add(simpleAction);
        simpleAction = buildKeyAlreadyPickedSimpleAction(game, pickKeyComplexAction);
        pickKeyComplexAction.getSteps().add(simpleAction);

        return pickKeyComplexAction;
    }

    private SimpleAction buildLookAroundSimpleAction(Game game, ComplexAction complexAction) {

        Parameter whichParameter = new ImplicitParameter("player");
        Condition<String> condition = new SiblingsSizeEqualsCondition(game, whichParameter, 0).not(null);
        String result = "There’s <siblings> in the room.";
        SimpleAction simpleAction = new LookAroundSimpleAction(complexAction, condition, whichParameter, result);

        return simpleAction;
    }

    private SimpleAction buildLookAroundNothingSimpleAction(Game game, ComplexAction complexAction) {

        Parameter whichParameter = new ImplicitParameter("player");
        Condition<String> condition = new SiblingsSizeEqualsCondition(game, whichParameter, 0);
        String result = "There’s nothing in the room.";
        SimpleAction simpleAction = new LookAroundSimpleAction(complexAction, condition, whichParameter, result);

        return simpleAction;
    }

    private SimpleAction buildOpenLockedDoorSimpleAction(Game game, ComplexAction complexAction) {

        Parameter whereParameter = new ImplicitParameter("player");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, whereParameter, 1).not(null);
        String result = "Ey! Where do you go?! room2 is locked.";
        SimpleAction simpleAction = new MessageSimpleAction(complexAction, condition, result);

        return simpleAction;
    }

    private SimpleAction buildOpenUnlockedDoorSimpleAction(Game game, ComplexAction complexAction) {

        Parameter childParameter = new ImplicitParameter("player");
        Parameter targetParameter = new ImplicitParameter("room2");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, childParameter, 1);
        String result = "You enter room2. You won the game!";
        SimpleAction simpleAction = new MoveChildSimpleAction(complexAction, condition, childParameter, targetParameter, result);

        return simpleAction;
    }

    private SimpleAction buildPickKeySimpleAction(Game game, ComplexAction complexAction) {

        Parameter childParameter = new ImplicitParameter("key");
        Parameter targetParameter = new ImplicitParameter("player");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, targetParameter, 1).not(null);
        String result = "There you go!";
        SimpleAction simpleAction = new MoveChildSimpleAction(complexAction, condition, childParameter, targetParameter, result);

        return simpleAction;
    }

    private SimpleAction buildKeyAlreadyPickedSimpleAction(Game game, ComplexAction complexAction) {

        Parameter whereParameter = new ImplicitParameter("player");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, whereParameter, 1);
        String result = "Key already picked!";
        SimpleAction simpleAction = new MessageSimpleAction(complexAction, condition, result);

        return simpleAction;
    }
}
