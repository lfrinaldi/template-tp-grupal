package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.engine.ObjectAction;
import ar.fiuba.tdd.tp.engine.RoomAction;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private List<GameObject> objects;

    public Room(String name, ArrayList<GameObject> objects) {
        this.name = name;
        this.objects = objects;
    }

    public List<GameObject> getObjects() {
        return this.objects;
    }

    public String getName() {
        return this.name;
    }

    public String execute(Action action) {
        //TODO: Repair this
        return action.getName();
    }
}
