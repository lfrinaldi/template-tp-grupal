package ar.fiuba.tdd.tp.loader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Adrián on 4/27/2016.
 */
public class FetchQuestTest {
    private FetchQuest fetchQuest;

    @Before
    public void setup() {
        fetchQuest = new FetchQuest();
    }

    @Test
    public void fetchQuestTest() {
        Assert.assertTrue(fetchQuest.receiveMessage("pick stick").equals("You won the game!"));
    }

    @Test
    public void multipleFetchQuestsTest() {
        FetchQuest f1 = new FetchQuest();
        FetchQuest f2 = new FetchQuest();
        f1.receiveMessage("pick stick");
        Assert.assertTrue(f2.receiveMessage("open door").equals("You won the game!"));
    }
}
