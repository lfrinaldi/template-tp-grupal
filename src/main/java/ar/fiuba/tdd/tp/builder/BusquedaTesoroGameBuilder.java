package ar.fiuba.tdd.tp.builder;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.*;
import ar.fiuba.tdd.tp.action.simple.parameter.ExplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.ImplicitCurrentParentParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.ImplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.*;
import ar.fiuba.tdd.tp.condition.core.Condition;
import ar.fiuba.tdd.tp.model.*;

@SuppressWarnings("CPD-START")
public class BusquedaTesoroGameBuilder implements GameBuilder {

    @Override
    public Game build() {
        GameObject scene = buildScene();
        Game game = new Game(scene);
        addActions(game);

        return game;
    }

    private void addActions(Game game) {
        game.addAction(buildLookAroundComplexAction(game));
        game.addAction(buildOpenDoor1ComplexAction(game));
        game.addAction(buildOpenDoor2ComplexAction(game));
        game.addAction(buildPickSilverKeyComplexAction(game));
        game.addAction(buildOpenClosetComplexAction(game));
        game.addAction(buildOpenTrunkComplexAction(game));
        game.addAction(buildOpenBoxComplexAction(game));
        game.addAction(buildPickGoldenKeyComplexAction(game));
        game.addAction(buildOpenRedBoxComplexAction(game));
        game.addAction(buildOpenGreenBoxComplexAction(game));
        game.addAction(buildHelpComplexAction(game));
        game.addAction(buildDrinkComplexAction(game));
        game.addAction(buildPickTreasureComplexAction(game));
        game.addAction(buildLeaveComplexAction(game));
        game.addAction(buildOpenDoor3ComplexAction(game));
        game.addAction(buildOpenDoor4ComplexAction(game));
        game.addAction(buildOpenDoor5ComplexAction(game));
    }

    private GameObject buildScene() {
        GameObject scene = new GameObject("scene");
        scene.addChild(buildRoom1());
        scene.addChild(buildRoom2());
        scene.addChild(buildRoom3());
        scene.addChild(buildRoom4());
        scene.addChild(buildRoom5());

        return scene;
    }

    private GameObject buildRoom1() {
        GameObject room1 = new GameObject("room1");
        GameObject door1 = new GameObject("door1");
        room1.addChild(door1);
        GameObject player = new GameObject("player");
        room1.addChild(player);

        return room1;
    }

    private GameObject buildRoom2() {
        GameObject room2 = new GameObject("room2");
        GameObject door2 = new GameObject("door2");
        room2.addChild(door2);
        GameObject silverKey = new GameObject("silver-key");
        room2.addChild(silverKey);

        return room2;
    }

    private GameObject buildRoom3() {
        GameObject room3 = new GameObject("room3");
        GameObject door3 = new GameObject("door3");
        room3.addChild(door3);
        GameObject goldenKey = new GameObject("golden-key");
        GameObject box = new GameObject("box");
        box.addChild(goldenKey);
        GameObject trunk = new GameObject("trunk");
        trunk.addChild(box);
        GameObject closet = new GameObject("closet");
        closet.addChild(trunk);
        room3.addChild(closet);

        return room3;
    }

    private GameObject buildRoom4() {
        GameObject room4 = new GameObject("room4");
        GameObject door4 = new GameObject("door4");
        room4.addChild(door4);
        GameObject poison = new GameObject("poison");
        GameObject redBox = new GameObject("red-box");
        redBox.addChild(poison);
        room4.addChild(redBox);
        GameObject antiPoison = new GameObject("anti-poison");
        antiPoison.getAttributesMap().put("help", "You can drink the potion.");
        GameObject greenBox = new GameObject("green-box");
        greenBox.addChild(antiPoison);
        room4.addChild(greenBox);

        return room4;
    }

    private GameObject buildRoom5() {
        GameObject room5 = new GameObject("room5");
        GameObject door5 = new GameObject("door5");
        room5.addChild(door5);
        GameObject treasure = new GameObject("treasure");
        treasure.getAttributesMap().put("help", "You can pick the treasure.");
        room5.addChild(treasure);

        return room5;
    }

