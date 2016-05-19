package ar.fiuba.tdd.tp.connection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Server {

    private static final Queue<Integer> ports = new LinkedList<>(Arrays.asList(8001, 8002, 8003, 8004, 8005, 8006, 8006,
            8007, 8008));

    public static void main(String[] args) {
        try {
            System.out.println("Welcome MainServer");
            System.out.println("Please, enter command (type exit to finish sever):");
            String command = "";
            InputStream inputStream = System.in;
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            int serverPort = 8000;
            instanceGameServer(serverPort);
            while (!"exit".equals(command)) {
                command = bufferedReader.readLine();
                if (command != null) {
                    if (command.startsWith("load game ")) {
                        String game = command.replace("load game ", "");
                        int port = getPort();
                        instanceEngineGameServer(game, port);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void instanceEngineGameServer(String game, int port) {
        try {
            Thread gameServer = new EngineGameServer(port, game);
            gameServer.start();
            System.out.println(String.format("%s loaded and listening on port %s", game, port));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void instanceGameServer(int serverPort) {
        try {
            Thread gameServer = new MainGameServer(serverPort, null);
            gameServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Integer getPort() throws Exception {
        Integer port;
        if (ports.size() > 0) {
            port = ports.poll();
        } else {
            throw new Exception("There is no port available");
        }
        return port;
    }

}