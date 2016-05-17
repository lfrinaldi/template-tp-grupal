package ar.fiuba.tdd.tp.loader;


import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameBuilder;
import ar.fiuba.tdd.tp.server.BuilderLoader;

public class GameLoader implements Loader {

    @Override
    public Game get(String gameName) {
        Game game = null;
        try {
            GameBuilder gameBuilder = BuilderLoader.load(gameName);
            game = gameBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return game;
    }
}
