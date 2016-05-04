package ar.fiuba.tdd.tp.game;

/**
 * Created by Adrián on 4/27/2016.
 */
public abstract class GameObject {
    protected String name;

    public boolean is(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
