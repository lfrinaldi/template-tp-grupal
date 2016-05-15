package ar.fiuba.tdd.tp.condition;

import java.util.function.Function;

public class UnaryCondition<T> extends AbstractCondition<T> {

    private Condition<T> cond1;
    private Function<Boolean, Boolean> operator;

    /**
     * Create a new unary condition based on another cond.
     *
     * @param cond1 Condition instance to not.
     */
    public UnaryCondition(final Condition<T> cond1, Function<Boolean, Boolean> operator) {
        this.cond1 = cond1;
        this.operator = operator;
    }

    public boolean isSatisfiedBy(final T elementT) {
        return operator.apply(cond1.isSatisfiedBy(elementT));
    }
}
