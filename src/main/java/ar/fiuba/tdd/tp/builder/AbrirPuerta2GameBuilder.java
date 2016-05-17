package ar.fiuba.tdd.tp.builder;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.GetAttributeSimpleAction;
import ar.fiuba.tdd.tp.action.simple.LookAroundSimpleAction;
import ar.fiuba.tdd.tp.action.simple.MessageSimpleAction;
import ar.fiuba.tdd.tp.action.simple.MoveChildSimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.ExplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.ImplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.*;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

@SuppressWarnings("CPD-START")
public class  AbrirPuerta2GameBuilder implements GameBuilder {

    @Override
    public Game build() {

        GameObject scene = buildScene();
        Game game = new Game(scene);
        ComplexAction complexAction = buildLookAroundComplexAction(game);
        game.addAction(complexAction);
        complexAction = buildOpenDoorComplexAction(game);
        game.addAction(complexAction);
        complexAction = buildHelpComplexAction(game);
        game.addAction(complexAction);
        complexAction = buildOpenBoxComplexAction(game);
        game.addAction(complexAction);
        complexAction = buildCloseBoxComplexAction(game);
        game.addAction(complexAction);
        complexAction = buildPickKeyComplexAction(game);
        game.addAction(complexAction);

        return game;
    }

    private GameObject buildScene() {
        GameObject room1 = new GameObject("room1");
        GameObject player = new GameObject("player");
        GameObject box = new GameObject("box");
        box.getAttributesMap().put("help", "You can open/close the box.");
        GameObject key = new GameObject("key");
        box.addChild(key);
        GameObject door = new GameObject("door");
        room1.addChild(player);
        room1.addChild(box);
        room1.addChild(door);
        GameObject scene = new GameObject("scene");
        scene.addChild(room1);
        GameObject room2 = new GameObject("room2");
        scene.addChild(room2);

        return scene;
    }

    private ComplexAction buildLookAroundComplexAction(Game game) {
        String name = "look around";
        String command = "look around";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildLookAroundSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildLookAroundNothingSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
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

    private ComplexAction buildHelpComplexAction(Game game) {

        String name = "What can I do with";
        String command = "What can I do with box ?";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildHelpSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);
        simpleAction = buildNoHelpSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);

