package ar.fiuba.tdd.tp.game;

/**
 * Created by Adrián on 4/23/2016.
 */
public interface Useable {

    void usar();

    Useable interactuar(Useable useable);

    String getDescription();
}
