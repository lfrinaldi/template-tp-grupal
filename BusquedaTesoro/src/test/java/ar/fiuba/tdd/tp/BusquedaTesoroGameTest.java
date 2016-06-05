package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("CPD-START")
public class BusquedaTesoroGameTest {

    private Game game;

    @Before
    public void setup() {
        BusquedaTesoroGameBuilder busquedaTesoroGameBuilder = new BusquedaTesoroGameBuilder();
        game = busquedaTesoroGameBuilder.build();
    }

    private String execute(String command) {
        System.out.println("> " + command);
        String result = game.doCommand(command, 123);
        System.out.println(result);
        return result;
    }


    @Test
    public void busquedaTesoroRoomTest() {
        // Secuential
        busquedaTesoroRoom1Test();
        busquedaTesoroRoom2Test();
        busquedaTesoroRoom3Test();
        busquedaTesoroRoom4Test();
        busquedaTesoroRoom5Test();
    }

    public void busquedaTesoroRoom1Test() {
        Assert.assertEquals("There's a door1 in the room.", execute("look around"));
        Assert.assertEquals("You enter room2.", execute("open door1"));
    }

    public void busquedaTesoroRoom2Test() {
        Assert.assertEquals("There's a door2 and a silver-key in the room.", execute("look around"));
        Assert.assertEquals("Ey! Where do you go?! room3 is locked.", execute("open door2"));
        Assert.assertEquals("There you go!", execute("pick silver-key"));
        Assert.assertEquals("You enter room3.", execute("open door2"));
    }

    public void busquedaTesoroRoom3Test() {
        Assert.assertEquals("There's a door3 and a closet in the room.", execute("look around"));
        Assert.assertEquals("Ok", execute("open closet"));
        Assert.assertEquals("There's a door3, a closet and a trunk in the room.", execute("look around"));
        Assert.assertEquals("Ok", execute("open trunk"));
        Assert.assertEquals("There's a door3, a closet, a trunk and a box in the room.", execute("look around"));
        Assert.assertEquals("Ok", execute("open box"));
        Assert.assertEquals("There's a door3, a closet, a trunk, a box and a golden-key in the room.",
                execute("look around"));
        Assert.assertEquals("There you go!", execute("pick golden-key"));
        Assert.assertEquals("You enter room4.", execute("open door3"));
    }

    public void busquedaTesoroRoom4Test() {
        Assert.assertEquals("There's a door4, a red-box and a green-box in the room.", execute("look around"));
        Assert.assertEquals("You've been poisoned!", execute("open red-box"));
        Assert.assertEquals("Ok", execute("open green-box"));
        Assert.assertEquals("There's a door4, a red-box, a green-box and a anti-poison in the room.",
                execute("look around"));
        Assert.assertEquals("Ey! Where do you go?! You are poisoned!", execute("open door4"));
        Assert.assertEquals("You can drink the potion.", execute("What can I do with anti-poison ?"));
        Assert.assertEquals("You are now healthy", execute("drink anti-poison"));
        Assert.assertEquals("You enter room5.", execute("open door4"));
    }

    public void busquedaTesoroRoom5Test() {
        Assert.assertEquals("There's a door5 and a treasure in the room.", execute("look around"));
        Assert.assertEquals("You just can carry up to two items. Leave something!", execute("pick treasure"));
        Assert.assertEquals("Ok", execute("leave silver-key"));
        Assert.assertEquals("You got the treasure! be sure to return to room1", execute("pick treasure"));
        Assert.assertEquals("You won the game!", execute("open door5"));
    }
}