package ar.fiuba.tdd.tp.game.object;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.game.ComplexObject;
import ar.fiuba.tdd.tp.game.SimpleObject;

public class Thief extends SimpleObject {

    private String talk;

/*
    public Thief(String name) {
        super(name);
    }
*/


    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    @Override
    public String use(Action action) {
        /*return action.execute(this);*/
        return null;
    }
}
