package ar.fiuba.tdd.tp.connection;

import ar.fiuba.tdd.tp.model.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class AbstractGameServer extends Thread {

    protected int port;
    protected String gameName;
    protected GameManager gameManager;

    public AbstractGameServer(int port, String gameName, GameManager gameManager) {
        this.port = port;
        this.gameName = gameName;
        this.gameManager = gameManager;
    }

    public void run() {
        try {
            ServerSocket listener = new ServerSocket(port);
            Game gameInstance = this.gameManager.loadGame(gameName);
            if (gameInstance != null) {
                System.out.println(gameInstance.getName());
                //noinspection InfiniteLoopStatement
                while (true) {
                    AbstractServer server = makeServer(listener.accept(), gameInstance);
                    server.start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract AbstractServer makeServer(Socket socket, Game gameInstance) throws IOException;
}
