package ar.fiuba.tdd.tp.condition;

public class FalseCondition extends GameCondition<String> {

    public FalseCondition() {
    }

    @Override
    public boolean isSatisfiedBy(String command) {
        return false;
    }
}
