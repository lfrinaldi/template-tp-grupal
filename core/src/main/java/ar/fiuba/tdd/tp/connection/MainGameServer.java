package ar.fiuba.tdd.tp.connection;


import ar.fiuba.tdd.tp.model.Game;

import java.io.IOException;
import java.net.Socket;

public class MainGameServer extends AbstractGameServer {

    public MainGameServer(int port, String gameName, GameManager gameManager) {
        super(port, gameName, gameManager);
    }

    protected AbstractServer makeServer(Socket socket, Game gameInstance) throws IOException {
        return new MainServer(socket, gameInstance);
    }
}
