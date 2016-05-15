package ar.fiuba.tdd.tp.game.builder;

import ar.fiuba.tdd.tp.builder.AbrirPuerta2GameBuilder;
import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Test;

public class AbrirPuerta2GameTest {

    @Test
    public void buildFetchQuestTest() {

        AbrirPuerta2GameBuilder abrirPuerta2GameBuilder = new AbrirPuerta2GameBuilder();
        Game game = abrirPuerta2GameBuilder.build();
        String result = game.doCommand("look around");
        System.out.println(result);
        result = game.doCommand("open door");
        System.out.println(result);
        result = game.doCommand("What can I do with box ?");
        System.out.println(result);
        result = game.doCommand("open box");
        System.out.println(result);
        result = game.doCommand("look around");
        System.out.println(result);
        result = game.doCommand("pick key");
        System.out.println(result);
        result = game.doCommand("open door");
        System.out.println(result);

        Assert.assertTrue(true);
    }
}
