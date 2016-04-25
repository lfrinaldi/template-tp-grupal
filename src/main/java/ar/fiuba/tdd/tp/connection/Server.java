package ar.fiuba.tdd.tp.connection;

import ar.fiuba.tdd.tp.game.Game;
import ar.fiuba.tdd.tp.game.Playable;
import ar.fiuba.tdd.tp.server.ServerMain;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

public class Server extends Thread {

    private Socket socket;
    private Playable game;

    public Server(Socket socket, Playable game) throws IOException {
        this.socket = socket;
        this.game = game;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
            processInput(in, out);
        } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void processInput(BufferedReader in, PrintWriter out) throws IOException {
        while (true) {
            String input = in.readLine();
            if (input != null) {
                input = connectCommand(in, out, input);
                if (input.equals(".")) {
                    out.println(input);
                    break;
                }
                if (game != null) {
                    String response = ((Game) game).receiveMessage(input);
                    out.println(response);
                } else {
                    out.println(input);
                }
            }
        }
    }

    private String connectCommand(BufferedReader in, PrintWriter out, String input) throws IOException {
        if (input.startsWith("connect ")) {
            String ipPort = input.replace("connect ", "");
            String[] data = ipPort.split(":");
            String ip = data[0];
            String port = data[1];
            input = connectGameServer(in, out, ip, port);
        }
        return input;
    }

    private String connectGameServer(BufferedReader in, PrintWriter out, String ip, String port) throws IOException {
        String input;
        Integer numPort = Integer.parseInt(port);
        Socket socket = new Socket(ip, numPort);
        new Client(socket, out);
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream, true, "UTF-8");
        out.println("Welcome to " + ServerMain.getKeyByValue(numPort));
        while (true) {
            String line = in.readLine();
            if (line != null) {
                printStream.println(line);
                if (".".equals(line)) {
                    input = ".";
                    break;
                }
            }
        }
        return input;
    }
}