package ar.fiuba.tdd.tp.loader;

import ar.fiuba.tdd.tp.game.Game;

public class GameLoader implements Loader {

    @Override
    public Game get(String gameName) {

/*
        if (gameName.equals("fetch quest")) {
            game = fetchQuest();
        } else if (gameName.equals("abrir puerta")) {
            game = abrirPuerta();
        } else if (gameName.equals("abrir puerta 2")) {
            game = abrirPuerta2();
        } else if (gameName.equals("objeto maldito")) {
            game = objetoMaldito();
        } else if (gameName.equals("lobo oveja col")) {
            game = loboOvejaCol();
        } else if (gameName.equals("torres hanoi")) {
            game = torresHanoi();
        } else if (gameName.equals("busqueda tersoro")) {
            game = busquedaTersoro();
        }
*/
        return torresHanoi();
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
