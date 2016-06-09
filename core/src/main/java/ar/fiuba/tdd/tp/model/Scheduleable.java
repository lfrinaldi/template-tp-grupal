package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.connection.ClientManager;

/**
 * Created by nicolas on 09/06/16.
 */
public interface Scheduleable {
    void run(ClientManager clientManager);
    void shutDown();
}
