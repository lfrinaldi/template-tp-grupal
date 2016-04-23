package ar.fiuba.tdd.tp.connection;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

public class Server extends Thread {

    private Socket socket;

    public Server(Socket socket) throws IOException {
        this.socket = socket;
    }

    public void run() {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

            while (true) {
                String input = in.readLine();
                if (input == null || input.equals(".")) {
                    out.println(input);
                    break;
                }
                out.println(input);
            }

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
}
