package ar.fiuba.tdd.tp.connection;

import ar.fiuba.tdd.tp.model.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class AbstractGameServer extends Thread {

    protected int port;
    protected String gameName;
    protected GameManager gameManager;
    protected ClientManager clientManager;

    public AbstractGameServer(int port, String gameName, GameManager gameManager) {
        this.port = port;
        this.gameName = gameName;
        this.gameManager = gameManager;
        this.clientManager = new ClientManager();
    }

    public void run() {
        try {
            ServerSocket listener = new ServerSocket(port);
            Game gameInstance = this.gameManager.loadGame(gameName);
            //noinspection InfiniteLoopStatement
            while (true) {
                AbstractServer server = makeServer(listener.accept(), gameInstance, clientManager);
                server.start();
                this.clientManager.addClient(server);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract AbstractServer makeServer(Socket socket, Game gameInstance, ClientManager clientManager) throws IOException;
}
