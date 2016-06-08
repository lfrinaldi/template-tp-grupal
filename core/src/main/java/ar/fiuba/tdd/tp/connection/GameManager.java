package ar.fiuba.tdd.tp.connection;

import ar.fiuba.tdd.tp.loader.GameLoader;
import ar.fiuba.tdd.tp.loader.Loader;
import ar.fiuba.tdd.tp.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private List<Game> loadedMultiPlayerGames;

    public GameManager() {
        this.loadedMultiPlayerGames = new ArrayList<>();
    }

    public Game loadGame(String gameName) {
        if (this.loadedMultiplayerGameNames().contains(gameName)) {
            return this.getMultiPlayerGame(gameName);
        } else {
            Loader loader = new GameLoader();
            Game game = loader.get(gameName);
            if (game.isMultiPlayer()) {
                this.loadedMultiPlayerGames.add(game);
            }
            return game;
        }
    }

    private Game getMultiPlayerGame(String gameName) {
        for (Game game: this.loadedMultiPlayerGames) {
            if (game.getName().equals(gameName)) {
                return game;
            }
        }
        return null;
    }

    private List<String> loadedMultiplayerGameNames() {
        List<String> names = new ArrayList<>();
        for (Game game: this.loadedMultiPlayerGames) {
            names.add(game.getName());
        }
        return names;
    }
}
