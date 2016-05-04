package ar.fiuba.tdd.tp.game;

/**
 * Created by leandro on 03/05/16.
 */
public class Player extends ComplexObject {

    private int maxItems;

    public Player(int maxItems) {
        this.maxItems = maxItems;
    }

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    public boolean canPick() {
        return getObjects().size() < maxItems;
    }
}
