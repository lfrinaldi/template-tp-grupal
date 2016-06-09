package ar.fiuba.tdd.tp.connection;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
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
            try {
                PrintWriter out = new PrintWriter(new OutputStreamWriter(c.getSocket().getOutputStream(), StandardCharsets
                        .UTF_8), true);
                out.println(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.clients.add(client);
    }
}
