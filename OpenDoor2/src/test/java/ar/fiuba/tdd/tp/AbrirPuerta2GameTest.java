package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("CPD-START")
public class AbrirPuerta2GameTest {

    private Game game;

    @Before
    public void setup() {
        AbrirPuerta2GameBuilder abrirPuerta2GameBuilder = new AbrirPuerta2GameBuilder();
        game = abrirPuerta2GameBuilder.build();
    }

    private String execute(String command) {
        System.out.println(command);
        String result = game.doCommand(command);
        System.out.println(result);
        return result;
    }

    @Test
    public void buildFetchQuestTest() {
        Assert.assertEquals("There's a box and a door in the room.", execute("look around"));
        Assert.assertEquals("Ey! Where do you go?! room2 is locked.", execute("open door"));
        Assert.assertEquals("You can open/close the box.", execute("What can I do with box ?"));
        Assert.assertEquals("The box is opened!.", execute("open box"));
        Assert.assertEquals("There's a box, a door and a key in the room.", execute("look around"));
        Assert.assertEquals("There you go!", execute("pick key"));
        Assert.assertEquals("You enter room2. You won the game!", execute("open door"));
    }
}
