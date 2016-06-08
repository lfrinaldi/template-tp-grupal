package ar.fiuba.tdd.tp.connection;

import java.util.ArrayList;
import java.util.List;

public class ClientManager {

    private List<AbstractServer> clients;

    public ClientManager() {
        this.clients = new ArrayList<>();
    }

    public void addClient(AbstractServer client) {
        this.clients.add(client);
    }

    public void broadcastButMe(AbstractServer client, String string) {
        this.clients.remove(client);
        for (AbstractServer c: this.clients) {
            c.print(string);
        }
        this.clients.add(client);
    }
}
