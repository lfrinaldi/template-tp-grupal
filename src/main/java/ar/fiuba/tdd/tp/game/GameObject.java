package ar.fiuba.tdd.tp.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 4/23/2016.
 */
public class GameObject implements Useable{

    private String description;
    private List<Useable> useables;

    public GameObject(String description){
        this.description = description;
    }

    public GameObject(String description, List<Useable> useables){
        this.description = description;
        this.useables = new ArrayList<Useable>(useables);
    }

    public void addUseable(Useable useable){
        this.useables.add(useable);
    }

    public List<Useable> getUseable(){
        return this.useables;
    }

    @Override
    public String getDescription(){
        return this.description;
    }

    @Override
    public void usar() {
        System.out.print("Usando " + description);
    }

    @Override
    public Useable interactuar(Useable useable) {
        System.out.print("Interactuando " + this.description + "con " + useable.getDescription());
        return null;
    }
}
