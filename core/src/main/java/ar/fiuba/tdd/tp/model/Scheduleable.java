package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.action.Action;
import ar.fiuba.tdd.tp.connection.ClientManager;

public interface Scheduleable {
    void run(ClientManager clientManager);
    void shutDown();
    void setExecute(Action action, String command);
}
