package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.MessageSimpleAction;
import ar.fiuba.tdd.tp.action.simple.MoveChildSimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.ExplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.ImplicitCurrentParentParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.ImplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.builder.GameBuilder;
import ar.fiuba.tdd.tp.condition.ChildrenSizeEqualsCondition;
import ar.fiuba.tdd.tp.condition.HasChildCondition;
import ar.fiuba.tdd.tp.condition.core.Condition;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

@SuppressWarnings("CPD-START")
public class LoboOvejaColGameBuilder implements GameBuilder {

    @Override
    public Game build() {
        GameObject scene = buildScene();
        Game game = new Game(scene, "Lobo, Oveja y Col");
        ComplexAction complexAction = buildTakeComplexAction(game);
        game.addAction(complexAction);
        complexAction = buildLeaveComplexAction(game);
        game.addAction(complexAction);
        complexAction = buildCrossNorthShoreComplexAction(game);
        game.addAction(complexAction);
        complexAction = buildCrossSouthShoreComplexAction(game);
        game.addAction(complexAction);

        return game;
    }

    private GameObject buildScene() {
        GameObject player = new GameObject("player");
        GameObject southShore = new GameObject("south-shore");
        southShore.addChild(player);
        GameObject sheep = new GameObject("sheep");
        southShore.addChild(sheep);
        GameObject wolf = new GameObject("wolf");
        southShore.addChild(wolf);
        GameObject col = new GameObject("col");
        southShore.addChild(col);
        GameObject scene = new GameObject("scene");
        GameObject northShore = new GameObject("north-shore");
        scene.addChild(northShore);
        scene.addChild(southShore);

        return scene;
    }

    private ComplexAction buildTakeComplexAction(Game game) {
        String name = "take";
        String command = "take <parametro>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildFullShipSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildTakeSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildTakeSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ExplicitParameter(1);
        Parameter targetParameter = new ImplicitParameter("player");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, targetParameter, 0);
        String result = "Ok";
        return new MoveChildSimpleAction(complexAction, condition, childParameter, targetParameter, result);
    }

    private SimpleAction buildFullShipSimpleAction(Game game, ComplexAction complexAction) {
        Parameter targetParameter = new ImplicitParameter("player");
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, targetParameter, 1);
        String result = "You can’t do that! The boat is full.";
        return new MessageSimpleAction(complexAction, condition, result);
    }

    private ComplexAction buildLeaveComplexAction(Game game) {
        String name = "leave";
        String command = "leave <parametro>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildYouWonSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildLeaveSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildLeaveSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ExplicitParameter(1);
        // Para dejar un elemento, el destino es la costa donde esta parado actualmente el player
        Parameter targetParameter = new ImplicitCurrentParentParameter(game.getScene().find("player"));
        Parameter playerParameter = new ImplicitParameter("player");

        Condition<String> condition = new ChildrenSizeEqualsCondition(game, playerParameter, 1);
        String result = "Ok";
        return new MoveChildSimpleAction(complexAction, condition, childParameter, targetParameter, result);
    }

    private SimpleAction buildYouWonSimpleAction(Game game, ComplexAction complexAction) {
        Parameter targetParameter = new ImplicitParameter("north-shore");
        // Gana si la costa norte tiene 4 elementos, player, wolf, sheep y col
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, targetParameter, 4);
        String result = "You won the game!";
        return new MessageSimpleAction(complexAction, condition, result);
    }

    private ComplexAction buildCrossNorthShoreComplexAction(Game game) {
        String name = "cross north-shore";
        String command = "cross north-shore";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildCantCrossWolfSheepSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildCantCrossSheepColSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildCrossNorthShoreSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildCrossNorthShoreSimpleAction(Game game, ComplexAction complexAction) {
        Parameter playerParameter = new ImplicitParameter("player");
        Parameter sheepParameter = new ImplicitParameter("sheep");
        Parameter wolfParameter = new ImplicitParameter("wolf");
        Parameter colParameter = new ImplicitParameter("col");
        Parameter southShore = new ImplicitParameter("south-shore");
        Parameter targetParameter = new ImplicitParameter("north-shore");

        // Cruza al norte si la costa sur no tiene oveja y lobo o no tiene oveja y col
        // crossCondition !(oveja && lobo) && !(oveja && col)
        Condition<String> notSheepAndWolf = new HasChildCondition(game, southShore, wolfParameter).and(new
                HasChildCondition(game, southShore, sheepParameter)).not(null);
        Condition<String> notSheepAndCol = new HasChildCondition(game, southShore, colParameter).and(new
                HasChildCondition(game, southShore, sheepParameter)).not(null);

        String result = "you have crossed!";
        return new MoveChildSimpleAction(complexAction, notSheepAndWolf.and(notSheepAndCol),
                playerParameter, targetParameter, result);
    }

    private ComplexAction buildCrossSouthShoreComplexAction(Game game) {
        String name = "cross south-shore";
        String command = "cross south-shore";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildCantCrossWolfSheepSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildCantCrossSheepColSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildCrossSouthShoreSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildCrossSouthShoreSimpleAction(Game game, ComplexAction complexAction) {
        Parameter playerParameter = new ImplicitParameter("player");
        Parameter sheepParameter = new ImplicitParameter("sheep");
        Parameter wolfParameter = new ImplicitParameter("wolf");
        Parameter colParameter = new ImplicitParameter("col");
        Parameter northShore = new ImplicitParameter("north-shore");
        Parameter targetParameter = new ImplicitParameter("south-shore");

        // Cruza al sur si la costa norte no tiene oveja y lobo o no tiene oveja y col
        // crossCondition !(oveja && lobo) && !(oveja && col)
        Condition<String> notSheepAndWolf = new HasChildCondition(game, northShore, wolfParameter).and(new
                HasChildCondition(game, northShore, sheepParameter)).not(null);
        Condition<String> notSheepAndCol = new HasChildCondition(game, northShore, colParameter).and(new
                HasChildCondition(game, northShore, sheepParameter)).not(null);

        String result = "you have crossed!";
        return new MoveChildSimpleAction(complexAction, notSheepAndWolf.and(notSheepAndCol),
                playerParameter, targetParameter, result);
    }

    private SimpleAction buildCantCrossWolfSheepSimpleAction(Game game, ComplexAction complexAction) {
        Parameter northShore = new ImplicitParameter("north-shore");
        Parameter sheepParameter = new ImplicitParameter("sheep");
        Parameter wolfParameter = new ImplicitParameter("wolf");

        // No puede cruzar si quedan solos la oveja y el lobo
        Condition<String> sheepAndWolf = new HasChildCondition(game, northShore, wolfParameter).and(new
                HasChildCondition(game, northShore, sheepParameter));

        String result = "You can’t do that! The wolf will eat the sheep!";
        return new MessageSimpleAction(complexAction, sheepAndWolf, result);
    }

    private SimpleAction buildCantCrossSheepColSimpleAction(Game game, ComplexAction complexAction) {
        Parameter northShore = new ImplicitParameter("north-shore");
        Parameter sheepParameter = new ImplicitParameter("sheep");
        Parameter colParameter = new ImplicitParameter("col");

        // No puede cruzar si quedan solos la oveja y la col
        Condition<String> sheepAndCol = new HasChildCondition(game, northShore, colParameter).and(new
                HasChildCondition(game, northShore, sheepParameter));

        String result = "You can’t do that! The sheep will eat the col!";
        return new MessageSimpleAction(complexAction, sheepAndCol, result);
    }
}
