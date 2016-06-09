package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.condition.core.AbstractCondition;

public class RandomCondition extends AbstractCondition<String> {

    private int probability;

    public RandomCondition(int probability) {
        this.probability = probability;
    }

    @Override
    public boolean isSatisfiedBy(String command) {
        return (Math.random() * 100) > this.probability;
    }
}
