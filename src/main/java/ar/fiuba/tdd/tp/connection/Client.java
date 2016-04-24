package ar.fiuba.tdd.tp.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client implements Runnable {

    private Thread thread;
    private Socket socket;
    private boolean finished = false;

    public Client(Socket socket) {
        this.socket = socket;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        try {

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while (!finished) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    finished = true;
                } else {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