    private ComplexAction buildLookAroundComplexAction(Game game) {
        String name = "look around";
        String command = "look around";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildLookAroundSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildLookAroundSimpleAction(Game game, ComplexAction complexAction) {
        Parameter whichParameter = new ImplicitParameter("player");

        String result = "There's <siblings> in the room.";
        SimpleAction simpleAction = new LookAroundSimpleAction(complexAction, new TrueCondition(), whichParameter, result);

        return simpleAction;
    }

    private ComplexAction buildPickSilverKeyComplexAction(Game game) {
        String name = "pick silver-key";
        String command = "pick silver-key";
        ComplexAction pickKeyComplexAction = new ComplexAction(name, command, game);
        pickKeyComplexAction.addAction(buildCantPickSimpleAction(game, pickKeyComplexAction));
        pickKeyComplexAction.addAction(buildPickSimpleAction(game, pickKeyComplexAction));

        return pickKeyComplexAction;
    }

    private ComplexAction buildPickGoldenKeyComplexAction(Game game) {
        String name = "pick golden-key";
        String command = "pick golden-key";
        ComplexAction pickKeyComplexAction = new ComplexAction(name, command, game);
        pickKeyComplexAction.addAction(buildCantPickSimpleAction(game, pickKeyComplexAction));
        pickKeyComplexAction.addAction(buildPickSimpleAction(game, pickKeyComplexAction));

        return pickKeyComplexAction;
    }

    private ComplexAction buildPickTreasureComplexAction(Game game) {
        String name = "pick treasure";
        String command = "pick treasure";
        ComplexAction pickKeyComplexAction = new ComplexAction(name, command, game);
        pickKeyComplexAction.addAction(buildCantPickSimpleAction(game, pickKeyComplexAction));
        pickKeyComplexAction.addAction(buildPickTreasureSimpleAction(game, pickKeyComplexAction));

        return pickKeyComplexAction;
    }

    private SimpleAction buildPickSimpleAction(Game game, ComplexAction complexAction) {
        Parameter keyParameter = new ExplicitParameter(1);
        Parameter playerParameter = new ImplicitParameter("player");
        // Player may just have zero or one item to pick another
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, playerParameter, 0)
                .or(new ChildrenSizeEqualsCondition(game, playerParameter, 1));

        String result = "There you go!";
        return new MoveChildSimpleAction(complexAction, condition, keyParameter,
                playerParameter, result);
    }

    private SimpleAction buildCantPickSimpleAction(Game game, ComplexAction complexAction) {
        Parameter playerParameter = new ImplicitParameter("player");
        // Player can only have up to 2 items
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, playerParameter, 2);

