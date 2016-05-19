package ar.fiuba.tdd.tp.builder;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.GetAttributeSimpleAction;
import ar.fiuba.tdd.tp.action.simple.MessageSimpleAction;
import ar.fiuba.tdd.tp.action.simple.MoveChildSimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.ExplicitCurrentLastChildParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.ExplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.ChildrenSizeEqualsCondition;
import ar.fiuba.tdd.tp.condition.Condition;
import ar.fiuba.tdd.tp.condition.HasAttributeCondition;
import ar.fiuba.tdd.tp.condition.IsBiggerThanAttributeCondition;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

public class TorresHanoiGameBuilder implements GameBuilder {

    @Override
    public Game build() {

        GameObject scene = buildScene();
        Game game = new Game(scene);
        ComplexAction complexAction = buildMoveTopComplexAction(game);
        game.getActions().add(complexAction);
        complexAction = buildHelpComplexAction(game);
        game.getActions().add(complexAction);
        complexAction = buildCheckTopComplexAction(game);
        game.getActions().add(complexAction);
        return game;

    }

    private ComplexAction buildCheckTopComplexAction(Game game) {

        String name = "check top";
        String command = "check top";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildCheckTopSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);
        simpleAction = buildCheckEmptySimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);

        return complexAction;

    }

    private SimpleAction buildCheckTopSimpleAction(Game game, ComplexAction complexAction) {

        Parameter targetParameter = new ExplicitParameter(2);
        Parameter childParameter = new ExplicitCurrentLastChildParameter(2, game);
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, targetParameter, 0).not(null);

        String result = "Size of top from <parent> is <attribute>";
        String attributeName = "size";

        SimpleAction simpleAction = new GetAttributeSimpleAction(complexAction, condition, childParameter,
                attributeName, result);

        return simpleAction;
    }

    private SimpleAction buildCheckEmptySimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ExplicitCurrentLastChildParameter(2, game);
        Parameter whichParameter = new ExplicitParameter(2);
        String attributeName = "size";
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, whichParameter, 0);
        String result = "The stack is empty";
        return new MessageSimpleAction(complexAction, condition, result);


    }


    private GameObject buildScene() {

        GameObject scene = new GameObject("scene");
        GameObject stack1 = new GameObject("stack1");
        GameObject stack2 = new GameObject("stack2");
        GameObject stack3 = new GameObject("stack3");

        String helpText = "You can check top/move top.";

        stack1.getAttributesMap().put("help", helpText);
        stack2.getAttributesMap().put("help", helpText);
        stack3.getAttributesMap().put("help", helpText);

        GameObject disc1 = new GameObject("disc1");
        GameObject disc2 = new GameObject("disc2");

        disc1.getAttributesMap().put("size", "1");
        disc2.getAttributesMap().put("size", "2");

        stack1.addChild(disc2);
        stack1.addChild(disc1);

        scene.addChild(stack1);
        scene.addChild(stack2);
        scene.addChild(stack3);

        return scene;

    }

    private ComplexAction buildHelpComplexAction(Game game) {

        String name = "What can I do with";
        String command = "What can I do with stack ?";
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

    private ComplexAction buildMoveTopComplexAction(Game game) {

        String name = "move top";
        String command = "move top";
        ComplexAction complexAction = new ComplexAction(name, command, game);

        SimpleAction winSimpleAction = buildWinSimpleAction(game, complexAction);
        complexAction.getSteps().add(winSimpleAction);
        SimpleAction simpleAction = buildMoveTopSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);
        simpleAction = buildMoveTopEmptySimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);
        return complexAction;

    }

    private SimpleAction buildWinSimpleAction(Game game, ComplexAction complexAction) {

        Parameter fromParameter = new ExplicitParameter(2);
        Parameter childParameter = new ExplicitCurrentLastChildParameter(2, game);
        Parameter targetParameter = new ExplicitParameter(3);
        Parameter childTargetParameter = new ExplicitCurrentLastChildParameter(3, game);
        Condition<String> targetCondition = new ChildrenSizeEqualsCondition(game, targetParameter, 0).or(
                new IsBiggerThanAttributeCondition(game, childParameter, childTargetParameter, "size"));
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, fromParameter, 0).not(null).and(targetCondition).not(null);
        String result = "you win!";
        SimpleAction simpleAction = new MoveChildSimpleAction(complexAction, condition, childParameter,
                targetParameter, result);

        return simpleAction;
    }

    private SimpleAction buildMoveTopSimpleAction(Game game, ComplexAction complexAction) {

        Parameter fromParameter = new ExplicitParameter(2);
        Parameter childParameter = new ExplicitCurrentLastChildParameter(2, game);
        Parameter targetParameter = new ExplicitParameter(3);
        Parameter childTargetParameter = new ExplicitCurrentLastChildParameter(3, game);
        Condition<String> targetCondition = new ChildrenSizeEqualsCondition(game, targetParameter, 0).or(
                new IsBiggerThanAttributeCondition(game, childParameter, childTargetParameter, "size"));
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, fromParameter, 0).not(null).and(targetCondition);
        String result = "moved!";
        SimpleAction simpleAction = new MoveChildSimpleAction(complexAction, condition, childParameter,
                targetParameter, result);

        return simpleAction;
    }

    private SimpleAction buildMoveTopEmptySimpleAction(Game game, ComplexAction complexAction) {
        Parameter fromParameter = new ExplicitParameter(2);
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, fromParameter, 0);
        String result = "The stack is empty!";
        return new MessageSimpleAction(complexAction, condition, result);
    }

}
