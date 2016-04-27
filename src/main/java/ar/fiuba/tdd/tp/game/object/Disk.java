package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Disk extends GameObject {

    private Integer size;

    public Disk(String description, Integer size) {
        super(description);
        this.size = size;
    }



    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String use(Action action) {
        return null;
    }
}
