package ar.fiuba.tdd.tp.connection;

import ar.fiuba.tdd.tp.game.Playable;

import java.io.IOException;
import java.net.Socket;

public class MainGameServer extends AbstractGameServer {

    public MainGameServer(int port, String gameName) {
        super(port, gameName);
    }

    protected AbstractServer makeServer(Socket socket, Playable gameInstance) throws IOException {
        return new MainServer(socket, gameInstance);
    }
}
