package ar.fiuba.tdd.tp.server;

import ar.fiuba.tdd.tp.connection.GameServer;
import ar.fiuba.tdd.tp.game.GameLoader;
import ar.fiuba.tdd.tp.game.Playable;
import ar.fiuba.tdd.tp.loader.Loader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ServerMain {

    private static final Map<String, Integer> serverMap = new HashMap<>();

    static {
        serverMap.put("fetch quest", 8001);
        serverMap.put("Abrir Puerta", 8002);
        serverMap.put("Abrir Puerta 2", 8003);
        serverMap.put("Objeto Maldito", 8004);
        serverMap.put("Acertijo del lobo, la oveja y la col", 8005);
        serverMap.put("Torres de Hanoi", 8006);
        serverMap.put("Busqueda del Tesoro", 8007);
    }

    public static String getKeyByValue(Integer value) {
        for (Map.Entry<String, Integer> entry : serverMap.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Welcome Server");
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
                        if (serverMap.containsKey(game)) {
                            int port = serverMap.get(game);
                            instanceEngineGameServer(game, port);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void instanceEngineGameServer(String game, int port) {
        try {
            Loader loader = new GameLoader();
            Playable gameInstance = loader.get(game);
            Thread gameServer = new GameServer(port, gameInstance);
            gameServer.start();
            System.out.println(String.format("%s loaded and listening on port %s", game, port));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void instanceGameServer(int serverPort) {
        try {
            Thread gameServer = new GameServer(serverPort, null);
            gameServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}