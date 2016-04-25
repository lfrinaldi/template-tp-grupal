package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.engine.Action;
import ar.fiuba.tdd.tp.engine.ObjectAction;
import ar.fiuba.tdd.tp.engine.RoomAction;

import java.util.ArrayList;

public class Level extends BaseGame {

    public Level(String description, ArrayList<Useable> useables) {
        super(description, useables);
    }

    public String play(Action action) {
        System.out.print("Nivel " + super.getDescription());
        // return list of useables as string
        return "action";
    }

    public String play(RoomAction action) {
        //System.out.print("Nivel " + super.getDescription());
        // return list of useables as string
        return "stick";
    }

    public String play(ObjectAction action) {
        //System.out.print("Object: " + super.getDescription());
        // Pasar esta accion al useable.getDescripcion() == action.getPrimaryObject()
        //return useables.get(0).usar(action);
        useables.get(0).usar();
        return "Accion desconocida";
    }

}
