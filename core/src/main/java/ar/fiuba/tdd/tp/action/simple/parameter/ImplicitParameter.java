package ar.fiuba.tdd.tp.action.simple.parameter;

public class ImplicitParameter implements Parameter {

    private String text;

    public ImplicitParameter(String text) {
        this.text = text;
    }

    @Override
    public String value(String command) {
        return text;
    }
}
