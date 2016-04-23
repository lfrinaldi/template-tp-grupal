package ar.fiuba.tdd.tp.game;

/**
 * Created by Adrián on 4/23/2016.
 */
public class SubGameObject implements Useable{

    private String description;


    public SubGameObject(String description){
        this.description = description;
    }

    @Override
    public void usar() {
        System.out.print("Usando " + description);
    }

    @Override
    public String getDescription(){
        return this.description;
    }

    @Override
    public Useable interactuar(Useable useable) {
        System.out.print("Interactuando " + this.description + "con " + useable.getDescription());
        return null;
    }
}
