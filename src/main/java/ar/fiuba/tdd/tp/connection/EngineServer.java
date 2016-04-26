package ar.fiuba.tdd.tp.connection;

import ar.fiuba.tdd.tp.game.Game;
import ar.fiuba.tdd.tp.game.Playable;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class EngineServer extends AbstractServer {

    public EngineServer(Socket socket, Game game) throws IOException {
        super(socket, game);
    }

    protected boolean processOutput(PrintWriter out, String input) {
        out.println(input);
        return true;
    }
}
