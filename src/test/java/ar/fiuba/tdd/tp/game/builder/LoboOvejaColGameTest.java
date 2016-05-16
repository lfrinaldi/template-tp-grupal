package ar.fiuba.tdd.tp.game.builder;

import ar.fiuba.tdd.tp.builder.LoboOvejaColGameBuilder;

import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Test;

public class LoboOvejaColGameTest {

    @Test
    public void buildLoboOvejaColTest() {
        LoboOvejaColGameBuilder loboOvejaColGameBuilder = new LoboOvejaColGameBuilder();
        Game game = loboOvejaColGameBuilder.build();

        String command = "take sheep"; System.out.println(command); String result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("Ok", result);
        command = "take wolf"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("You can’t do that! The boat is full.", result);
        command = "cross north-shore"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("you have crossed!", result);
        command = "leave sheep"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("Ok", result);
        command = "cross south-shore"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("you have crossed!", result);
        command = "take wolf"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("Ok", result);
        command = "cross north-shore"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("you have crossed!", result);
        command = "leave wolf"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("Ok", result);
        command = "cross south-shore"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("You can’t do that! The wolf will eat the sheep!", result);
    }
}
