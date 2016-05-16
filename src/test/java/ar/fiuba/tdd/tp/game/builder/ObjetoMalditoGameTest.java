package ar.fiuba.tdd.tp.game.builder;

import ar.fiuba.tdd.tp.builder.ObjetoMalditoGameBuilder;
import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ObjetoMalditoGameTest {

    private Game game;

    @Before
    public void setup() {
        ObjetoMalditoGameBuilder objetoMalditoGameBuilder = new ObjetoMalditoGameBuilder();
        game = objetoMalditoGameBuilder.build();
        /*Map<String, GameObject> player = game.getScene().find("player").getChildrenMap();
        Map<String, GameObject> thief = game.getScene().find("thief").getChildrenMap();
        Map<String, GameObject> room1 = game.getScene().find("room1").getChildrenMap();
        Map<String, GameObject> room2 = game.getScene().find("room2").getChildrenMap();
        Map<String, GameObject> room3 = game.getScene().find("room3").getChildrenMap();*/
        //System.out.println(player); System.out.println(thief); System.out.println(room1); System.out.println(room2)
        // ; System.out.println(room3);
    }

    private String execute(String command) {
        System.out.println(command);
        String result = game.doCommand(command);
        System.out.println(result);
        return result;
    }

    @Test
    public void objetoMalditoTest() {
        Assert.assertEquals("There's a door1 and a object in the room.", execute("look around"));
        Assert.assertEquals("Ey! Where do you go?! room2 is locked.", execute("open door1"));
        Assert.assertEquals("Ok", execute("pick object"));
        Assert.assertEquals("You enter room2.", execute("open door1"));
        Assert.assertEquals("There's a door2 and a thief in the room.", execute("look around"));
        Assert.assertEquals("Ey! Where do you go?! room3 is locked.", execute("open door2"));

        //command = "What can I do with thief?"; System.out.println(command); result = game.doCommand(command);
        // System.out.println(result);
        //Assert.assertEquals("You can talk with thief: \"Hello\", \"Bye\".", result);

        Assert.assertEquals("Hi!\nThe thief has just stolen your object!", execute("Talk to thief \"Hello\""));
        Assert.assertEquals("You enter room3. You won the game!", execute("open door2"));
    }


}
