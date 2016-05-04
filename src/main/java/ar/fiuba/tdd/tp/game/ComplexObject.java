package ar.fiuba.tdd.tp.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 4/23/2016.
 */
public class ComplexObject extends GameObject {


    private List<GameObject> objects = new ArrayList<>();

    public void setObjects(List<GameObject> objects) {
        this.objects = objects;
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

    public boolean hasElement(String objectName) {
        boolean hasElement = false;
        for (GameObject element : objects) {
            if (element.getName().equals(objectName)) {
                hasElement = true;
                break;
            }
        }
        return hasElement;
    }

    public GameObject getObject(String elementToPick) {
        GameObject object = null;
        for (GameObject element : objects) {
            if (element.getName().equals(elementToPick)) {
                object = element;
                break;
            }
        }
        return object;
    }

}
