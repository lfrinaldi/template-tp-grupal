package ar.fiuba.tdd.tp.loader;


import ar.fiuba.tdd.tp.builder.AbrirPuerta2GameBuilder;
import ar.fiuba.tdd.tp.model.Game;

public class GameLoader implements Loader {

    @Override
    public Game get(String gameName) {
        AbrirPuerta2GameBuilder gameBuilder = new AbrirPuerta2GameBuilder();
        //AbrirPuertaGameBuilder gameBuilder = new AbrirPuertaGameBuilder();
        //FetchQuestGameBuilder gameBuilder = new FetchQuestGameBuilder();
        return gameBuilder.build();
    }
}
