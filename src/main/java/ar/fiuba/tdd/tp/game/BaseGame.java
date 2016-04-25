package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 4/23/2016.
 */
public abstract class BaseGame implements Playable {

    private String description;
    protected List<Useable> useables;

    public BaseGame() {
    }

    public BaseGame(String description, List<Useable> useables) {
        this.description = description;
        this.useables = new ArrayList<Useable>(useables);
    }

    public void setUseables(List<Useable> useables) {
        this.useables = (this.useables == null) ? new ArrayList<>(useables) : this.useables;
    }

    public void addUseable(Useable useable) {
        this.useables.add(useable);
    }

    public List<Useable> getUseables() {
        return this.useables;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
