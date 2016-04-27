package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.Action;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private List<Useable> objects;

    public Room(String name, ArrayList<Useable> objects) {
        this.name = name;
        this.objects = objects;
    }

    public void setObjects(List<Useable> useables) {
        this.objects = useables;
    }


    public List<Useable> getObjects() {
        return this.objects;
    }

    public String getName() {
        return this.name;
    }

    public String execute(Action action) {
        return null;
    }

    public void addObjects(List<Useable> objects) {

        for (Useable useable : objects) {
            this.objects.add(useable);
        }
    }

    public boolean hasElement(Useable useable) {
        boolean hasElement = false;
        for (Useable element : this.objects) {
            if (element.getName().equals(useable.getName())) {
                hasElement = true;
            }
        }
        return hasElement;

    }
}
