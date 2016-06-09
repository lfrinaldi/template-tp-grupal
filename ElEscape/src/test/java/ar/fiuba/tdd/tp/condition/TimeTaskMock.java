package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.action.Action;
import ar.fiuba.tdd.tp.connection.ClientManager;
import ar.fiuba.tdd.tp.model.Scheduleable;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by nicolas on 09/06/16.
 */
public class TimeTaskMock implements Scheduleable {


    private TimeUnit timeUnit;
    private long delay;
    private Action action;
    private String command;

    public TimeTaskMock(long delay, TimeUnit timeUnit) {
        this.delay = delay;
        this.timeUnit = timeUnit;
    }

    public void setExecute(Action action, String command) {
        this.action = action;
        this.command = command;
    }

    @Override
    public void run(ClientManager clientManager) {
        action.execute(command);
    }

    @Override
    public void shutDown() {
        System.out.println("Shutting down");
    }
}
