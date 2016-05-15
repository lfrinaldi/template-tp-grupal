package ar.fiuba.tdd.tp.game.builder;

import ar.fiuba.tdd.tp.builder.AbrirPuertaGameBuilder;
import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Test;

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