        String result = "You just can carry up to two items. Leave something!";
        return new MessageSimpleAction(complexAction, condition, result);
    }

    private SimpleAction buildPickTreasureSimpleAction(Game game, ComplexAction complexAction) {
        Parameter keyParameter = new ExplicitParameter(1);
        Parameter playerParameter = new ImplicitParameter("player");
        // Player may just have zero or one item to pick another
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, playerParameter, 0)
                .or(new ChildrenSizeEqualsCondition(game, playerParameter, 1));

        String result = "You got the treasure! be sure to return to room1";
        return new MoveChildSimpleAction(complexAction, condition, keyParameter,
                playerParameter, result);
    }

    private ComplexAction buildLeaveComplexAction(Game game) {
        String name = "leave";
        String command = "leave <parameter>";
        ComplexAction leaveComplexAction = new ComplexAction(name, command, game);
        leaveComplexAction.addAction(buildLeaveSimpleAction(game, leaveComplexAction));

        return leaveComplexAction;
    }

    private SimpleAction buildLeaveSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ExplicitParameter(1);
        // Para dejar un elemento, el destino es la room donde esta parado actualmente el player
        Parameter targetParameter = new ImplicitCurrentParentParameter(game.getScene().find("player"));
        Parameter playerParameter = new ImplicitParameter("player");

        Condition<String> condition = new ChildrenSizeEqualsCondition(game, playerParameter, 1)
                .or(new ChildrenSizeEqualsCondition(game, playerParameter, 2));
        String result = "Ok";
        SimpleAction simpleAction = new MoveChildSimpleAction(complexAction, condition, childParameter,
                targetParameter, result);

        return simpleAction;
    }

    private ComplexAction buildHelpComplexAction(Game game) {
        String name = "What can I do with";
        String command = "What can I do with ?";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildHelpSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);
        simpleAction = buildNoHelpSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);

        return complexAction;
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

    private ComplexAction buildDrinkComplexAction(Game game) {
        String name = "drink anti-poison";
        String command = "drink anti-poison";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.addAction(buildDrinkSimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildDrinkSimpleAction(Game game, ComplexAction complexAction) {
        Parameter player = new ImplicitParameter("player");

        String result = "You are now healthy";
        return new ChangeAttributeSimpleAction(complexAction, new TrueCondition(), player, result, "poisoned",
                "false");
    }

    private ComplexAction buildOpenClosetComplexAction(Game game) {
        String name = "open closet";
        String command = "open closet";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.addAction(buildOpenClosetSimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildOpenClosetSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("trunk");
        Parameter targetParameter = new ImplicitParameter("room3");

        String result = "Ok";
        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter, targetParameter,
                result);
    }

    private ComplexAction buildOpenTrunkComplexAction(Game game) {
        String name = "open trunk";
        String command = "open trunk";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.addAction(buildOpenTrunkSimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildOpenTrunkSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("box");
        Parameter targetParameter = new ImplicitParameter("room3");

        String result = "Ok";
        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter, targetParameter,
                result);
    }

    private ComplexAction buildOpenBoxComplexAction(Game game) {
        String name = "open box";
        String command = "open box";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.addAction(buildOpenBoxSimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildOpenBoxSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("golden-key");
        Parameter targetParameter = new ImplicitParameter("room3");

        String result = "Ok";
        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter, targetParameter,
                result);
    }

    private ComplexAction buildOpenRedBoxComplexAction(Game game) {
        String name = "open red-box";
        String command = "open red-box";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.addAction(buildOpenRedBoxSimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildOpenRedBoxSimpleAction(Game game, ComplexAction complexAction) {
        Parameter player = new ImplicitParameter("player");

        String result = "You've been poisoned!";
        return new ChangeAttributeSimpleAction(complexAction, new TrueCondition(), player, result, "poisoned",
                "true");
    }

    private ComplexAction buildOpenGreenBoxComplexAction(Game game) {
        String name = "open green-box";
        String command = "open green-box";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.addAction(buildOpenGreenBoxSimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildOpenGreenBoxSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("anti-poison");
        Parameter targetParameter = new ImplicitParameter("room4");

        String result = "Ok";
        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter, targetParameter,
                result);
    }

    private ComplexAction buildOpenDoor1ComplexAction(Game game) {
        String name = "open door1";
        String command = "open door1";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.getSteps().add(buildOpenUnlockedDoor1SimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildOpenUnlockedDoor1SimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("player");
        Parameter targetParameter = new ImplicitParameter("room2");

        String result = "You enter room2.";
        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter,
                targetParameter, result);
    }

    private ComplexAction buildOpenDoor2ComplexAction(Game game) {
        String name = "open door2";
        String command = "open door2";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.getSteps().add(buildOpenLockedDoor2SimpleAction(game, complexAction));
        complexAction.getSteps().add(buildOpenUnlockedDoor2SimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildOpenLockedDoor2SimpleAction(Game game, ComplexAction complexAction) {
        Parameter player = new ImplicitParameter("player");
        Parameter silverKey = new ImplicitParameter("silver-key");
        Condition<String> condition = new HasChildCondition(game, player, silverKey).not(null);

        String result = "Ey! Where do you go?! room3 is locked.";
        return new MessageSimpleAction(complexAction, condition, result);
    }

    private SimpleAction buildOpenUnlockedDoor2SimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("player");
        Parameter targetParameter = new ImplicitParameter("room3");
        Parameter silverKey = new ImplicitParameter("silver-key");
        Condition<String> condition = new HasChildCondition(game, childParameter, silverKey);

        String result = "You enter room3.";
        return new MoveChildSimpleAction(complexAction, condition, childParameter,
                targetParameter, result);
    }

    private ComplexAction buildOpenDoor3ComplexAction(Game game) {
        String name = "open door3";
        String command = "open door3";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.getSteps().add(buildOpenUnlockedDoor3SimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildOpenUnlockedDoor3SimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("player");
        Parameter targetParameter = new ImplicitParameter("room4");
        // TODO: Always true condition
        Parameter trueParameter = new ImplicitParameter("treasure");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, trueParameter, 0);

        String result = "You enter room4.";
        return new MoveChildSimpleAction(complexAction, condition, childParameter,
                targetParameter, result);
    }

    private ComplexAction buildOpenDoor4ComplexAction(Game game) {
        String name = "open door4";
        String command = "open door4";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.getSteps().add(buildOpenLockedDoor4SimpleAction(game, complexAction));
        complexAction.getSteps().add(buildOpenUnlockedDoor4SimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildOpenLockedDoor4SimpleAction(Game game, ComplexAction complexAction) {
        Parameter player = new ImplicitParameter("player");
        Condition<String> condition = new AttributeEqualsCondition(game, player, "poisoned", "true");

        String result = "Ey! Where do you go?! You are poisoned!";
        return new MessageSimpleAction(complexAction, condition, result);
    }

    private SimpleAction buildOpenUnlockedDoor4SimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("player");
        Parameter targetParameter = new ImplicitParameter("room5");

        String result = "You enter room5.";
        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter,
                targetParameter, result);
    }

    private ComplexAction buildOpenDoor5ComplexAction(Game game) {
        String name = "open door5";
        String command = "open door5";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.getSteps().add(buildYouWonSimpleAction(game, complexAction));
        complexAction.getSteps().add(buildOpenUnlockedDoor5SimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildYouWonSimpleAction(Game game, ComplexAction complexAction) {
        Parameter player = new ImplicitParameter("player");
        Parameter treasure = new ImplicitParameter("treasure");
        // Gana si el player entra al room1 con el treasure
        Condition<String> condition = new HasChildCondition(game, player, treasure);
        String result = "You won the game!";

        return new MessageSimpleAction(complexAction, condition, result);
    }

    private SimpleAction buildOpenUnlockedDoor5SimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("player");
        Parameter targetParameter = new ImplicitParameter("room1");

        String result = "You enter room1.";
        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter,
                targetParameter, result);
    }

}
