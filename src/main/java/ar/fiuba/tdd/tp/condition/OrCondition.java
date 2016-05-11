package ar.fiuba.tdd.tp.condition;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by leandro on 10/05/16.
 */
public class OrCondition<T> extends AbstractCondition<T> {

    private Condition<T> cond1;
    private Condition<T> cond2;
    private BiFunction<Boolean, Boolean, Boolean> operator;

    /**
     * Create a new OR condition based on two other cond.
     *
     * @param cond1 Condition one.
     * @param cond2 Condition two.
     */
    public OrCondition(final Condition<T> cond1, final Condition<T> cond2, BiFunction<Boolean, Boolean, Boolean> operator) {
        this.cond1 = cond1;
        this.cond2 = cond2;
        this.operator = operator;
    }

    public boolean isSatisfiedBy(final T elementT) {
        return operator.apply(cond1.isSatisfiedBy(elementT), cond2.isSatisfiedBy(elementT));
    }
}