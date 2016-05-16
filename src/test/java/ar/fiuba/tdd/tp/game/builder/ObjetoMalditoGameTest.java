package ar.fiuba.tdd.tp.game.builder;

import ar.fiuba.tdd.tp.builder.ObjetoMalditoGameBuilder;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class ObjetoMalditoGameTest {

    @Test
    public void objetoMalditoTest() {
        ObjetoMalditoGameBuilder objetoMalditoGameBuilder = new ObjetoMalditoGameBuilder();
        Game game = objetoMalditoGameBuilder.build();

        String command = "";
        String result = "";

        Map<String,GameObject> player = game.getScene().find("player").getChildrenMap();
        Map<String,GameObject> thief = game.getScene().find("thief").getChildrenMap();
        Map<String,GameObject> room1 = game.getScene().find("room1").getChildrenMap();
        Map<String,GameObject> room2 = game.getScene().find("room2").getChildrenMap();
        Map<String,GameObject> room3 = game.getScene().find("room3").getChildrenMap();
        //System.out.println(player); System.out.println(thief); System.out.println(room1); System.out.println(room2); System.out.println(room3);

        command = "look around"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("There's a door1 and a object in the room.", result);

        command = "open door1"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("Ey! Where do you go?! room2 is locked.", result);

        command = "pick object"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("Ok", result);

        command = "open door1"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("You enter room2.", result);

        command = "look around"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("There's a door2 and a thief in the room.", result);

        command = "open door2"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("Ey! Where do you go?! room3 is locked.", result);

        //command = "What can I do with thief?"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        //Assert.assertEquals("You can talk with thief: \"Hello\", \"Bye\".", result);

        command = "Talk to thief \"Hello\""; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("Hi!\nThe thief has just stolen your object!", result);

        command = "open door2"; System.out.println(command); result = game.doCommand(command); System.out.println(result);
        Assert.assertEquals("You enter room3. You won the game!", result);


        Assert.assertTrue(true);
    }
}
