package ar.fiuba.tdd.tp.game;

import java.util.ArrayList;

/**
 * Created by Adrián on 4/23/2016.
 */
public class Level extends BaseGame{


    public Level(String description, ArrayList<Useable> useables){
        super(description, useables);
    }


    @Override
    public void play() {
        super.play();
        System.out.print("Nivel " + super.getDescription());
    }
}
