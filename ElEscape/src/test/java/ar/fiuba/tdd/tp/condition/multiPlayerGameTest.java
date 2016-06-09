package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.EscapeGameBuilder;
import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("CPD-START")
public class multiPlayerGameTest {

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
    public void player_one_can_see_player_two() {
        Assert.assertEquals("There’s a Lapicera in the room.", execute("look around", "player1"));
        // Entra otro jugador
        game.addNewPlayer("player2");
        Assert.assertEquals("There’s a Lapicera and a player2 in the room.", execute("look around", "player1"));
        Assert.assertEquals("There’s a Lapicera and a player1 in the room.", execute("look around", "player2"));
        Assert.assertEquals("Entro", execute("goto Salon3", "player1"));
        Assert.assertEquals("There’s a Llave in the room.", execute("look around", "player1"));
        Assert.assertEquals("There’s a Lapicera in the room.", execute("look around", "player2"));
    }
}