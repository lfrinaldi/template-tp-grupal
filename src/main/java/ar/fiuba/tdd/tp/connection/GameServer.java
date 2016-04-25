package ar.fiuba.tdd.tp.connection;

import ar.fiuba.tdd.tp.game.GameLoader;
import ar.fiuba.tdd.tp.game.Playable;
import ar.fiuba.tdd.tp.loader.Loader;

import java.net.ServerSocket;

public class GameServer extends Thread {

    private int port;
    private Playable game;

    public GameServer(int port, Playable game) {
        this.port = port;
        this.game = game;
    }

    public void run() {
        try {
            ServerSocket listener = new ServerSocket(port);
            //noinspection InfiniteLoopStatement
            while (true) {
                new Server(listener.accept(), game).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
