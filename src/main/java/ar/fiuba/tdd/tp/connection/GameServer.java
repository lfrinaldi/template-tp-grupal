package ar.fiuba.tdd.tp.connection;

import java.net.ServerSocket;

public class GameServer extends Thread {

    private int port;

    public GameServer(int port) {
        this.port = port;
    }

    public void run() {
        try {
            ServerSocket listener = new ServerSocket(port);
            //noinspection InfiniteLoopStatement
            while (true) {
                new Server(listener.accept()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
