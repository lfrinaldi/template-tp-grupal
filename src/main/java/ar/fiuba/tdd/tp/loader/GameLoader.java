package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.*;
import ar.fiuba.tdd.tp.loader.Loader;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leandro on 22/04/16.
 */
public class GameLoader implements Loader {

    @Override
    public Game get(String gameName) {
        // Don't care about the name, just create fetch quest
        System.out.print(gameName);
        // TODO: invoke method by gameName
        return null;//fetchQuest();
    }

    private Game fetchQuest() {
        return new FetchQuest();
    }

    private Game abrirPuerta() {
        return new AbrirPuerta();
    }

    private Game abrirPuerta2() {
        return new AbrirPuerta2();
    }

    private Game objetoMaldito() {
        return new ObjetoMaldito();
    }

    private Game loboOvejaCol() {
        return new LoboOvejaCol();
    }

    private Game torresHanoi() {
        return new TorresHanoi();
    }

    private Game busquedaTersoro() {
        return new BusquedaTesoro();
    }
}
