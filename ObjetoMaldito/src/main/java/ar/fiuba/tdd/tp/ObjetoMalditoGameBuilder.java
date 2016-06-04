package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.GetAttributeSimpleAction;
import ar.fiuba.tdd.tp.action.simple.LookAroundSimpleAction;
import ar.fiuba.tdd.tp.action.simple.MessageSimpleAction;
import ar.fiuba.tdd.tp.action.simple.MoveChildSimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.ExplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.ImplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.ChildrenSizeEqualsCondition;
import ar.fiuba.tdd.tp.condition.HasAttributeCondition;
import ar.fiuba.tdd.tp.condition.TrueCondition;
import ar.fiuba.tdd.tp.condition.core.Condition;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameBuilder;
import ar.fiuba.tdd.tp.model.GameObject;

@SuppressWarnings("CPD-START")
public class ObjetoMalditoGameBuilder implements GameBuilder {

    @Override
    public Game build() {
        GameObject scene = buildScene();
        Game game = new Game(scene);
        game.addAction(buildPickComplexAction(game));
        game.addAction(buildOpenDoor1ComplexAction(game));
        game.addAction(buildOpenDoor2ComplexAction(game));
        game.addAction(buildHelpComplexAction(game));
        game.addAction(buildTalkToThiefComplexAction(game));
        game.addAction(buildLookAroundComplexAction(game));

        return game;
    }

    private GameObject buildScene() {
        GameObject room1 = new GameObject("room1");
        GameObject room2 = new GameObject("room2");
        GameObject room3 = new GameObject("room3");
        GameObject door1 = new GameObject("door1");
        door1.addChild(room2);
        GameObject door2 = new GameObject("door2");
        door2.addChild(room3);
        room1.addChild(new GameObject("player"));
        room1.addChild(new GameObject("object"));
        room1.addChild(door1);
        GameObject thief = new GameObject("thief");
        thief.getAttributes().put("help", "You can talk with thief: \"Hello\", \"Bye\".");
        room2.addChild(thief);
        room2.addChild(door2);
        GameObject scene = new GameObject("scene");
        scene.addChild(room1);
        scene.addChild(room2);
        scene.addChild(room3);

        return scene;
    }

    private ComplexAction buildPickComplexAction(Game game) {
        String name = "pick";
        String command = "pick <parameter>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildPickSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildPickSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ExplicitParameter(1);
        Parameter targetParameter = new ImplicitParameter("player");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, targetParameter, 0);
        String result = "Ok";
        SimpleAction simpleAction = new MoveChildSimpleAction(complexAction, condition, childParameter, targetParameter, result);

        return simpleAction;
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

    private ComplexAction buildOpenDoor1ComplexAction(Game game) {
        String name = "open door1";
        String command = "open door1";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildOpenLockedDoor1SimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildOpenUnlockedDoor1SimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildOpenLockedDoor1SimpleAction(Game game, ComplexAction complexAction) {
        Parameter whereParameter = new ImplicitParameter("player");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, whereParameter, 0);
        String result = "Ey! Where do you go?! room2 is locked.";
        SimpleAction simpleAction = new MessageSimpleAction(complexAction, condition, result);

        return simpleAction;
    }

    private SimpleAction buildOpenUnlockedDoor1SimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("player");
        Parameter targetParameter = new ImplicitParameter("room2");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, childParameter, 1);
        String result = "You enter room2.";
        SimpleAction simpleAction = new MoveChildSimpleAction(complexAction, condition, childParameter,
                targetParameter, result);

        return simpleAction;
    }

    private ComplexAction buildOpenDoor2ComplexAction(Game game) {
        String name = "open door2";
        String command = "open door2";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildOpenLockedDoor2SimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildOpenUnlockedDoor2SimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildOpenLockedDoor2SimpleAction(Game game, ComplexAction complexAction) {
        Parameter whereParameter = new ImplicitParameter("player");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, whereParameter, 1);
        String result = "Ey! Where do you go?! room3 is locked.";
        SimpleAction simpleAction = new MessageSimpleAction(complexAction, condition, result);

        return simpleAction;
    }

    private SimpleAction buildOpenUnlockedDoor2SimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("player");
        Parameter targetParameter = new ImplicitParameter("room3");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, childParameter, 0);
        String result = "You enter room3. You won the game!";
        SimpleAction simpleAction = new MoveChildSimpleAction(complexAction, condition, childParameter,
                targetParameter, result);

        return simpleAction;
    }

    private ComplexAction buildTalkToThiefComplexAction(Game game) {
        String name = "Talk to thief";
        String command = "Talk to thief <parameter>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildTalkToThiefSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildTalkToThiefSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("object");
        Parameter targetParameter = new ImplicitParameter("thief");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, targetParameter, 0);
        String result = "Hi!\nThe thief has just stolen your object!";
        SimpleAction simpleAction = new MoveChildSimpleAction(complexAction, condition, childParameter,
                targetParameter, result);

        return simpleAction;
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
}
