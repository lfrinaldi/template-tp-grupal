package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.condition.Condition;
import ar.fiuba.tdd.tp.model.Game;

import java.util.ArrayList;
import java.util.List;

public class ComplexAction implements Action {

    private String name;
    private String command;
    private Game game;
    private List<SimpleAction> steps = new ArrayList<>();

    public ComplexAction(String name, String command, Game game) {
        this.name = name;
        this.command = command;
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

    public Game getGame() {
        return game;
    }

    public List<SimpleAction> getSteps() {
        return steps;
    }

    public void addAction(SimpleAction action) {
        this.steps.add(action);
    }

    @Override
    public String execute(String command) {

        for (SimpleAction step : steps) {

            Condition<String> condition = step.getCondition();

            if (condition.isSatisfiedBy(command)) {
                return step.execute(command);
            }
        }

        return null;
    }
}
