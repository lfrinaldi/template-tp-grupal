package ar.fiuba.tdd.tp.condition;

public class TrueCondition extends GameCondition<String> {

    public TrueCondition() {
    }

    @Override
    public boolean isSatisfiedBy(String command) {
        return true;
    }
}
