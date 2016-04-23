package ar.fiuba.tdd.tp.game;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Adrián on 4/23/2016.
 */
public class Level extends BaseGame {


    public Level(String description, ArrayList<Useable> useables) {
        super(description, useables);
    }


    @Override
    public String play() {
        super.play();
        return ("Nivel " + super.getDescription());
    }
}
