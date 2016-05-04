package ar.fiuba.tdd.tp.loader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FetchQuestTest {
    private FetchQuest fetchQuest;

    @Before
    public void setup() {
        fetchQuest = new FetchQuest();
    }

    @Test
    public void fetchQuestTest() {
        Assert.assertTrue(fetchQuest.pick("stick").equals("You picked stick"));
        Assert.assertTrue(fetchQuest.checkEndGame());
    }

}
