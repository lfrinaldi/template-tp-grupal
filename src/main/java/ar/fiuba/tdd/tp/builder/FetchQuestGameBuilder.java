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

public class FetchQuestGameBuilder implements GameBuilder {

    @Override
    public Game build() {

        GameObject scene = buildScene();
        Game game = new Game(scene);
        ComplexAction complexAction = buildLookAroundComplexAction(game);
        game.getActions().add(complexAction);
        complexAction = buildPickStickComplexAction(game);
        game.getActions().add(complexAction);

        return game;
    }

    private GameObject buildScene() {

        GameObject scene = new GameObject("scene");
        GameObject room = new GameObject("room");
        GameObject player = new GameObject("player");
        GameObject stick = new GameObject("stick");
        room.addChild(player);
        room.addChild(stick);
        scene.addChild(room);

        return scene;
    }

    private ComplexAction buildLookAroundComplexAction(Game game) {

        String name = "look around";
        String command = "look around";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildLookAroundSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);
        simpleAction = buildYouWonSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);

        return complexAction;
    }

    private ComplexAction buildPickStickComplexAction(Game game) {

        String name = "pick stick";
        String command = "pick stick";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildPickStickSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);
        simpleAction = buildYouWonSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);

        return complexAction;
    }

    private SimpleAction buildLookAroundSimpleAction(Game game, ComplexAction complexAction) {

        Parameter whichParameter = new ImplicitParameter("player");
        Condition<String> condition = new SiblingsSizeEqualsCondition(game, whichParameter, 0).not(null);
        String result = "There’s <siblings> in the room.";
        SimpleAction simpleAction = new LookAroundSimpleAction(complexAction, condition, whichParameter, result);

        return simpleAction;
    }

    private SimpleAction buildPickStickSimpleAction(Game game, ComplexAction complexAction) {

        Parameter childParameter = new ImplicitParameter("stick");
        Parameter targetParameter = new ImplicitParameter("player");
        Condition<String> condition = new SiblingsSizeEqualsCondition(game, targetParameter, 0).not(null);
        String result = "You won the game!";
        SimpleAction simpleAction = new MoveChildSimpleAction(complexAction, condition, childParameter, targetParameter, result);

        return simpleAction;
    }

    private SimpleAction buildYouWonSimpleAction(Game game, ComplexAction complexAction) {

        Parameter whereParameter = new ImplicitParameter("player");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, whereParameter, 1);
        String result = "There’s nothing in the room. You won the game!";
        SimpleAction simpleAction = new MessageSimpleAction(complexAction, condition, result);

        return simpleAction;
    }
}
