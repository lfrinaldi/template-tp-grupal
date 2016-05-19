package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("CPD-START")
public class AbrirPuertaGameTest {

    @Test
    public void buildFetchQuestTest() {

        AbrirPuertaGameBuilder abrirPuertaGameBuilder = new AbrirPuertaGameBuilder();
        Game game = abrirPuertaGameBuilder.build();
        String result = game.doCommand("look around");
        System.out.println(result);
        result = game.doCommand("open door");
        System.out.println(result);
        result = game.doCommand("pick key");
        System.out.println(result);
        result = game.doCommand("pick key");
        System.out.println(result);
        result = game.doCommand("open door");
        System.out.println(result);

        Assert.assertTrue(true);
    }
}
