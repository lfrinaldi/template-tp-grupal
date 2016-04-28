package ar.fiuba.tdd.tp.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 4/23/2016.
 */
public abstract class ComplexObject extends GameObject {


    private List<Useable> objects = new ArrayList<Useable>();

    public void setObjects(List<Useable> objects) {
        this.objects = objects;
    }

    public void addObject(Useable object) {
        this.objects.add(object);
    }

    public List<Useable> getObjects() {
        return this.objects;
    }

    public String getName() {
        return this.name;
    }


}
