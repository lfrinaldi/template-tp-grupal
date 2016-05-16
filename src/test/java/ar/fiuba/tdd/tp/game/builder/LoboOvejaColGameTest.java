package ar.fiuba.tdd.tp.game.builder;

import ar.fiuba.tdd.tp.builder.LoboOvejaColGameBuilder;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class LoboOvejaColGameTest {

    @Test
    public void buildLoboOvejaColTest() {
        LoboOvejaColGameBuilder loboOvejaColGameBuilder = new LoboOvejaColGameBuilder();
        Game game = loboOvejaColGameBuilder.build();

        Map<String,GameObject> costaSur = game.getScene().getChild("south-shore").getChildrenMap();
        Map<String,GameObject> costaNorte = game.getScene().getChild("north-shore").getChildrenMap();
        Map<String,GameObject> player = game.getScene().getChild("south-shore").getChild("player").getChildrenMap();

        String command = "take sheep"; System.out.println(command); String result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals(result, "Ok");
        command = "take wolf"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals(result, "You can’t do that! The boat is full.");
        command = "cross north-shore"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals(result, "you have crossed!");
        command = "leave sheep"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals(result, "Ok");
        command = "cross south-shore"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals(result, "you have crossed!");
        command = "take wolf"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals(result, "Ok");
        command = "cross north-shore"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals(result, "you have crossed!");
        command = "leave wolf"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals(result, "Ok");
        command = "cross south-shore"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals(result, "You can’t do that! The wolf will eat the sheep!");

        //System.out.println(costaSur); System.out.println(costaNorte); System.out.println(player);
    }
}
