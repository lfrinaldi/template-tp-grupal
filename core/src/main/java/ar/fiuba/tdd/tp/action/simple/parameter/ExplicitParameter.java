package ar.fiuba.tdd.tp.action.simple.parameter;

public class ExplicitParameter implements Parameter {

    private int position;

    public ExplicitParameter(int position) {
        this.position = position;
    }

    @Override
    public String value(String command) {

        String[] splitCommand = command.split(" ");

        return splitCommand[position];
    }
}
