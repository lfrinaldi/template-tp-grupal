package ar.fiuba.tdd.tp.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandro on 27/04/16.
 */
public class Player {

    private List<Useable> useables;

    public Player() {
        this.useables = new ArrayList<>();
    }

    public void addElement(Useable useable) {
        this.useables.add(useable);
    }

    public boolean hasElement(Useable useable) {
        boolean hasElement = false;
        for (Useable element : this.useables) {
            if (element.getName().equals(useable.getName())) {
                hasElement = true;
                break;
            }
        }
        return hasElement;
    }

    public boolean removeObject(String objectName) {
        return this.useables.removeIf(element -> element.getName().equals(objectName));
    }
}