        return complexAction;
    }

    private ComplexAction buildOpenBoxComplexAction(Game game) {

        String name = "open box";
        String command = "open box";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildOpenClosedBoxSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildOpenOpenedBoxSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private ComplexAction buildCloseBoxComplexAction(Game game) {

        String name = "close box";
        String command = "close box";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildCloseOpenedBoxSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildCloseClosedBoxSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private ComplexAction buildPickKeyComplexAction(Game game) {

        String name = "pick key";
        String command = "pick key";
        ComplexAction pickKeyComplexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildPickKeySimpleAction(game, pickKeyComplexAction);
        pickKeyComplexAction.addAction(simpleAction);
        simpleAction = buildKeyAlreadyPickedSimpleAction(game, pickKeyComplexAction);
        pickKeyComplexAction.addAction(simpleAction);
        simpleAction = buildTheresNoKeyToPickSimpleAction(game, pickKeyComplexAction);
        pickKeyComplexAction.addAction(simpleAction);

        return pickKeyComplexAction;
    }

    @SuppressWarnings("PMD")
    private SimpleAction buildLookAroundSimpleAction(Game game, ComplexAction complexAction) {
        Parameter whichParameter = new ImplicitParameter("player");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, whichParameter, 1).not(null);
        String result = "There’s <siblings> in the room.";
        return new LookAroundSimpleAction(complexAction, condition, whichParameter, result);
    }

    private SimpleAction buildLookAroundNothingSimpleAction(Game game, ComplexAction complexAction) {
        Parameter whichParameter = new ImplicitParameter("player");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, whichParameter, 1);
        String result = "There’s nothing in the room.";
        return new LookAroundSimpleAction(complexAction, condition, whichParameter, result);
    }

    private SimpleAction buildOpenLockedDoorSimpleAction(Game game, ComplexAction complexAction) {
        Parameter whereParameter = new ImplicitParameter("player");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, whereParameter, 1).not(null);
        String result = "Ey! Where do you go?! room2 is locked.";
        return new MessageSimpleAction(complexAction, condition, result);
    }

    private SimpleAction buildOpenUnlockedDoorSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("player");
        Parameter targetParameter = new ImplicitParameter("room2");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, childParameter, 1);
        String result = "You enter room2. You won the game!";
        return new MoveChildSimpleAction(complexAction, condition, childParameter,
                targetParameter, result);
    }

    private SimpleAction buildHelpSimpleAction(Game game, ComplexAction complexAction) {
        Parameter whichParameter = new ExplicitParameter(5);
        String attributeName = "help";
        Condition<String> condition = new HasAttributeCondition(game, whichParameter, attributeName);
        String result = "<attribute>";
        return new GetAttributeSimpleAction(complexAction, condition, whichParameter,
                attributeName, result);
    }

    private SimpleAction buildNoHelpSimpleAction(Game game, ComplexAction complexAction) {
        Parameter whichParameter = new ExplicitParameter(5);
        String attributeName = "help";
        Condition<String> condition = new HasAttributeCondition(game, whichParameter, attributeName).not(null);
        String result = "No help available";
        return new MessageSimpleAction(complexAction, condition, result);
    }

    private SimpleAction buildOpenClosedBoxSimpleAction(Game game, ComplexAction complexAction) {
        Parameter boxParameter = new ImplicitParameter("box");
        Parameter keyParameter = new ImplicitParameter("key");
        Parameter room1Parameter = new ImplicitParameter("room1");
        Condition<String> condition = new HasChildCondition(game, boxParameter, keyParameter);
        String result = "The box is opened!.";
        return new MoveChildSimpleAction(complexAction, condition, keyParameter, room1Parameter,
                result);
    }

    private SimpleAction buildOpenOpenedBoxSimpleAction(Game game, ComplexAction complexAction) {

        Parameter boxParameter = new ImplicitParameter("box");
        Parameter keyParameter = new ImplicitParameter("key");
        //Parameter room1Parameter = new ImplicitParameter("room1");
        Condition<String> condition = new HasChildCondition(game, boxParameter, keyParameter).not(null);
        String result = "Box already opened!";
        return new MessageSimpleAction(complexAction, condition, result);
    }

    private SimpleAction buildCloseOpenedBoxSimpleAction(Game game, ComplexAction complexAction) {
        Parameter room1Parameter = new ImplicitParameter("room1");
        Parameter keyParameter = new ImplicitParameter("key");
        Parameter boxParameter = new ImplicitParameter("box");
        Condition<String> condition = new HasChildCondition(game, room1Parameter, keyParameter);
        String result = "The box is closed!.";
        return new MoveChildSimpleAction(complexAction, condition, keyParameter, boxParameter,
                result);
    }

    private SimpleAction buildCloseClosedBoxSimpleAction(Game game, ComplexAction complexAction) {

        Parameter room1Parameter = new ImplicitParameter("room1");
        Parameter keyParameter = new ImplicitParameter("key");
        //Parameter boxParameter = new ImplicitParameter("box");
        Condition<String> condition = new HasChildCondition(game, room1Parameter, keyParameter).not(null);
        String result = "Box already closed!";

        return new MessageSimpleAction(complexAction, condition, result);
    }

    private SimpleAction buildPickKeySimpleAction(Game game, ComplexAction complexAction) {
        Parameter room1Parameter = new ImplicitParameter("room1");
        Parameter keyParameter = new ImplicitParameter("key");
        Parameter playerParameter = new ImplicitParameter("player");
        Condition<String> condition = new HasChildCondition(game, room1Parameter, keyParameter);
        String result = "There you go!";
        return new MoveChildSimpleAction(complexAction, condition, keyParameter,
                playerParameter, result);
    }

    private SimpleAction buildKeyAlreadyPickedSimpleAction(Game game, ComplexAction complexAction) {
        Parameter keyParameter = new ImplicitParameter("key");
        Parameter playerParameter = new ImplicitParameter("player");
        Condition<String> condition = new HasChildCondition(game, playerParameter, keyParameter);
        String result = "Key already picked!";
        return new MessageSimpleAction(complexAction, condition, result);
    }

    private SimpleAction buildTheresNoKeyToPickSimpleAction(Game game, ComplexAction complexAction) {
        Parameter boxParameter = new ImplicitParameter("box");
        Parameter keyParameter = new ImplicitParameter("key");
        Condition<String> condition = new HasChildCondition(game, boxParameter, keyParameter);
        String result = "There's no key to pick.";
        return new MessageSimpleAction(complexAction, condition, result);
    }
}
