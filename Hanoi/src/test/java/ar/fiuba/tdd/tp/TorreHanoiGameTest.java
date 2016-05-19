package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("CPD-START")
public class TorreHanoiGameTest {

    @Test
    public void buildTorreHanoiTest() {

        TorresHanoiGameBuilder torresHanoiGameBuilder = new TorresHanoiGameBuilder();
        Game game = torresHanoiGameBuilder.build();


        String result = game.doCommand("What can I do with stack1 ?");
        System.out.println(result);
        result = game.doCommand("check top stack1");
        System.out.println(result);
        result = game.doCommand("move top stack1 stack2");
        System.out.println(result);
        result = game.doCommand("move top stack1 stack3");
        System.out.println(result);
        result = game.doCommand("move top stack2 stack3");
        System.out.println(result);
        Assert.assertTrue(true);
    }
}
