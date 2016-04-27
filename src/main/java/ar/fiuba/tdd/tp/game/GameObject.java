package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 4/23/2016.
 */
public abstract class GameObject implements Usable {

    private String name;
    private List<GameObject> objects;

    public GameObject(String description) {
        this.name = description;
        this.objects = new ArrayList<>();
    }

    public GameObject(String name, List<GameObject> objects) {
        this.name = name;
        this.objects = new ArrayList<>(objects);
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public List<GameObject> getObjects() {
        return this.objects;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String use(Action action) {
        return action.execute(this);
    }
}
