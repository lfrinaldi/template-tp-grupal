package ar.fiuba.tdd.tp.action.simple.parameter;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

public class ExplicitCurrentLastChildParameter implements Parameter {

    private int position;
    private Game game;

    public ExplicitCurrentLastChildParameter(int position, Game game) {
        this.position = position;
        this.game = game;
    }

    @Override
    public String value(String command) {

        String[] splitCommand = command.split(" ");
        GameObject gameObject = game.getScene().find(splitCommand[position]);
        if (!gameObject.getChildren().isEmpty()) {
            GameObject lastGameObject = gameObject.getChildren().get(gameObject.getChildren().size() - 1);
            return lastGameObject.getName();
        }

        return "";
    }
}
