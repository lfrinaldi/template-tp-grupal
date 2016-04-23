package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.game.GameObject;

import java.util.ArrayList;

public class Action {
    private String name;
    private ArrayList<GameObject> objects;

    public Action(String name, ArrayList<GameObject> objects) {
        this.name = name;
        this.objects = objects;
    }

    public String getName() {
        return name;
    }

    public GameObject getPrimaryObject() {
        return this.objects.get(0);
    }
}
