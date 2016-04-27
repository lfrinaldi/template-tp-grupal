package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.GameObject;

import java.util.List;

public class Thief extends GameObject {

    private String talk;

    public Thief(String description) {
        super(description);
    }


    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    @Override
    public String use(Action action) {
        return null;
    }
}
