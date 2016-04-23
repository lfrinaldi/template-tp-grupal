package ar.fiuba.tdd.tp.server;

import ar.fiuba.tdd.tp.connection.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerMain {

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try {
            ServerSocket listener = new ServerSocket(port);
            //noinspection InfiniteLoopStatement
            while (true) {
                new Server(listener.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}