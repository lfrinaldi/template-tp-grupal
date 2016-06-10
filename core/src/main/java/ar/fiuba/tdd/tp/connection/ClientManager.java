package ar.fiuba.tdd.tp.connection;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ClientManager {

    private List<AbstractServer> clients;
    private String lastMessage;

    public ClientManager() {
        this.clients = new ArrayList<>();
    }

    // Testing pourpose
    public String getLastMessage() {
        return this.lastMessage;
    }

    public void addClient(AbstractServer client) {
        this.clients.add(client);
    }

    public void broadcastButMe(AbstractServer client, String string) {
        this.lastMessage = string;
        for (AbstractServer c: this.clients) {
            if (c != client) {
                try {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(c.getSocket().getOutputStream(), StandardCharsets
                            .UTF_8), true);
                    out.println(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
