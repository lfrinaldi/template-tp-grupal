package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.loader.Loader;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leandro on 22/04/16.
 */
public class GameLoader implements Loader {

    @Override
    public Game get(String name) {
        Game game = null;
        if ("fetch quest".equals(name)) {
            GameObject stick = new GameObject("stick");
            Level room = new Level("room", new ArrayList<Useable>(Arrays.asList(stick)));
            game = new Game("This is fetch quest game, only one room", new ArrayList<Playable>(Arrays.asList(room)));
        }
        return game;
    }

}
