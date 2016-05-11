package ar.fiuba.tdd.tp.condition;

/**
 * Created by leandro on 10/05/16.
 */
public class OrCondition<T> extends AbstractCondition<T> {

    private Condition<T> cond1;
    private Condition<T> cond2;

    /**
     * Create a new OR condition based on two other cond.
     *
     * @param cond1 Condition one.
     * @param cond2 Condition two.
     */
    public OrCondition(final Condition<T> cond1, final Condition<T> cond2) {
        this.cond1 = cond1;
        this.cond2 = cond2;
    }

    public boolean isSatisfiedBy(final T t) {
        return cond1.isSatisfiedBy(t) || cond2.isSatisfiedBy(t);
    }
}