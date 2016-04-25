package ar.fiuba.tdd.tp.connection;

import ar.fiuba.tdd.tp.game.Playable;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainServer extends AbstractServer {

    public MainServer(Socket socket, Playable game) throws IOException {
        super(socket, game);
    }

    protected boolean processOutput(PrintWriter out, String input) {
        out.println("bye!");
        return false;
    }
}
