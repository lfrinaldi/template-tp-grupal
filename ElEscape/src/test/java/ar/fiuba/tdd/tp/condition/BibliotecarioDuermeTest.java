package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.action.Action;
import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.ChangeAttributeSimpleAction;
import ar.fiuba.tdd.tp.action.simple.MessageSimpleAction;
import ar.fiuba.tdd.tp.action.simple.MoveChildSimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.ExplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.ImplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.core.Condition;
import ar.fiuba.tdd.tp.connection.ClientManager;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;
import ar.fiuba.tdd.tp.model.Scheduleable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("CPD-START")
public class BibliotecarioDuermeTest {

    private ComplexAction buildAddPlayerComplexAction(Game game) {
        String name = "add player";
        String command = "add player <parameter>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.addAction(buildAddPlayerSimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildAddPlayerSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ExplicitParameter(2); //player
        Parameter targetParameter = new ImplicitParameter("Hall");

        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter,
                targetParameter, "New player added");
    }

    private ComplexAction buildInitPlayerComplexAction(Game game) {
        String name = "init player";
        String command = "init player <parameter>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.addAction(buildInitPlayerSimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildInitPlayerSimpleAction(Game game, ComplexAction complexAction) {
        Parameter targetParameter = new ExplicitParameter(2); //player
        Parameter childParameter = new ImplicitParameter("Trago");

        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter,
                targetParameter, "Ok");
    }

    private Game game;
    private ClientManager clientManager;

    @Before
    public void setup() {
        GameObject scene = new GameObject("scene");
        GameObject pasillo = new GameObject("Pasillo");
        GameObject biblioteca = new GameObject("Biblioteca");
        GameObject hall = new GameObject("Hall");
        GameObject bibliotecario = new GameObject("Bibliotecario");
        GameObject trago = new GameObject("Trago");
        scene.addChild(pasillo);
        scene.addChild(biblioteca);
        scene.addChild(trago);
        hall.addChild(bibliotecario);
        scene.addChild(hall);

        game = new Game(scene, "El Escape 2");

        game.addAction(buildAddPlayerComplexAction(game));
        game.addAction(buildInitPlayerComplexAction(game));

        game.addNewPlayer("player1");
        game.getScene().find("player1").getAttributes().putAll(new HashMap<String, String>() {
            {
                put("Status", "Jugando");
            }
        });

        clientManager = new ClientManager();
        game.setClientManager(clientManager);

        game.addAction(buildGotoComplexAction(game, "Biblioteca"));
        game.addAction(buildGotoComplexAction(game, "Pasillo"));
        game.addAction(buildGotoComplexAction(game, "Hall"));
        game.addAction(buildGiveTragoToComplexAction(game));
    }

    private String execute(String command, String player) {
        System.out.println("> " + command);
        String result = game.doCommand(command, player);
        System.out.println(result);
        return result;
    }

    private ComplexAction buildGotoComplexAction(Game game, String roomName) {
        String name = "goto " + roomName;
        String command = "goto <parameter>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildGotoSimpleAction(game, complexAction, "Entro");
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildGotoSimpleAction(Game game, ComplexAction complexAction, String result) {
        Parameter childParameter = new ExplicitParameter(2); //player
        Parameter targetParameter = new ExplicitParameter(1);

        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter,
                targetParameter, result);
    }

    private ComplexAction buildGiveTragoToComplexAction(Game game) {
        String name = "give Trago to";
        String command = "give Trago to <parameter>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildGiveTragoToSimpleAction(game, complexAction, "El bibliotecario se durmio");
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildGiveTragoToSimpleAction(Game game, ComplexAction complexAction, String result) {
        Parameter targetParameter = new ImplicitParameter("Bibliotecario");

        return new ChangeAttributeSimpleAction(complexAction, new TrueCondition(), targetParameter,
                "El bibliotecario se durmio", "Status", "Dormido");
    }

    @Test
    public void test_paso_del_tiempo() {
        Assert.assertEquals("El bibliotecario se durmio", execute("give Trago to Bibliotecario", "player1"));
        Scheduleable timeTask = new TimeTaskMock(120, TimeUnit.SECONDS);
        timeTask.setExecute(buildAwakeComplexAction(game), "awake Bibliotecario");
        game.addTimeTask(timeTask);
        Assert.assertEquals("Entro", execute("goto Biblioteca", "player1"));
        Assert.assertEquals("Entro", execute("goto Hall", "player1"));
        // Pasaron 2 minutos
        game.runTimeTasks();
        Assert.assertEquals("Perdiste, te vio el Bibliotecario", clientManager.getLastMessage());
    }

    private Action buildAwakeComplexAction(Game game) {
        String name = "awake Bibliotecario";
        String command = "awake Bibliotecario";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        String result = "Perdiste, te vio el Bibliotecario";

        return new MessageSimpleAction(complexAction, new TrueCondition(), result);
    }

    @Test
    public void test_movimiento_random() {
        game.setMultiPlayer();
        game.addNewPlayer("player2");
        game.getScene().find("player2").getAttributes().putAll(new HashMap<String, String>() {
            {
                put("Status", "Jugando");
            }
        });
        Assert.assertEquals("El bibliotecario se durmio", execute("give Trago to Bibliotecario", "player1"));
        Scheduleable timeTask = new TimeTaskMock(120, TimeUnit.SECONDS);
        timeTask.setExecute(buildAwakeAndMoveComplexAction(game), "goto random Bibliotecario");
        game.addTimeTask(timeTask);
        Scheduleable timeTask2 = new TimeTaskMock(120, TimeUnit.SECONDS);
        timeTask2.setExecute(buildCatchPlayersComplexAction(game), "catch players");
        game.addTimeTask(timeTask2);
        Assert.assertEquals("Entro", execute("goto Biblioteca", "player1"));
        Assert.assertEquals("Entro", execute("goto Biblioteca", "player2"));
        Assert.assertEquals("Entro", execute("goto Pasillo", "player2"));
        // Pasaron 2 minutos
        game.runTimeTasks();
        Assert.assertEquals("Perdio", game.getScene().find("player1").getAttribute("Status"));
        Assert.assertEquals("Jugando", game.getScene().find("player2").getAttribute("Status"));
    }

    private Action buildCatchPlayersComplexAction(Game game) {
        String name = "catch players";
        String command = "catch players";
        ComplexAction complexAction = new ComplexAction(name, command, game);

        Parameter targetParameter = new ImplicitParameter("player1");
        Condition condition = new TrueCondition();
        SimpleAction simpleAction = new ChangeAttributeSimpleAction(complexAction, condition, targetParameter,
                "Perdio", "Status", "Perdio");
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private Action buildAwakeAndMoveComplexAction(Game game) {
        String name = "goto random";
        String command = "goto random <parameter>";
        Parameter childParameter = new ExplicitParameter(2);
        ComplexAction complexAction = new ComplexAction(name, command, game);

        Parameter targetParameter1 = new ImplicitParameter("Biblioteca");
        Condition condition = new RandomCondition(0);
        SimpleAction simpleAction1 = new MoveChildSimpleAction(complexAction, condition, childParameter,
                targetParameter1, "Bibliotecario entro a Biblioteca");
        complexAction.addAction(simpleAction1);

        return complexAction;
    }
}
