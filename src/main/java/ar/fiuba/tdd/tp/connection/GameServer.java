package ar.fiuba.tdd.tp.connection;

import ar.fiuba.tdd.tp.game.GameLoader;
import ar.fiuba.tdd.tp.game.Playable;
import ar.fiuba.tdd.tp.loader.Loader;

import java.net.ServerSocket;

public class GameServer extends Thread {

    private int port;
    private String gameName;

    public GameServer(int port, String gameName) {
        this.port = port;
        this.gameName = gameName;
    }

    public void run() {
        try {
            ServerSocket listener = new ServerSocket(port);
            Loader loader = new GameLoader();
            Playable gameInstance = loader.get(gameName);
            //noinspection InfiniteLoopStatement
            while (true) {
                new Server(listener.accept(), gameInstance).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
