package ar.fiuba.tdd.tp.builder;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.model.*;

@SuppressWarnings("CPD-START")
public class BusquedaTesoroGameBuilder implements GameBuilder {

    @Override
    public Game build() {
        GameObject scene = buildScene();
        Game game = new Game(scene);

        return game;
    }

    private GameObject buildScene() {
        GameObject room1 = new GameObject("room1");
        GameObject room2 = new GameObject("room2");
        GameObject room3 = new GameObject("room3");
        GameObject room4 = new GameObject("room4");
        GameObject room5 = new GameObject("room5");
        GameObject scene = new GameObject("scene");
        scene.addChild(room1);
        scene.addChild(room2);
        scene.addChild(room3);
        scene.addChild(room4);
        scene.addChild(room5);

        return scene;
    }
}
