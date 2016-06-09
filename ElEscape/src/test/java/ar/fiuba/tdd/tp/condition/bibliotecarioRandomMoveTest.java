package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.EscapeGameBuilder;
import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("CPD-START")
public class bibliotecarioRandomMoveTest {

    private Game game;

    @Before
    public void setup() {
        EscapeGameBuilder escapeGameBuilder = new EscapeGameBuilder();
        game = escapeGameBuilder.build();
        game.setMultiPlayer();
        game.addNewPlayer("player1");
    }

    private String execute(String command, String player) {
        System.out.println("> " + command);
        String result = game.doCommand(command, player);
        System.out.println(result);
        return result;
    }

    @Test
    public void move_random_bibliotecario() {
        //Assert.assertEquals("eter", execute("goto random", "player1"));
    }
}