package ar.fiuba.tdd.tp.connection;

import ar.fiuba.tdd.tp.game.Game;
import ar.fiuba.tdd.tp.game.Playable;

import java.io.IOException;
import java.net.Socket;

public class EngineGameServer extends AbstractGameServer {

    public EngineGameServer(int port, String gameName) {
        super(port, gameName);
    }

    protected AbstractServer makeServer(Socket socket, Game gameInstance) throws IOException {
        return new EngineServer(socket, gameInstance);
    }
}
