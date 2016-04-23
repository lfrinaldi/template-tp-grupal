package ar.fiuba.tdd.tp.game;

/**
 * Created by Adrián on 4/23/2016.
 */
public interface Useable {

    public void usar();

    public Useable interactuar(Useable useable);

    public String getDescription();
}
