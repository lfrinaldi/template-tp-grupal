package model;

import ar.fiuba.tdd.tp.model.TimeTask;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TimeTaskTest {

    private TimeTask timeTask;

    @Before
    public void setup() {
        timeTask = new TimeTask(10, TimeUnit.SECONDS);
    }

    @After
    public void shutDown() {
        if (timeTask.isRunning()) {
            timeTask.shutDown();
        }

    }

    @Test
    public void runTask() {
        this.timeTask.run(createProcedure("Executing procedure"));
        Assert.assertEquals(true, timeTask.isRunning());
        try {
            TimeUnit.SECONDS.sleep(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void stopARunningTask() {
        this.timeTask.run(createProcedure("procedure"));
        timeTask.shutDown();
        Assert.assertEquals(false, timeTask.isRunning());
    }

    private Runnable createProcedure(String text) {
        return () -> System.out.println(text);
    }
}
