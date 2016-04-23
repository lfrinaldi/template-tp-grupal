package ar.fiuba.tdd.tp.engine;

import java.util.ArrayList;

public abstract class Action {
    private String name;
    private ArrayList<String> objects;

    public Action(String name, ArrayList<String> objects) {
        this.name = name;
        this.objects = objects;
    }

    public String getName() {
        return name;
    }

    public String getPrimaryObject() {
        return this.objects.get(0);
    }
}
