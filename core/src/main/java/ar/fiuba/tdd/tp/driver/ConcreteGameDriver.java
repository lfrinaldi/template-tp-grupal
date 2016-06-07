package ar.fiuba.tdd.tp.driver;

import ar.fiuba.tdd.tp.loader.GameLoader;
import ar.fiuba.tdd.tp.model.Game;

public class ConcreteGameDriver implements GameDriver {
    protected Game game;

    public void initGame(String jarPath) throws GameLoadFailedException {
        GameLoader loader = new GameLoader();
        game = loader.get("escape");
    }

    public String sendCommand(String cmd) {
        return game.doCommand(cmd, game.getCurrentPlayerId());
    }

    public GameState getCurrentState() {
        String status = game.getScene().getAttribute("status");
        switch (status) {
            case "win":
                return GameState.Won;
            case "lost":
                return GameState.Lost;
            default:
                return GameState.InProgress;
        }
    }
}
