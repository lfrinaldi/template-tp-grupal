package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("CPD-START")
public class ObjetoMalditoGameTest {

    private Game game;

    @Before
    public void setup() {
        ObjetoMalditoGameBuilder objetoMalditoGameBuilder = new ObjetoMalditoGameBuilder();
        game = objetoMalditoGameBuilder.build();
    }

    private String execute(String command) {
        System.out.println(command);
        String result = game.doCommand(command, "123");
        System.out.println(result);
        return result;
    }

    @Test
    public void objetoMalditoTest() {
        Assert.assertEquals("There's a object and a door1 in the room.", execute("look around"));
        Assert.assertEquals("Ey! Where do you go?! room2 is locked.", execute("open door1"));
        Assert.assertEquals("Ok", execute("pick object"));
        Assert.assertEquals("You enter room2.", execute("open door1"));
        Assert.assertEquals("There's a thief and a door2 in the room.", execute("look around"));
        Assert.assertEquals("Ey! Where do you go?! room3 is locked.", execute("open door2"));
        Assert.assertEquals("You can talk with thief: \"Hello\", \"Bye\".", execute("What can I do with thief ?"));
        Assert.assertEquals("Hi!\nThe thief has just stolen your object!", execute("Talk to thief \"Hello\""));
        Assert.assertEquals("You enter room3. You won the game!", execute("open door2"));
    }


}
