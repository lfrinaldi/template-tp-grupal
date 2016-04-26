package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Disk extends GameObject {

    private Integer size;

    public Disk(String description, Integer size) {
        super(description);
        this.size = size;
    }

    public Disk(String name, List<GameObject> objects, Integer size) {
        super(name, objects);
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
