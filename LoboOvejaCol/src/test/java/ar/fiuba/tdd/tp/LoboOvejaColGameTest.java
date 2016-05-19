package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("CPD-START")
public class LoboOvejaColGameTest {
    private Game game;

    @Before
    public void setup() {
        LoboOvejaColGameBuilder loboOvejaColGameBuilder = new LoboOvejaColGameBuilder();
        game = loboOvejaColGameBuilder.build();
    }

    @Test
    public void buildLoboOvejaColTest() {
        Assert.assertEquals("Ok", executeCommand("take sheep"));
        Assert.assertEquals("You can’t do that! The boat is full.", executeCommand("take wolf"));
        Assert.assertEquals("you have crossed!", executeCommand("cross north-shore"));
        Assert.assertEquals("Ok", executeCommand("leave sheep"));
        Assert.assertEquals("you have crossed!", executeCommand("cross south-shore"));
        Assert.assertEquals("Ok", executeCommand("take wolf"));
        Assert.assertEquals("you have crossed!", executeCommand("cross north-shore"));
        Assert.assertEquals("Ok", executeCommand("leave wolf"));
        Assert.assertEquals("You can’t do that! The wolf will eat the sheep!", executeCommand("cross south-shore"));
    }

    private String executeCommand(String command) {
        System.out.println(command);
        String result = game.doCommand(command);
        System.out.println(result);
        return result;
    }
}
