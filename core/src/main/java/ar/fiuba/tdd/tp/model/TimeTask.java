package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.action.Action;
import ar.fiuba.tdd.tp.connection.ClientManager;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeTask implements Scheduleable {
    private ScheduledExecutorService executor;
    private TimeUnit timeUnit;
    private long delay;
    private Action action;
    private String command;

    public TimeTask(long delay, TimeUnit timeUnit) {
        executor = Executors.newScheduledThreadPool(1);
        this.delay = delay;
        this.timeUnit = timeUnit;
    }

    public void run(Runnable procedure) {
        if (!executor.isShutdown()) {
            Runnable task = () -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    procedure.run();
                } catch (InterruptedException e) {
                    System.err.println("task interrupted");
                }
            };

            executor.scheduleWithFixedDelay(task, 0, this.delay, timeUnit);
        }
    }



    public void setExecute(Action action, String command) {
        this.action = action;
        this.command = command;
    }

    public void run(ClientManager clientManager) {
        run(() -> {
            String value = action.execute(command);
            clientManager.broadcastButMe(null, value);
        });
    }

    public void shutDown() {
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    public boolean isRunning() {
        return !executor.isShutdown();
    }

}
