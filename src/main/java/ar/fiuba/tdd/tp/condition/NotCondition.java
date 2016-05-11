package ar.fiuba.tdd.tp.condition;

/**
 * Created by leandro on 10/05/16.
 */
public class NotCondition<T> extends AbstractCondition<T> {

    private Condition<T> cond1;

    /**
     * Create a new NOT condition based on another cond.
     *
     * @param cond1 Condition instance to not.
     */
    public NotCondition(final Condition<T> cond1) {
        this.cond1 = cond1;
    }

    public boolean isSatisfiedBy(final T t) {
        return !cond1.isSatisfiedBy(t);
    }
}
