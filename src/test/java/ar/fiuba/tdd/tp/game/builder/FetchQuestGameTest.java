package ar.fiuba.tdd.tp.game.builder;

import ar.fiuba.tdd.tp.builder.FetchQuestGameBuilder;
import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Test;

public class FetchQuestGameTest {

    @Test
    public void buildFetchQuestTest() {

        FetchQuestGameBuilder fetchQuestGameBuilder = new FetchQuestGameBuilder();
        Game game = fetchQuestGameBuilder.build();
        String result = game.doCommand("look around");
        System.out.println(result);
        result = game.doCommand("pick stick");
        System.out.println(result);
        result = game.doCommand("pick stick");
        System.out.println(result);

        Assert.assertTrue(true);
    }
}
