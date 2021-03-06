package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.condition.core.AbstractCondition;
import ar.fiuba.tdd.tp.model.GameObject;

import java.util.List;

public class ComplexCondition extends AbstractCondition<GameObject> {

    List<AbstractCondition> conditions;

    public ComplexCondition(List<AbstractCondition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean isSatisfiedBy(GameObject gameObject) {

        for (AbstractCondition condition : conditions) {
            if (not(condition).isSatisfiedBy(gameObject)) {
                return false;
            }

        }
        return true;
    }
}
