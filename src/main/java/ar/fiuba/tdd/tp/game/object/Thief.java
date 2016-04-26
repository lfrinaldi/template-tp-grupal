package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Thief extends GameObject {

    private String talk;

    public Thief(String description) {
        super(description);
    }

    public Thief(String name, List<GameObject> objects) {
        super(name, objects);
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }
}
